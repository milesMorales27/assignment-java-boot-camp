package com.example.workshop_ecommerce.Order.OrderCheckOut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/createOrder")
    public OrderCheckOut createOrder(@RequestBody OrderCheckOut orderCheckOut){
        return orderService.createOrderCheckOut(orderCheckOut) ;
    }

    @GetMapping("/getOrderDetail/{orderId}")
    public OrderCheckOut gerOrder(@PathVariable int orderId){
        return orderService.getOrderDetail(orderId);
    }
}
