package stm.vis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import stm.vis.data.messages.MessageType;

/**
 * Uploaded messages to VIS to be forwarded to STM Module (e.g. route, text message, polygon)
 * @author aheredia
 *
 */
@Entity
@Table(name = "uploaded_message")
public class UploadedMessage {

	/**
	 * Unique internal identity
	 */
	@Id
	@TableGenerator(name = "UPLOADEDMESSAGE_ID_GEN", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "UPLOADEDMESSAGE_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "UPLOADEDMESSAGE_ID_GEN")
	@Column(name = "id")
	private Long id;

	/**
	 * Received time set by VIS
	 */
	@Column(name = "receive_time")
	private Date receiveTime;

	/**
	 * Source identity of the message
	 */
	@Column(name = "source")
	private String from;

	/**
	 * Flag if Acknowledge is requested when message transferred to the STM Module (ship)
	 */
	@Column(name = "delivery_ack_requested")
	private boolean deliveryAckRequested;

	/**
	 * Flag when Acknowledgement is sent
	 */
	@Column(name = "ack_delivered")
	private boolean ackDelivered;

	/**
	 * Endpoint (complete URI) where Acknowledge shall be sent when message transferred to STM Module (ship or ship representative)
	 */
	@Column(name = "delivery_ack_endpoint")
	private String deliveryAckEndpoint;

	/**
	 * Flag that is set to true when STM Module notify succeeded.
	 */
	@Column(name = "notified")
	private boolean notified;

	/**
	 * Flag if message is fetched/sent to STM Module (ship or ship representative)
	 */
	@Column(name = "fetched_by_ship")
	private boolean fetchedByShip;

	/**
	 * Time when message is fetched/sent to STM Module (ship or ship representative)
	 */
	@Column(name = "fetch_time")
	private Date fetchTime;

	/**
	 * Type of message (enumeration)
	 */
	@Column(name = "message_type")
	private MessageType messageType;

	/**
	 * The message in raw format
	 */
	@Column(name = "message")
	@Lob
	private byte[] message;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getReceiveTime() {
		return this.receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	public String getFrom() {
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public boolean isDeliveryAckRequested() {
		return this.deliveryAckRequested;
	}

	public void setDeliveryAckRequested(boolean deliveryAckRequested) {
		this.deliveryAckRequested = deliveryAckRequested;
	}

	public boolean isAckDelivered() {
		return this.ackDelivered;
	}

	public void setAckDelivered(boolean ackDelivered) {
		this.ackDelivered = ackDelivered;
	}

	public String getDeliveryAckEndpoint() {
		return this.deliveryAckEndpoint;
	}

	public void setDeliveryAckEndpoint(String deliveryAckEndpoint) {
		this.deliveryAckEndpoint = deliveryAckEndpoint;
	}

	public boolean isNotified() {
		return this.notified;
	}

	public void setNotified(boolean notified) {
		this.notified = notified;
	}

	public boolean isFetchedByShip() {
		return this.fetchedByShip;
	}

	public void setFetchedByShip(boolean fetchedByShip) {
		this.fetchedByShip = fetchedByShip;
	}

	public Date getFetchTime() {
		return this.fetchTime;
	}

	public void setFetchTime(Date fetchTime) {
		this.fetchTime = fetchTime;
	}

	public MessageType getMessageType() {
		return this.messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	public byte[] getMessage() {
		return this.message;
	}

	public void setMessage(byte[] message) {
		this.message = message;
	}

}
