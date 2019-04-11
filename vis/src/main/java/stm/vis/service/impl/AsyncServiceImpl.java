package stm.vis.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import stm.vis.data.ResponseObject;
import stm.vis.data.StatusCode;
import stm.vis.data.VISRequestType;
import stm.vis.data.messages.MessageType;
import stm.vis.data.messages.STMMessage;
import stm.vis.exception.VISException;
import stm.vis.model.Identity;
import stm.vis.model.PublishedMessage;
import stm.vis.model.Subscription;
import stm.vis.service.AsyncService;
import stm.vis.service.SubscriptionService;
import stm.vis.ssc.client.SscClientHelper;
import stm.vis.ssc.client.SscClientHelperFactory;
import stm.vis.ssc.client.data.IRService;

@org.springframework.stereotype.Service
public class AsyncServiceImpl extends VISAbstractService implements AsyncService {

	@Autowired
	private SubscriptionService subscriptionService;

	@Autowired
	private SscClientHelperFactory sscClientFactory;

	private SscClientHelper sscClient;

	@PostConstruct
	void initSscClient() {
		this.sscClient = this.sscClientFactory.newInstance();
	}

	@Async
	@Override
	public void sendMessageToSubscribers(String uvid, STMMessage voyagePlan, PublishedMessage publishedMessage) {
		/*
		 * Operation functionality
		 * - get subcribers to UVID=route.UVID
		 * - for each subscriber
		 *   - Match RTZ schema version to subscriber
		 *   - Invoke subscriber.uploadVoyagePlan(route)
		 */

		List<Subscription> subscribers = this.subscriptionService.getSubscriptions(uvid, MessageType.RTZ);
		for (Subscription subscriber : subscribers) {
			try {
				this.uploadVoyagePlan(subscriber.getCallbackEndpoint(), voyagePlan);
				this.subscriptionService.updateTimeOfLastSentMessage(subscriber);
			} catch (VISException e) {
				e.printStackTrace();
			}
		}
	}

	private void uploadVoyagePlan(String callbackEndpoint, STMMessage voyagePlan) throws VISException {
		String url = callbackEndpoint + "/voyagePlans?deliveryAckEndPoint=" + this.getMyDeliveryAckEndpoint();
		String body = new String(voyagePlan.getData());
		/* String response = */ this.callService(VISRequestType.POST, url, body);
	}

	private String callService(VISRequestType requestType, String url, String body) throws VISException {
		Map<String, String> headersMap = new HashMap<>();
		// TODO Add more headers?
		headersMap.put("Content-Type", "application/json");
		ResponseObject response = this.sscClient.callService(requestType, url, headersMap, body);
		if (response.getStatusCode() != StatusCode.OK) {
			throw new VISException(response.getBody());
		}
		return response.getBody();
	}

	public String callService(IRService service, String body) {
		// TODO Notification not defined in documentation
		// TODO this.sscClient.callService(requestType, targetUrl, headersMap, body);
		return null;
	}

	public IRService findService(Identity authorizedIdentity, String serviceName) {
		// TODO this.sscClient.callServiceRegistryRequest(requestType, requestUrl, headersMap, body);
		return null;
	}

}
