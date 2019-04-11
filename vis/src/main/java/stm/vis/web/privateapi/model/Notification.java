package stm.vis.web.privateapi.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * Notification
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-08-31T17:12:17.402Z")

public class Notification {
	@JsonProperty("Body")
	private String body = null;

	@JsonProperty("FromOrgId")
	private String fromOrgId = null;

	@JsonProperty("FromOrgName")
	private String fromOrgName = null;

	@JsonProperty("FromServiceId")
	private String fromServiceId = null;

	@JsonProperty("MessageWaiting")
	private Integer messageWaiting = null;

	@JsonProperty("NotificationCreatedAt")
	private DateTime notificationCreatedAt = null;

	/**
	 * Gets or Sets notificationType
	 */
	public enum NotificationTypeEnum {
		MESSAGE_WAITING("MESSAGE_WAITING"),

		UNAUTHORIZED_REQUEST("UNAUTHORIZED_REQUEST"),

		ACKNOWLEDGEMENT_RECEIVED("ACKNOWLEDGEMENT_RECEIVED"),

		ERROR_MESSAGE("ERROR_MESSAGE");

		private String value;

		NotificationTypeEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static NotificationTypeEnum fromValue(String text) {
			for (NotificationTypeEnum b : NotificationTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("NotificationType")
	private NotificationTypeEnum notificationType = null;

	@JsonProperty("ReceivedAt")
	private DateTime receivedAt = null;

	@JsonProperty("Subject")
	private String subject = null;

	/**
	 * Gets or Sets notificationSource
	 */
	public enum NotificationSourceEnum {
		VIS("VIS"),

		SPIS("SPIS");

		private String value;

		NotificationSourceEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static NotificationSourceEnum fromValue(String text) {
			for (NotificationSourceEnum b : NotificationSourceEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("NotificationSource")
	private NotificationSourceEnum notificationSource = null;

	public Notification body(String body) {
		this.body = body;
		return this;
	}

	/**
	 * Get body
	 * 
	 * @return body
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Notification fromOrgId(String fromOrgId) {
		this.fromOrgId = fromOrgId;
		return this;
	}

	/**
	 * Get fromOrgId
	 * 
	 * @return fromOrgId
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public String getFromOrgId() {
		return fromOrgId;
	}

	public void setFromOrgId(String fromOrgId) {
		this.fromOrgId = fromOrgId;
	}

	public Notification fromOrgName(String fromOrgName) {
		this.fromOrgName = fromOrgName;
		return this;
	}

	/**
	 * Get fromOrgName
	 * 
	 * @return fromOrgName
	 **/
	@ApiModelProperty(value = "")

	public String getFromOrgName() {
		return fromOrgName;
	}

	public void setFromOrgName(String fromOrgName) {
		this.fromOrgName = fromOrgName;
	}

	public Notification fromServiceId(String fromServiceId) {
		this.fromServiceId = fromServiceId;
		return this;
	}

	/**
	 * Get fromServiceId
	 * 
	 * @return fromServiceId
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public String getFromServiceId() {
		return fromServiceId;
	}

	public void setFromServiceId(String fromServiceId) {
		this.fromServiceId = fromServiceId;
	}

	public Notification messageWaiting(Integer messageWaiting) {
		this.messageWaiting = messageWaiting;
		return this;
	}

	/**
	 * Get messageWaiting
	 * 
	 * @return messageWaiting
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public Integer getMessageWaiting() {
		return messageWaiting;
	}

	public void setMessageWaiting(Integer messageWaiting) {
		this.messageWaiting = messageWaiting;
	}

	public Notification notificationCreatedAt(DateTime notificationCreatedAt) {
		this.notificationCreatedAt = notificationCreatedAt;
		return this;
	}

	/**
	 * Get notificationCreatedAt
	 * 
	 * @return notificationCreatedAt
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid

	public DateTime getNotificationCreatedAt() {
		return notificationCreatedAt;
	}

	public void setNotificationCreatedAt(DateTime notificationCreatedAt) {
		this.notificationCreatedAt = notificationCreatedAt;
	}

	public Notification notificationType(NotificationTypeEnum notificationType) {
		this.notificationType = notificationType;
		return this;
	}

	/**
	 * Get notificationType
	 * 
	 * @return notificationType
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public NotificationTypeEnum getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(NotificationTypeEnum notificationType) {
		this.notificationType = notificationType;
	}

	public Notification receivedAt(DateTime receivedAt) {
		this.receivedAt = receivedAt;
		return this;
	}

	/**
	 * Get receivedAt
	 * 
	 * @return receivedAt
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid

	public DateTime getReceivedAt() {
		return receivedAt;
	}

	public void setReceivedAt(DateTime receivedAt) {
		this.receivedAt = receivedAt;
	}

	public Notification subject(String subject) {
		this.subject = subject;
		return this;
	}

	/**
	 * Get subject
	 * 
	 * @return subject
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Notification notificationSource(NotificationSourceEnum notificationSource) {
		this.notificationSource = notificationSource;
		return this;
	}

	/**
	 * Get notificationSource
	 * 
	 * @return notificationSource
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public NotificationSourceEnum getNotificationSource() {
		return notificationSource;
	}

	public void setNotificationSource(NotificationSourceEnum notificationSource) {
		this.notificationSource = notificationSource;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Notification notification = (Notification) o;
		return Objects.equals(this.body, notification.body) && Objects.equals(this.fromOrgId, notification.fromOrgId)
				&& Objects.equals(this.fromOrgName, notification.fromOrgName)
				&& Objects.equals(this.fromServiceId, notification.fromServiceId)
				&& Objects.equals(this.messageWaiting, notification.messageWaiting)
				&& Objects.equals(this.notificationCreatedAt, notification.notificationCreatedAt)
				&& Objects.equals(this.notificationType, notification.notificationType)
				&& Objects.equals(this.receivedAt, notification.receivedAt)
				&& Objects.equals(this.subject, notification.subject)
				&& Objects.equals(this.notificationSource, notification.notificationSource);
	}

	@Override
	public int hashCode() {
		return Objects.hash(body, fromOrgId, fromOrgName, fromServiceId, messageWaiting, notificationCreatedAt,
				notificationType, receivedAt, subject, notificationSource);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Notification {\n");

		sb.append("    body: ").append(toIndentedString(body)).append("\n");
		sb.append("    fromOrgId: ").append(toIndentedString(fromOrgId)).append("\n");
		sb.append("    fromOrgName: ").append(toIndentedString(fromOrgName)).append("\n");
		sb.append("    fromServiceId: ").append(toIndentedString(fromServiceId)).append("\n");
		sb.append("    messageWaiting: ").append(toIndentedString(messageWaiting)).append("\n");
		sb.append("    notificationCreatedAt: ").append(toIndentedString(notificationCreatedAt)).append("\n");
		sb.append("    notificationType: ").append(toIndentedString(notificationType)).append("\n");
		sb.append("    receivedAt: ").append(toIndentedString(receivedAt)).append("\n");
		sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
		sb.append("    notificationSource: ").append(toIndentedString(notificationSource)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
