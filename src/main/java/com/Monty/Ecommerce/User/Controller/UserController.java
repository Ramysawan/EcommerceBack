/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Monty.Ecommerce.User.Controller;

import com.Monty.Ecommerce.User.Entity.LoginRequest;
import com.Monty.Ecommerce.User.Entity.Role;
import com.Monty.Ecommerce.User.Entity.User;
import com.Monty.Ecommerce.User.Repository.UserRepository;
import com.Monty.Ecommerce.User.Service.UserService;
import com.Monty.Ecommerce.security.jwt.JwtUtils;
import com.Monty.Ecommerce.security.services.UserDetailsImpl;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {
    
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;
    
    @Autowired
    JwtUtils jwtUtils;
    
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
	if (userService.existsByUsername(user.getUsername())) {
            return ResponseEntity.ok("Error: Username is already taken!");
	}
        else if (userService.existsByEmail(user.getEmail())) {
            return ResponseEntity.ok("Error: Email is already in use!");
	}
        else{
            userService.saveUser(user);
        }
	return ResponseEntity.ok("User registered successfully!");
    }
    
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
	Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

	SecurityContextHolder.getContext().setAuthentication(authentication);
	String jwt = jwtUtils.generateJwtToken(authentication);
		
	UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
	List<String> roles = userDetails.getAuthorities().stream()
			.map(item -> item.getAuthority())
			.collect(Collectors.toList());

	return ResponseEntity.ok("Token: " + jwt +
                "\nUser id: " + userDetails.getId() +
                "\nUsername: "+ userDetails.getUsername() +
                "\nEmail: "+ userDetails.getEmail() +
                "\nRole: "+ roles);
    }
    
    
    
}
