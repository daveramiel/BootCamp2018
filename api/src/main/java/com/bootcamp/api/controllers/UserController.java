package com.bootcamp.api.controllers;


import com.bootcamp.api.models.User;
import com.bootcamp.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> registerUser(@RequestParam String email, @RequestParam String password) {
        this.userService.newUser(email, password);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password) {
        String token;
        token = this.userService.login(email, password);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET, produces = "application/json")
    public List<User> getAll(){
        return this.userService.getAllUsers();
    }


}
