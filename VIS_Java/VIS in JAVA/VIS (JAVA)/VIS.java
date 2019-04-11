package VIS;

import getVPResponseObject.getVPResponseObject;
import STMTypes.URN;
import responseObjects.responseObj;
import STMTypes.URI;
import STMMessage.TextMessage.textMessage;
import STMMessage.RTZ.route;
import responseObjects.statusCode;
import SSC.identityDescriptionObjects.identityDescriptionObjects;
import SSC.serviceResponseObject.serviceResponseObject;
import SSC.callServiceObject.callServiceObject;
import SSC.findIdentityObject.findIdentitiesObj;
import SSC.serviceDescriptionObjects.serviceDescriptionObject;
import SSC.findServiceObject.findServicesObject;
import Messages.Message;
import Messages.Messages;

/**
 * @author M02AMIOL
 * @version 1.0
 * @created 19-aug-2016 15:46:54
 */
public class VIS {

	/**
	 * @author M02AMIOL
	 * @version 1.0
	 * @created 19-aug-2016 15:46:54
	 */
	public class VIS_Public_Interface {

		public VIS_Public_Interface(){

		}

		public void finalize() throws Throwable {

		}
		/**
		 * Returns the latest voyage plan with route status = "Used for monitoring" (7)
		 * that the requester is authorized to
		 */
		public getVPResponseObject getVoyagePlan(){
			//Check authorization
			//If authorized, return VP

			return null;
		}

		/**
		 * Returns the latest voyage plan with UVID=<id> published by STM Module
		 * independent on route status that the requester is authorized to.
		 * 
		 * @param UVID
		 */
		public getVPResponseObject getVoyagePlanById(URN UVID){
			return null;
		}

		/**
		 * Returns the latest voyage plan with UVID=<id> and status=<routeStatus>
		 * published by STM Module that the requester is authorized to.
		 * 
		 * @param UVID
		 * @param routeStatus
		 */
		public getVPResponseObject getVoyagePlanById_RouteStatus(URN UVID, int routeStatus){
			return null;
		}

		/**
		 * Returns the latest voyage plan with status=<routeStatus> published by STM
		 * Module independent on UVID that the requester is authorized to.
		 * 
		 * @param routeStatus
		 */
		public getVPResponseObject getVoyagePlanByRouteStatus(int routeStatus){
			return null;
		}

		/**
		 * 
		 * @param callbackEndpoint
		 */
		public responseObj removeVoyagePlanSubscription(URI callbackEndpoint){
			return null;
		}

		/**
		 * 
		 * @param UVID
		 * @param callbackEndpoint
		 */
		public responseObj removeVoyagePlanSubscriptionById(URN UVID, URI callbackEndpoint){
			return null;
		}

		/**
		 * Publicly exposed endpoint in VIS to facilitate subscription request of voyage
		 * plans published to/from VIS independent on route status.
		 * The received request is stored in VIS database and endpoint from calling party
		 * is stored in a subscription table in VIS database together with subscription
		 * parameters.
		 * 
		 * @param callbackEndpoint
		 */
		public responseObj subscribeToVoyagePlan(URI callbackEndpoint){
			//The received request is stored in VIS
			//database and endpoint from calling
			//party is stored in a subscription table
			//in VIS database together with
			//subscription parameters.

			return null;
		}

		/**
		 * Request subscription for specific VoyagePlan by <UVID> independent on route
		 * status
		 * 
		 * @param UVID
		 * @param callbackEndpoint
		 */
		public responseObj subscribeToVoyagePlanById(URN UVID, URI callbackEndpoint){
			return null;
		}

		/**
		 * 
		 * @param areaObj
		 * @param deliveryAckEndpoint
		 * @param transactionId
		 */
		public responseObj uploadPolygon(AreaFeatureObject (Polygon) areaObj, URI deliveryAckEndpoint, int transactionId){
			//The uploaded message is stored in cache
			//The message is checked against the area
			//schema
			//If correct, a notification is sent to
			//STM Module
			//
			//If delivery ACK is requested, the flag
			//is set in cache and when the STM Module
			//calls getMessage, VIS sends the message
			//to STM Module and a delivery ACK to the
			//requested endpoint.

			return null;
		}

