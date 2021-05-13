package com.Monty.Ecommerce.User.Service;

import com.Monty.Ecommerce.User.Entity.Password;
import com.Monty.Ecommerce.User.Entity.User;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

public interface UserService {
    
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    
    User saveUser(User user);
    
    ResponseEntity<User> updatePass(String username, Password pass);
    
}
