package stm.vis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import stm.vis.model.Connection;

public interface ConnectionRepository extends JpaRepository<Connection, String> {

}
