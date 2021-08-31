package it.discovery.jdbc.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import it.discovery.jdbc.config.JdbcConfig;
import it.discovery.jdbc.model.Order;
import it.discovery.jdbc.model.Product;

@SpringJUnitConfig(classes = JdbcConfig.class)
public class SpringJdbcProductRepositoryTest {
	
	@Autowired
	ProductRepository productRepository;
	
	@Test
	void save_validProduct_success() {
		Product product = new Product();
		product.setName("Phone");
		product.setPrice(100);
		
		Order order = new Order();
		order.setAmount(1);
		product.addOrder(order);
		productRepository.save(product);
		
		Product product2 = productRepository.findById(product.getId());
		assertEquals(product.getName(), product2.getName());
	}


}
