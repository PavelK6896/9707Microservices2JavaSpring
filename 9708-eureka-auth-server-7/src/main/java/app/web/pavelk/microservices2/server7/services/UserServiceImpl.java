package app.web.pavelk.microservices2.server7.services;

import app.web.pavelk.microservices2.server7.entities.Role;
import app.web.pavelk.microservices2.server7.entities.User;
import app.web.pavelk.microservices2.server7.repositories.RoleRepository;
import app.web.pavelk.microservices2.server7.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void saveAdmin() {
        User user = new User();
        user.setEmail("admin@admin");
        user.setName("1");
        user.setUsername("1");
        Role admin = roleRepository.findOneByName("ADMIN");

        System.out.println("saveAdmin" + admin);
        if (admin == null) {
            admin = roleRepository.save(new Role("ADMIN"));
        }

        user.setRoles(Collections.singleton(admin));
        user.setPassword(bCryptPasswordEncoder.encode("1"));
        userRepository.save(user);

        System.out.println("saveAdmin saveAdmin");
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User findByUsername(String username) {
        return userRepository.findOneByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findOneByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
