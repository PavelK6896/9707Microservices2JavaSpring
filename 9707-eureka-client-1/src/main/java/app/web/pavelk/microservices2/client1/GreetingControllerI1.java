package app.web.pavelk.microservices2.client1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public interface GreetingControllerI1 {
    @RequestMapping("/greeting")
    String greeting();

    @GetMapping("/param/{id}")
    String parametrized(@PathVariable(value = "id") String id);
}
