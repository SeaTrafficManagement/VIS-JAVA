package STMMessage.TextMessage;


/**
 * Version: 0.1 ; Date: 2016-06-21
 * @author M02AMIOL
 * @version 1.0
 * @created 19-aug-2016 16:01:04
 */
public class textMessage {

	/**
	 * The message author, mandatory
	 */
	private string author;
	/**
	 * The message body (the actual text message), mandatory
	 */
	private string body;
	/**
	 * The message creation dateTime, mandatory
	 */
	private dateTime createdAt;
	/**
	 * The sending actor, mandatory
	 */
	private string from;
	/**
	 * A reference to an information object (such as a Unique Voyage ID), optional
	 */
	private string informationObjectReferenceId;
	/**
	 * A geographical position (point) related to the text message, optional.
	 */
	private GM_Point position;
	/**
	 * The service type of the sender, optional
	 */
	private string serviceType;
	/**
	 * The message subject, mandatory
	 */
	private string subject;
	/**
	 * Identifier of the text message, mandatory
	 */
	private string textMessageId;

	public textMessage(){

	}

	public void finalize() throws Throwable {

	}
}//end textMessage