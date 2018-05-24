package com.topic6.topic6.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductRepository {

    private static ProductRepository dbInstance;
    private Connection connection;


    public static ProductRepository getDbInstance(){
        return ProductRepository.dbInstance == null ? new ProductRepository() : ProductRepository.dbInstance;
    }

    private ProductRepository() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ShoppingApi","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
