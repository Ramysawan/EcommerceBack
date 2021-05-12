package com.Monty.Ecommerce.VendorAddress.Repository;

import com.Monty.Ecommerce.Address.Entity.Address;
import com.Monty.Ecommerce.VendorAddress.Entity.VendorAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface VendorAddressRepository extends JpaRepository<VendorAddress, Serializable> {

    @Query("select a from VendorAddress a where a.vendoraddressId = ?1")
    VendorAddress findById(UUID id);

    @Query("select a from VendorAddress a where a.address1 like %?1% or a.address2 like %?1% or a.address3 like %?1%")
    List<VendorAddress> findByVendorAddressName(String addressName);

    @Query("select a from VendorAddress a where a.country like ?1")
    List<VendorAddress> findByCountry(String country);

    @Query("select a from VendorAddress a where a.city like ?1")
    List<VendorAddress> findByCity(String city);

    @Query("select a from VendorAddress a where a.state like ?1")
    List<VendorAddress> findByState(String state);

}
