package stm.vis.service;

import java.util.List;
import java.util.Map;

import stm.vis.data.FindServicesParams;
import stm.vis.data.VISRequestType;
import stm.vis.data.ResponseObject;
import stm.vis.data.messages.Messages;
import stm.vis.exception.VISException;
import stm.vis.model.Identity;
import stm.vis.model.VISNotification;
import stm.vis.model.PublishedMessage;
import stm.vis.model.Subscription;
import stm.vis.ssc.client.data.IRService;
import stm.vis.ssc.client.data.VISOrganization;
import stm.vis.ssc.client.data.SRService;
import stm.vis.web.privateapi.model.SubscriptionObject;

public interface VISPrivateInterface {

	/**
	 * Enables publishing a VoyagePlan in RTZ format to VIS, which will store it and forward to subscribers and on request.
	 * 
	 * When a publishMessage request is received in VIS the message payload is validated and subsequently stored in the VIS database. 
	 * Publishing a message serve two purposes; store the latest VoyagePlan and facilitate sending of the published VoyagePlan to subscribers. 
	 * The latter case is only relevant if there are subscribers for Voyage Plans with the actual UVID. 
	 * Endpoints for subscribers are read from the subscription table in VIS dB and the SSC exposed interface for consuming a service, callService is invoked. Hereby passing the relevant payload received in the STMMessage together with endpoint (URI) for the called service found in the subscription table.
	 * In case the schema validation fails a message informing the caller of an invalid format is returned.
	 * 
	 * @param dataId
	 * @param messageType
	 * @param message
	 * @return
	 */
	ResponseObject publishMessage(String dataId, String messageType, String message);

	/**
	 * Enable private application to fetch published messages from VIS to check consistency.
	 * Returns the current active voyage plans in VIS.
	 * @return
	 */
	List<PublishedMessage> getPublishedMessages();

	/**
	 * Enables the STM onboard system (STM Module) to retrieve messages waiting in VIS. 
	 * The messages can be of type RTZ, textMessage, Area/Polygon.
	 * @return
	 */
	Messages getMessages(Integer limitQuery);

	ResponseObject authorizeIdentities(List<Identity> identities, String dataId);

	List<Identity> findAuthorizedIdentities(String dataId);

	ResponseObject removeAuthorizedIdentitites(List<Identity> identities, String dataId);

	/**
	 * Retrieve waiting notifications. 
	 * Alternative method for private application to poll VIS for noitification if not possible to receive notifications from VIS. 
	 * Can also be called if private application has been restarted or has been offline.
	 * @return
	 */
	List<VISNotification> getNotifications();

	List<Subscription> getSubscriptions(String dataId);

	void addSubscriptions(List<SubscriptionObject> subscriptions, String dataId) throws VISException;

	void removeSubscriptions(List<SubscriptionObject> subscriptions, String dataId) throws VISException;

	/*
	 * SSC Methods
	 */

	List<VISOrganization> findIdentities() throws VISException;

	VISOrganization findOrganization(String organisationMrn) throws VISException;

	IRService findIdentity(String organisationMrn, String serviceMrn, String incomingCertificateType) throws VISException;

	List<SRService> findServices(FindServicesParams params) throws VISException;

	ResponseObject callService(VISRequestType requestType, String targetUrl, Map<String, String> headersMap, String body) throws VISException;

	/**
	 * Enables removing a published message in VIS.
	 * @param dataId
	 */
	void removePublishedMessage(String dataId) throws VISException;

}
