package app.web.pavelk.microservices2.client12.controller;


import app.web.pavelk.microservices2.client12.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;

@Controller
public class ProductController {
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public String main2(Model model) {
        ResponseEntity<CollectionModel<Product>> responseEntity =
                restTemplate.exchange("http://localhost:8091/api/products", HttpMethod.GET, null,
                        new ParameterizedTypeReference<CollectionModel<Product>>() {
                        }, Collections.emptyMap());

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            CollectionModel<Product> customerResource = responseEntity.getBody();
            Collection<Product> content = customerResource.getContent();
            System.out.println(content);
            model.addAttribute("product", content);
        }

        model.addAttribute("greeting", "All");
        return "prod";
    }

    @GetMapping("/{id}")
    public String main(Model model,
                       @PathVariable(value = "id") String id) {
        System.out.println(" @GetMapping id ");
        ResponseEntity restExchange = restTemplate.exchange("http://localhost:8091/api/products/" + id,
                HttpMethod.GET, null, Product.class);

        model.addAttribute("greeting", "id");
        model.addAttribute("product", restExchange.getBody());
        return "prod";
    }

    @PostMapping(value = "/")
    public String createProduct(@ModelAttribute Product product, Model model) {
        System.out.println(product + " createProduct");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Product> request = new HttpEntity<>(product, headers);
        restTemplate.exchange("http://localhost:8091/api/products", HttpMethod.POST, request, Product.class);
        model.addAttribute("greeting", "create");
        return "prod";
    }

}
