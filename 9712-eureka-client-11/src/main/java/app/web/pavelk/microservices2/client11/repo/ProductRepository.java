package app.web.pavelk.microservices2.client11.repo;

import app.web.pavelk.microservices2.client11.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
