package io.swagger.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.TextMessage;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-25T16:37:01.519Z")

@Api(value = "textMessage", description = "the textMessage API")
public interface TextMessageApi {

	@ApiOperation(value = "", notes = "Upload text message to VIS from other services i.e. Route Optimization service.", response = String.class, tags = {})
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "uploadTextMessage successful", response = String.class),
		@ApiResponse(code = 200, message = "unexpected error", response = String.class) })
	@RequestMapping(value = "/textMessage", produces = { "application/json", "application/xml", "text/xml", "text/html" }, consumes = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<String> uploadTextMessage(
		@ApiParam(value = "Text message to add to VIS message db for delivery to STM Onboard system", required = true) @RequestBody TextMessage textMessage,
		@ApiParam(value = "Acknowledgement required, optionally an URL could be provided to send acknowledgment.") @RequestParam(value = "deliveryAckEndpoint", required = false) String deliveryAckEndpoint,
		@ApiParam(value = "TransactionId used for optionally providing a an Id to relate text messages to other messages exchanged") @RequestParam(value = "transactionId", required = false) String transactionId);

}
