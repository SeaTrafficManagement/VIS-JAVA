package stm.vis.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import stm.vis.data.ResponseObject;
import stm.vis.data.SourceIdentity;
import stm.vis.data.StatusCode;
import stm.vis.data.messages.MessageType;
import stm.vis.exception.AuthorizationException;
import stm.vis.model.Identity;
import stm.vis.model.PublishedMessage;
import stm.vis.model.Subscription;
import stm.vis.service.AclService;
import stm.vis.service.PublishedMessagesService;
import stm.vis.service.SubscriptionService;
import stm.vis.service.VISSubscriptionInterface;

@Service
public class VISSubscription extends VISAbstractService implements VISSubscriptionInterface {

	@Autowired
	private AclService aclService;

	@Autowired
	private PublishedMessagesService publishedMessagesService;
	
	@Autowired
	private SubscriptionService subscriptionService;

	@Override
	public ResponseObject subscribeToVoyagePlan(SourceIdentity sourceIdentity, String uvid, String callbackEndpoint) {
		Identity identity = this.getIdentity(sourceIdentity);
		try {
			URI callbackEndpointURI = callbackEndpoint == null ? null : new URI(callbackEndpoint);
			List<String> uvids = new ArrayList<>();
			if (uvid == null) {
				// If the requester have access to some of the active UVIDs, a subscription will be added to the authorized UVID(s). 
				// The private application will be notified regarding the non-authorized UVID(s).
				List<PublishedMessage> activeVoyagePlans = this.publishedMessagesService.findAllActiveVoyagePlans();
				for (PublishedMessage message : activeVoyagePlans) {
					try {
						String messageId = message.getMessageId();
						this.aclService.checkAuthorization(identity, messageId);
						uvids.add(messageId);
					} catch (AuthorizationException e) {
						this.sendNotifyToSTMModule(sourceIdentity, uvid, uvid);
					}
				}
				if (CollectionUtils.isEmpty(uvids)) {
					throw new AuthorizationException("Not authorized to any UVID");
				}
			} else {
				this.aclService.checkAuthorization(identity, uvid);
				uvids.add(uvid);
			}
			return this.subscribe(identity, uvids, MessageType.RTZ, callbackEndpointURI);
		} catch (URISyntaxException e) {
			return this.createResponseObject(StatusCode.ERROR, e.getMessage());
		} catch (AuthorizationException e) {
			e.printStackTrace();
			this.sendNotifyToSTMModule(sourceIdentity, uvid, uvid);
			return this.createResponseObject(StatusCode.NOT_AUTHORIZED, "Not authorized");
		}
	}

	private ResponseObject subscribe(Identity identity, List<String> messages, MessageType messageType, URI callbackEndpoint) {
		/* 
		 * - The received request is stored in VIS database.
		 * - The authorization to data is checked and if authorized an OK is given and the callbackEndpoint 
		 *     from calling party is stored in a subscription table in VIS database together with subscription 
		 *     parameters.
		 * 
		 * Find source identity of the service call
		 * Check Authorization to data (voyage plan) by source identity
		 * - if not authorized, notify ship that message is requested by source identity
		 * - if authorized, add identity to subscription list on UVID 
		 */
		for (String messageId : messages) {
			this.addIdentityToSubscriptionList(identity, messageId, messageType, callbackEndpoint);
		}
		ResponseObject response = this.createResponseObject(StatusCode.OK, "Subscription done successfully");
		return response;
	}

	private Identity getIdentity(SourceIdentity sourceIdentity) {
		Identity identity = new Identity();
		identity.setId(sourceIdentity.getOrganisationMrn());
		identity.setName(sourceIdentity.getOrganisationName());
		return identity;
	}

	private void addIdentityToSubscriptionList(Identity identity, String messageId, MessageType messageType, URI callbackEndpoint) {
		this.subscriptionService.addSubscription(identity, messageId, messageType, callbackEndpoint);
	}

	@Override
	public ResponseObject removeVoyagePlanSubscription(SourceIdentity sourceIdentity, String uvid, String callBackendpoint) {
		ResponseObject response;
		try {
			URI callbackEndpointURI = callBackendpoint == null ? null : new URI(callBackendpoint);
			response = this.remove(sourceIdentity, uvid, MessageType.RTZ, callbackEndpointURI);
		} catch (URISyntaxException e) {
			response = this.createResponseObject(StatusCode.ERROR, e.getMessage());
		}
		return response;
	}

	private ResponseObject remove(SourceIdentity sourceIdentity, String messageId, MessageType messageType, URI callbackEndpoint) {
		Identity identity = this.getIdentity(sourceIdentity);
		this.subscriptionService.removeSubscription(identity, messageId, messageType, callbackEndpoint);
		return this.createResponseObject(StatusCode.OK, "Subscription removed successfully");
	}

	private ResponseObject createResponseObject(StatusCode status, String body) {
		ResponseObject response = new ResponseObject();
		response.setStatusCode(status);
		response.setBody(body);
		return response;
	}

	@Override
	public List<Subscription> getSubscriptions(SourceIdentity sourceIdentity, String callbackEndpoint) {
		Identity identity = this.getIdentity(sourceIdentity);
		List<Subscription> subscriptions = this.subscriptionService.getSubscriptions(identity, MessageType.RTZ, callbackEndpoint);
		return subscriptions;
	}
}
