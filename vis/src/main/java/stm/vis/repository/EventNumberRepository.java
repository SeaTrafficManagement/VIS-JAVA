package stm.vis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import stm.vis.model.EventNumber;

public interface EventNumberRepository extends JpaRepository<EventNumber, Integer> {

}
