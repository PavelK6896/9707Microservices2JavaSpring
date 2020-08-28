package app.web.pavelk.microservices2.client2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

    private GreetingClient greetingClient;

    @Autowired
    public void setGreetingClient(GreetingClient greetingClient) {
        this.greetingClient = greetingClient;
    }

    @RequestMapping("/param")
    public String greeting(Model model) {
        String answer = greetingClient.parametrized("1000");
        model.addAttribute("greeting", answer);
        return "greeting-view";
    }

    @ResponseBody
    @RequestMapping("/g1")//метод 1 клиента в интерфейсе
    public String greeting1() {
        return greetingClient.greeting();
    }


    @ResponseBody
    @GetMapping("/")//метод 1 клиента не в интерфейсе
    public String hello() {
        return greetingClient.hello();
    }

}
