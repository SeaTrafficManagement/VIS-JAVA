package stm.vis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import stm.vis.model.LogEvent;

public interface LogEventRepository extends JpaRepository<LogEvent, Long> {

}
