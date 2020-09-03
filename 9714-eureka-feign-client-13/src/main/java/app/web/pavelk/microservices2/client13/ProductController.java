package app.web.pavelk.microservices2.client13;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

    private CrudClient crudClient;

    @Autowired
    public void setGreetingClient(CrudClient crudClient) {
        this.crudClient = crudClient;
    }

    @ResponseBody
    @GetMapping("/")
    public String getProducts() {
        return crudClient.getProducts();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public String getProduct(@PathVariable(value = "id") String id) {
        return crudClient.getProduct(id);
    }

}
