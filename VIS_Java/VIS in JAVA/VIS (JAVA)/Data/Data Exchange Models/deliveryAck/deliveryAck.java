package deliveryAck;

import STMTypes.URN;

/**
 * Object for message ACK
 * @author M02AMIOL
 * @version 1.0
 * @created 19-aug-2016 16:01:01
 */
public class deliveryAck {

	private string ackResult;
	/**
	 * Identity of source (sender
	 * ) of message that have been delivered
	 */
	private URN fromId;
	/**
	 * Friendly name of sender
	 */
	private string fromName;
	/**
	 * Id for the ACK
	 */
	private string id;
	/**
	 * Reference to delivered message
	 */
	private URN referenceId;
	/**
	 * Time of delivery
	 */
	private dateTime timeOfDelivery;
	/**
	 * Identity of target (receipent) of message delivery
	 */
	private URN toId;
	/**
	 * Friendly name of recipient
	 */
	private string toName;

	public deliveryAck(){

	}

	public void finalize() throws Throwable {

	}
}//end deliveryAck