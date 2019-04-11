package stm.vis.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import stm.vis.data.SourceIdentity;
import stm.vis.model.Connection;
import stm.vis.model.Connection.ConnectionStatus;
import stm.vis.model.LogEvent;
import stm.vis.model.VISNotification;
import stm.vis.model.VISNotification.NotificationType;
import stm.vis.repository.ConnectionRepository;
import stm.vis.repository.EventDataTypeRepository;
import stm.vis.repository.EventNumberRepository;
import stm.vis.repository.EventTypeRepository;
import stm.vis.repository.LogEventRepository;
import stm.vis.service.NotificationsService;
import stm.vis.service.VISInternalInterface;

@Service
public class VISInternal implements VISInternalInterface {

	@Value("${vis.config.system}")
	private String system;

	@Value("${vis.config.component}")
	private String component;

	@Value("${vis.config.timer-job.unfetched-time}")
	private int unfetchedTime;

	@Autowired
	private NotificationFactory notificationFactory;

	@Autowired
	private NotificationsService notificationsService;

	@Autowired
	private LogEventRepository logEventRepository;

	@Autowired
	private EventNumberRepository eventNumberRepository;

	@Autowired
	private EventTypeRepository eventTypeRepository;
	
	@Autowired
	private EventDataTypeRepository eventDataTypeRepository;
	
	@Autowired
	private ConnectionRepository connectionRepository;

	@Override
	public void sendNotifyToSTMModule(SourceIdentity identity, String dataId, String message) {
		/* 
		 * - Create notification message "UNAUTHORIZED_REQUEST"
		 * - Send "notify" to STM Module
		 * 
		 * Log event and data.
		 * Update connection status
		 */

		VISNotification notification = this.notificationFactory.createUnauthorizedRequestNotification(identity, message);
		this.notificationsService.saveNotification(notification);
	}

	@Override
	public void sendNotifyToSTMModule(NotificationType type, SourceIdentity identity, String dataId, String message) {
		VISNotification notification = this.notificationFactory.createMessageWaitingNotification();
		this.notificationsService.saveNotification(notification);
	}

	@Override
	public LogEvent logEvent(String serviceInstanceId, String externalOrgId, String externalEntityId, int eventNumber, int eventType, String eventParameters, int eventDataType, String eventData) {
		LogEvent event = new LogEvent();
		event.setTime(new Date());
		event.setServiceInstanceId(serviceInstanceId);
		event.setExternalOrgId(externalOrgId);
		event.setExternalEntityId(externalEntityId);
		event.setEventNumber(this.eventNumberRepository.findOne(eventNumber));
		event.setEventType(this.eventTypeRepository.findOne(eventType));
		event.setEventParameters(eventParameters);
		event.setEventDataType(this.eventDataTypeRepository.findOne(eventDataType));
		event.setEventData(eventData);
		return this.logEventRepository.save(event);
	}

	@Override
	public Connection updateConnectionStatus(String component, ConnectionStatus status) {
		Connection connection = new Connection();
		connection.setComponent(component);
		connection.setLastInteraction(new Date());
		connection.setConnectionStatus(status);
		return this.connectionRepository.save(connection);
	}

	@Override
	public Date getLastInteractionTime(String component) {
		Date lastInteractionTime = null;
		Connection connection = this.connectionRepository.findOne(component);
		if (connection != null) {
			lastInteractionTime = connection.getLastInteraction();
		}
		return lastInteractionTime;
	}

}
