package Notification;


/**
 * To inside application, such as STM Module
 * @author M02AMIOL
 * @version 1.0
 * @created 19-aug-2016 16:01:03
 */
public class Notification {

	/**
	 * Notification body, optional
	 * If message less than X bytes, the message (XML) can be sent in the body of the
	 * notification.
	 * Needs to be aligned with STM Module and ship operator configuration and policies
	 */
	private string body;
	/**
	 * Source of notification and source for retrieving the complete message, mandatory
	 */
	private string fromId;
	/**
	 * Friendly name of sender for presentation
	 */
	private string fromName;
	/**
	 * Identity of the notification, mandatory
	 */
	private string id;
	/**
	 * >0 if a message is waiting in server, otherwise 0, mandatory
	 */
	private int messageWaiting;
	/**
	 * Notification created at date and time, mandatory
	 */
	private dateTime notificationCreatedAt;
	/**
	 * Type of notification by enumeration
	 */
	private enumNotificationType notificationType;
	/**
	 * Date and time for the reception of the message.
	 */
	private dateTime receivedAt;
	/**
	 * Notification subject, mandatory
	 */
	private string subject;
	public enumNotificationType m_enumNotificationType;

	public Notification(){

	}

	public void finalize() throws Throwable {

	}
}//end Notification