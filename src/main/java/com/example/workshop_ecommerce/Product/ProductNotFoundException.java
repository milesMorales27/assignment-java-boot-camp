package com.example.workshop_ecommerce.Product;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String name) {
        super(name);
    }
}
