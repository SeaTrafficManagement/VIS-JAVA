package stm.vis.data.messages;

/**
 * Abstract class representing any defined STM Message
 * @author aheredia
 */
public class STMMessage {

	private MessageType messageType;
	private byte[] data;

	public MessageType getMessageType() {
		return this.messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	public byte[] getData() {
		return this.data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
