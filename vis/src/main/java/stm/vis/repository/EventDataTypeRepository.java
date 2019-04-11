package stm.vis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import stm.vis.model.EventDataType;

public interface EventDataTypeRepository extends JpaRepository<EventDataType, Integer> {

}
