package app.web.pavelk.microservices2.client2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Eureka2ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(Eureka2ClientApplication.class, args);
    }
}

