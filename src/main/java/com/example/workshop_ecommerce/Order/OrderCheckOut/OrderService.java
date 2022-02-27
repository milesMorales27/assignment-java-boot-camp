package com.example.workshop_ecommerce.Order.OrderCheckOut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    public OrderCheckOut createOrderCheckOut(OrderCheckOut orderCheckOut){
        return  orderRepository.saveAndFlush(orderCheckOut);
    }

    public OrderCheckOut getOrderDetail(int orderId){
            return orderRepository.findByorderId(orderId).get();
    }
}
