package com.example.workshop_ecommerce.Cart;
import com.example.workshop_ecommerce.Order.OrderCheckOut.OrderCheckOut;
import com.example.workshop_ecommerce.User.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @OneToOne(mappedBy = "cart")
    @JsonBackReference
    private OrderCheckOut orderDetail;

}
