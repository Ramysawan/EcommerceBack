package com.Monty.Ecommerce.Brand.Repository;

import com.Monty.Ecommerce.Address.Entity.Address;
import com.Monty.Ecommerce.Brand.Entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;

public interface BrandRepository extends JpaRepository<Brand, Serializable> {
    
    @Query("select b from Brand b where b.brandId = ?1")
    Brand findById(UUID id);
    
    @Query("select b from Brand b where b.title like %?1%")
    List<Brand> findByBrandName(String brandName);
    
}
