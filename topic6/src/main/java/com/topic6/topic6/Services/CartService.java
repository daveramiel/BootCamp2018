package com.topic6.topic6.Services;

import com.topic6.topic6.Models.CartModel;
import com.topic6.topic6.Models.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartModel cart;

    public CartService(){
        this.cart = new CartModel();
    }

    public void addNewProduct(ProductModel newP, int amount){
        newP.setAmount(amount);
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
