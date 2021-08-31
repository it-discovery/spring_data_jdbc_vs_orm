package it.discovery.jdbc.service;

import it.discovery.jdbc.model.Product;
import it.discovery.jdbc.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;
	
	public void save(Product product) {
		productRepository.save(product);
	}

	public Product findById(int id) {
		return productRepository.findById(id).orElseThrow();
	}

}
