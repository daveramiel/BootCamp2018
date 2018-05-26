package com.bootcamp.api.services;


import com.bootcamp.api.models.User;
import com.bootcamp.api.repositories.UserRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public Boolean newUser(String mail, String password){
        User newUser = new User();
        Boolean answer = false;
        if(this.userRepository.findByEmail(mail) == null){
            newUser.setEmail(mail);
            newUser.setPassword(password);
            this.userRepository.save(newUser);
            answer = true;
        }
        return answer;
    }

    public User getByEmail(String email){
        return this.userRepository.findByEmail(email);
    }

    public String login(String mail, String password){
        String token = null;
        User loginUs = this.userRepository.findByEmail(mail);
        if (loginUs != null && loginUs.getPassword().equals(password)){
            token = Base64.encodeBase64String((loginUs.getEmail() + loginUs.getPassword()).getBytes());
            loginUs.setToken(token);
            this.userRepository.save(loginUs);
        }
        return token;
    }


    public User getByToken(String token) {
        return this.userRepository.findByToken(token);
    }
}
