package app.web.pavelk.microservices2.server6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Eureka6ConfigServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(Eureka6ConfigServerApplication.class, args);
	}
}

