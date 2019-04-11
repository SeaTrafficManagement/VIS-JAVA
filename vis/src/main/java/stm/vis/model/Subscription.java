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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import stm.vis.data.messages.MessageType;

/**
 * Active subscriptions
 * @author aheredia
 *
 */
@Entity
@Table(name = "subscription")
public class Subscription {

	/**
	 * Unique internal id of the subscription object
	 */
	@Id
	@TableGenerator(name = "SUBSCRIPTION_ID_GEN", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "SUBSCRIPTION_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "SUBSCRIPTION_ID_GEN")
	@Column(name = "id")
	private Long id;

	/**
	 * Message ID to subscribe on. In the case of VIS it's a UVID. Empty means subscription on all published voyage plans from the ship independent on UVID.
	 */
	@Column(name = "message_id")
	private String messageId;

	/**
	 * Type of message subscribed on. In case of VIS it's currently RTZ of defined versions.
	 */
	@Column(name = "message_type")
	@Enumerated(EnumType.STRING)
	private MessageType messageType;

	/**
	 * The URL to subscribers uploadVoyagePlan endpoint where published voyage plans are forwarded.
	 */
	@Column(name = "callback_endpoint")
	private String callbackEndpoint;

	/**
	 * Identity of subscriber. Used to check against ACL.
	 */
	@ManyToOne
	@JoinColumn(name = "subscriber_identity_id")
	private Identity subscriberIdentity;

	/**
	 * Time for start of subscription
	 */
	@Column(name = "time_of_subscription_request")
	private Date timeOfSubscriptionRequest;

	/**
	 * Time for last sent message to subscriber
	 */
	@Column(name = "time_of_last_sent_message")
	private Date timeOfLastSentMessage;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessageId() {
		return this.messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public MessageType getMessageType() {
		return this.messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	public String getCallbackEndpoint() {
		return this.callbackEndpoint;
	}

	public void setCallbackEndpoint(String callbackEndpoint) {
		this.callbackEndpoint = callbackEndpoint;
	}

	public Identity getSubscriberIdentity() {
		return this.subscriberIdentity;
	}

	public void setSubscriberIdentity(Identity subscriberIdentity) {
		this.subscriberIdentity = subscriberIdentity;
	}

	public Date getTimeOfSubscriptionRequest() {
		return this.timeOfSubscriptionRequest;
	}

	public void setTimeOfSubscriptionRequest(Date timeOfSubscriptionRequest) {
		this.timeOfSubscriptionRequest = timeOfSubscriptionRequest;
	}

	public Date getTimeOfLastSentMessage() {
		return this.timeOfLastSentMessage;
	}

	public void setTimeOfLastSentMessage(Date timeOfLastSentMessage) {
		this.timeOfLastSentMessage = timeOfLastSentMessage;
	}

}
