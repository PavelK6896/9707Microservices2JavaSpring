package app.web.pavelk.microservices2.server7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableAuthorizationServer
public class Auth7ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Auth7ServerApplication.class, args);
    }
}
