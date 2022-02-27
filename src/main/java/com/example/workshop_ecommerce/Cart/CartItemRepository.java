package com.example.workshop_ecommerce.Cart;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findBycartId(int id);
    Optional<CartItem> findByproductId(int productInCartID);
}
