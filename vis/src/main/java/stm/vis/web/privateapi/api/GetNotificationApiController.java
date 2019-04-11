package stm.vis.web.privateapi.api;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import stm.vis.model.VISNotification;
import stm.vis.service.VISPrivateInterface;
import stm.vis.web.privateapi.model.Notification;
import stm.vis.web.privateapi.model.Notification.NotificationTypeEnum;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-10T12:58:37.496Z")

@Controller
public class GetNotificationApiController implements GetNotificationApi {

	@Autowired
	private VISPrivateInterface service;

	@Override
	public ResponseEntity<List<Notification>> getNotification() {
		List<VISNotification> notifications = this.service.getNotifications();
		return this.createResponseEntity(notifications);
	}

	private ResponseEntity<List<Notification>> createResponseEntity(List<VISNotification> notifications) {
		List<Notification> list = new ArrayList<>();
		for (VISNotification notification : notifications) {
			list.add(this.convertToNotification(notification));
		}
		return new ResponseEntity<List<Notification>>(list, HttpStatus.OK);
	}

	private Notification convertToNotification(VISNotification notification) {
		Notification result = new Notification()
			.body(notification.getBody())
			.fromOrgId(notification.getFromOrgId())
			.fromOrgName(notification.getFromOrgName())
			.fromServiceId(notification.getFromServiceId())
			.messageWaiting(notification.isMessageWaiting() ? 1 : 0)
			.notificationCreatedAt(new DateTime(notification.getCreatedAt()))
			.notificationType(NotificationTypeEnum.fromValue(notification.getType().name()))
			.receivedAt(new DateTime(notification.getReceivedAt()))
			.subject(notification.getSubject())
			.notificationSource(notification.getNotificationSource()); 
		return result;
	}

}
