package stm.vis.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import stm.vis.data.SourceIdentity;
import stm.vis.model.VISNotification;
import stm.vis.model.VISNotification.NotificationType;
import stm.vis.web.privateapi.model.Notification.NotificationSourceEnum;

@Component
public class NotificationFactory {

	@Value("${vis.config.identity}")
	private String identity;

	@Value("${vis.config.name}")
	private String name;

	@Value("${vis.config.acknowledgment.subject}")
	private String acknowledgmentSubject;

	@Value("${vis.config.message-waiting.subject}")
	private String messageWaitingSubject;

	@Value("${vis.config.authorization-requested.subject}")
	private String authorizationRequestedSubject;

	@Value("${vis.config.addMessageToNotification}")
	private boolean addMessageToNotification;

	public VISNotification createAcknowledgementReceivedNotification(SourceIdentity identity, String body) {
		return this.createNotification(NotificationType.ACKNOWLEDGEMENT_RECEIVED, identity.getOrganisationMrn(), identity.getOrganisationName(), identity.getServiceId(), this.acknowledgmentSubject, body, true);
	}

	public VISNotification createMessageWaitingNotification() {
		return this.createNotification(NotificationType.MESSAGE_WAITING, this.identity, this.name, this.name, this.messageWaitingSubject);
	}

	public VISNotification createUnauthorizedRequestNotification(SourceIdentity identity, String message) {
		return this.createNotification(NotificationType.UNAUTHORIZED_REQUEST, identity.getOrganisationMrn(), identity.getOrganisationName(), identity.getServiceId(), this.authorizationRequestedSubject, message);
	}

	public VISNotification createErrorMessageNotification(SourceIdentity identity, String message) {
		return this.createNotification(NotificationType.ERROR_MESSAGE, identity.getOrganisationMrn(), identity.getOrganisationName(), identity.getServiceId(), this.authorizationRequestedSubject, message);
	}

	private VISNotification createNotification(NotificationType type, String fromId, String fromName, String serviceId, String subject) {
		return this.createNotification(type, fromId, fromName, subject, null);
	}

	private VISNotification createNotification(NotificationType type, String fromId, String fromName, String serviceId,  String subject, String body) {
		return this.createNotification(type, fromId, fromName, serviceId, subject, body, this.addMessageToNotification);
	}

	private VISNotification createNotification(NotificationType type, String fromId, String fromName, String fromServiceId, String subject, String body, boolean sendBody) {
		VISNotification notification = new VISNotification();
		notification.setType(type);
		notification.setCreatedAt(new Date());
		notification.setFromOrgId(fromId);
		notification.setFromOrgName(fromName);
		notification.setFromServiceId(fromServiceId);
		notification.setReceivedAt(null);
		notification.setMessageWaiting(true);
		notification.setSubject(subject);
		notification.setNotificationSource(NotificationSourceEnum.VIS);
		
		if (sendBody) {
			notification.setBody(body);
		}
		return notification;
	}

}
