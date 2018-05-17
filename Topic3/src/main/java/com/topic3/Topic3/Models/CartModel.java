package com.topic3.Topic3.model;



import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> cartList;

    public ShoppingCart(){
        this.cartList = new ArrayList<>();
    }

    public void addItem(Product newProd){
        this.cartList.add(newProd);
    }

    public Boolean deleteItem(Long idProd){
        Boolean answer = false;
        for (Product removeP : this.cartList) {
            if (idProd == removeP.getId()){
                this.cartList.remove(removeP);
                answer = true;
            }
        }
        return answer;
    }

    public List<Product> getFullList(){
        return this.cartList;
    }

    public Boolean cleanCart(){
        Boolean answer=false;
        if (!this.cartList.isEmpty()){
            this.cartList.clear();
            answer = true;
        }
        return answer;
    }

}
