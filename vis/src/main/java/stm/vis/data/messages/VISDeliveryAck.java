package stm.vis.data.messages;

import java.util.Date;

/**
 * Object for message ACK
 * @author aheredia
 *
 */
public class VISDeliveryAck {

	/**
	 * Id for the ACK
	 */
	private String id;

	/**
	 * Reference to delivered message
	 */
	private String referenceId;

	/**
	 * Time of delivery
	 */
	private Date timeOfDelivery;

	/**
	 * Identity of source (sender) of message that have been delivered
	 */
	private String fromId;

	/**
	 * Friendly name of sender
	 */
	private String fromName;

	/**
	 * Identity of target (receipent) of message delivery
	 */
	private String toId;

	/**
	 * Friendly name of recipient
	 */
	private String toName;

	/**
	 * 
	 */
	private String ackResult;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReferenceId() {
		return this.referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public Date getTimeOfDelivery() {
		return this.timeOfDelivery;
	}

	public void setTimeOfDelivery(Date timeOfDelivery) {
		this.timeOfDelivery = timeOfDelivery;
	}

	public String getFromId() {
		return this.fromId;
	}

	public void setFromId(String fromId) {
		this.fromId = fromId;
	}

	public String getFromName() {
		return this.fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getToId() {
		return this.toId;
	}

	public void setToId(String toId) {
		this.toId = toId;
	}

	public String getToName() {
		return this.toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public String getAckResult() {
		return this.ackResult;
	}

	public void setAckResult(String ackResult) {
		this.ackResult = ackResult;
	}

}
