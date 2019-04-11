package stm.vis.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import stm.vis.model.UploadedMessage;

public interface UploadedMessageRepository extends JpaRepository<UploadedMessage, Long> {

	List<UploadedMessage> findByFetchedByShip(boolean fetchedByShip);

	List<UploadedMessage> findByFetchedByShip(boolean fetchedByShip, Pageable pageable);

	long countByFetchedByShip(boolean fetchedByShip);

	int countByFetchedByShipAndReceiveTimeLessThan(boolean fetchedByShip, Date receiveTime);

}
