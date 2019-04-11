package stm.vis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import stm.vis.model.ACLObject;
import stm.vis.model.Identity;

public interface ACLObjectRepository extends JpaRepository<ACLObject, Long> {

	ACLObject findByMessage(String message);

	List<ACLObject> findAllByIdentities(Identity identity);

}
