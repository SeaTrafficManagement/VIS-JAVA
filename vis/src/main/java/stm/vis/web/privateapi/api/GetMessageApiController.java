package stm.vis.web.privateapi.api;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiParam;
import stm.vis.data.messages.Messages;
import stm.vis.data.messages.VISMessage;
import stm.vis.service.VISPrivateInterface;
import stm.vis.web.privateapi.model.Message;
import stm.vis.web.privateapi.model.MessageEnvelope;
import stm.vis.web.privateapi.model.StmMessage;

@javax.annotation.Generated(value = "class stm.vis.web.privateapi.codegen.languages.SpringCodegen", date = "2016-09-19T15:20:31.221Z")

@Controller
public class GetMessageApiController implements GetMessageApi {

	private static final Logger log = LoggerFactory.getLogger(GetMessageApiController.class);
	
	@Autowired
	private VISPrivateInterface service;

	@Override
	public ResponseEntity<MessageEnvelope> getMessageGetMessage(
			@ApiParam(value = "Limit the number of messages to be received") @RequestParam(value = "limitQuery", required = false) String limitQuery) {
		Integer limit = null;
		try {
			limit = Integer.parseInt(limitQuery);
		} catch (NumberFormatException ex) {
			log.warn("Invalid limitQuery received: " + limitQuery);
		}
		Messages messages = this.service.getMessages(limit);
		return this.createResponseEntity(messages);
	}

	private ResponseEntity<MessageEnvelope> createResponseEntity(Messages messages) {
		List<Message> list = new ArrayList<>();
		for (VISMessage message : messages.getMessages()) {
			list.add(this.convertToMessage(message));
		}

		MessageEnvelope envelope = new MessageEnvelope();
		envelope.setNumberOfMessages(messages.getNumberOfMessages());
		envelope.setRemainingNumberOfMessages(messages.getRemainingNumberOfMessages());
		envelope.setMessage(list);

		return new ResponseEntity<MessageEnvelope>(envelope, HttpStatus.OK);
	}

	private Message convertToMessage(VISMessage message) {
		// TODO Add fields to VISMessage: callbackEndpoint, fromOrgId, fromOrgName, fromServiceId
		// TODO Remove field from VISMessage: from 
		return new Message()
//				.callbackEndpoint(callbackEndpoint)
				.id(message.getId())
				.receivedAt(new DateTime(message.getReceivedAt()))
//				.fromOrgId(fromOrgId)
//				.fromOrgName(fromOrgName)
//				.fromServiceId(fromServiceId)
				.messageType(message.getMessageType().name())
				.stmMessage(this.convertToStmMessage(message));
	}

	private StmMessage convertToStmMessage(VISMessage message) {
		return new StmMessage().message(new String(message.getMessage()));
	}

}
