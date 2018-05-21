package com.topic3.Topic3.ModelTest;

import com.topic3.Topic3.Models.CartModel;
import com.topic3.Topic3.Models.ProductModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CartTest {

    private CartModel shoppingCart;

    @Before
    public void loadCart(){
        this.shoppingCart = new CartModel();
    }

    @Test
    public void newCartIsEmpty(){
        assertTrue(this.shoppingCart.isEmpty());
    }

    @Test
    public void cartWithProductsDeleteByProductID(){
        ProductModel example1 = mock(ProductModel.class);
        ProductModel example2 = mock(ProductModel.class);
        when(example1.getId()).thenReturn(404);

        this.shoppingCart.addItem(example1);
        this.shoppingCart.addItem(example2);

        assertTrue(this.shoppingCart.deleteItem(404));

    }

    @Test
    public void cartWithProductsCleanIt(){
        ProductModel example1 = mock(ProductModel.class);
        ProductModel example2 = mock(ProductModel.class);


        this.shoppingCart.addItem(example1);
        this.shoppingCart.addItem(example2);

        this.shoppingCart.cleanCart();

        assertTrue(this.shoppingCart.isEmpty());
    }

}
