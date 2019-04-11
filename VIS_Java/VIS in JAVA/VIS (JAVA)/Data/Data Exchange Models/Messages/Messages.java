package Messages;


/**
 * Container for messages to STM Module
 * @author M02AMIOL
 * @version 1.0
 * @created 19-aug-2016 16:01:03
 */
public class Messages {

	/**
	 * Total number of messages in this container
	 */
	private int numberOfMessages;
	/**
	 * Remaining messages waiting to be retrieved
	 */
	private int remainingNumberOfMessages;
	public Message m_Message;

	public Messages(){

	}

	public void finalize() throws Throwable {

	}
}//end Messages