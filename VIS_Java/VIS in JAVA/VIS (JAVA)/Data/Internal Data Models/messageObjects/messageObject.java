package messageObjects;

import STMTypes.URI;
import STMTypes.URN;
import STMMessage.STMMessage;
import STMMessage.enumMessageType;
import schemas.schema;

/**
 * Message object internally used in VIS for both published messages from STM
 * Module and incoming messages to STM Module.
 * @author M02AMIOL
 * @version 1.0
 * @created 19-aug-2016 16:01:03
 */
public class messageObject {

	/**
	 * Reference id for the information/data. If voyage plan then UVID.
	 */
	private string dataId;
	/**
	 * Endpoint for ACK requested when delivery. Empty if no ACK is requested.
	 */
	private URI deliveryAckRequired;
	/**
	 * Flag for fetched by STM Module. True if fetched.
	 */
	private boolean fetched;
	/**
	 * Time for fetching the message.
	 */
	private dateTime fetchTime;
	/**
	 * Identity of the source of information/data
	 */
	private URN from;
	/**
	 * Unique id for the message
	 */
	private string id;
	/**
	 * The message of any valid STM Message
	 */
	private STMMessage message;
	/**
	 * Type of message
	 */
	private enumMessageType messageType;
	/**
	 * Time for receiving the message from STM Module or service provider
	 */
	private dateTime receiveTime;
	/**
	 * The schema for the message
	 * 
	 * Is this attribute necessary here?
	 */
	private string schemaId;
	/**
	 * Identity of the target of information/data
	 */
	private URN to;
	private STMMessage m_STMMessage;
	public enumMessageType m_enumMessageType;

	public messageObject(){

	}

	public void finalize() throws Throwable {

	}
}//end messageObject