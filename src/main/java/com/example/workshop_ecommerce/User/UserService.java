package com.example.workshop_ecommerce.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepositpry userRepositpry;
    public User getUserById(int id){
        Optional<User> result = userRepositpry.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new UserIDNotFoundException(id);
    }
}
