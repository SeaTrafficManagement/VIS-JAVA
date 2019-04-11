package stm.vis.service.impl;

import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import stm.vis.data.messages.STMMessage;
import stm.vis.model.Identity;
import stm.vis.model.UploadedMessage;
import stm.vis.repository.UploadedMessageRepository;
import stm.vis.service.UploadedMessageService;

@Service
public class UploadedMessageServiceImpl implements UploadedMessageService {

	@Autowired
	private UploadedMessageRepository repository;

	@Override
	public UploadedMessage saveUploadedMessage(Identity sourceIdentity, STMMessage message, URI deliveryAckEndpoint) {
		UploadedMessage uploadedMessage = new UploadedMessage();
		uploadedMessage.setReceiveTime(new Date());
		uploadedMessage.setFrom(sourceIdentity.getId());
		uploadedMessage.setDeliveryAckRequested(deliveryAckEndpoint != null);
		uploadedMessage.setAckDelivered(false);
		uploadedMessage.setDeliveryAckEndpoint(deliveryAckEndpoint == null ? null : deliveryAckEndpoint.toString());
		uploadedMessage.setNotified(false);
		uploadedMessage.setFetchedByShip(false);
		uploadedMessage.setFetchTime(null);
		uploadedMessage.setMessageType(message.getMessageType());
		uploadedMessage.setMessage(message.getData());
		return this.repository.save(uploadedMessage);
	}

	@Override
	public UploadedMessage getUploadedMessage(String id) {
		return this.repository.findOne(new Long(id));
	}

	@Override
	public List<UploadedMessage> getUploadedMessages() {
		return this.repository.findByFetchedByShip(false);
	}

	@Override
	public List<UploadedMessage> getUploadedMessages(int limit) {
		return this.repository.findByFetchedByShip(false, new PageRequest(1, limit));
	}

	@Override
	public boolean hasUnfetchedMessagesOlderThan(int unfetchedTime) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MILLISECOND, unfetchedTime * (-1));
		int count = this.repository.countByFetchedByShipAndReceiveTimeLessThan(false, calendar.getTime());
		return (count > 0);
	}

	@Override
	public int getRemainingNumberOfMessages() {
		return (int) this.repository.countByFetchedByShip(false);
	}

	@Override
	public UploadedMessage updateMessageFetched(UploadedMessage message, Date now) {
		message.setNotified(true);
		message.setFetchedByShip(true);
		message.setFetchTime(now);
		return this.repository.save(message);
	}

	@Override
	public UploadedMessage updateMessageACKSent(UploadedMessage message) {
		message.setAckDelivered(true);
		return this.repository.save(message);
	}

}
