/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Monty.Ecommerce.Brand.Service.ServiceImpl;

import com.Monty.Ecommerce.Brand.Entity.Brand;
import com.Monty.Ecommerce.Brand.Repository.BrandRepository;
import com.Monty.Ecommerce.Brand.Service.BrandService;
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
public class BrandServiceImpl implements BrandService{

    @Autowired
    private BrandRepository brandRepository;
    
    @Override
    public List<Brand> getAllBrand() {
        return brandRepository.findAll();
    }

    @Override
    public List<Brand> getBrandByName(String brandName) {

        return brandRepository.findByBrandName(brandName);
    }

    @Override
    public Brand createBrand(Brand brand) {
        Calendar dateCreated = Calendar.getInstance();
        brand.setDateCreated(dateCreated);
        return brandRepository.save(brand);
    }

    @Override
    public ResponseEntity<Brand> updateBrand(@PathVariable UUID id, @RequestBody Brand brand) {
        Brand bra = brandRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));
        
        bra.setTitle(brand.getTitle());
        bra.setPhotoURL(brand.getPhotoURL());
        bra.setActive(brand.isActive());
        bra.setDateCreated(brand.getDateCreated());
        Calendar dateUpdated = Calendar.getInstance();
        bra.setDateUpdated(dateUpdated);
        
        Brand updateBrand = brandRepository.save(bra);
        return ResponseEntity.ok(updateBrand);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteBrand(@PathVariable UUID id) {
        Brand brand = brandRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));
        
        brandRepository.delete(brand);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
      
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteAllBrand() {
        brandRepository.deleteAll();
        
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
      
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Brand> getBrandId(UUID id) {
        Brand brand = brandRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));
        return ResponseEntity.ok(brand);
    }

    @Override
    public Brand findBrand(UUID id) {
        Brand brand = brandRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));
        return brand;
    }
    
}
