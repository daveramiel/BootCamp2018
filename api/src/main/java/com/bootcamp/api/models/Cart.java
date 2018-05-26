package com.bootcamp.api.models;


import lombok.Getter;
import lombok.Setter;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shopping_carts")
public class Cart {
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
        CartLine cL = null;
        if (!isProduct(p.getId())){
            cL = new CartLine(p,this,amount);
            this.getLines().add(cL);
        }
    }
}
