package com.Monty.Ecommerce.User.Repository;

import com.Monty.Ecommerce.User.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {
    
    Optional<User> findByUsername(String username);

//    @Query("select a from User a where a.username = '?1'")
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    
}
