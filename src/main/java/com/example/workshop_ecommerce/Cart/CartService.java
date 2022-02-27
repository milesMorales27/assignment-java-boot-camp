package com.example.workshop_ecommerce.Cart;

import com.example.workshop_ecommerce.Product.ProductIDNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public Optional<Cart> getCart(int userId){
        Optional<Cart> cart_result = cartRepository.findByUser_userId(userId);
        if(cart_result.isPresent()){
            return cart_result;
        }
        throw new CartNotFoundException(userId);
    }
    @Autowired
    private CartItemRepository cartItemRepository;
    public CartItem addCartItem(CartItem cartItem){
        int productInCartID = cartItem.getProductId();
        Optional<CartItem> exitProductId = cartItemRepository.findByproductId(productInCartID);
        if(exitProductId.isPresent()){
            int nowQuantity = cartItem.getQuantity() + exitProductId.get().getQuantity();
            exitProductId.get().setQuantity(nowQuantity);
            return cartItemRepository.saveAndFlush(exitProductId.get());
        }else{
            return cartItemRepository.saveAndFlush(cartItem);
        }
    }

    public List<CartItem> getCartItem(int userId){
       Optional<Cart> cart = cartRepository.findByUser_userId(userId);
        if(cart.isPresent()){
            return cart.get().getCartItemList();
        }
        throw new CartItemNotFoundException("Cart is Emtry");
    }
}
