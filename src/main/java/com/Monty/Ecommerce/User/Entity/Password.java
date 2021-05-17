/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Monty.Ecommerce.User.Entity;

import lombok.Data;

/**
 *
 * @author Admin
 */
@Data
public class Password {
    
    private String pass;

    public Password(String pass) {
        this.pass = pass;
    }
}
