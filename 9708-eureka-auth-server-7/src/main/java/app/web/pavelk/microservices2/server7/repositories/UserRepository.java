package app.web.pavelk.microservices2.server7.repositories;

import app.web.pavelk.microservices2.server7.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findOneByUsername(String username);
}
