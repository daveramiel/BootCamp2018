package com.bootcamp.api.services;


import com.bootcamp.api.models.Cart;
import com.bootcamp.api.models.CartLine;
import com.bootcamp.api.models.Product;
import com.bootcamp.api.models.User;
import com.bootcamp.api.repositories.CartLineRepository;
import com.bootcamp.api.repositories.CartRepository;
import com.bootcamp.api.repositories.ProductRepository;
import com.bootcamp.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartLineRepository cartLineRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    public Cart generateCart(User user) {
        return this.cartRepository.save(new Cart(user));
    }

    public Cart getFullCart(Long userId) {
        Cart shoppingCart = this.cartRepository.findByUserId(userId);
        if (shoppingCart == null) {
            Optional<User> user = this.userRepository.findById(userId);
            this.generateCart(user.get());
        }
        return shoppingCart;
    }

    public Cart addProductById(Long idProd, Long userId, int amount) {
        Cart shoppingCart = this.getFullCart(userId);
        Optional<Product> p = this.productRepository.findById(idProd);
        shoppingCart.addNewLine(p.get(), amount);
        this.cartRepository.save(shoppingCart);
        return shoppingCart;
    }

    public Cart updateById(Long idProd, Long userId, int amount) {
        Cart letsUpdate = this.getFullCart(userId);
        if (letsUpdate.isProduct(idProd)) {
            for (CartLine cL : letsUpdate.getLines()) {
                if (cL.getProduct().getId() == idProd) {
                    letsUpdate.getLines().remove(cL);
                    this.addProductById(idProd, userId, amount);
                }
            }
        }
        return this.getFullCart(userId);
    }


    @javax.transaction.Transactional
    public boolean deleteById(Long idProd, Long userId) {
        boolean answer = false;
        Cart toDelete = this.getFullCart(userId);
        if (toDelete.isProduct(idProd)) {
            List<CartLine> listCartLine = toDelete.getLines();
            int i = 0;

            while(!listCartLine.get(i).getProduct().getId().equals(idProd)){
                i++;
            }
            Long id = listCartLine.get(i).getId();
            this.cartLineRepository.deleteById(id);
            /*
            listCartLine.remove(i);
            toDelete.setLines(listCartLine);

            this.cartRepository.save(toDelete);
            */
            answer = true;
        }

        return answer;
    }

    public Cart emptyCart(Long userId) {
        Cart emptyIt = this.getFullCart(userId);
        emptyIt.getLines().clear();
        this.cartRepository.save(emptyIt);
        return emptyIt;
    }

}
