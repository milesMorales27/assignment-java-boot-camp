package com.example.workshop_ecommerce.Cart;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartItemId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_Id",referencedColumnName = "cartId")
    @JsonBackReference
    private Cart cartId;
    private int productId;
    private int quantity;
}
