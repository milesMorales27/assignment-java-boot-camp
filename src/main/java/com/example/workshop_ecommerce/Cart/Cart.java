package com.example.workshop_ecommerce.Cart;
import com.example.workshop_ecommerce.Cart.Payment.Payment;
import com.example.workshop_ecommerce.Cart.ShippingAddress.ShippingAddress;
import com.example.workshop_ecommerce.User.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;
    @OneToOne
    @JoinColumn(
            name = "user_Id",
            referencedColumnName = "userId"
    )
    private User user;
    @OneToMany(
            mappedBy = "cartId",
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<CartItem> cartItemList;
    private String cartStatus;
    @OneToOne(
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    @JoinColumn(
            name = "shipping_Id",
            referencedColumnName = "ShippingAddressId"
    )
    private ShippingAddress shippingAddress;
    @OneToOne(
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    @JoinColumn(
            name = "payment_Id",
            referencedColumnName = "paymentId"
    )
    private Payment paymentDetail;

}
