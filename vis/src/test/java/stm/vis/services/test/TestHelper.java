package stm.vis.services.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import stm.vis.data.SourceIdentity;
import stm.vis.data.messages.MessageType;
import stm.vis.data.messages.RouteStatus;
import stm.vis.data.messages.STMMessage;
import stm.vis.data.route.Route;
import stm.vis.data.route.RouteInfo;
import stm.vis.data.textMessage.TextMessage;
import stm.vis.model.ACLObject;
import stm.vis.model.Identity;
import stm.vis.model.PublishedMessage;
import stm.vis.model.Schema;
import stm.vis.model.UploadedMessage;
import stm.vis.web.privateapi.model.Message;
import stm.vis.web.privateapi.model.StmMessage;

@Component
public class TestHelper {

	public Identity getDefaultIdentity() {
		Identity identity = new Identity();
		identity.setId("id-1");
		identity.setName("identity-1");
		return identity;
	}

	public SourceIdentity getDefaultSourceIdentity() {
		SourceIdentity identity = new SourceIdentity();
		identity.setServiceId("id-1");
		identity.setServiceName("identity-1");
		identity.setOrganisationMrn("organisation-mrn");
		identity.setOrganisationName("organisation-name");
		return identity;
	}

	public Route getDefaultRoute() {
		Route route = new Route();
		route.setRouteInfo(new RouteInfo());
		route.getRouteInfo().setVesselVoyage("uvid");
		route.getRouteInfo().setRouteStatus(Integer.toString(RouteStatus.PLANNED_FOR_VOYAGE.getValue()));
		// (V2) route.getRouteInfo().setRouteStatus(new BigInteger(Integer.toString(RouteStatus.PLANNED_FOR_VOYAGE.getValue())));
		return route;
	}

	public URI getDefaultURI() {
		try {
			return new URI("http://default.uri.com/");
		} catch (URISyntaxException e) {
			return null;
		}
	}

	public UploadedMessage getDefaultUploadedMessage() {
		UploadedMessage message = new UploadedMessage();
		message.setId(1L);
		message.setReceiveTime(new Date());
		message.setFrom("from");
		message.setMessage("message".getBytes());
		message.setMessageType(MessageType.TXTMSG);
		message.setDeliveryAckRequested(true);
		message.setDeliveryAckEndpoint("delivery-ack-endpoint");
		message.setAckDelivered(false);
		message.setNotified(false);
		message.setFetchedByShip(false);
		message.setFetchTime(null);
		return message;
	}

	public TextMessage getDefaultTextMessage() {
		TextMessage textMessage = new TextMessage();
		textMessage.setTextMessageId("message-id");
		textMessage.setAuthor("message-author");
		textMessage.setFrom("message-from");
		textMessage.setCreatedAt(this.now());
		textMessage.setSubject("message-subject");
		textMessage.setBody("message-body");
		return textMessage;
	}

	private XMLGregorianCalendar now() {
		return this.fromDate(new Date());
	}

	public XMLGregorianCalendar fromDate(Date date) {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(date);
		c.setTimeZone(TimeZone.getTimeZone("UTC"));
		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
			return null;
		}
	}

	public STMMessage getDefaultSTMMessage() {
		STMMessage message = new STMMessage();
		message.setMessageType(MessageType.RTZ);
		message.setData("stm-message".getBytes());
		return message;
	}

	public Message getDefaultMessage() {
		StmMessage stmMessage = new StmMessage();
		stmMessage.setMessage("message-content");

		Message message = new Message()
				.callbackEndpoint("callback-endpoint")
				.id("message-1")
				.receivedAt(new DateTime())
				.fromOrgId("message-from-org-id")
				.fromOrgName("message-from-org-name")
				.fromServiceId("message-from-service-id")
				.messageType(MessageType.TXTMSG.name())
				.stmMessage(stmMessage);
		return message;
	}

	public Schema getDefaultSchema() {
		Schema schema = new Schema();
		schema.setId(1L);
		schema.setName("schema-name");
		schema.setSchema("schema-schema".getBytes());
		return schema;
	}

	public PublishedMessage getDefaultPublishedMessage() {
		PublishedMessage message = new PublishedMessage();
		message.setId(1L);
		message.setDateTime(new Date());
		message.setMessageId("message-id");
		message.setMessage("published-message".getBytes());
		message.setMessageLastUpdateTime(new Date());
		message.setMessageStatus(1);
		message.setMessageType(MessageType.RTZ);
		message.setSchema(this.getDefaultSchema());
		return message;
	}

	public ACLObject getDefaultAclObject() {
		ACLObject acl = new ACLObject();
		acl.setId(1L);
		acl.setLastUpdateTime(new Date());
		acl.setMessage("message");
		acl.setIdentities(Collections.singletonList(this.getDefaultIdentity()));
		return acl;
	}

	public String getDefaultTextMessageAsJSON() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(this.getDefaultTextMessage());
	}

}
