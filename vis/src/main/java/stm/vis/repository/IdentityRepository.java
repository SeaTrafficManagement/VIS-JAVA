package stm.vis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import stm.vis.model.Identity;

public interface IdentityRepository extends JpaRepository<Identity, Long> {

}
