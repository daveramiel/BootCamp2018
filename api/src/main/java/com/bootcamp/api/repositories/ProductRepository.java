package com.bootcamp.api.repositories;


import com.bootcamp.api.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository <Product,Long> {
   List<Product> findByCategory (@Param("category")String category);
   Product findByName (@Param("name")String name);
}
