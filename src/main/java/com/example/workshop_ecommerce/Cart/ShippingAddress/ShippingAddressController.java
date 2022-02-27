package com.example.workshop_ecommerce.Cart.ShippingAddress;

import com.example.workshop_ecommerce.Cart.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShippingAddressController {
    @Autowired
    ShippingAddressService shippingAddressService;
    @PostMapping("CartCheckOut/addShippingAddress")
    public ShippingAddress addAddress(@RequestBody ShippingAddress shippingAddress){
        return  shippingAddressService.addShippingAddress(shippingAddress);
    }
}
