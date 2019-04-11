package stm.vis.service;

import stm.vis.data.messages.STMMessage;
import stm.vis.model.PublishedMessage;

public interface AsyncService {

	void sendMessageToSubscribers(String uvid, STMMessage voyagePlan, PublishedMessage publishedMessage);

}
