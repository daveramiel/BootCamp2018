package com.bootcamp.api.ServiceTest;

import com.bootcamp.api.models.Cart;
import com.bootcamp.api.models.User;
import com.bootcamp.api.repositories.CartRepository;
import com.bootcamp.api.services.CartService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CartServiceTest {

    private CartService cartService;
    private CartRepository cartRepository;
    private User mockedUser;

    @Before
    public void setUp(){
        this.mockedUser = new User();
        this.cartRepository = mock(CartRepository.class);
        when(this.cartRepository.save(new Cart(mockedUser))).thenReturn(new Cart(mockedUser));
        this.cartService = new CartService(cartRepository);
    }

    /*@Test
    public void givenUserCreatesNewCart(){
        this.cartService.generateCart(this.mockedUser);
        assertEquals(new Cart(mockedUser));
    }*/
}
