package stm.vis.data.messages;

import java.util.List;

/**
 * Container for messages to STM Module
 * @author aheredia
 *
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

	/**
	 * List of messages
	 */
	private List<VISMessage> messages;

	public int getNumberOfMessages() {
		return this.numberOfMessages;
	}

	public void setNumberOfMessages(int numberOfMessages) {
		this.numberOfMessages = numberOfMessages;
	}

	public int getRemainingNumberOfMessages() {
		return this.remainingNumberOfMessages;
	}

	public void setRemainingNumberOfMessages(int remainingNumberOfMessages) {
		this.remainingNumberOfMessages = remainingNumberOfMessages;
	}

	public List<VISMessage> getMessages() {
		return this.messages;
	}

	public void setMessages(List<VISMessage> messages) {
		this.messages = messages;
	}

}
