package com.bootcamp.api.services;


import com.bootcamp.api.models.User;
import com.bootcamp.api.repositories.UserRepository;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepo){
        this.userRepository = userRepo;
    }

    public void newUser(String mail, String password) {
        User newUser = new User();
        if (!this.userRepository.existsByEmail(mail)) {
            newUser.setEmail(mail);
            newUser.setPassword(password);
            this.userRepository.save(newUser);
        }
    }

    public User getByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public String login(String mail, String password) {
        String token = null;
        User loginUs = this.userRepository.findByEmail(mail);
        if (loginUs != null && loginUs.getPassword().equals(password)) {
            token = Base64.encodeBase64String((loginUs.getEmail() + loginUs.getPassword()).getBytes());
            loginUs.setToken(token);
            this.userRepository.save(loginUs);
        }
        return token;
    }


    public User getByToken(String token) {
        return this.userRepository.findByToken(token);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }
}
