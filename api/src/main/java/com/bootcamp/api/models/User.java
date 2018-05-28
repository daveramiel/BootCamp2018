package com.bootcamp.api.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name =  "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "password")
    private String password;
    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "token")
    private String token;

    /*public User(String email, String password){
        this.email = email;
        this.password = password;
    }*/
}
