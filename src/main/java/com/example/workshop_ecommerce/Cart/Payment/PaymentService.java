package com.example.workshop_ecommerce.Cart.Payment;

import com.example.workshop_ecommerce.Cart.Cart;
import com.example.workshop_ecommerce.Cart.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private CartRepository cartRepository;
    public Payment addPaymentMethod(Payment payment){
        int cartId = payment.getCart().getCartId();
        Optional<Cart> cart = cartRepository.findBycartId(cartId);
        if(cart.isPresent()){
            cart.get().setPaymentDetail(payment);
        }
        return paymentRepository.save(payment);
    }
}
