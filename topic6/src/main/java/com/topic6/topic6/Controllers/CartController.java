package com.topic6.topic6.Controllers;

import com.topic6.topic6.Models.CartModel;
import com.topic6.topic6.Models.ProductModel;
import com.topic6.topic6.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CartController {

    @Autowired
    private CartService cartService;

    public CartController(){
        this.cartService =  new CartService();
    }

    @RequestMapping(value = "/products" , method = RequestMethod.GET , produces = "application/json")
    public CartModel allproducts(){
        return this.cartService.getFullCart();
    }

    @RequestMapping(value = "/products/{amout}" , method = RequestMethod.POST , produces = "application/json")
    public CartModel addProduct(@PathVariable("amount") int amount, ProductModel productAdd){
        this.cartService.addNewProduct(productAdd,amount);
        return this.cartService.getFullCart();
    }


    @RequestMapping(value = "/products/{id}" , method = RequestMethod.DELETE , produces = "application/json")
    public CartModel deleteProduct(@PathVariable("id") int idProduct){
        this.cartService.deleteItem(idProduct);
        return this.cartService.getFullCart();
    }

    @RequestMapping(value = "/products" , method = RequestMethod.DELETE , produces = "application/json")
    public void emptyCart(){
        this.cartService.clearCart();
    }
}
