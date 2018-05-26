package com.bootcamp.api.services;


import com.bootcamp.api.models.Product;
import com.bootcamp.api.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public List<Product> getAll(){
        return this.productRepository.findAll();
    }

    public Product getByName(String name){
        return this.productRepository.findByName(name);
    }

    public List<Product> getByCategory(String category){
        return this.productRepository.findByCategory(category);
    }

}
