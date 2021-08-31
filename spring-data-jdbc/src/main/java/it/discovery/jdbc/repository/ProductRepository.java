package it.discovery.jdbc.repository;

import it.discovery.jdbc.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
