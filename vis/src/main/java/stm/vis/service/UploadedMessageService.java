package stm.vis.service;

import java.net.URI;
import java.util.Date;
import java.util.List;

import stm.vis.data.messages.STMMessage;
import stm.vis.model.Identity;
import stm.vis.model.UploadedMessage;

public interface UploadedMessageService {

	UploadedMessage saveUploadedMessage(Identity sourceIdentity, STMMessage message, URI deliveryAckEndpoint);

	UploadedMessage getUploadedMessage(String dataId);

	List<UploadedMessage> getUploadedMessages();

	List<UploadedMessage> getUploadedMessages(int limit);

	/**
	 * 
	 * @param unfetchedTime time in milliseconds
	 * @return
	 */
	boolean hasUnfetchedMessagesOlderThan(int unfetchedTime);

	int getRemainingNumberOfMessages();

	UploadedMessage updateMessageFetched(UploadedMessage message, Date now);

	UploadedMessage updateMessageACKSent(UploadedMessage message);

}
