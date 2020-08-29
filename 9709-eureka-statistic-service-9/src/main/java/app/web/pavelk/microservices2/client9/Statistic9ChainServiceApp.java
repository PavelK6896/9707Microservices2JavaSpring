package app.web.pavelk.microservices2.client9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
public class Statistic9ChainServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(Statistic9ChainServiceApp.class, args);
    }
}
