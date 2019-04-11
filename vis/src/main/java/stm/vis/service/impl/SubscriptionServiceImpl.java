package stm.vis.service.impl;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stm.vis.data.messages.MessageType;
import stm.vis.model.Identity;
import stm.vis.model.Subscription;
import stm.vis.repository.SubscriptionRepository;
import stm.vis.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	private SubscriptionRepository repository;

	@Override
	public Subscription addSubscription(Identity identity, String messageId, MessageType messageType, URI callbackEndpoint) {
		Subscription subscription = new Subscription();
		subscription.setMessageId(messageId);
		subscription.setMessageType(messageType);
		subscription.setCallbackEndpoint(callbackEndpoint.toString());
		subscription.setSubscriberIdentity(identity);
		subscription.setTimeOfSubscriptionRequest(new Date());
		subscription.setTimeOfLastSentMessage(null);
		return this.repository.save(subscription);
	}

	@Override
	public void removeSubscription(Identity identity, String messageId, MessageType messageType, URI callbackEndpoint) {
		this.repository.deleteByMessageIdAndMessageTypeAndCallbackEndpoint(messageId, messageType, callbackEndpoint);
	}

	@Override
	public void updateTimeOfLastSentMessage(Subscription subscription) {
		subscription.setTimeOfLastSentMessage(new Date());
		this.repository.save(subscription);
	}

	@Override
	public List<Subscription> getSubscriptions(String messageId, MessageType messageType) {
		return this.repository.findByMessageIdAndMessageType(messageId, messageType);
	}

	@Override
	public List<Subscription> getSubscriptions(Identity identity, MessageType messageType, String callbackEndpoint) {
		return this.repository.findBySubscriberIdentityAndMessageTypeAndCallbackEndpoint(identity, messageType, callbackEndpoint);
	}
}
