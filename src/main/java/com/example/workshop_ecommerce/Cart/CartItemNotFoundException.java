package com.example.workshop_ecommerce.Cart;

public class CartItemNotFoundException extends RuntimeException {
    public CartItemNotFoundException(String e) {
        super(e);
    }
}
