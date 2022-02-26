package com.example.workshop_ecommerce.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositpry extends JpaRepository<User, Integer> {
    Optional<User> findById(int id);
}
