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
import stm.vis.web.privateapi.model.ResponseObj;
import stm.vis.web.privateapi.model.SubscriptionObject;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-13T06:38:39.503Z")

@Api(value = "subscription", description = "the subscription API")
public interface SubscriptionApi {

	@ApiOperation(value = "", notes = "", response = ResponseObj.class, tags = { "Subscription", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ResponseObj.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Void.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Void.class),
			@ApiResponse(code = 200, message = "unexpected error", response = Void.class) })

	@RequestMapping(value = "/privateapi/subscription", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<ResponseObj> addSubscription(
			@ApiParam(value = "Identities to add as subscribers on dataId", required = true) @Valid @RequestBody List<SubscriptionObject> subscriptions,
			@NotNull @ApiParam(value = "", required = true) @RequestParam(value = "dataId", required = true) String dataId);

	@ApiOperation(value = "", notes = "Find list of subscriber identities to Voyage Plans", response = SubscriptionObject.class, responseContainer = "List", tags = {
			"Subscription", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = SubscriptionObject.class, responseContainer = "List"),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found ( requested identities are not found)", response = Void.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Void.class),
			@ApiResponse(code = 200, message = "unexpected error", response = Void.class) })

	@RequestMapping(value = "/privateapi/subscription", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<SubscriptionObject>> getSubscriptions(
			@ApiParam(value = "Data id usually an uvid") @RequestParam(value = "dataId", required = false) String dataId);

	@ApiOperation(value = "", notes = "", response = SubscriptionObject.class, responseContainer = "List", tags = {
			"Subscription", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = SubscriptionObject.class, responseContainer = "List"),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found ( requested identities are not found)", response = Void.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Void.class),
			@ApiResponse(code = 200, message = "unexpected error", response = Void.class) })

	@RequestMapping(value = "/privateapi/subscription", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.DELETE)
	ResponseEntity<List<SubscriptionObject>> removeSubscriptions(
			@NotNull @ApiParam(value = "", required = true) @RequestParam(value = "dataId", required = true) String dataId,
			@ApiParam(value = "", required = true) @Valid @RequestBody List<SubscriptionObject> subscriptionObjects);

}
