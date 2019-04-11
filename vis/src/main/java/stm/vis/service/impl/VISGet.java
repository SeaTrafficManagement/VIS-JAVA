package stm.vis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import stm.vis.data.GetVPResponseObject;
import stm.vis.data.SourceIdentity;
import stm.vis.data.StatusCode;
import stm.vis.data.messages.RouteStatus;
import stm.vis.exception.MessageParseException;
import stm.vis.model.Identity;
import stm.vis.model.PublishedMessage;
import stm.vis.service.MessageParser;
import stm.vis.service.PublishedMessagesService;
import stm.vis.service.VISGetInterface;

@Service
public class VISGet extends VISAbstractService implements VISGetInterface {

	@Autowired
	private PublishedMessagesService publishedMessagesService;

	@Autowired
	private MessageParser messageParser;

	@Override
	public GetVPResponseObject getVoyagePlans(SourceIdentity sourceIdentity, String uvid, RouteStatus routeStatus) {
		return this.execute(sourceIdentity, uvid, routeStatus);
	}

	private GetVPResponseObject execute(SourceIdentity sourceIdentity, String uvid, RouteStatus routeStatus) {
		/*
		 * Depending on the provided parameters, the following will be returned:
		 * GET /voyagePlans
		 * No parameters given;
		 * Return the latest published voyage plan with routeStatus "not inactivated" (routeStatus != "8") for all UVIDs the requester have access to. 
		 * If two or more voyage plans have routeStatus "Used for monitoring" (routeStatus=="7") for one ship, then only the latest published of them shall be returned.
		 * 
		 * GET /voyagePlans?UVID=myUVID
		 * Return the latest published message with requested UVID if the requester have access.
		 * 
		 * GET /voyagePlans?routeStatus=myRouteStatus
		 * Return the latest published message with requested routeStatus the requester have access to.
		 * If two or more voyage plans have routeStatus "Used for monitoring" (routeStatus=="7") for one ship, then only the latest published of them shall be returned.
		 * 
		 * GET /voyagePlans?UVID=myUVID&routeStatus=myRouteStatus
		 * Return the latest published message with requested UVID and routeStatus the requester have access.
		 */

		Identity identity = this.getIdentity(sourceIdentity);
		List<PublishedMessage> messages = this.publishedMessagesService.findVoyagePlans(uvid, routeStatus, identity);
		
		if (CollectionUtils.isEmpty(messages)) {
			return this.createResponseObject(StatusCode.VP_NOT_FOUND, "Voyage plan not found");
		} 
		
		GetVPResponseObject response;
		List<byte[]> voyagePlans = new ArrayList<>();
		try {
			for (PublishedMessage message : messages) {
				this.messageParser.getRouteFromMessage(message.getMessage());
				voyagePlans.add(message.getMessage());
			}
		} catch (MessageParseException e) {
			e.printStackTrace();
			return this.createResponseObject(StatusCode.SCHEMA_NOK, "Error parsing voyage plan: " + e.getMessage());
		}
		response = this.createResponseObject(StatusCode.OK, "Get voyage plan", voyagePlans);

		return response;
	}

	private Identity getIdentity(SourceIdentity sourceIdentity) {
		Identity identity = new Identity();
		identity.setId(sourceIdentity.getOrganisationMrn());
		identity.setName(sourceIdentity.getOrganisationName());
		return identity;
	}

	private GetVPResponseObject createResponseObject(StatusCode code, String subject) {
		return this.createResponseObject(code, subject, null);
	}

	private GetVPResponseObject createResponseObject(StatusCode code, String subject, List<byte[]> voyagePlans) {
		GetVPResponseObject response = new GetVPResponseObject();
		response.setCode(code);
		response.setSubject(subject);
		if (voyagePlans != null) {
			for (byte[] bytes : voyagePlans)
			response.getRouteMessages().add(new String(bytes));
		}
		// Get lastInteractionTime between STM-Module and VIS
		response.setLastInteractionTime(this.getLastInteractionTime());
		return response;
	}

}
