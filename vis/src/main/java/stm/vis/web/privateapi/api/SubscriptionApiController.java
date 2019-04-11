package stm.vis.web.privateapi.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiParam;
import stm.vis.exception.VISException;
import stm.vis.model.Subscription;
import stm.vis.service.VISPrivateInterface;
import stm.vis.web.privateapi.model.ResponseObj;
import stm.vis.web.privateapi.model.SubscriptionObject;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-13T06:38:39.503Z")

@Controller
public class SubscriptionApiController implements SubscriptionApi {

	private static final Logger log = LoggerFactory.getLogger(SubscriptionApiController.class);

	@Autowired
	private VISPrivateInterface service;

	@Override
	public ResponseEntity<ResponseObj> addSubscription(
			@ApiParam(value = "Identities to add as subscribers on dataId", required = true) @Valid @RequestBody List<SubscriptionObject> subscriptions,
			@NotNull @ApiParam(value = "", required = true) @RequestParam(value = "dataId", required = true) String dataId) {
		try {
			this.service.addSubscriptions(subscriptions, dataId);
			return this.createResponseEntity(dataId);
		} catch (VISException e) {
			log.error("Error in addSubscriptions: " + e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<List<SubscriptionObject>> getSubscriptions(
			@ApiParam(value = "Data id usually an uvid") @RequestParam(value = "dataId", required = false) String dataId) {
		List<Subscription> subscriptions = this.service.getSubscriptions(dataId);
		return this.createResponseEntity(subscriptions);
	}

	@Override
	public ResponseEntity<List<SubscriptionObject>> removeSubscriptions(
			@NotNull @ApiParam(value = "", required = true) @RequestParam(value = "dataId", required = true) String dataId,
			@ApiParam(value = "", required = true) @Valid @RequestBody List<SubscriptionObject> subscriptionObjects) {
		try {
			this.service.removeSubscriptions(subscriptionObjects, dataId);
			return new ResponseEntity<List<SubscriptionObject>>(subscriptionObjects, HttpStatus.OK);
		} catch (VISException e) {
			log.error("Error in removeSubscriptions: " + e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private ResponseEntity<ResponseObj> createResponseEntity(String dataId) {
		ResponseObj response = new ResponseObj();
		response.setDataId(dataId);
		return new ResponseEntity<ResponseObj>(response, HttpStatus.OK);
	}

	private ResponseEntity<List<SubscriptionObject>> createResponseEntity(List<Subscription> subscriptions) {
		List<SubscriptionObject> list = new ArrayList<>();
		for (Subscription subscription : subscriptions) {
			list.add(this.toSubscriptionObject(subscription));
		}
		return new ResponseEntity<List<SubscriptionObject>>(list, HttpStatus.OK);
	}

	private SubscriptionObject toSubscriptionObject(Subscription subscription) {
		SubscriptionObject object = new SubscriptionObject();
		object.setIdentityId(subscription.getSubscriberIdentity().getId());
		object.setIdentityName(subscription.getSubscriberIdentity().getName());
		object.setEndpointURL(subscription.getCallbackEndpoint());
		return object;
	}

}
