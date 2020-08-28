package app.web.pavelk.microservices2.client2;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("eureka-client1")
public interface GreetingClient {

    @RequestMapping("/greeting")
    String greeting();

    @GetMapping("/param/{id}")
    String parametrized(@PathVariable(value = "id") String id);

    @RequestMapping("/")
    String hello();
}
