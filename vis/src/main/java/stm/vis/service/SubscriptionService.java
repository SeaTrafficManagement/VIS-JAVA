package stm.vis.service;

import java.net.URI;
import java.util.List;

import stm.vis.data.messages.MessageType;
import stm.vis.model.Identity;
import stm.vis.model.Subscription;

public interface SubscriptionService {

	Subscription addSubscription(Identity identity, String messageId, MessageType messageType, URI callbackEndpoint);

	void removeSubscription(Identity identity, String messageId, MessageType messageType, URI callbackEndpoint);

	List<Subscription> getSubscriptions(String messageId, MessageType messageType);

	List<Subscription> getSubscriptions(Identity identity, MessageType rtz, String callbackEndpoint);

	void updateTimeOfLastSentMessage(Subscription subscription);

}
