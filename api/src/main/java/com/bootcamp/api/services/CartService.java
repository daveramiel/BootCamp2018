package com.bootcamp.api.services;


import com.bootcamp.api.models.Cart;
import com.bootcamp.api.models.CartLine;
import com.bootcamp.api.models.Product;
import com.bootcamp.api.repositories.CartRepository;
import com.bootcamp.api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    public Cart getFullCart(Long userId){
        return this.cartRepository.findByUserId(userId);
    }

    public Cart addProductById(Long idProd, Long userId,int amount){
        Cart shoppingCart = this.getFullCart(userId);
        Optional<Product> p = this.productRepository.findById(idProd);
        shoppingCart.addNewLine(p.get(),amount);
        this.cartRepository.save(shoppingCart);
        return shoppingCart;
    }

    public Cart updateById(Long idProd, Long userId,int amount){
        Cart letsUpdate = this.getFullCart(userId);
        if(letsUpdate.isProduct(idProd)){
            for (CartLine cL:letsUpdate.getLines()) {
                if(cL.getProduct().getId() == idProd){
                    letsUpdate.getLines().remove(cL);
                    this.addProductById(idProd,userId,amount);
                }
            }
        }
        return this.getFullCart(userId);
    }


    public boolean deleteById(Long idProd, Long userId) {
        boolean answer = false;
        Cart toDelete = this.getFullCart(userId);
        if (toDelete.isProduct(idProd)){
            for (CartLine cL:toDelete.getLines()) {
                if(cL.getProduct().getId() == idProd){
                    toDelete.getLines().remove(cL);
                    answer = true;
                }
            }
        }
        this.cartRepository.save(toDelete);
        return answer;
    }

    public Cart emptyCart(Long userId){
        Cart emptyIt = this.getFullCart(userId);
        emptyIt.getLines().clear();
        this.cartRepository.save(emptyIt);
        return emptyIt;
    }

}
