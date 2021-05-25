/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Monty.Ecommerce.Address.Service.ServiceImpl;

import com.Monty.Ecommerce.Address.Entity.Address;
import com.Monty.Ecommerce.Address.Repository.AddressRepository;
import com.Monty.Ecommerce.Address.Service.AddressService;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Admin
 */
@Service
public class AddressServiceImpl implements AddressService {
    
    @Autowired
    private AddressRepository addressRepository;
    
    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address createAddress(@RequestBody Address address){
        Calendar dateCreated = Calendar.getInstance();
        address.setDateCreated(dateCreated);
        return addressRepository.save(address);
    }

    @Override
    public ResponseEntity<Address> getAddressId(@PathVariable UUID id) {
        Address address = addressRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));
        return ResponseEntity.ok(address);
    }

    @Override
    public ResponseEntity<Address> updateAddress(@PathVariable UUID id, @RequestBody Address address) {
        Address add = addressRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));
        
        add.setAddress1(address.getAddress1());
        add.setAddress2(address.getAddress2());
        add.setAddress3(address.getAddress3());
        add.setCountry(address.getCountry());
        add.setState(address.getState());
        add.setCity(address.getCity());
        add.setPostalCode(address.getPostalCode());
        add.setAdditionnalDescription(address.getAdditionnalDescription());
        add.setActive(address.isActive());
        add.setDateCreated(address.getDateCreated());
        Calendar dateUpdated = Calendar.getInstance();
        add.setDateUpdated(dateUpdated);
        add.setTitle(address.getTitle());
        //add.setCustomer(address.getCustomer());
        Address updateAddress = addressRepository.save(add);
        return ResponseEntity.ok(updateAddress);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteAddress(@PathVariable UUID id) {
        Address address = addressRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));
        
        addressRepository.delete(address);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
      
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteAllAddress() {
        addressRepository.deleteAll();
        
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
      
        return ResponseEntity.ok(response);
    }

    @Override
    public List<Address> getAddressByAddressName(String name) {
        return addressRepository.findByAddressName(name);
    }

    @Override
    public List<Address> getAddressByCountry(String country) {
        return addressRepository.findByCountry(country);
    }

    @Override
    public List<Address> getAddressByCity(String city) {
        return addressRepository.findByCity(city);
    }

    @Override
    public List<Address> getAddressByState(String state) {
        return addressRepository.findByState(state);
    }
   
}
