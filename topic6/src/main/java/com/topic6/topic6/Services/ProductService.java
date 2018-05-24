package com.topic6.topic6.Services;


import com.topic6.topic6.Models.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired private ProductModel product;

    public void newProduct(String name, int price){
        this.product.setName(name);
        this.product.setPrice(price);
    }

}
