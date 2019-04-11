package stm.vis.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import stm.vis.data.SourceIdentity;
import stm.vis.data.route.Route;
import stm.vis.model.Connection;
import stm.vis.model.Connection.ConnectionStatus;
import stm.vis.model.LogEvent;
import stm.vis.model.VISNotification.NotificationType;
import stm.vis.service.VISInternalInterface;

public abstract class VISAbstractService {

	@Value("${vis.config.component}")
	private String component;

	@Value("${vis.config.ssc.endpoint}")
	private String sscEndpoint;

	@Autowired
	private VISInternalInterface internalService;

	public VISInternalInterface getInternalService() {
		return this.internalService;
	}

	protected LogEvent logEvent(String externalOrgId, String externalEntityId, int eventNumber, int eventType, String eventParameters, int eventDataType, String eventData) {
		return this.internalService.logEvent(this.component, externalOrgId, externalEntityId, eventNumber, eventType, eventParameters, eventDataType, eventData);
	}

	protected void sendNotifyToSTMModule(SourceIdentity identity, String dataId, byte[] data) {
		String message = null;
		if (data != null) {
			message = new String(data);
		}
		this.sendNotifyToSTMModule(identity, dataId, message);
	}

	protected void sendNotifyToSTMModule(SourceIdentity identity, String dataId, String message) {
		this.internalService.sendNotifyToSTMModule(identity, dataId, message);
	}

	protected void sendMessageWaitingNotificationToSTMModule(SourceIdentity identity, String dataId, byte[] data) {
		this.internalService.sendNotifyToSTMModule(NotificationType.MESSAGE_WAITING, identity, dataId, new String(data));
	}

	protected Connection updateConnectionStatus(ConnectionStatus status) {
		return this.internalService.updateConnectionStatus(this.component, status);
	}

	protected Date getLastInteractionTime() {
		return this.internalService.getLastInteractionTime(this.component);
	}

	protected String getUVIDFromRoute(Route route) {
		return route.getRouteInfo().getVesselVoyage();
	}

	protected String getMyDeliveryAckEndpoint() {
		return this.sscEndpoint;
	}

}
