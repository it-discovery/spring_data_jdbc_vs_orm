package it.discovery.jdbc.repository;

import it.discovery.jdbc.model.Product;

public interface ProductRepository {
	
	void save(Product product);
	
	Product findById(int id);

}
