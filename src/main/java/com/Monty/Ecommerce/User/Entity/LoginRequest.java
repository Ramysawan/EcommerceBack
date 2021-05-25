/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Monty.Ecommerce.User.Entity;

import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 *
 * @author Admin
 */
@Data
public class LoginRequest {
	
    @NotBlank	
    private String username;
	
    @NotBlank	
    private String password;
	
    public LoginRequest(){
    }
    
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    } 
}
