package stm.vis.web.publicapi.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiParam;
import stm.vis.data.GetVPResponseObject;
import stm.vis.data.ResponseObject;
import stm.vis.data.SourceIdentity;
import stm.vis.data.messages.MessageType;
import stm.vis.data.messages.RouteStatus;
import stm.vis.data.messages.STMMessage;
import stm.vis.exception.VISException;
import stm.vis.model.Subscription;
import stm.vis.service.VISGetInterface;
import stm.vis.service.VISSubscriptionInterface;
import stm.vis.service.VISUploadInterface;
import stm.vis.web.publicapi.model.GetSubscriptionResponse;
import stm.vis.web.publicapi.model.GetVoyagePlanResponse;
import stm.vis.web.publicapi.model.VoyagePlan;

@javax.annotation.Generated(value = "class stm.vis.web.publicapi.codegen.languages.SpringCodegen", date = "2016-09-19T15:19:39.094Z")

@Controller
public class VoyagePlansApiController extends BasePublicApiController implements VoyagePlansApi {

	private static final Logger log = LoggerFactory.getLogger(VoyagePlansApiController.class);

	@Autowired
	private VISGetInterface getService;

	@Autowired
	private VISSubscriptionInterface subscriptionService;

	@Autowired
	private VISUploadInterface uploadService;

