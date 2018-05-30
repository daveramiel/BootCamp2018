package com.bootcamp.api.services;


import com.bootcamp.api.models.Product;
import com.bootcamp.api.repositories.ProductRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository prodRepo){
        this.productRepository = prodRepo;
    }

    public List<Product> getAll(){
        return this.productRepository.findAll();
    }

    public Product getByName(String name){
        return this.productRepository.findByName(name);
    }

    public List<Product> getByCategory(String category)
    {
        return this.productRepository.findByCategory(category);
    }

}
