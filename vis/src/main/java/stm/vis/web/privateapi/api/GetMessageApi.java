package stm.vis.web.privateapi.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import stm.vis.web.privateapi.model.MessageEnvelope;

@javax.annotation.Generated(value = "class stm.vis.web.privateapi.codegen.languages.SpringCodegen", date = "2016-09-19T15:20:31.221Z")

@Api(value = "getMessage", description = "the getMessage API")
public interface GetMessageApi {

	@ApiOperation(value = "Retrieve received messages from VIS database", notes = "", response = MessageEnvelope.class, tags = {
			"GetMessage", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = MessageEnvelope.class),
			@ApiResponse(code = 200, message = "Unexpected error", response = Void.class) })

	@RequestMapping(value = "/privateapi/getMessage", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<MessageEnvelope> getMessageGetMessage(
			@ApiParam(value = "Limit the number of messages to be received") @RequestParam(value = "limitQuery", required = false) String limitQuery);

}
