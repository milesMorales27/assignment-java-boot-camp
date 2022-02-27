package com.example.workshop_ecommerce.Order.OrderCheckOut;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderCheckOut, Integer> {
    Optional<OrderCheckOut> findByorderId(int cartId);
}
