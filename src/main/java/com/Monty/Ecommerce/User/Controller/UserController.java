/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Monty.Ecommerce.User.Controller;

import com.Monty.Ecommerce.ResourceNotFoundException.ResourceNotFoundException;
import com.Monty.Ecommerce.User.Entity.LoginRequest;
import com.Monty.Ecommerce.User.Entity.Password;
import com.Monty.Ecommerce.User.Entity.User;
import com.Monty.Ecommerce.User.Service.UserService;
import com.Monty.Ecommerce.security.jwt.JwtUtils;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Admin
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class UserController {
    
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;
    
    @Autowired
    JwtUtils jwtUtils;
    
    //create a new user account    *********************************************************************************************
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
        if (userService.existsByUsername(user.getUsername())) {
            throw new ResourceNotFoundException("Username is already taken");
        }
        else if (userService.existsByEmail(user.getEmail())) {
            throw new ResourceNotFoundException("Email is already taken");
        }
        else{
           userService.saveUser(user);
        }
        return ResponseEntity.ok("User Created");
    }

    
    //authenticate user account    **********************************************************************************************
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
	/*Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        
        String jwt = jwtUtils.generateJwtToken(authentication);       
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Authorization",  "Bearer " + jwt);
        
	SecurityContextHolder.getContext().setAuthentication(authentication);
	
        
	UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
	List<String> roles = userDetails.getAuthorities().stream()
			.map(item -> item.getAuthority())
			.collect(Collectors.toList());
        System.out.println("1 " + new Date() + " ");*/
        
	return ResponseEntity.ok("Token: " + "\nUser id: ");
    }
    
    //change password
    @PutMapping("/forgotpassword/{username}")
    public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody Password pass){
        return userService.updatePass(username, pass);
    }
    
    
    
}
