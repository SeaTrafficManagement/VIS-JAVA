package Messages;

import STMTypes.URN;
import STMMessage.STMMessage;
import STMMessage.enumMessageType;

/**
 * Message to the STM Module
 * @author M02AMIOL
 * @version 1.0
 * @created 19-aug-2016 16:01:02
 */
public class Message {

	/**
	 * Identity of the message source
	 */
	private URN from;
	/**
	 * Identity of the message
	 */
	private string id;
	/**
	 * The message of any STM format
	 */
	private STMMessage message;
	/**
	 * Type of STM message
	 */
	private enumMessageType messageType;
	/**
	 * Date and time of reception
	 */
	private dateTime receivedAt;
	public enumMessageType m_enumMessageType;

	public Message(){

	}

	public void finalize() throws Throwable {

	}
}//end Message