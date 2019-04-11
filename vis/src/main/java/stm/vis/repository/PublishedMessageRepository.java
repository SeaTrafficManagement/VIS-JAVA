package stm.vis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import stm.vis.model.PublishedMessage;

public interface PublishedMessageRepository extends JpaRepository<PublishedMessage, Long> {

	List<PublishedMessage> findByMessageStatusNotOrderByDateTimeDesc(Integer messageStatus);

	List<PublishedMessage> findByMessageStatusOrderByDateTimeDesc(Integer messageStatus);

	List<PublishedMessage> findByMessageIdOrderByDateTimeDesc(String messageId);

	List<PublishedMessage> findByMessageIdAndMessageStatusOrderByDateTimeDesc(String messageId, Integer messageStatus);

	void deleteByMessageId(String dataId);

}
