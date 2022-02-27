package com.example.workshop_ecommerce.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByNameContainingIgnoreCase(String name);
    Optional<Product> findByproductId(int id);
    List<Product> findAll();
}
