package stm.vis.service;

import java.util.List;

import stm.vis.data.ResponseObject;
import stm.vis.data.SourceIdentity;
import stm.vis.exception.VISException;
import stm.vis.model.Subscription;

public interface VISSubscriptionInterface {

	/**
	 * Operation for subscription of voyage plans. 
	 * The operation will store the incoming callbackEndpoint and upload voyage plans to this interface whenever they are changed. 
	 * The operation expects that the callbackEndpoint adhere to VIS uploadVoyagePlan interface (POST /voyagePlans). 
	 * The subscription remains active until removed either by private application or by requester.
	 * 
	 * If UVID is not provided (is blank), VIS will try to set up a subscription to all "active" UVID with route with routeStatus 1-7 the requester has access to. 
	 * If there are 2 or more voyage plans with routeStatus="7" for one ship, only the latest published of them will generate a subscription.
	 * I.e. if there are one VP with routeStatus=7 and one in routeStatus=3, subscription will be enabled for both UVIDs.	 
	 * 
	 * @param sourceIdentity
	 * @param uvid
	 * @param callbackEndpoint
	 * @return
	 */
	ResponseObject subscribeToVoyagePlan(SourceIdentity sourceIdentity, String uvid, String callbackEndpoint) throws VISException;

	/**
	 * Remove subscription from the ship for my identity/callbackEndpoint and UVID.
	 * @param sourceIdentity
	 * @param uvid
	 * @param callbackEndpoint
	 * @return
	 */
	ResponseObject removeVoyagePlanSubscription(SourceIdentity sourceIdentity, String uvid, String callBackendpoint);

	/**
	 * Get information on subscribed voyage plans.
	 * @param sourceIdentity
	 * @param callbackEndpoint
	 * @return
	 */
	List<Subscription> getSubscriptions(SourceIdentity sourceIdentity, String callbackEndpoint);

}
