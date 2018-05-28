package com.bootcamp.api.controllers;


import com.bootcamp.api.models.Product;
import com.bootcamp.api.services.ProductService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(method = RequestMethod.GET , produces = "application/json")
    public List<Product> getAllProducts(){
        return this.productService.getAll();
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET , produces =  "application/json")
    public Product getByName(@RequestParam String name){
        return this.productService.getByName(name);
    }

    @RequestMapping(value = "/categories/{category}",method = RequestMethod.GET , produces = "application/json")
    public List<Product> getByCategory(@PathVariable("category") String category){
        return this.productService.getByCategory(category);
    }
}

