package com.example.workshop_ecommerce.Product;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String name;
    private String detail;
    private double defaultPrice;
    private double discount;

    private int store;

    public Product(String searchProduct) {
        this.name = searchProduct;
    }

    public Product(String name, String detail, double defaultPrice, double discount, int store) {
        this.name = name;
        this.detail = detail;
        this.defaultPrice = defaultPrice;
        this.discount = discount;
        this.store = store;
    }
}
