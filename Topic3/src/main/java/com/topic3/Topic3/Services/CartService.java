package com.topic3.Topic3.Services;

import com.topic3.Topic3.Models.CartModel;
import com.topic3.Topic3.Models.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CartService {

    @Autowired private CartModel cart;

    public CartService(){
        this.cart = new CartModel();
    }

    public void addNewProdcut(ProductModel newP){
        this.cart.addItem(newP);
    }

    public CartModel getFullCart(){
        return this.cart.isEmpty() ? null : this.cart;
    }

    public Boolean searchProduct(int productId){
        Boolean answer = false;
        for (ProductModel productSearch : this.cart.getFullList()){
            if(productId == productSearch.getId()){
                answer = true;
            }
        }
        return answer;
    }

    public Boolean deleteItem(int productId){
        Boolean answer = false;
        if (!this.cart.isEmpty() && this.searchProduct(productId)){
            answer = this.cart.deleteItem(productId);
        }
        return answer;
    }

    public CartModel clearCart(){
        if (!this.cart.isEmpty()){
            this.cart.cleanCart();
        }
        return this.cart;
    }



}
