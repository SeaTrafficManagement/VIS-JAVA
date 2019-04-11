package stm.vis.repository;

import java.net.URI;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import stm.vis.data.messages.MessageType;
import stm.vis.model.Identity;
import stm.vis.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

	void deleteByCallbackEndpoint(String string);

	void deleteByMessageIdAndMessageTypeAndCallbackEndpoint(String messageId, MessageType messageType, URI callbackEndpoint);

	List<Subscription> findByMessageIdAndMessageType(String messageId, MessageType messageType);

	List<Subscription> findBySubscriberIdentityAndMessageTypeAndCallbackEndpoint(Identity subscriberIdentity, MessageType messageType, String callbackEndpoint);

}
