package com.example.workshop_ecommerce.Cart.ShippingAddress;

import com.example.workshop_ecommerce.Cart.Cart;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ShippingAddressId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String address;
    private String zipcode;
    private String province;
    private String district;
    private String street;
    @OneToOne(
            mappedBy = "shippingAddress"
    )
    @JsonBackReference
    private Cart cart;
}
