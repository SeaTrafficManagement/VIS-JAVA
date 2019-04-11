package stm.vis.web.privateapi.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiParam;
import stm.vis.data.ResponseObject;
import stm.vis.exception.VISException;
import stm.vis.model.PublishedMessage;
import stm.vis.service.VISPrivateInterface;
import stm.vis.web.privateapi.model.PublishedMessageContract;
import stm.vis.web.privateapi.model.ResponseObj;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-10T12:58:37.496Z")

@Controller
public class PublishedMessageApiController implements PublishedMessageApi, GetPublishedMessagesApi, PublishMessageApi {

	@Autowired
	private VISPrivateInterface service;

	@Override
	public ResponseEntity<ResponseObj> publishMessagePublishMessage(
			@NotNull @ApiParam(value = "data Id for published message normally this is the UVID", required = true) @RequestParam(value = "dataId", required = true) String dataId,
			@NotNull @ApiParam(value = "Message type for published message (RTZ)", required = true) @RequestParam(value = "messageType", required = true) String messageType,
			@ApiParam(value = "Typically STM payload data (RTZ)", required = true) @Valid @RequestBody String message) {
		ResponseObject response = this.service.publishMessage(dataId, messageType, message);
		return this.createResponseEntity(response, dataId);
	}

	@Override
	public ResponseEntity<List<PublishedMessageContract>> publishMessageGetPublishedMessages() {
		List<PublishedMessage> publishedMessages = this.service.getPublishedMessages();
		return this.createResponseEntity(publishedMessages);
	}

	@Override
	public ResponseEntity<ResponseObj> publishMessageRemovePublishedMessage(
			@NotNull @ApiParam(value = "", required = true) @RequestParam(value = "dataId", required = true) String dataId) {
		try {
			this.service.removePublishedMessage(dataId);
			return this.createResponseEntity(HttpStatus.OK, dataId);
			} catch (VISException e) {
				e.printStackTrace();
				return this.createResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, dataId);
			}
		}

	private ResponseEntity<ResponseObj> createResponseEntity(HttpStatus status, String dataId) {
		ResponseObj obj = new ResponseObj();
		obj.setDataId(dataId);
		return new ResponseEntity<ResponseObj>(obj, status);
	}

	private ResponseEntity<List<PublishedMessageContract>> createResponseEntity(List<PublishedMessage> publishedMessages) {
		List<PublishedMessageContract> list = new ArrayList<>();
		for (PublishedMessage publishedMessage : publishedMessages) {
			list.add(this.convertToContract(publishedMessage));
		}
		return new ResponseEntity<List<PublishedMessageContract>>(list, HttpStatus.OK);
	}

	private ResponseEntity<ResponseObj> createResponseEntity(ResponseObject response, String dataId) {
		ResponseObj obj = new ResponseObj();
		obj.setDataId(dataId);
		HttpStatus status;
		switch (response.getStatusCode()) {
			case OK:
				obj.setDataId(response.getBody());
				status = HttpStatus.OK;
				break;
			case NOT_AUTHORIZED:
				status = HttpStatus.UNAUTHORIZED;
				break;
			default:
				status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<ResponseObj>(obj, status);
	}

	private PublishedMessageContract convertToContract(PublishedMessage publishedMessage) {
		PublishedMessageContract contract = new PublishedMessageContract();
		contract.setMessage(new String(publishedMessage.getMessage()));
		contract.setMessageID(publishedMessage.getMessageId());
		contract.setMessageLastUpdateTime(new DateTime(publishedMessage.getMessageLastUpdateTime()));
		contract.setMessageStatus(publishedMessage.getMessageStatus());
		contract.setMessageType(publishedMessage.getMessageType().name());
		contract.setMessageValidFrom(new DateTime(publishedMessage.getValidFrom()));
		contract.setMessageValidTo(new DateTime(publishedMessage.getValidTo()));
		contract.setPublishTime(new DateTime(publishedMessage.getDateTime()));
		return contract;
	}

}
