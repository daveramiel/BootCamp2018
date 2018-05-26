package com.bootcamp.api.repositories;


import com.bootcamp.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User,Long> {
    User findByEmail (@Param("email")String email);

    User findByToken(String token);
}
