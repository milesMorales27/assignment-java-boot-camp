package com.example.workshop_ecommerce.Cart.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @PostMapping("CartCheckOut/addPaymentMethod")
    public Payment addPayment(@RequestBody Payment payment){
        return paymentService.addPaymentMethod(payment);
    }
}
