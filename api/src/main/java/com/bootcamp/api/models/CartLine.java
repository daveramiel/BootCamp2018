package com.bootcamp.api.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity(name = "cart_lines")
public class CartLine {

    @Getter @Setter @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_cart")
    private Cart cart;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @Getter
    @Setter
    @Column(name = "quantity")
    private int quantity;

    @Setter
    @Column(name = "subtotal")
    private double subtotal;

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    public CartLine(Product p, Cart c, int amount){
        this.setProduct(p);
        this.setCart(c);
        this.setQuantity(amount);
        this.setSubtotal(amount * p.getPrice());
    }
}
