package com.topic3.Topic3.Controllers;

import com.topic3.Topic3.Models.CartModel;
import com.topic3.Topic3.Models.ProductModel;
import com.topic3.Topic3.Services.CartService;
import org.springframework.beans.factory.annotation.*;
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

    @RequestMapping(value = "/products" , method = RequestMethod.POST , produces = "application/json")
    public CartModel addProduct(ProductModel productAdd){
        this.cartService.addNewProdcut(productAdd);
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

