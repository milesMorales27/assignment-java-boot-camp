package com.example.workshop_ecommerce.Product;

public class ProductIDNotFoundException extends RuntimeException {
    public ProductIDNotFoundException(int id) {

        super(Integer.toString(id));
    }
}
