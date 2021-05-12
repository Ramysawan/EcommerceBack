package com.Monty.Ecommerce.User.Service;

import com.Monty.Ecommerce.User.Entity.User;
import java.util.Optional;

public interface UserService {
    
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    
    User saveUser(User user);
    
}
