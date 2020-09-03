package app.web.pavelk.microservices2.client12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Eureka12ClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(Eureka12ClientApplication.class, args);
	}


}

