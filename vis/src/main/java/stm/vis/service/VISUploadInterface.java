package stm.vis.service;

import stm.vis.data.ResponseObject;
import stm.vis.data.SourceIdentity;
import stm.vis.data.messages.STMMessage;
import stm.vis.exception.VISException;

public interface VISUploadInterface {

	/**
	 * Facilitates sending (uploading) a voyage plan to VIS to be forwarded to private application. 
	 * If endpoint provided for deliveryACK, an ACK will be sent when message has been delivered to private application. 
	 * If endpoint provided for callback, a result is expected to be uploaded to callback endpoint. E.g. when ship requesting 
	 * route optimization, the ship may provide the ships endpoint to inform the route optimization provider that the optimized 
	 * route is expected on this endpoint upload operation(s), voyage plan, text message and/or area message.
	 * 
	 * @param sourceIdentity
	 * @param voyagePlan
	 * @param deliveryAckEndpoint
	 * @param uvid
	 * @param callbackEndPoint
	 * @return
	 */
	ResponseObject uploadVoyagePlan(SourceIdentity sourceIdentity, STMMessage voyagePlan, String deliveryAckEndpoint, String callbackEndPoint) throws VISException;

	/**
	 * Facilitates sending (uploading) a text message to VIS to be forwarded to the ship (STM Module).
	 * If endpoint provided for deliveryACK, an ACK will be sent when message has been forwarded to STM Module.
	 * A transaction id can be provided to relate the message to e.g. a voyage plan. A transaction id is returned when uploading a voyage plan.
	 * A transaction id is returned. 
	 * 
	 * @param sourceIdentity
	 * @param textMessage
	 * @param deliveryAckEndpoint
	 * @param transactionId
	 * @return
	 */
	ResponseObject uploadTextMessage(SourceIdentity sourceIdentity, String textMessage, String deliveryAckEndpoint) throws VISException;

	/**
	 * Facilitates sending (uploading) a polygon (area) to VIS to be forwarded to the ship (STM Module).
	 * If endpoint provided for deliveryACK, an ACK will be sent when message has been forwarded to STM Module.
	 * A transaction id can be provided to relate the message to e.g. a voyage plan. A transaction id is returned when uploading a voyage plan.
	 * A transaction id is returned.
	 * 
	 * @param sourceIdentity
	 * @param areaObj
	 * @param deliveryAckEndpoint
	 * @param transactionId
	 * @return
	 */
	ResponseObject uploadArea(SourceIdentity sourceIdentity, STMMessage area, String deliveryAckEndpoint) throws VISException;

}
