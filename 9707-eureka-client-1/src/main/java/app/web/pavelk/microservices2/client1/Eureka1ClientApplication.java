package app.web.pavelk.microservices2.client1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Eureka1ClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(Eureka1ClientApplication.class, args);
	}
}

