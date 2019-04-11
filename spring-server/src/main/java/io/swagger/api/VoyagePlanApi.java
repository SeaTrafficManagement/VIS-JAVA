package io.swagger.api;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.VoyagePlan;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-25T16:37:01.519Z")

@Api(value = "voyagePlan", description = "the voyagePlan API")
public interface VoyagePlanApi {

	@ApiOperation(value = "", notes = "Returns active VoyagePlan", response = VoyagePlan.class, responseContainer = "List", tags = {})
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "getVoyagePlan response", response = VoyagePlan.class),
		@ApiResponse(code = 200, message = "unexpected error", response = VoyagePlan.class) })
	@RequestMapping(value = "/voyagePlan", produces = { "application/json", "application/xml", "text/xml", "text/html" }, consumes = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<VoyagePlan>> getVoyagePlan(
		@ApiParam(value = "Acknowledgement required, optionally an URL could be provided to send acknowledgment.") @RequestParam(value = "deliveryAckEndpoint", required = false) String deliveryAckEndpoint,
		@ApiParam(value = "TransactionId used for optionally providing an Id to relate text messages to other messages exchanged") @RequestParam(value = "transactionId", required = false) String transactionId);

	@ApiOperation(value = "", notes = "Returns a VoyagePlan based on a single UVID", response = VoyagePlan.class, tags = {})
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "getVoyagePlanById response", response = VoyagePlan.class),
		@ApiResponse(code = 200, message = "unexpected error", response = VoyagePlan.class) })
	@RequestMapping(value = "/voyagePlan/{uvid}", produces = { "application/json", "application/xml", "text/xml", "text/html" }, consumes = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<VoyagePlan> getVoyagePlanById(
		@ApiParam(value = "UVID of VoyagePlan to fetch.", required = true) @PathVariable("uvid") String uvid,
		@ApiParam(value = "Acknowledgement required, optionally an URL could be provided to send acknowledgment.") @RequestParam(value = "deliveryAckEndpoint", required = false) String deliveryAckEndpoint,
		@ApiParam(value = "TransactionId used for optionally providing a an Id to relate text messages to other messages exchanged") @RequestParam(value = "transactionId", required = false) String transactionId);

	@ApiOperation(value = "", notes = "Remove subscription for active Voyage Plan from other services i.e. Enhanced Monitoring", response = String.class, tags = {})
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Removal of subscription for all Voyage Plans message received successfully", response = String.class),
		@ApiResponse(code = 200, message = "unexpected error", response = String.class) })
	@RequestMapping(value = "/voyagePlan/subscribe", produces = { "application/json" }, consumes = { "application/json" }, method = RequestMethod.DELETE)
	ResponseEntity<String> removeVoyagePlanSubscription(@ApiParam(value = "An endpoint (URL) specifying the address where the subscribed data is to be posted", required = true) @RequestParam(value = "callBackendpoint", required = true) String callBackendpoint,
		@ApiParam(value = "Acknowledgement required, optionally an URL could be provided to send acknowledgment.") @RequestParam(value = "deliveryAckEndpoint", required = false) String deliveryAckEndpoint,
		@ApiParam(value = "TransactionId used for optionally providing a an Id to relate text messages to other messages exchanged") @RequestParam(value = "transactionId", required = false) String transactionId);

	@ApiOperation(value = "", notes = "remove subscription for a specific Voyage Plan from other services i.e. Enhanced Monitoring", response = String.class, tags = {})
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Removal of subscription for a specific Voyage Plan message received successfully", response = String.class),
		@ApiResponse(code = 200, message = "unexpected error", response = String.class) })
	@RequestMapping(value = "/voyagePlan/subscribe/{uvid}", produces = { "application/json" }, consumes = { "application/json" }, method = RequestMethod.DELETE)
	ResponseEntity<String> removeVoyagePlanSubscriptionById(
		@ApiParam(value = "UVID of VoyagePlan to fetch.", required = true) @PathVariable("uvid") String uvid,
		@ApiParam(value = "An endpoint (URL) specifying the address where the subscribed data is to be posted", required = true) @RequestParam(value = "callBackendpoint", required = true) String callBackendpoint,
		@ApiParam(value = "Acknowledgement required, optionally an URL could be provided to send acknowledgment.") @RequestParam(value = "deliveryAckEndpoint", required = false) String deliveryAckEndpoint,
		@ApiParam(value = "TransactionId used for optionally providing a an Id to relate text messages to other messages exchanged") @RequestParam(value = "transactionId", required = false) String transactionId);

	@ApiOperation(value = "", notes = "Request subscription for active Voyage Plan from other services i.e. Enhanced Monitoring", response = String.class, tags = {})
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Subscribe to active Voyage Plan message received successfully", response = String.class),
		@ApiResponse(code = 200, message = "unexpected error", response = String.class) })
	@RequestMapping(value = "/voyagePlan/subscribe", produces = { "application/json" }, consumes = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<String> subscribeToVoyagePlan(@ApiParam(value = "An endpoint (URL) specifying the address where the subscribed data is to be posted", required = true) @RequestParam(value = "callBackendpoint", required = true) String callBackendpoint, @ApiParam(value = "Identity of subscribing party, used for authorization purposes", required = true) @RequestParam(value = "subscriberIdentity", required = true) String subscriberIdentity,
		@ApiParam(value = "Specifies the desired expiration date for a subscription request") @RequestParam(value = "timeOfSubscriptionRequest", required = false) DateTime timeOfSubscriptionRequest, @ApiParam(value = "Acknowledgement required, optionally an URL could be provided to send acknowledgment.") @RequestParam(value = "deliveryAckEndpoint", required = false) String deliveryAckEndpoint,
		@ApiParam(value = "TransactionId used for optionally providing a an Id to relate text messages to other messages exchanged") @RequestParam(value = "transactionId", required = false) String transactionId);

	@ApiOperation(value = "", notes = "Request subscription for a specific Voyage Plan from other services i.e. Enhanced Monitoring", response = String.class, tags = {})
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Subscribe to active Voyage Plan message received successfully", response = String.class),
		@ApiResponse(code = 200, message = "unexpected error", response = String.class) })
	@RequestMapping(value = "/voyagePlan/subscribe/{uvid}", produces = { "application/json" }, consumes = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<String> subscribeToVoyagePlanById(
		@ApiParam(value = "UVID of VoyagePlan to fetch.", required = true) @PathVariable("uvid") String uvid,
		@ApiParam(value = "An endpoint (URL) specifying the address where the subscribed data is to be posted", required = true) @RequestParam(value = "callBackendpoint", required = true) String callBackendpoint,
		@ApiParam(value = "Specifies the desired expiration date for a subscription request") @RequestParam(value = "timeOfSubscriptionRequest", required = false) DateTime timeOfSubscriptionRequest,
		@ApiParam(value = "Acknowledgement required, optionally an URL could be provided to send acknowledgment.") @RequestParam(value = "deliveryAckEndpoint", required = false) String deliveryAckEndpoint,
		@ApiParam(value = "TransactionId used for optionally providing a an Id to relate text messages to other messages exchanged") @RequestParam(value = "transactionId", required = false) String transactionId);

	@ApiOperation(value = "", notes = "Upload VoyagePlan to VIS from other services i.e. Route Optimization service.", response = String.class, tags = {})
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "uploadVoyagePlan successful", response = String.class),
		@ApiResponse(code = 200, message = "unexpected error", response = String.class) })
	@RequestMapping(value = "/voyagePlan", produces = { "application/json" }, consumes = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<String> uploadVoyagePlan(@ApiParam(value = "UVID of VoyagePlan to upload.", required = true) @RequestParam(value = "uvid", required = true) String uvid,
		@ApiParam(value = "VoyagePlan to add to VIS message db", required = true) @RequestBody VoyagePlan voyagePlan,
		@ApiParam(value = "Acknowledgement required, optionally an URL could be provided to send acknowledgment.") @RequestParam(value = "deliveryAckEndpoint", required = false) String deliveryAckEndpoint,
		@ApiParam(value = "TransactionId used for optionally providing a an Id to relate text messages to other messages exchanged") @RequestParam(value = "transactionId", required = false) String transactionId);

}
