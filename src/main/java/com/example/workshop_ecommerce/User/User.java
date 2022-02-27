package com.example.workshop_ecommerce.User;

import com.example.workshop_ecommerce.Cart.Cart;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String address;
    private String zipcode;
    private String province;
    private String district;
    private String street;
    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private Cart cart;



}
