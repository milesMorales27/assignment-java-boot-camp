package com.example.workshop_ecommerce.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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
    @DeleteMapping("deleteItemInCart/{userId}/{productId}")
    public String deleteItemInCart(@PathVariable int userId, @PathVariable int productId){
        return cartService.deleteCartItem(userId,productId);
    }

    @PostMapping(path = "/AddProductToCart",consumes = MediaType.APPLICATION_JSON_VALUE)
     public CartItem addProductToCart(@RequestBody CartItem cartItem){
        return cartService.addCartItem(cartItem);
    }

    @GetMapping("CartDetail/{userId}")
    public List<CartItem> getCartDetail(@PathVariable int userId){
        return cartService.getCartItem(userId);
    }


}
