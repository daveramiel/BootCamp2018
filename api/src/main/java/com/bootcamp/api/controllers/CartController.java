package com.bootcamp.api.controllers;


import com.bootcamp.api.models.Cart;
import com.bootcamp.api.models.CartLine;
import com.bootcamp.api.models.Product;
import com.bootcamp.api.models.User;
import com.bootcamp.api.services.CartService;
import com.bootcamp.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET , produces = "application/json")
    public Cart getFullCart(@RequestParam String token){
        User user = this.userService.getByToken(token);
        return this.cartService.getFullCart(user.getId());
    }

    @RequestMapping(value = "/{idproduct}" , method = RequestMethod.POST , produces = "application/json")
    public Cart addProductById(@RequestParam String token,@PathVariable("idproduct") Long idProd,@RequestParam int amount){
        User user = this.userService.getByToken(token);
        return this.cartService.addProductById(idProd,user.getId(),amount);
    }

    @RequestMapping(value = "/{idproduct}", method = RequestMethod.PUT , produces = "application/json")
    public Cart updateById(@RequestParam String token, @RequestParam int amount, @PathVariable("idproduct") Long idProd){
        User user = this.userService.getByToken(token);
        return this.cartService.updateById(idProd,user.getId(),amount);
    }

    @RequestMapping(value = "/{idproduct}" ,  method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<?> deleteById(@RequestParam String token,@PathVariable("idproduct") Long idProd){
        User user = this.userService.getByToken(token);
        return this.cartService.deleteById(idProd,user.getId()) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
    public Cart deleteCart(@RequestParam String token){
        User user = this.userService.getByToken(token);
        return this.cartService.emptyCart(user.getId());
    }
}
