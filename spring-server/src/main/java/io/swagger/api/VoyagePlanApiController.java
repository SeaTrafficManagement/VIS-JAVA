package io.swagger.api;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiParam;
import io.swagger.model.VoyagePlan;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-25T16:37:01.519Z")

@Controller
public class VoyagePlanApiController implements VoyagePlanApi {

	@Override
	public ResponseEntity<List<VoyagePlan>> getVoyagePlan(
		@ApiParam(value = "Acknowledgement required, optionally an URL could be provided to send acknowledgment.") @RequestParam(value = "deliveryAckEndpoint", required = false) String deliveryAckEndpoint,
		@ApiParam(value = "TransactionId used for optionally providing an Id to relate text messages to other messages exchanged") @RequestParam(value = "transactionId", required = false) String transactionId) {
		// TODO do some magic!
		return new ResponseEntity<List<VoyagePlan>>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<VoyagePlan> getVoyagePlanById(
		@ApiParam(value = "UVID of VoyagePlan to fetch.", required = true) @PathVariable("uvid") String uvid,
		@ApiParam(value = "Acknowledgement required, optionally an URL could be provided to send acknowledgment.") @RequestParam(value = "deliveryAckEndpoint", required = false) String deliveryAckEndpoint,
		@ApiParam(value = "TransactionId used for optionally providing a an Id to relate text messages to other messages exchanged") @RequestParam(value = "transactionId", required = false) String transactionId) {
		// TODO do some magic!
		return new ResponseEntity<VoyagePlan>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> removeVoyagePlanSubscription(@ApiParam(value = "An endpoint (URL) specifying the address where the subscribed data is to be posted", required = true) @RequestParam(value = "callBackendpoint", required = true) String callBackendpoint,
		@ApiParam(value = "Acknowledgement required, optionally an URL could be provided to send acknowledgment.") @RequestParam(value = "deliveryAckEndpoint", required = false) String deliveryAckEndpoint,
		@ApiParam(value = "TransactionId used for optionally providing a an Id to relate text messages to other messages exchanged") @RequestParam(value = "transactionId", required = false) String transactionId) {
		// TODO do some magic!
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> removeVoyagePlanSubscriptionById(
		@ApiParam(value = "UVID of VoyagePlan to fetch.", required = true) @PathVariable("uvid") String uvid,
		@ApiParam(value = "An endpoint (URL) specifying the address where the subscribed data is to be posted", required = true) @RequestParam(value = "callBackendpoint", required = true) String callBackendpoint,
		@ApiParam(value = "Acknowledgement required, optionally an URL could be provided to send acknowledgment.") @RequestParam(value = "deliveryAckEndpoint", required = false) String deliveryAckEndpoint,
		@ApiParam(value = "TransactionId used for optionally providing a an Id to relate text messages to other messages exchanged") @RequestParam(value = "transactionId", required = false) String transactionId) {
		// TODO do some magic!
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> subscribeToVoyagePlan(
		@ApiParam(value = "An endpoint (URL) specifying the address where the subscribed data is to be posted", required = true) @RequestParam(value = "callBackendpoint", required = true) String callBackendpoint,
		@ApiParam(value = "Identity of subscribing party, used for authorization purposes", required = true) @RequestParam(value = "subscriberIdentity", required = true) String subscriberIdentity,
		@ApiParam(value = "Specifies the desired expiration date for a subscription request") @RequestParam(value = "timeOfSubscriptionRequest", required = false) DateTime timeOfSubscriptionRequest,
		@ApiParam(value = "Acknowledgement required, optionally an URL could be provided to send acknowledgment.") @RequestParam(value = "deliveryAckEndpoint", required = false) String deliveryAckEndpoint,
		@ApiParam(value = "TransactionId used for optionally providing a an Id to relate text messages to other messages exchanged") @RequestParam(value = "transactionId", required = false) String transactionId) {
		// TODO do some magic!
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> subscribeToVoyagePlanById(
		@ApiParam(value = "UVID of VoyagePlan to fetch.", required = true) @PathVariable("uvid") String uvid,
		@ApiParam(value = "An endpoint (URL) specifying the address where the subscribed data is to be posted", required = true) @RequestParam(value = "callBackendpoint", required = true) String callBackendpoint,
		@ApiParam(value = "Specifies the desired expiration date for a subscription request") @RequestParam(value = "timeOfSubscriptionRequest", required = false) DateTime timeOfSubscriptionRequest,
		@ApiParam(value = "Acknowledgement required, optionally an URL could be provided to send acknowledgment.") @RequestParam(value = "deliveryAckEndpoint", required = false) String deliveryAckEndpoint,
		@ApiParam(value = "TransactionId used for optionally providing a an Id to relate text messages to other messages exchanged") @RequestParam(value = "transactionId", required = false) String transactionId) {
		// TODO do some magic!
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> uploadVoyagePlan(
		@ApiParam(value = "UVID of VoyagePlan to upload.", required = true) @RequestParam(value = "uvid", required = true) String uvid,
		@ApiParam(value = "VoyagePlan to add to VIS message db", required = true) @RequestBody VoyagePlan voyagePlan,
		@ApiParam(value = "Acknowledgement required, optionally an URL could be provided to send acknowledgment.") @RequestParam(value = "deliveryAckEndpoint", required = false) String deliveryAckEndpoint,
		@ApiParam(value = "TransactionId used for optionally providing a an Id to relate text messages to other messages exchanged") @RequestParam(value = "transactionId", required = false) String transactionId) {
		// TODO do some magic!
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
