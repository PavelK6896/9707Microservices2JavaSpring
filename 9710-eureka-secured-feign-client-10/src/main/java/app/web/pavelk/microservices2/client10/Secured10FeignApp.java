package app.web.pavelk.microservices2.client10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
@EnableFeignClients
public class Secured10FeignApp {
    public static void main(String[] args) {
        SpringApplication.run(Secured10FeignApp.class, args);
    }
}
