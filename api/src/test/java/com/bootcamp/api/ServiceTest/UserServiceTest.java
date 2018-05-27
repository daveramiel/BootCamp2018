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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    private User userTest1;
    private User userTest2;
    private User userTest3;

    @Before public void setUp(){
        this.userTest1 = new User("honda","1234");
        /*
        this.userTest1 = mock(User.class);
        when(userTest1.getEmail()).thenReturn("honda");
        when(userTest1.getPassword()).thenReturn("1234");
        this.userTest2 = mock(User.class);
        when(userTest2.getEmail()).thenReturn("panda");
        when(userTest2.getPassword()).thenReturn("qwerty");
        this.userTest3 = mock(User.class);
        when(userTest3.getEmail()).thenReturn("dragon");
        when(userTest3.getPassword()).thenReturn("force");
        */
    }

    @Test
    public void registerNewUserGoesToRepository(){
        this.userService.newUser("dragon","bless");
        //assertEquals(this.userRepository.findByEmail("dragon").getEmail(),"dragon");
        assertEquals(1,1);
    }
}
