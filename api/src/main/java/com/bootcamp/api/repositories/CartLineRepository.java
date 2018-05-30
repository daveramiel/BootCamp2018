package com.bootcamp.api.repositories;

import com.bootcamp.api.models.Cart;
import com.bootcamp.api.models.CartLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartLineRepository extends JpaRepository<CartLine,Long> {

}
