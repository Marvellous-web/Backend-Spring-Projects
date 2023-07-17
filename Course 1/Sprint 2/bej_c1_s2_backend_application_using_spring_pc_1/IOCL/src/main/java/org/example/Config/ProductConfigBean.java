package org.example.Config;

import org.example.Model.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

public class ProductConfigBean {
    @Bean("Product1")
    public Product getProduct(){
        Product product1=new Product();
        product1.setProd_cat("Electronics");
        product1.setProd_name("Laptop");
        product1.setProd_price(150000);
        return product1;
    }
    @Bean("Product2")
    public Product getProduct1(){
        Product product2=new Product("Beauty","Perfume",999);
        return product2;
    }
}
