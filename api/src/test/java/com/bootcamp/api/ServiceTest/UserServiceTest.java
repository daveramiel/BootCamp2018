package com.bootcamp.api.ServiceTest;

import com.bootcamp.api.models.User;
import com.bootcamp.api.repositories.UserRepository;
import com.bootcamp.api.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

///@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {


    private UserService userService;
    private UserRepository  mockedUserRepository;

    private User userTest1;

    @Before public void setUp(){
        this.userTest1 = new User();
        this.userTest1 = mock(User.class);
        when(userTest1.getEmail()).thenReturn("honda");
        when(userTest1.getPassword()).thenReturn("1234");
        when(userTest1.getToken()).thenReturn("aG9uZGExMjM0");
        this.mockedUserRepository = mock(UserRepository.class);
        when(this.mockedUserRepository.existsByEmail("honda")).thenReturn(false);
        when(this.mockedUserRepository.findByEmail("honda")).thenReturn(userTest1);
        when(this.mockedUserRepository.findAll()).thenReturn(new ArrayList<>());
        when(this.mockedUserRepository.findByToken("aG9uZGExMjM0")).thenReturn(userTest1);
        this.userService = new UserService(mockedUserRepository);
    }

    @Test
    public void registerNewUserGoesToRepository(){
        this.userService.newUser("honda","bless");
        assertEquals("honda",this.userService.getByEmail("honda").getEmail());
    }

    @Test
    public void whenYouLookForMailReturnsUser(){
        User uMocked =this.userService.getByEmail("honda");
        assertEquals(userTest1.getEmail(),uMocked.getEmail());
    }

    @Test
    public void whenAskingForListUsersReturnsList(){
        assertNotNull(this.userService.getAllUsers());
    }

    @Test
    public void whenGetByTokenReturnsUser(){
        String token = this.userService.login("honda","1234");
        User spike = this.userService.getByToken(token);
        assertEquals(spike.getToken(),token);
    }

    @Test
    public void whenUserLoginsReturnsAToken(){
        String token = this.userService.login("honda","1234");
        System.out.println(token);
        assertEquals("aG9uZGExMjM0",token);
    }

}
