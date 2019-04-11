package stm.vis.data.messages;

import java.util.Date;

/**
 * Message to the STM Module
 * @author aheredia
 *
 */
public class VISMessage {

	/**
	 * Identity of the message
	 */
	private String id;

	/**
	 * Date and time of reception
	 */
	private Date receivedAt;

	/**
	 * Identity of the message source
	 */
	private String from;

	/**
	 * Type of STM message
	 */
	private MessageType messageType;

	/**
	 * The message of any STM format
	 */
	private byte[] message;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getReceivedAt() {
		return this.receivedAt;
	}

	public void setReceivedAt(Date receivedAt) {
		this.receivedAt = receivedAt;
	}

	public MessageType getMessageType() {
		return this.messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	public String getFrom() {
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public byte[] getMessage() {
		return this.message;
	}

	public void setMessage(byte[] message) {
		this.message = message;
	}

}