		/**
		 * 
		 * @param textMessage
		 * @param deliveryAckEndpoint
		 * @param transactionId
		 */
		public responseObj uploadTextMessage(textMessage textMessage, URI deliveryAckEndpoint, int transactionId){
			//The uploaded message is stored in cache
			//The textMessage is checked against the
			//textMessagew schema
			//If correct, a notification is sent to
			//STM Module
			//
			//If delivery ACK is requested, the flag
			//is set in cache and when the STM Module
			//calls getMessage, VIS sends the message
			//to STM Module and a delivery ACK to the
			//requested endpoint.

			return null;
		}

		/**
		 * Publicly exposed endpoint in VIS to facilitate receipt of a STM Message i.e.
		 * voyage plan in VIS. The received message is stored in VIS database and
		 * forwarded to the STM Module.
		 * 
		 * @param voyagePlan
		 * @param deliveryAckEndpoint
		 * @param transactionId
		 * @param UVID
		 */
		public responseObj uploadVoyagePlan(route voyagePlan, URI deliveryAckEndpoint, int transactionId, int UVID){
			//The uploaded message is stored in cache
			//The voyage plan is checked against the
			//RTZ schema
			//If correct, a notification is sent to
			//STM Module
			//
			//If delivery ACK is requested, the flag
			//is set in cache and when the STM Module
			//calls getMessage, VIS sends the message
			//to STM Module and a delivery ACK to the
			//requested endpoint.

			return null;
		}
	}//end VIS_Public_Interface

	/**
	 * @author M02AMIOL
	 * @version 1.0
	 * @created 19-aug-2016 15:46:55
	 */
	public class VIS_BusinessLogic {

		public VIS_BusinessLogic(){

		}

		public void finalize() throws Throwable {

		}
		/**
		 * If authorized, add Subscriber
		 */
		private int addSubscriber(){
			return 0;
		}

		/**
		 * <ul>
		 * 	<li>Retrieve the requested information object id</li>
		 * 	<li>Retrieve the source identity</li>
		 * 	<li>Check identity against the Access Control List</li>
		 * </ul>
		 * 
		 * If not authorized, return responseCode=20x "Not authorized to data"
		 */
		private int checkAuthorization(){
			return 0;
		}

		/**
		 * Retrieve the requested message from cache
		 */
		private int getMessageFromCache(){
			return 0;
		}

		/**
		 * Forward Voyage Plan to ship onboard application (notify and getMessage)
		 */
		private int notify(){
			return 0;
		}

		private int sendDeliveryACK(){
			return 0;
		}

		private int storeMessageInCache(){
			return 0;
		}

		private int validateSchema(){
			return 0;
		}
	}//end VIS_BusinessLogic

	/**
	 * @author M02AMIOL
	 * @version 1.0
	 * @created 19-aug-2016 15:46:55
	 */
	public class VIS_Private_Interface {

		public VIS_Private_Interface(){

		}

		public void finalize() throws Throwable {

		}
		/**
		 * 
		 * @param identityDescriptionObjects
		 * @param dataId
		 */
		public statusCode authorizeIdentities(identityDescriptionObjects identityDescriptionObjects, URN dataId){
			return null;
		}

		/**
		 * 
		 * @param callServiceObj
		 */
		public serviceResponseObject callService(callServiceObject callServiceObj){
			return null;
		}

		/**
		 * 
		 * @param findIdentityObj
		 */
		public identityDescriptionObjects findIdentities(findIdentitiesObj findIdentityObj){
			return null;
		}

		/**
		 * 
		 * @param findServiceParameters
		 */
		public serviceDescriptionObject findService(findServicesObject findServiceParameters){
			return null;
		}

		/**
		 * 
		 * @param id
		 */
		public Message getMessage(URN id){
			return null;
		}

		/**
		 * Enables the STM onboard system (STM Module) to retrieve messages waiting in VIS.
		 * The messages can be of type RTZ,textMessage,Area/Polygon
		 */
		public MessageList getMessages(){
			return null;
		}

		/**
		 * 
		 * @param maxNumberOfMsgs
		 */
		public Messages getMessages(int maxNumberOfMsgs){
			return null;
		}

		/**
		 * Enables publishing a VoyagePlan to VIS, which will store it and forward to
		 * subscribers and on request.
		 * 
		 * @param VoyagePlan
		 */
		public responseObj publishMessage(route VoyagePlan){
			//VIS stores the Voyage Plan in
			//cache/repository
			//VIS forwards the Voyage Plan to all
			//subscribers (according to subscription
			//parameters and authorization)

			return null;
		}
	}//end VIS_Private_Interface

	public VIS Private Interface m_VIS Private Interface;

	public VIS(){

	}

	public void finalize() throws Throwable {

	}
}//end VIS