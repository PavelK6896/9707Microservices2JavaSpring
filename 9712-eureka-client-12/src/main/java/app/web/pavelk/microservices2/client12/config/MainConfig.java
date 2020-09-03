package app.web.pavelk.microservices2.client12.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MainConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}