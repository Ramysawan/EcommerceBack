/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Monty.Ecommerce.User.ServiceImpl;

import com.Monty.Ecommerce.Shipment.Entity.Shipment;
import com.Monty.Ecommerce.User.Entity.Password;
import com.Monty.Ecommerce.User.Entity.User;
import com.Monty.Ecommerce.User.Repository.UserRepository;
import com.Monty.Ecommerce.User.Service.UserService;
import java.util.Calendar;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    PasswordEncoder encoder;
    
    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        user.setLoginPassword(encoder.encode(user.getLoginPassword()));
        user.setRole("ROLE_USER");
        Calendar dateCreated = Calendar.getInstance();
        user.setDateCreated(dateCreated);
        
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<User> updatePass(String username, Password pass) {
        Optional<User> u = userRepository.findByUsername(username);
        
        User updatedUser = u.get();
        updatedUser.setLoginPassword(encoder.encode(pass.getPass()));
        Calendar dateUpdated = Calendar.getInstance();
        updatedUser.setDateUpdated(dateUpdated);
        User user = userRepository.save(updatedUser);
        return ResponseEntity.ok(user);
        
    }
    
}
