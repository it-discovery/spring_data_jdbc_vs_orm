package it.discovery.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.discovery.jpa.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
