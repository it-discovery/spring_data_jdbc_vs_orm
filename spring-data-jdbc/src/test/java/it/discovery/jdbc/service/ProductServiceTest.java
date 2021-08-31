package it.discovery.jdbc.service;

import it.discovery.jdbc.model.Order;
import it.discovery.jdbc.model.Product;
import it.discovery.jdbc.model.ProductDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import it.discovery.jdbc.config.JdbcConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@JdbcTest
@ContextConfiguration(classes=JdbcConfig.class)
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    void findByName_productDoesntExist_notFound() {
        ProductDTO product = productService.findByName("Some product");
        assertNull(product);
    }

    @Test
    void save_validProduct_success() {
        Product product = new Product();
        product.setName("Phone");
        product.setPrice(100);

        Order order = new Order();
        order.setAmount(1);
        product.addOrder(order);
        productService.save(product);

        Product product2 = productService.findById(product.getId());
        assertEquals(product.getName(), product2.getName());
    }
}
