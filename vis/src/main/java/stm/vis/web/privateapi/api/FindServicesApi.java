package stm.vis.web.privateapi.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import stm.vis.web.privateapi.model.FindServicesRequestObj;
import stm.vis.web.privateapi.model.FindServicesResponseObj;

@javax.annotation.Generated(value = "class stm.vis.web.privateapi.codegen.languages.SpringCodegen", date = "2016-09-19T15:20:31.221Z")

@Api(value = "findServices", description = "the findServices API")
public interface FindServicesApi {

	@ApiOperation(value = "Discover services in SeaSWIM service registry", notes = "", response = FindServicesResponseObj.class, tags = {
			"FindServices", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = FindServicesResponseObj.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 401, message = "Unauthorized (the user cannot be authenticated in the Service Registry)", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden (the user is not authorized to requested service)", response = Void.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Void.class),
			@ApiResponse(code = 200, message = "unexpected error", response = Void.class) })

	@RequestMapping(value = "/privateapi/findServices", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<FindServicesResponseObj> findServicesFindServices(
			@ApiParam(value = "Filter keywords and organizationId for service instances", required = true) @Valid @RequestBody FindServicesRequestObj findServicesObj);

}
