package com.Monty.Ecommerce.Address.Repository;

import com.Monty.Ecommerce.Address.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Serializable> {
    
    @Query("select a from Address a where a.addressId = ?1")
    Address findById(UUID id);
    
    @Query("select a from Address a where a.address1 like %?1% or a.address2 like %?1% or a.address3 like %?1%")
    List<Address> findByAddressName(String addressName);
    
    @Query("select a from Address a where a.country like ?1")
    List<Address> findByCountry(String country);
    
    @Query("select a from Address a where a.city like ?1")
    List<Address> findByCity(String city);
    
    @Query("select a from Address a where a.state like ?1")
    List<Address> findByState(String state);
    
}
