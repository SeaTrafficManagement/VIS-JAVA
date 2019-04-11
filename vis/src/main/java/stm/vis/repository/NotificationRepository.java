package stm.vis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import stm.vis.model.VISNotification;

public interface NotificationRepository extends JpaRepository<VISNotification, Long> {

	List<VISNotification> findByMessageWaitingTrue();

}
