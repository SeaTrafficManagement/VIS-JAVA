package stm.vis.service.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import stm.vis.data.FindServicesParams;
import stm.vis.data.ResponseObject;
import stm.vis.data.StatusCode;
import stm.vis.data.VISRequestType;
import stm.vis.data.messages.MessageType;
import stm.vis.data.messages.Messages;
import stm.vis.data.messages.STMMessage;
import stm.vis.data.messages.VISDeliveryAck;
import stm.vis.data.messages.VISMessage;
import stm.vis.data.route.Route;
import stm.vis.exception.MessageParseException;
import stm.vis.exception.MessageValidationException;
import stm.vis.exception.VISException;
import stm.vis.model.ACLObject;
import stm.vis.model.Connection.ConnectionStatus;
import stm.vis.model.Identity;
import stm.vis.model.PublishedMessage;
import stm.vis.model.Schema;
import stm.vis.model.Subscription;
import stm.vis.model.UploadedMessage;
import stm.vis.model.VISNotification;
import stm.vis.service.AclService;
import stm.vis.service.AsyncService;
import stm.vis.service.MessageParser;
import stm.vis.service.MessageValidator;
import stm.vis.service.NotificationsService;
import stm.vis.service.PublishedMessagesService;
import stm.vis.service.SchemaService;
import stm.vis.service.SubscriptionService;
import stm.vis.service.UploadedMessageService;
import stm.vis.service.VISPrivateInterface;
import stm.vis.ssc.client.SscClientHelper;
import stm.vis.ssc.client.SscClientHelperFactory;
import stm.vis.ssc.client.data.IRService;
import stm.vis.ssc.client.data.SRService;
import stm.vis.ssc.client.data.VISOrganization;
import stm.vis.web.privateapi.model.SubscriptionObject;

@Service
public class VISPrivate extends VISAbstractService implements VISPrivateInterface {

	@Autowired
	private MessageValidator messageValidator;

	@Autowired
	private MessageParser messageParser;

	@Autowired
	private SchemaService schemaService;

	@Autowired
	private PublishedMessagesService publishedMessageService;

	@Autowired
	private UploadedMessageService uploadedMessageService;

	@Autowired
	private NotificationsService notificationsService;

	@Autowired
	private SubscriptionService subscriptionService;

	@Autowired
	private AclService aclService;

	@Autowired
	private AsyncService asyncService;

	@Autowired
	private SscClientHelperFactory sscClientFactory;

	private SscClientHelper sscClient;

	@PostConstruct
	void initSscClient() {
		this.sscClient = this.sscClientFactory.newInstance();
	}

	@Override
	public ResponseObject publishMessage(String messageId, String messageType, String message) {
		this.updateConnectionStatus(ConnectionStatus.CONNECTED);

		/*
		 * Operation functionality
		 * 
		 * - Validate message
		 * - VIS stores the Voyage Plan in cache/repository
		 * - VIS forwards the Voyage Plan to all subscribers (according to subscription parameters and authorization)
		 */

		STMMessage voyagePlan = new STMMessage();
		voyagePlan.setMessageType(MessageType.valueOf(messageType));
		voyagePlan.setData(message.getBytes());

		try {
			Schema schema = this.schemaService.getRouteSchema();
			this.messageValidator.validateMessage(voyagePlan, schema);
			Route route = this.messageParser.getRouteFromMessage(voyagePlan);
			PublishedMessage publishedMessage = this.publishedMessageService.saveRouteMessage(message, route, schema);
			this.asyncService.sendMessageToSubscribers(this.getUVIDFromRoute(route), voyagePlan, publishedMessage);
			return this.createResponseObject(StatusCode.OK, publishedMessage.getId().toString());
		} catch (MessageValidationException ex) {
			ex.printStackTrace();
			return this.createResponseObject(StatusCode.SCHEMA_NOK, "Message validation error: " + ex.getMessage());
		} catch (MessageParseException ex) {
			ex.printStackTrace();
			return this.createResponseObject(StatusCode.SCHEMA_NOK, "Message parse error: " + ex.getMessage());
		} catch (Exception ex) {
			ex.printStackTrace();
			return this.createResponseObject(StatusCode.ERROR, "Message NOT published. Undefined error: " + ex);
		}
	}

	@Override
	public List<PublishedMessage> getPublishedMessages() {
		this.updateConnectionStatus(ConnectionStatus.CONNECTED);
		return this.publishedMessageService.findAllActiveVoyagePlans();
	}
	
	@Override
	public void removePublishedMessage(String dataId) throws VISException {
		try {
			this.publishedMessageService.removePublishedMessage(dataId);
		} catch (Exception e) {
			throw new VISException(e.getMessage(), e);
		}
	}

	private ResponseObject createResponseObject(StatusCode statusCode, String message) {
		ResponseObject response = new ResponseObject();
		response.setStatusCode(statusCode);
		response.setBody(message);
		return response;
	}

