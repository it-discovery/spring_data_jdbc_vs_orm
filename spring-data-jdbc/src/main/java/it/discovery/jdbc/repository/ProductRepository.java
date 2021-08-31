package it.discovery.jdbc.repository;

import it.discovery.jdbc.model.Product;
import it.discovery.jdbc.model.ProductDTO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Cacheable
    @Query("SELECT ID,NAME from PRODUCTS WHERE name=:name")
    ProductDTO findByName(@Param("name") String name);
}
