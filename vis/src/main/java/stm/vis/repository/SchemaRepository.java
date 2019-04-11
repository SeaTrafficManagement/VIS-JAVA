package stm.vis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import stm.vis.model.Schema;

public interface SchemaRepository extends JpaRepository<Schema, Long> {

	Schema findByName(String name);

}
