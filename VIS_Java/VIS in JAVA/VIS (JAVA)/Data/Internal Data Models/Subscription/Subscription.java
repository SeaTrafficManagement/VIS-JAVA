package Subscription;

import STMTypes.URI;
import STMTypes.URN;
import STMMessage.enumMessageType;

/**
 * Subscription object for each subscriber.
 * @author M02AMIOL
 * @version 1.0
 * @created 19-aug-2016 16:01:04
 */
public class Subscription {

	/**
	 * The URL to subscribers uploadVoyagePlan endpoint where published voyage plans
	 * are forwarded.
	 */
	private URI callbackEndpoint;
	/**
	 * Reference to identity of the subscribed information/data. In the case of VIS
	 * it's a UVID. Empty means subscription on all published voyage plans from the
	 * ship independant on UVID.
	 */
	private URN dataId;
	/**
	 * Unique id of the subscription object
	 */
	private string id;
	/**
	 * Type of message subscribed on. In case of VIS it's currently RTZ of defined
	 * versions.
	 */
	private enumMessageType messageType;
	/**
	 * Identity of subscriber. Used to check against ACL.
	 */
	private URN subscriberIdentity;
	/**
	 * Time for last sent message to subscriber
	 */
	private dateTime timeOfLastSentMessage;
	/**
	 * Time for start of subscription 
	 */
	private dateTime timeOfSubscriptionRequest;
	public enumMessageType m_enumMessageType;

	public Subscription(){

	}

	public void finalize() throws Throwable {

	}
}//end Subscription