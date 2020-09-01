package app.web.pavelk.microservices2.client11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Eureka11ClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(Eureka11ClientApplication.class, args);
	}
}

