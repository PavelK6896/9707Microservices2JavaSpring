package app.web.pavelk.microservices2.server7.repositories;

import app.web.pavelk.microservices2.server7.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findOneByName(String name);
}
