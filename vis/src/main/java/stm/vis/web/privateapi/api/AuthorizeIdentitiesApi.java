package stm.vis.web.privateapi.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
import stm.vis.web.privateapi.model.IdentityDescriptionObject;
import stm.vis.web.privateapi.model.ResponseObj;

@javax.annotation.Generated(value = "class stm.vis.web.privateapi.codegen.languages.SpringCodegen", date = "2016-09-19T15:20:31.221Z")

@Api(value = "authorizeIdentities", description = "the authorizeIdentities API")
public interface AuthorizeIdentitiesApi {

	@ApiOperation(value = "", notes = "Find list of authorized identities to Voyage Plans", response = IdentityDescriptionObject.class, responseContainer = "List", tags = {
			"AuthorizeIdentities", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = IdentityDescriptionObject.class, responseContainer = "List"),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found ( requested identities are not found)", response = Void.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Void.class),
			@ApiResponse(code = 200, message = "unexpected error", response = Void.class) })

	@RequestMapping(value = "/privateapi/authorizeIdentities", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<IdentityDescriptionObject>> findAuthorizedIdentities(
			@NotNull @ApiParam(value = "Data id usually an uvid", required = true) @RequestParam(value = "dataId", required = true) String dataId);

	@ApiOperation(value = "", notes = "Authorize identities to Voyage Plan", response = ResponseObj.class, tags = {
			"AuthorizeIdentities", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ResponseObj.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Void.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Void.class),
			@ApiResponse(code = 200, message = "unexpected error", response = Void.class) })

	@RequestMapping(value = "/privateapi/authorizeIdentities", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<ResponseObj> authorizeIdentities(
			@NotNull @ApiParam(value = "Data id usually an UVID", required = true) @RequestParam(value = "dataId", required = true) String dataId,
			@ApiParam(value = "Attributes to describe an organization in STM", required = true) @Valid @RequestBody List<IdentityDescriptionObject> identityDescriptionObjects);

	@ApiOperation(value = "Remove Authorize identities to Voyage Plan", notes = "", response = ResponseObj.class, tags = {
			"AuthorizeIdentities", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseObj.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found ( requested identities are not found)", response = Void.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Void.class),
			@ApiResponse(code = 200, message = "unexpected error", response = Void.class) })

	@RequestMapping(value = "/privateapi/authorizeIdentities", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.DELETE)
	ResponseEntity<ResponseObj> authorizeIdentitiesRemoveAuthorizedIdentitites(
			@NotNull @ApiParam(value = "Data id usually an uvid", required = true) @RequestParam(value = "dataId", required = true) String dataId,
			@ApiParam(value = "Attributes to describe an organization in STM", required = true) @Valid @RequestBody List<IdentityDescriptionObject> identityDescriptionObjects);

}
