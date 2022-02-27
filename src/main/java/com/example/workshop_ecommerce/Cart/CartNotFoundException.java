package com.example.workshop_ecommerce.Cart;

public class CartNotFoundException extends RuntimeException {
    public CartNotFoundException(int id) {
        super(Integer.toString(id));
    }
}
