package stm.vis.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import stm.vis.data.messages.MessageType;
import stm.vis.data.messages.RouteStatus;
import stm.vis.data.route.Route;
import stm.vis.exception.AuthorizationException;
import stm.vis.model.Identity;
import stm.vis.model.PublishedMessage;
import stm.vis.model.Schema;
import stm.vis.repository.PublishedMessageRepository;
import stm.vis.service.AclService;
import stm.vis.service.PublishedMessagesService;

@Service
public class PublishedMessageServiceImpl implements PublishedMessagesService {

	@Autowired
	private PublishedMessageRepository repository;

	@Autowired
	private AclService aclService;

	@Override
	public PublishedMessage saveRouteMessage(String message, Route route, Schema schema) {
		RouteStatus routeStatus = RouteStatus.fromValue(Integer.parseInt(route.getRouteInfo().getRouteStatus()));
		String uvid = route.getRouteInfo().getVesselVoyage();

		Date validFrom = null;
		XMLGregorianCalendar validityPeriodStart = route.getRouteInfo().getValidityPeriodStart();
		if (validityPeriodStart != null) {
			validFrom = validityPeriodStart.toGregorianCalendar().getTime();
		}
		Date validTo = null;
		XMLGregorianCalendar validityPeriodStop = route.getRouteInfo().getValidityPeriodStop();
		if (validityPeriodStop != null) {
			validTo = validityPeriodStop.toGregorianCalendar().getTime();
		}

		Date now = new Date();
		Date lastUpdateTime = now; // TODO [Documentation] Is there any route attribute with last update time? 

		MessageType messageType = MessageType.RTZ;

		PublishedMessage publishedMessage = new PublishedMessage();
		publishedMessage.setDateTime(now);
		publishedMessage.setSchema(schema);
		publishedMessage.setMessageId(uvid);
		publishedMessage.setMessageType(messageType);
		publishedMessage.setMessageStatus(routeStatus.getValue());
		publishedMessage.setMessage(message.getBytes());
		publishedMessage.setMessageLastUpdateTime(lastUpdateTime);
		publishedMessage.setValidFrom(validFrom);
		publishedMessage.setValidTo(validTo);
		return this.repository.save(publishedMessage);
	}

	@Override
	public List<PublishedMessage> findVoyagePlans(String uvid, RouteStatus routeStatus, Identity identity) {
		List<PublishedMessage> messages;
		if (StringUtils.isEmpty(uvid)) {
			if (routeStatus == null) {
				 // Return the latest published voyage plan with routeStatus "not inactivated" (routeStatus != "8") for all UVIDs the requester have access to. 
				 // If two or more voyage plans have routeStatus "Used for monitoring" (routeStatus=="7") for one ship, then only the latest published of them shall be returned.
				messages = this.repository.findByMessageStatusNotOrderByDateTimeDesc(RouteStatus.INACTIVE.getValue());
			} else {
				// Return the latest published message with requested routeStatus the requester have access to.
				// If two or more voyage plans have routeStatus "Used for monitoring" (routeStatus=="7") for one ship, then only the latest published of them shall be returned.
				messages = this.repository.findByMessageStatusOrderByDateTimeDesc(routeStatus.getValue());
			}
		} else {
			if (routeStatus == null) {
				// Return the latest published message with requested UVID if the requester have access.
				messages = this.repository.findByMessageIdOrderByDateTimeDesc(uvid);
			} else {
				// Return the latest published message with requested UVID and routeStatus the requester have access.
				messages = this.repository.findByMessageIdAndMessageStatusOrderByDateTimeDesc(uvid, routeStatus.getValue());
			}
		}

		// The response can contain 0 or more (0..*) voyage plans, but only 0 or one (0..1) voyage plan with same UVID.
		Map<String, PublishedMessage> lastPublishedMap = new LinkedHashMap<>();
		for (PublishedMessage message : messages) {
			try {
				this.checkAuthorization(identity, message.getMessageId());

				String shipId= message.getMessageId();
				PublishedMessage lastMessage = lastPublishedMap.get(shipId);
				if (lastMessage == null || message.getDateTime().after(lastMessage.getDateTime())) {
					lastPublishedMap.put(shipId, message);
				}
			} catch (AuthorizationException ex) {
				// Ignore message if user is not authorized, try with the next one
			}
		}
		return new ArrayList<>(lastPublishedMap.values());
	}

	private void checkAuthorization(Identity identity, String uvid) throws AuthorizationException {
		this.aclService.checkAuthorization(identity, uvid);
	}

	@Override
	public List<PublishedMessage> findAllActiveVoyagePlans() {
		return this.repository.findByMessageStatusNotOrderByDateTimeDesc(RouteStatus.INACTIVE.getValue());
	}
	
	@Override
	public void removePublishedMessage(String dataId) {
		this.repository.deleteByMessageId(dataId);
	}
	
}
