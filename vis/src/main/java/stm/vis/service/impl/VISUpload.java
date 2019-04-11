package stm.vis.service.impl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import stm.vis.data.ResponseObject;
import stm.vis.data.SourceIdentity;
import stm.vis.data.StatusCode;
import stm.vis.data.messages.STMMessage;
import stm.vis.data.route.Route;
import stm.vis.data.textMessage.TextMessage;
import stm.vis.exception.MessageParseException;
import stm.vis.exception.MessageValidationException;
import stm.vis.model.Identity;
import stm.vis.model.UploadedMessage;
import stm.vis.service.MessageParser;
import stm.vis.service.MessageValidator;
import stm.vis.service.SchemaService;
import stm.vis.service.UploadedMessageService;
import stm.vis.service.VISUploadInterface;

@Service
public class VISUpload extends VISAbstractService implements VISUploadInterface {

	@Autowired
	private MessageParser parser;

	@Autowired
	private MessageValidator validator;

	@Autowired
	private SchemaService schemaService;

	@Autowired
	private UploadedMessageService uploadedMessageService;

	@Override
	public ResponseObject uploadVoyagePlan(SourceIdentity sourceIdentity, STMMessage voyagePlan, String deliveryAckEndpoint, String callbackEndPoint) {
		try {
			URI uriDeliveryAckEndpoint = deliveryAckEndpoint == null ? null : new URI(deliveryAckEndpoint);
			URI  uriCallbackEndPoint = callbackEndPoint == null ? null : new URI(callbackEndPoint);
			return this.uploadVoyagePlan(sourceIdentity, voyagePlan, uriDeliveryAckEndpoint, uriCallbackEndPoint);
		} catch (Exception e) {
			return this.getResponseObject(StatusCode.ERROR, e.getMessage());
		}
	}

	private ResponseObject uploadVoyagePlan(SourceIdentity sourceIdentity, STMMessage voyagePlan, URI deliveryAckEndpoint, URI callbackEndPoint) {
		/* Operation functionality
		 * 
		 * The voyage plan is checked against the RTZ schema and internal rules
		 *   - In addition to the RTZ schema the following attributes is mandatory; vesselVoyage and routeStatus
		 * If delivery ACK is requested, VIS sends a delivery ACK to the requested endpoint when VIS has delivered the uploaded message to private application.
		 */

		try {
			this.validator.validateMessage(voyagePlan, this.schemaService.getRouteSchema());
			Route route = this.parser.getRouteFromMessage(voyagePlan);
			this.validateVoyagePlanWithInternalRules(route);
			String uvid = this.getUVIDFromRoute(route);
			// TODO [documentation] more details about callbackEndPoint
			this.upload(sourceIdentity, voyagePlan, deliveryAckEndpoint, uvid);
			return this.getResponseObject(StatusCode.OK);
		} catch (MessageValidationException e) {
			e.printStackTrace();
			return this.getResponseObject(StatusCode.SCHEMA_NOK, "Error validating voyage plan");
		} catch (MessageParseException e) {
			e.printStackTrace();
			return this.getResponseObject(StatusCode.SCHEMA_NOK, "Error parsing voyage plan");
		}
	}

	 /** 
	  * In addition to the RTZ schema the following attributes is mandatory; vesselVoyage and routeStatus
	  * @param route
	 * @throws MessageValidationException 
	  */
	private void validateVoyagePlanWithInternalRules(Route route) throws MessageValidationException {
		String errors = "";
		String vesselVoyage = route.getRouteInfo().getVesselVoyage();
		if (vesselVoyage == null) {
			errors = errors + "vesselVoyage";
		}
		String routeStatus = route.getRouteInfo().getRouteStatus();
		if (routeStatus == null) {
			errors = errors + "routeStatus";
		}
		if (!StringUtils.isEmpty(errors)) {
			throw new MessageValidationException("Mandatory fields: " + errors);
		}
	}

	@Override
	public ResponseObject uploadTextMessage(SourceIdentity sourceIdentity, String textMessage, String deliveryAckEndpoint) {
		try {
			URI uri = deliveryAckEndpoint == null ? null : new URI(deliveryAckEndpoint);
			return this.uploadTextMessage(sourceIdentity, textMessage, uri);
		} catch (Exception e) {
			return this.getResponseObject(StatusCode.ERROR, e.getMessage());
		}
	}

