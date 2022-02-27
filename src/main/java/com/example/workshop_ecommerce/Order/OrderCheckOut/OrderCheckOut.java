package com.example.workshop_ecommerce.Order.OrderCheckOut;
import com.example.workshop_ecommerce.Cart.Cart;
import com.example.workshop_ecommerce.Order.ShippingAddress.ShippingAddess;
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
public class OrderCheckOut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    //private Peyment paymentDetail;
    //private ShippingAddess shippingDetail;
    @OneToOne(cascade = CascadeType.MERGE ,fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(
            name = "cartId",
            referencedColumnName = "cartId"
    )
    @JsonManagedReference
    private Cart cart;
    private String orderStatus;
    private double shippingCost;

}
