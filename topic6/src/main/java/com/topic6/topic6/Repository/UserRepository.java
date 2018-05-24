package com.topic6.topic6.Repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserRepository {

    private static UserRepository dbInstance;
    private Connection connection;


    public static UserRepository getDbInstance(){
        return UserRepository.dbInstance == null ? new UserRepository() : UserRepository.dbInstance;
    }

    private UserRepository() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ShoppingApi","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
