package stm.vis.web.privateapi.api;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import stm.vis.web.privateapi.model.ResponseObj;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-10T12:58:37.496Z")

@Api(value = "publishedMessage", description = "the publishedMessage API")
public interface PublishedMessageApi {

	@ApiOperation(value = "Remove published message", notes = "", response = ResponseObj.class, tags = {
			"PublishMessage", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ResponseObj.class) })

	@RequestMapping(value = "/privateapi/publishedMessage", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.DELETE)
	ResponseEntity<ResponseObj> publishMessageRemovePublishedMessage(
			@NotNull @ApiParam(value = "", required = true) @RequestParam(value = "dataId", required = true) String dataId);

}
