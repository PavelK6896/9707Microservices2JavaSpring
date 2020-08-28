package app.web.pavelk.microservices2.server7.services;


import app.web.pavelk.microservices2.server7.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
}
