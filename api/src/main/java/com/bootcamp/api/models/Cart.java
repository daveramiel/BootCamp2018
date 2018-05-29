package com.bootcamp.api.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "shopping_carts")
public class Cart {

    public Cart(User user){
        this.setUser(user);
        this.lines = new ArrayList<>();
    }

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Setter @Column(name = "total") private double total;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Getter @Setter @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,fetch = FetchType.EAGER) private List<CartLine> lines;

    public double getTotal() {
        double total = 0;

        for(CartLine cl : this.lines){
            total += cl.getSubtotal();
        }
        return total;
    }

    public void findLineAddAmount(Long idProd, int amount) {
        for (CartLine cL : this.getLines()) {
            if (cL.getProduct().getId() == idProd) {
                cL.setQuantity(cL.getQuantity() + amount);
            }
        }
    }

    public Boolean isProduct(Long idProd){
        Boolean answer=false;
        for (CartLine cL : this.getLines()) {
            if(cL.getProduct().getId() == idProd){
                answer = true;
            }
        }
        return answer;
    }

    public void addNewLine(Product p,int amount){
        CartLine cL = new CartLine(p,this,amount);
        if (!isProduct(p.getId())){
            this.getLines().add(cL);
        } else {
            this.findLineAddAmount(p.getId(),amount);
        }
        this.setTotal(this.getTotal());
    }
}
