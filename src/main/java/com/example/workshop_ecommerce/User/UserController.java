package com.example.workshop_ecommerce.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {
    @Autowired
    private UserRepositpry userRepositpry;

    @PostConstruct
    public void CreateUser(){
        User user = User.builder()
                            .name("Somchai")
                            .surname("Rukchat")
                            .phoneNumber("0823658975")
                            .address("546/78")
                            .province("bangkok")
                            .district("bangna")
                            .street("sukhumvir")
                            .zipcode("18254").build();
        userRepositpry.save(user);
    }


    @Autowired
    private UserService userService;
    @GetMapping("User/{id}")
    public User GetUser(@PathVariable int id){
        return userService.getUserById(id);
    }

}
