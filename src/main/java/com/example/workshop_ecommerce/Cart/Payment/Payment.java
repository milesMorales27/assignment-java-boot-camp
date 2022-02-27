package com.example.workshop_ecommerce.Cart.Payment;

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
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
    private String paymentMethod;
    private String paymentData;
    private String name;
    private String surName;
    @OneToOne(
            mappedBy = "paymentDetail"
    )
    @JsonBackReference
    private Cart cart;
}