	@Override
	public ResponseEntity<List<GetSubscriptionResponse>> getSubscriptionToVoyagePlans(HttpServletRequest request,
			@NotNull @ApiParam(value = "Callback expected. Base URL of the vis instance as in the Service Registry. The callback response will be sent to the voyagePlans endPoint of the instance", required = true) @RequestParam(value = "callbackEndpoint", required = true) String callbackEndpoint) {
		try {
			List<Subscription> response = this.subscriptionService.getSubscriptions(this.getSourceIdentity(request), callbackEndpoint);
			return this.createResponseEntity(response);
		} catch (VISException e) {
			log.error("Error in getSubscriptionToVoyagePlans: " + e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<GetVoyagePlanResponse> getVoyagePlans(HttpServletRequest request,
			@ApiParam(value = "Unique identity (UVID) of a voyage plan") @RequestParam(value = "uvid", required = false) String uvid,
			@ApiParam(value = "Status of a route for a voyageplan: 1-Original   2-Planned_for_voyage    3-Optimized 4-Cross_Checked 5-Safety_Checked    6-Approved  7-Used_for_monitoring   8-Inactive") @RequestParam(value = "routeStatus", required = false) String routeStatus) {
		SourceIdentity sourceIdentity = null;
		try {
			sourceIdentity = this.getSourceIdentity(request);
			this.logEvent(sourceIdentity.getOrganisationMrn(), sourceIdentity.getServiceId(), 1, 7, this.getGetVoyagePlansLogParameters(uvid, routeStatus), 8, null);
			GetVPResponseObject response = this.getService.getVoyagePlans(sourceIdentity, uvid, RouteStatus.fromValue(routeStatus));
			this.logReturn(sourceIdentity.getOrganisationMrn(), sourceIdentity.getServiceId(), 2, 1, getGetVoyagePlansLogParameters(uvid, routeStatus), 1, response);
			return this.createResponseEntity(response);
		} catch (VISException e) {
			log.error("Error in getVoyagePlans: " + e.getMessage(), e);
			if (sourceIdentity != null) {
				this.logError(sourceIdentity.getOrganisationMrn(), sourceIdentity.getServiceId(), 2, 5, this.getGetVoyagePlansLogParameters(uvid, routeStatus), e);
			}
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private String getGetVoyagePlansLogParameters(String uvid, String  routeStatus) {
		return "uvid=" + uvid + ", routeStatus=" + routeStatus;
	}

	@Override
	public ResponseEntity<Void> removeVoyagePlanSubscription(HttpServletRequest request,
			@NotNull @ApiParam(value = "Callback expected. Base url of the vis instance as in the Service Registry. The callback response will be sent to the voyagePlans endPoint of the instance", required = true) @RequestParam(value = "callbackEndpoint", required = true) String callbackEndpoint,
			@ApiParam(value = "Unique identity (UVID) of a voyage plan") @RequestParam(value = "uvid", required = false) String uvid) {
		try {
			ResponseObject response = this.subscriptionService.removeVoyagePlanSubscription(this.getSourceIdentity(request), uvid, callbackEndpoint);
			return this.createResponseEntity(response);
		} catch (VISException e) {
			log.error("Error in removeVoyagePlanSubscription: " + e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Void> subscribeToVoyagePlan(HttpServletRequest request,
			@NotNull @ApiParam(value = "Callback expected. Base URL of the vis instance as in the Service Registry. The callback response will be sent to the voyagePlans endPoint of the instance", required = true) @RequestParam(value = "callbackEndpoint", required = true) String callbackEndpoint,
			@ApiParam(value = "Unique identity (UVID) of a voyageplan. If no uvid is provided, the subscription is to all the active uvid that your organization has access to") @RequestParam(value = "uvid", required = false) String uvid) {
		SourceIdentity sourceIdentity = null;
		try {
			sourceIdentity = this.getSourceIdentity(request);
			this.logEvent(sourceIdentity.getOrganisationMrn(), sourceIdentity.getServiceId(), 9, 7, this.getSubscribeToVoyagePlansLogParameters(callbackEndpoint, uvid), 8, null);
			ResponseObject response = this.subscriptionService.subscribeToVoyagePlan(sourceIdentity, uvid, callbackEndpoint);
			return this.createResponseEntity(response);
		} catch (VISException e) {
			log.error("Error in subscribeToVoyagePlan: " + e.getMessage(), e);
			if (sourceIdentity != null) {
				this.logError(sourceIdentity.getOrganisationMrn(), sourceIdentity.getServiceId(), 10, 5, this.getSubscribeToVoyagePlansLogParameters(callbackEndpoint, uvid), e);
			}
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private String getSubscribeToVoyagePlansLogParameters(String callbackEndpoint, String uvid) {
		return "callbackEndpoint=" + callbackEndpoint + ", uvid=" + uvid;
	}

	@Override
	public ResponseEntity<Void> uploadVoyagePlan(HttpServletRequest request,
			@ApiParam(value = "Voyage Plan in RTZ v1.1STM. vesselVoyage and routeStatusEnum is required", required = true) @Valid @RequestBody String voyagePlan,
			@ApiParam(value = "Acknowledgement expected. Base URL for VIS as in Service Registry. An ACK is expected to this URL when the receiving private application retrieve the message") @RequestParam(value = "deliveryAckEndPoint", required = false) String deliveryAckEndPoint,
			@ApiParam(value = "Callback expected. Base URL of the VIS instance as in the Service Registry. The callback response will be sent to the voyagePlans endPoint of the instance") @RequestParam(value = "callbackEndpoint", required = false) String callbackEndpoint) {
		SourceIdentity sourceIdentity = null;
		try {
			sourceIdentity = this.getSourceIdentity(request);
			this.logEvent(sourceIdentity.getOrganisationMrn(), sourceIdentity.getServiceId(), 3, 7, this.uploadVoyagePlansLogParameters(deliveryAckEndPoint, callbackEndpoint), 1, voyagePlan);
			ResponseObject response = this.uploadService.uploadVoyagePlan(sourceIdentity, this.getStmMessage(voyagePlan), deliveryAckEndPoint, callbackEndpoint);
			return this.createResponseEntity(response);
		} catch (VISException e) {
			log.error("Error in uploadVoyagePlan: " + e.getMessage(), e);
			if (sourceIdentity != null) {
				this.logError(sourceIdentity.getOrganisationMrn(), sourceIdentity.getServiceId(), 4, 5, this.uploadVoyagePlansLogParameters(deliveryAckEndPoint, callbackEndpoint), e);
			}
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private String uploadVoyagePlansLogParameters(String deliveryAckEndPoint, String callbackEndPoint) {
		return "deliveryAckEndPoint=" + deliveryAckEndPoint + ", callbackEndPoint=" + callbackEndPoint;
	}

	private STMMessage getStmMessage(String voyagePlan) {
		STMMessage message = new STMMessage();
		message.setMessageType(MessageType.RTZ);
		message.setData(voyagePlan.getBytes());
		return message;
	}

	private ResponseEntity<GetVoyagePlanResponse> createResponseEntity(GetVPResponseObject response) {
		GetVoyagePlanResponse responseObject = new GetVoyagePlanResponse();
		HttpStatus status;
		switch (response.getCode()) {
			case OK:
				status = HttpStatus.OK;
				responseObject.setLastInteractionTime(new DateTime(response.getLastInteractionTime()));
				for (String routeMessage : response.getRouteMessages()) {
					responseObject.addVoyagePlansItem(new VoyagePlan().route(routeMessage));
				}
				break;
			case NOT_AUTHORIZED:
				status = HttpStatus.UNAUTHORIZED;
				break;
			case ERROR:
				status = HttpStatus.INTERNAL_SERVER_ERROR;
				break;
			default:
				status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<GetVoyagePlanResponse>(responseObject, status);
	}

	private ResponseEntity<List<GetSubscriptionResponse>> createResponseEntity(List<Subscription> response) {
		List<GetSubscriptionResponse> list = new ArrayList<>();
		for (Subscription subscription : response) {
			list.add(new GetSubscriptionResponse().dataId(subscription.getMessageId()));
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
