package com.example.workshop_ecommerce.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CartController {


    @Autowired
    private CartService cartService;

    @GetMapping("Cart/{userId}")
    public Optional<Cart> getCart(@PathVariable int userId){
        return cartService.getCart(userId);
    }

    @PostMapping(path = "/AddProductToCart",consumes = MediaType.APPLICATION_JSON_VALUE)
     public CartItem addProductToCart(@RequestBody CartItem cartItem){
        return cartService.addCartItem(cartItem);
    }

    @GetMapping("Cartdetail/{userId}")
    public List<CartItem> getCartDetail(@PathVariable int userId){
        return cartService.getCartItem(userId);
    }


}
