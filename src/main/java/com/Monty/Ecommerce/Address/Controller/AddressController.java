/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Monty.Ecommerce.Address.Controller;

import com.Monty.Ecommerce.Address.Entity.Address;
import com.Monty.Ecommerce.Address.Service.AddressService;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.Monty.Ecommerce.Customer.Entity.Customer;
import com.Monty.Ecommerce.Customer.Service.CustomerService;
import com.Monty.Ecommerce.Vendor.Entity.Vendor;
import com.Monty.Ecommerce.VendorAddress.Entity.VendorAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Ali
 */
@RestController
@RequestMapping("/api/v1/")
public class AddressController {
    
    @Autowired 
    AddressService addressService;
    
    //get all address
    @GetMapping("/address")
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }
    
    //get one address by id
    @GetMapping("/address/{id}")
    public ResponseEntity<Address> getAddressId(@PathVariable UUID id){
        return addressService.getAddressId(id);
    }
    
    //create one address
    @PostMapping("/address")
    public Address createAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }
    
    //update one address
    @PutMapping("/address/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable UUID id, @RequestBody Address addressDetails){
        return addressService.updateAddress(id, addressDetails);
    }
    
    //delete one address
    @DeleteMapping("/address/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAddress(@PathVariable UUID id){
        return addressService.deleteAddress(id);
    }
    
    //delete all address
    @DeleteMapping("/address")
    public ResponseEntity<Map<String, Boolean>> deleteAllAddress(){
        return addressService.deleteAllAddress();
    }
    
    //get address by nameAddress
    @GetMapping("/address/add/{name}")
    public List<Address> getAddressByAddressName(@PathVariable String name){
        return addressService.getAddressByAddressName(name);
    }
    
    //get address by country
    @GetMapping("/address/country/{country}")
    public List<Address> getAddressByCountry(@PathVariable String country){
        return addressService.getAddressByCountry(country);
    }
    
    //get address by city
    @GetMapping("/address/city/{city}")
    public List<Address> getAddressByCity(@PathVariable String city){
        return addressService.getAddressByCity(city);
    }
    
    //get address by state
    @GetMapping("/address/state/{state}")
    public List<Address> getAddressByState(@PathVariable String state){
        return addressService.getAddressByState(state);
    }

    
}
