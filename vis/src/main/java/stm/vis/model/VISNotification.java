package stm.vis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import stm.vis.web.privateapi.model.Notification.NotificationSourceEnum;

/**
 * Notification to inside application, such as STM Module
 * @author aheredia
 *
 */
@Entity
@Table(name = "notification")
public class VISNotification {

	public enum NotificationType {
		MESSAGE_WAITING, UNAUTHORIZED_REQUEST, ACKNOWLEDGEMENT_RECEIVED, ERROR_MESSAGE;
	}
	
	/**
	 * Identity of the notification, mandatory
	 */
	@Id
	@TableGenerator(name = "NOTIFICATION_ID_GEN", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "NOTIFICATION_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "NOTIFICATION_ID_GEN")
	@Column(name = "id")
	private Long id;

	/**
	 * Type of notification by enumeration
	 */
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private NotificationType type;

	/**
	 * Notification created at date and time, mandatory
	 */
	@Column(name = "created_at")
	private Date createdAt;

	/**
	 * Source of notification and source for retrieving the complete message, mandatory
	 */
	@Column(name = "from_id")
	private String fromOrgId;

	/**
	 * Friendly name of sender for presentation
	 */
	@Column(name = "from_name")
	private String fromOrgName;

	/**
	 * From service id
	 */
	@Column(name = "from_service_id")
	private String fromServiceId;

	/**
	 * Date and time for the reception of the message
	 */
	@Column(name = "received_at")
	private Date receivedAt;

	/**
	 * >0 if a message is waiting in server, otherwise 0, mandatory
	 */
	@Column(name = "message_waiting")
	private boolean messageWaiting;

	/**
	 * Notification subject, mandatory
	 */
	@Column(name = "subject")
	private String subject;

	/**
	 * Notification body, optional If message less than X bytes, the message (XML) can be sent in the body of the notification. 
	 * Needs to be aligned with STM Module and ship operator configuration and policies
	 */
	@Column(name = "body")
	private String body;

	@Column(name = "data_id")
	private String dataId;

	@Column(name = "notification_source")
	@Enumerated(EnumType.STRING)
	private NotificationSourceEnum notificationSource;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NotificationType getType() {
		return this.type;
	}

	public void setType(NotificationType type) {
		this.type = type;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getFromOrgId() {
		return this.fromOrgId;
	}

	public void setFromOrgId(String fromOrgId) {
		this.fromOrgId = fromOrgId;
	}

	public String getFromOrgName() {
		return this.fromOrgName;
	}

	public void setFromOrgName(String fromOrgName) {
		this.fromOrgName = fromOrgName;
	}

	public String getFromServiceId() {
		return fromServiceId;
	}
	
	public void setFromServiceId(String fromServiceId) {
		this.fromServiceId = fromServiceId;
	}
	
	public Date getReceivedAt() {
		return this.receivedAt;
	}

	public void setReceivedAt(Date receivedAt) {
		this.receivedAt = receivedAt;
	}

	public boolean isMessageWaiting() {
		return this.messageWaiting;
	}

	public void setMessageWaiting(boolean messageWaiting) {
		this.messageWaiting = messageWaiting;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDataId() {
		return this.dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId;
	}

	public NotificationSourceEnum getNotificationSource() {
		return notificationSource;
	}
	
	public void setNotificationSource(NotificationSourceEnum notificationSource) {
		this.notificationSource = notificationSource;
	}
	
}
