package com.example.workshop_ecommerce.Cart.ShippingAddress;

import com.example.workshop_ecommerce.Cart.Cart;
import com.example.workshop_ecommerce.Cart.CartNotFoundException;
import com.example.workshop_ecommerce.Cart.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShippingAddressService {
    @Autowired
    private ShippingAddressRepository shippingAddressRepository;

    @Autowired
    private CartRepository cartRepository;
    public ShippingAddress addShippingAddress(ShippingAddress shippingAddress){
        int cartId = shippingAddress.getCart().getCartId();
        Optional<Cart> cart = cartRepository.findBycartId(cartId);
        if(cart.isPresent()){
           cart.get().setShippingAddress(shippingAddress);
           return  shippingAddressRepository.saveAndFlush(shippingAddress);
        }
        throw new CartNotFoundException(cartId);
    }

}
