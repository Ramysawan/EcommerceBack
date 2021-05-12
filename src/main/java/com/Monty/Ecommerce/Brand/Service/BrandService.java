package com.Monty.Ecommerce.Brand.Service;

import com.Monty.Ecommerce.Brand.Entity.Brand;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

public interface BrandService {
    
    List<Brand> getAllBrand();
    
    List<Brand> getBrandByName(String brandName);
    
    ResponseEntity<Brand> getBrandId(UUID id);
    
    Brand createBrand(Brand brand);
    
    ResponseEntity<Brand> updateBrand(UUID id, Brand brand);
    
    ResponseEntity<Map<String, Boolean>> deleteBrand(UUID id);
    
    ResponseEntity<Map<String, Boolean>> deleteAllBrand();

    Brand findBrand(UUID id);
}