	@Override
	public ResponseObject authorizeIdentities(List<Identity> identities, String dataId) {
		// TODO Create aspect to update connection status in every method
		this.updateConnectionStatus(ConnectionStatus.CONNECTED);

		/*
		 * Operation functionality
		 * - The incoming parameters are format checked
		 * - POSIX Access Control List is created for the dataId and given identities (organisations)
		 * - ACL is updated or created for the dataId in VIS internal database
		 * - HTTP Response is sent, if error in format of incoming parameters, an error code and message is sent.
		 * - The authorized organisations are notified by either uploading the latest published Voyage Plan or by notify the UVID given authorization to.
		 */

		ResponseObject response = new ResponseObject();
		try {
			this.checkDataIdFormat(dataId);
			List<Identity> savedIdentities = this.aclService.createIdentities(identities);
			/* ACLObject acl = */ this.aclService.createACL(dataId, savedIdentities);
			response.setBody("Identities authorized successfully");
			response.setStatusCode(StatusCode.OK);
		} catch (VISException e) {
			e.printStackTrace();
			response.setBody(e.getMessage());
			response.setStatusCode(StatusCode.DATAID_NOK);
		}

		return response;
	}

	@Override
	public List<Identity> findAuthorizedIdentities(String dataId) {
		this.updateConnectionStatus(ConnectionStatus.CONNECTED);
		ACLObject acl = this.aclService.getAclForMessage(dataId);
		return acl.getIdentities();
	}

