package app.web.pavelk.microservices2.client13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Eureka13ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(Eureka13ClientApplication.class, args);
    }
}

