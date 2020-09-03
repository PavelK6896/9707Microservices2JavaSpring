package app.web.pavelk.microservices2.client13;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("eureka-client11")
public interface CrudClient {

    @GetMapping("/api/products")
    String getProducts();

    @GetMapping("/api/products/{id}")
    String getProduct(@PathVariable(value = "id") String id);

}
