package app.web.pavelk.microservices2.client12.model;

import app.web.pavelk.microservices2.common2.ProductI1;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product implements ProductI1 {

    private String title;

    private String description;

    private BigDecimal price;

}


