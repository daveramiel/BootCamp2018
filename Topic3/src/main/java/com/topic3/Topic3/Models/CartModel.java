package com.topic3.Topic3.Models;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Repository
public class CartModel {


    private ArrayList<ProductModel> cartList;

    public CartModel() {
        this.cartList = new ArrayList<>();
    }

    public void addItem(ProductModel newProd) {
        this.cartList.add(newProd);
    }

    public Boolean deleteItem(int idProd) {
        Boolean answer = false;
        for (ProductModel removeP : this.cartList) {
            if (idProd == removeP.getId()) {
                this.cartList.remove(removeP);
                answer = true;
            }
        }
        return answer;
    }

    public ArrayList<ProductModel> getFullList() {
        return this.cartList;
    }

    public void cleanCart() {
        this.cartList.clear();
    }

    public Boolean isEmpty() {
        return this.cartList.isEmpty();
    }



}
