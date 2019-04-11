package stm.vis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stm.vis.data.SourceIdentity;
import stm.vis.model.VISNotification;
import stm.vis.service.AcknowledgementService;
import stm.vis.service.NotificationsService;
import stm.vis.web.publicapi.model.DeliveryAck;

@Service
public class AcknowledgementServiceImpl implements AcknowledgementService {

	@Autowired
	private NotificationFactory notificationFactory;

	@Autowired
	private NotificationsService notificationService;

	@Override
	public void acknowledgementReceived(DeliveryAck deliveryAck, SourceIdentity sourceIdentity) {
		VISNotification notification = this.notificationFactory.createAcknowledgementReceivedNotification(sourceIdentity, deliveryAck.toString());
		this.notificationService.saveNotification(notification);
	}

}
