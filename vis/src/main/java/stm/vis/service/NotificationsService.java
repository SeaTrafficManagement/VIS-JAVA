package stm.vis.service;

import java.util.List;

import stm.vis.model.VISNotification;

public interface NotificationsService {

	List<VISNotification> getNotifications();

	void saveNotification(VISNotification notification);

}
