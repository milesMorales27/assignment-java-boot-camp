package com.example.workshop_ecommerce.Cart;
import com.example.workshop_ecommerce.Product.Product;
import com.example.workshop_ecommerce.Product.ProductIDNotFoundException;
import com.example.workshop_ecommerce.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;
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
        int cartId = cartItem.getCartId().getCartId();
        Optional<Cart> cart = cartRepository.findBycartId(cartId);
        if(cart.isPresent()) {
            int productInCartID = cartItem.getProductId();
            Optional<Product> product = productRepository.findByproductId(productInCartID);
            if (product.isPresent()) {
                Optional<CartItem> exitProductId = cartItemRepository.findByproductId(productInCartID);
                if (exitProductId.isPresent()) {
                    int nowQuantity = cartItem.getQuantity() + exitProductId.get().getQuantity();
                    exitProductId.get().setQuantity(nowQuantity);
                    return cartItemRepository.saveAndFlush(exitProductId.get());
                } else {
                    return cartItemRepository.saveAndFlush(cartItem);
                }
            }
            throw new ProductIDNotFoundException(productInCartID);
        }
        throw new CartNotFoundException(cartId);

    }
    public String deleteCartItem(int userId , int productId){
        Optional<Cart> cart = cartRepository.findByUser_userId(userId);

        if(cart.isPresent()){
            int cartId = cart.get().getCartId();
            Optional<CartItem> Product = cartItemRepository.findByCartId_cartIdAndProductId(cartId,productId);
            if(Product.isPresent()){
                cartItemRepository.delete(Product.get());
                return "Success";
            }
            throw new CartItemNotFoundException("Item in cart Not found");
        }
        throw new CartNotFoundException(userId);
    }
    public List<CartItem> getCartItem(int userId){
       Optional<Cart> cart = cartRepository.findByUser_userId(userId);
        if(cart.isPresent()){
            return cart.get().getCartItemList();
        }
        throw new CartItemNotFoundException("Cart is empty");
    }
}
