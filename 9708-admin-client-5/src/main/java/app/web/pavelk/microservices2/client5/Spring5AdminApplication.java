package app.web.pavelk.microservices2.client5;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//Существует несколько реализаций функции "Discovery Service"
// (Эврика, консул, смотритель зоопарка). @EnableDiscoveryClient живет в
// spring-cloud-commons и выбирает реализацию на classpath.
// @EnableEurekaClient живет в spring-cloud-netflix и работает только на эврику.
// Если Эврика находится на вашем classpath, они фактически одинаковы.
@EnableEurekaClient
@EnableAdminServer
public class Spring5AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring5AdminApplication.class, args);
    }
}
