package stm.vis.service;

import java.util.Date;

import stm.vis.data.SourceIdentity;
import stm.vis.model.Connection;
import stm.vis.model.Connection.ConnectionStatus;
import stm.vis.model.LogEvent;
import stm.vis.model.VISNotification.NotificationType;

public interface VISInternalInterface {

	/**
	 * Send notification to STM Module
	 * @param identity
	 * @param dataId
	 * @param message 
	 */
	void sendNotifyToSTMModule(SourceIdentity identity, String dataId, String message);

	/**
	 * Send notification to STM Module
	 * @param type
	 * @param identity
	 * @param dataId
	 * @param message
	 */
	void sendNotifyToSTMModule(NotificationType type, SourceIdentity identity, String dataId, String message);

	/**
	 * Logs event using current datetime
	 * 
	 * @param serviceInstanceId
	 * @param externalOrgId
	 * @param externalEntityId
	 * @param eventNumber
	 * @param eventType
	 * @param eventParameters
	 * @param eventDataType
	 * @param eventData
	 * @return
	 */
	LogEvent logEvent(String serviceInstanceId, String externalOrgId, String externalEntityId, int eventNumber, int eventType, String eventParameters, int eventDataType, String eventData);

	/**
	 * Updates Connection object for this component, using connection status and current datetime
	 * @param component
	 * @param status
	 * @return
	 */
	Connection updateConnectionStatus(String component, ConnectionStatus status);

	Date getLastInteractionTime(String component);


}
