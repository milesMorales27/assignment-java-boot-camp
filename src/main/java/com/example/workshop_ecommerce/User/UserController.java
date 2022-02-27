package com.example.workshop_ecommerce.User;

import com.example.workshop_ecommerce.Cart.Cart;
import com.example.workshop_ecommerce.Cart.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {
    @Autowired
    private UserRepositpry userRepositpry;
    @Autowired
    private CartRepository cartRepository;
    @PostConstruct
    public void CreateUser(){
        User user = User.builder()
                            .name("Somchai")
                            .surname("Rukchat")
                            .phoneNumber("0823658975")
                            .address("546/78")
                            .province("bangkok")
                            .district("bangna")
                            .street("sukhumvit")
                            .zipcode("18254").build();
        userRepositpry.save(user);
        Cart c = new Cart();
        c.setUser(user);
        cartRepository.save(c);
    }


    @Autowired
    private UserService userService;
    @GetMapping("User/{id}")
    public User GetUser(@PathVariable int id){
        return userService.getUserById(id);
    }

}
