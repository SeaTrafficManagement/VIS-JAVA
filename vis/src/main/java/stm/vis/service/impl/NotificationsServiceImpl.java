package stm.vis.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stm.vis.model.VISNotification;
import stm.vis.repository.NotificationRepository;
import stm.vis.service.NotificationsService;

@Service
public class NotificationsServiceImpl implements NotificationsService {

	@Autowired
	private NotificationRepository repository;

	@Override
	public List<VISNotification> getNotifications() {
		List<VISNotification> notifications = this.repository.findByMessageWaitingTrue();

		for (VISNotification notification : notifications) {
			notification.setMessageWaiting(false);
			notification.setReceivedAt(new Date());
			this.saveNotification(notification);
		}
		return notifications;
	}

	@Override
	public void saveNotification(VISNotification notification) {
		this.repository.save(notification);
	}

}
