package app.web.pavelk.microservices2.client1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController implements GreetingControllerI1 {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/")
    public String main() {
        return appName;
    }

    @GetMapping("/name")
    public String greeting(@RequestParam(name = "name", required = false) String s) {
        return String.format("Hello from '%s'!", s);
    }

    @Override
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/param/{id}")
    public String parametrized(@PathVariable(value = "id") String id) {
        return "echo: " + id;
    }

}
