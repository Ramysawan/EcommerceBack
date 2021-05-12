/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Monty.Ecommerce.Brand.Controller;

import com.Monty.Ecommerce.Brand.Entity.Brand;
import com.Monty.Ecommerce.Brand.Service.BrandService;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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
 * @author Admin
 */
@RestController
@RequestMapping("/api/v1/")
public class BrandController {
    
    @Autowired 
    BrandService brandService;
    
    //get all brands
    @GetMapping("/brand")
    public List<Brand> getAllBrand(){
        return brandService.getAllBrand();
    }
    
    //get one brand by id
    @GetMapping("/brand/{id}")
    public ResponseEntity<Brand> getBrandId(@PathVariable UUID id){
        return brandService.getBrandId(id);
    }
    
    //get brand by name
    @GetMapping("/brand/br/{brandName}")
    public List<Brand> getBrandByName(@PathVariable String brandName){

        return brandService.getBrandByName(brandName);
    }
    
    //create one brand
    @PostMapping("/brand")
    public Brand createBrand(@RequestBody Brand brand){
        return brandService.createBrand(brand);
    }
    
    //update one brand
    @PutMapping("/brand/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable UUID id, @RequestBody Brand brandDetails){
        return brandService.updateBrand(id, brandDetails);
    }
    
    //delete one brand
    @DeleteMapping("/brand/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBrand(@PathVariable UUID id){
        return brandService.deleteBrand(id);
    }
    
    //delete all brand
    @DeleteMapping("/brand")
    public ResponseEntity<Map<String, Boolean>> deleteAllBrand(){
        return brandService.deleteAllBrand();
    }
    
}
