package io.swagger.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiParam;
import io.swagger.model.TextMessage;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-25T16:37:01.519Z")

@Controller
public class TextMessageApiController implements TextMessageApi {

	@Override
	public ResponseEntity<String> uploadTextMessage(
		@ApiParam(value = "Text message to add to VIS message db for delivery to STM Onboard system", required = true) @RequestBody TextMessage textMessage,
		@ApiParam(value = "Acknowledgement required, optionally an URL could be provided to send acknowledgment.") @RequestParam(value = "deliveryAckEndpoint", required = false) String deliveryAckEndpoint,
		@ApiParam(value = "TransactionId used for optionally providing a an Id to relate text messages to other messages exchanged") @RequestParam(value = "transactionId", required = false) String transactionId) {
		// TODO do some magic!
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
