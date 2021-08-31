package it.discovery.jpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import it.discovery.JpaApplication;
import it.discovery.jpa.model.Order;
import it.discovery.jpa.model.Product;

@DataJpaTest(showSql = true)
@ContextConfiguration(classes = JpaApplication.class)
@Rollback(false)
public class ProductRepositoryTest {
	
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
		
		Product product2 = productRepository.findById(product.getId()).get();
		assertEquals(product.getName(), product2.getName());
		assertEquals(1, product2.getOrders().size());
	}

}
