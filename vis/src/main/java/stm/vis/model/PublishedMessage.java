package stm.vis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import stm.vis.data.messages.MessageType;

/**
 * Published messages from STM Module (e.g. routes in RTZ)
 * @author aheredia
 *
 */
@Entity
@Table(name = "published_message")
public class PublishedMessage {

	/**
	 * Unique internal ID
	 */
	@Id
	@TableGenerator(name = "PUBLISHEDMESSAGES_ID_GEN", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "PUBLISHEDMESSAGES_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PUBLISHEDMESSAGES_ID_GEN")
	@Column(name = "id")
	private Long id;

	/**
	 * Publish time to VIS (set by VIS when received)
	 */
	@Column(name = "publish_time")
	private Date dateTime;

	/**
	 * Identity of the message (extracted from the message). In case of voyage plan it's the UVID.
	 */
	@Column(name = "message_id")
	private String messageId;

	/**
	 * Status on the message (extracted or derived from the message). In case of voyage plan it's the routeStatus.
	 */
	@Column(name = "message_status")
	private Integer messageStatus;

	/**
	 * Time of update of the message (extracted from the message)
	 */
	@Column(name = "message_last_update_time")
	private Date messageLastUpdateTime;

	/**
	 * Type of message (enumeration)
	 */
	@Column(name = "message_type")
	@Enumerated(EnumType.STRING)
	private MessageType messageType;

	/**
	 * The actual message in raw format
	 */
	@Column(name = "message")
	@Lob
	private byte[] message;

	/**
	 * Message schema
	 */
	@ManyToOne
	@JoinColumn(name = "schema_id")
	private Schema schema;

	@Column(name = "valid_from")
	private Date validFrom;

	@Column(name = "valid_to")
	private Date validTo;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getMessageId() {
		return this.messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public Integer getMessageStatus() {
		return this.messageStatus;
	}

	public void setMessageStatus(Integer messageStatus) {
		this.messageStatus = messageStatus;
	}

	public Date getMessageLastUpdateTime() {
		return this.messageLastUpdateTime;
	}

	public void setMessageLastUpdateTime(Date messageLastUpdateTime) {
		this.messageLastUpdateTime = messageLastUpdateTime;
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

	public Schema getSchema() {
		return this.schema;
	}

	public void setSchema(Schema schema) {
		this.schema = schema;
	}

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

}
