package app.web.pavelk.microservices2.common2;

public interface ProductI1 {
    String getTitle();

    String getDescription();

    java.math.BigDecimal getPrice();

    void setTitle(String title);

    void setDescription(String description);

    void setPrice(java.math.BigDecimal price);
}
