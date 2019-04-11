package stm.vis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import stm.vis.model.EventType;

public interface EventTypeRepository extends JpaRepository<EventType, Integer> {

}
