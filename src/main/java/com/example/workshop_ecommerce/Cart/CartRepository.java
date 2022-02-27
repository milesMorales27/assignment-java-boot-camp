package com.example.workshop_ecommerce.Cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Optional<Cart> findByUser_userId(int userId);
    Optional<Cart> findBycartId(int cartId);
}
