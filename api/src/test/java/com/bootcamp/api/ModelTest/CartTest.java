package com.bootcamp.api.ModelTest;


import com.bootcamp.api.models.Cart;
import com.bootcamp.api.models.CartLine;
import com.bootcamp.api.models.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CartTest {

    private Cart cartShopping;

    @Before
    public void setUp(){
        this.cartShopping = new Cart();
        this.cartShopping.setLines(new ArrayList<>());
    }

    @Test
    public void whenAddProductCreatesNewLine(){
        Product p = mock(Product.class);
        when(p.getId()).thenReturn(1L);
        this.cartShopping.addNewLine(p,1);
        assertEquals(1,this.cartShopping.getLines().size());
    }

    @Test
    public void whenAskForProductByIdThatExistsReturnsTrue(){
        Product p = mock(Product.class);
        when(p.getId()).thenReturn(1L);
        this.cartShopping.addNewLine(p,1);
        assertTrue(this.cartShopping.isProduct(1L));
    }

    @Test
    public void whenAddsAProductThatExistsIncreasesAmount(){
        Product p = mock(Product.class);
        when(p.getId()).thenReturn(1L);
        this.cartShopping.addNewLine(p,1);
        this.cartShopping.addNewLine(p,14);
        int i = 0;
        for (CartLine cL :this.cartShopping.getLines()) {
            if (cL.getProduct().getId()==p.getId()){
                i = cL.getQuantity();
            }
        }
        assertEquals(15,i);
    }

    @Test
    public void givenIdProductDelLine(){
        Product p = mock(Product.class);
        when(p.getId()).thenReturn(1L);
        when(p.getName()).thenReturn("Hi i'm face");
        this.cartShopping.addNewLine(p,1);
        this.cartShopping.deleteCartLineByProd(p.getId());
        assertEquals(0,this.cartShopping.getLines().size());
    }

}
