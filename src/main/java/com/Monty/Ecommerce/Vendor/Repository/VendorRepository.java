package com.Monty.Ecommerce.Vendor.Repository;

import com.Monty.Ecommerce.Brand.Entity.Brand;
import com.Monty.Ecommerce.Vendor.Entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface VendorRepository extends JpaRepository<Vendor, Serializable> {

    @Query("select b from Vendor b where b.vendorId = ?1")
    Vendor findById(UUID id);

    @Query("select b from Vendor b where b.vendorName like %?1%")
    List<Vendor> findByVendorName(String vendorName);
}
