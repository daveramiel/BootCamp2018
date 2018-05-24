package com.topic6.topic6.Models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {


    private String mailLogin;
    private String name;
    private String password;
    private int idUser;

    public UserModel(String mail, String name, String pass){
        this.mailLogin = mail;
        this.name = name;
        this.password = pass;
    }

}
