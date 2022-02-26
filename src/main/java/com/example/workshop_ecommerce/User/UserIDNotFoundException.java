package com.example.workshop_ecommerce.User;

public class UserIDNotFoundException extends RuntimeException {
    public UserIDNotFoundException(int id) {
        super(Integer.toString(id));
    }
}