	@Override
	public ResponseObject removeAuthorizedIdentitites(List<Identity> identities, String dataId) {
		this.updateConnectionStatus(ConnectionStatus.CONNECTED);

		ResponseObject response = new ResponseObject();
		try {
			this.aclService.removeAuthorizedIdentities(dataId, identities);
			response.setBody("Identities authorization removed successfully");
			response.setStatusCode(StatusCode.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response.setBody("Error removing authorized identities for message " + dataId + ": " + e.getMessage());
			response.setStatusCode(StatusCode.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	private void checkDataIdFormat(String dataId) throws VISException {
		// TODO [documentation] dataId in MRN format is mandatory, the access control will be set to this dataId. Is primarily UVID in VIS
		boolean valid = true;
		if (!valid) {
			throw new VISException("Error validating dataId: " + dataId);
		}
	}

	/**
	 * Get messages from uploadedMessage and return
	 * When returned messages to STM Module, check if ACK is requested, if yes send ACK to provided AckEndpoint
	 * @param dataId
	 * @param limitQuery
	 * @return
	 */
	@Override
	public Messages getMessages(Integer limitQuery) {
		this.updateConnectionStatus(ConnectionStatus.CONNECTED);
		/* Operation functionality
		 * 
		 * - Retrieve messages: find all non-fetched messages
		 *   - with limit number of messages returned
		 * - Create response object and return
		 * - If return OK, for each message
		 *   - if ACK requested, send ACK
		 */

		List<UploadedMessage> uploadedMessages;
		if (limitQuery == null) {
			uploadedMessages = this.uploadedMessageService.getUploadedMessages();
		} else {
			uploadedMessages = this.uploadedMessageService.getUploadedMessages(limitQuery);
		}

		Messages response = new Messages();
		response.setRemainingNumberOfMessages(this.uploadedMessageService.getRemainingNumberOfMessages());
		response.setNumberOfMessages(uploadedMessages.size());
		response.setMessages(this.toMessageList(uploadedMessages));

		// TODO How to know if message is received by the ship?
		this.processSentMessagesAsync(uploadedMessages);

		return response;
	}

	private List<VISMessage> toMessageList(List<UploadedMessage> uploadedMessages) {
		List<VISMessage> list = new ArrayList<>();
		if (uploadedMessages != null) {
			for (UploadedMessage uploadedMessage : uploadedMessages) {
				list.add(this.toMessage(uploadedMessage));
			}
		}
		return list;
	}

	private VISMessage toMessage(UploadedMessage uploadedMessage) {
		VISMessage message = new VISMessage();
		message.setId(uploadedMessage.getId().toString());
		message.setFrom(uploadedMessage.getFrom());
		message.setReceivedAt(uploadedMessage.getReceiveTime());
		message.setMessageType(uploadedMessage.getMessageType());
		message.setMessage(uploadedMessage.getMessage());
		return message;
	}

	private void processSentMessagesAsync(List<UploadedMessage> uploadedMessages) {
		/*
		 *  - For each uploadedMessage:
		 *    - update notified, fetchedByShip, fecthTime
		 *    - send ACK if requested
		 */
		Date now = new Date();
		for (UploadedMessage message : uploadedMessages) {
			message = this.uploadedMessageService.updateMessageFetched(message, now);
			if (message.isDeliveryAckRequested()) {
				this.sendACK(message);
			}
		}
	}

	private void sendACK(UploadedMessage message) {
		/* Operation functionality
		 * - create ACK message
		 * - send ACK message to given endpoint using callService
		 */

		VISDeliveryAck deliveryAck = new VISDeliveryAck();
		deliveryAck.setId(UUID.randomUUID().toString());
		deliveryAck.setReferenceId(message.getId().toString());
		deliveryAck.setTimeOfDelivery(new Date());
		deliveryAck.setFromId(this.getFromIdentity(message).getId().toString());
		deliveryAck.setFromName(this.getFromIdentity(message).getName());
		deliveryAck.setToId(this.getToIdentity(message).getId().toString());
		deliveryAck.setToName(this.getToIdentity(message).getName());
		deliveryAck.setAckResult("ACK");
		try {
			this.sendDeliveryAckMessage(deliveryAck, message.getDeliveryAckEndpoint());
			this.uploadedMessageService.updateMessageACKSent(message);
		} catch (VISException e) {
		}
	}

	private void sendDeliveryAckMessage(VISDeliveryAck deliveryAck, String deliveryAckEndpoint) throws VISException {
		try {
			String url = deliveryAckEndpoint + "/acknowledgement";
			ObjectMapper mapper = new ObjectMapper();
			String body = mapper.writeValueAsString(deliveryAck);
			this.callService(VISRequestType.POST, url, null, body);
		} catch (JsonProcessingException e) {
			throw new VISException("Error converting DeliveryAck object to JSON: " + e.getMessage(), e);
		}
	}

	private Identity getFromIdentity(UploadedMessage message) {
		// TODO Get identity for the source (sender) of the message
		Identity identity = new Identity();
		identity.setId("id-1");
		identity.setName("identity-1");
		return identity;
	}

	private Identity getToIdentity(UploadedMessage message) {
		// TODO Get identity for the target (recipient) of the message
		Identity identity = new Identity();
		identity.setId("id-2");
		identity.setName("identity-2");
		return identity;
	}

	@Override
	public List<VISNotification> getNotifications() {
		this.updateConnectionStatus(ConnectionStatus.CONNECTED);
		return this.notificationsService.getNotifications();
	}

	@Override
	public List<Subscription> getSubscriptions(String dataId) {
		this.updateConnectionStatus(ConnectionStatus.CONNECTED);
		return this.subscriptionService.getSubscriptions(dataId, MessageType.RTZ);
	}

	@Override
	public void addSubscriptions(List<SubscriptionObject> subscriptions, String dataId) throws VISException {
		this.updateConnectionStatus(ConnectionStatus.CONNECTED);
		try {
			for (SubscriptionObject subscription : subscriptions) {
				Identity identity = this.getIdentityFromSubscriptionObject(subscription);
				this.subscriptionService.addSubscription(identity, dataId, MessageType.RTZ, new URI(subscription.getEndpointURL()));
			}
		} catch (Exception e) {
			throw new VISException("Error adding subscriptions: " + e.getMessage(), e);
		}
	}

	@Override
	public void removeSubscriptions(List<SubscriptionObject> subscriptions, String dataId) throws VISException {
		this.updateConnectionStatus(ConnectionStatus.CONNECTED);
		try {
			for (SubscriptionObject subscription : subscriptions) {
				Identity identity = this.getIdentityFromSubscriptionObject(subscription);
				this.subscriptionService.removeSubscription(identity, dataId, MessageType.RTZ, new URI(subscription.getEndpointURL()));
			}
		} catch (Exception e) {
			throw new VISException("Error removing subscriptions: " + e.getMessage(), e);
		}
	}

	private Identity getIdentityFromSubscriptionObject(SubscriptionObject subscription) {
		Identity identity = new Identity();
		identity.setId(subscription.getIdentityId());
		identity.setName(subscription.getIdentityName());
		return identity;
	}

	// SSC Methods

	@Override
	public List<VISOrganization> findIdentities() throws VISException {
		this.updateConnectionStatus(ConnectionStatus.CONNECTED);
		return this.sscClient.findOrganizations();
	}

	@Override
	public ResponseObject callService(VISRequestType requestType, String targetUrl, Map<String, String> headersMap, String body) throws VISException {
		this.updateConnectionStatus(ConnectionStatus.CONNECTED);
		return this.sscClient.callService(requestType, targetUrl, headersMap, body);
	}

	@Override
	public IRService findIdentity(String organisationMrn, String serviceId, String type) throws VISException {
		// FIXME How do we get the "friendly name" of the service and the organization?
		// return this.sscClient.findIdentity(organisationMrn, serviceId, type);
		IRService service = new IRService();
		service.setMrn(serviceId);
		service.setName(serviceId);
		service.setOwner(new VISOrganization());
		service.getOwner().setMrn(organisationMrn);
		service.getOwner().setName(organisationMrn);
		return service;
	}

	@Override
	public List<SRService> findServices(FindServicesParams params) throws VISException {
		this.updateConnectionStatus(ConnectionStatus.CONNECTED);
		return this.sscClient.findServices(params);
	}

	@Override
	public VISOrganization findOrganization(String organisationMrn) throws VISException {
		return this.sscClient.findOrganization(organisationMrn);
	}

}