	private ResponseObject uploadTextMessage(SourceIdentity sourceIdentity, String message, URI deliveryAckEndpoint) {
		/* 
		 * - The uploaded message is stored in cache 
		 * - The textMessage is checked against the textMessage schema
		 * - If correct, a notification is sent to STM Module
		 * - If delivery ACK is requested, the flag is set in cache and when the STM Module calls getMessage, VIS sends the message to STM Module and a delivery ACK to the requested endpoint.
		 * - A transaction ID is provided in response body
		 */

		try {
			TextMessage textMessage = this.parser.getTextMessageFromMessage(message.getBytes());
			STMMessage stmMessage = this.parser.getMessageFromTextMessage(textMessage);
			this.upload(sourceIdentity, stmMessage, deliveryAckEndpoint);
			return this.getResponseObject(StatusCode.OK);
		} catch (MessageValidationException | MessageParseException e) {
			e.printStackTrace();
			return this.getResponseObject(StatusCode.SCHEMA_NOK, "Error validating text message");
		}
	}

	@Override
	public ResponseObject uploadArea(SourceIdentity sourceIdentity, STMMessage area, String deliveryAckEndpoint) {
		try {
			URI uri = deliveryAckEndpoint == null ? null : new URI(deliveryAckEndpoint);
			return this.uploadArea(sourceIdentity, area, uri);
		} catch (Exception e) {
			return this.getResponseObject(StatusCode.ERROR, e.getMessage());
		}
	}

	private ResponseObject uploadArea(SourceIdentity sourceIdentity, STMMessage message, URI deliveryAckEndpoint) {
		/* 
		 * - The uploaded message is stored in cache 
		 * - The message is checked against the area schema
		 * - If correct, a notification is sent to STM Module
		 * - If delivery ACK is requested, the flag is set in cache and when the STM Module calls getMessage, VIS sends the message to STM Module and a delivery ACK to the requested endpoint.
		 * - A transaction ID is provided in response body
		 */

		try {
			this.parser.getPolygonFromMessage(message);
			this.upload(sourceIdentity, message, deliveryAckEndpoint);
			return this.getResponseObject(StatusCode.OK);
		} catch (MessageParseException e) {
			e.printStackTrace();
			return this.getResponseObject(StatusCode.SCHEMA_NOK, "Error validating area");
		}
	}

	private ResponseObject upload(SourceIdentity sourceIdentity, STMMessage message, URI deliveryAckEndpoint) {
		return this.upload(sourceIdentity, message, deliveryAckEndpoint, null);
	}

	private ResponseObject upload(SourceIdentity sourceIdentity, STMMessage message, URI deliveryAckEndpoint, String messageId) {
		/* 
		 * - Store message
		 * - Send "notify" to STM Module
		 */
		Identity identity = this.getIdentity(sourceIdentity);
		Long dataId = this.storeMessage(identity, message, deliveryAckEndpoint);
		this.sendMessageWaitingNotificationToSTMModule(sourceIdentity, Long.toString(dataId), message.getData());
		return this.getResponseObject(StatusCode.OK, "Message uploaded");
	}

	private Identity getIdentity(SourceIdentity sourceIdentity) {
		Identity identity = new Identity();
		identity.setId(sourceIdentity.getServiceId());
		identity.setName(sourceIdentity.getServiceName());
		return identity;
	}

	private ResponseObject getResponseObject(StatusCode code) {
		ResponseObject response = new ResponseObject();
		response.setStatusCode(code);
		return response;
	}

	private ResponseObject getResponseObject(StatusCode code, String body) {
		ResponseObject response = new ResponseObject();
		response.setStatusCode(code);
		response.setBody(body);
		return response;
	}

	/**
	 * Queue until forwarded to ship.
	 * Insert post in table uploadedMessages 
	 * @return the created unique id
	 */
	private Long storeMessage(Identity identity, STMMessage message, URI deliveryAckEndpoint) {
		/* 
		 * - Create and insert post in table uploadedMessages
		 * - return internal id for inserted post
		 */
		UploadedMessage uploadedMessage = this.uploadedMessageService.saveUploadedMessage(identity, message, deliveryAckEndpoint);
		return uploadedMessage.getId();
	}
}
