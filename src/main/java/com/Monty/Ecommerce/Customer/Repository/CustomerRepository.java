package com.Monty.Ecommerce.Customer.Repository;

import com.Monty.Ecommerce.Customer.Entity.Customer;
import com.Monty.Ecommerce.VendorAddress.Entity.VendorAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, Serializable> {

    @Query("select a from Customer a where a.customerId = ?1")
    Customer findById(UUID id);

    @Query("select a from Customer a where a.firstName like %?1% or a.lastName like %?1%")
    List<Customer> findByFirstLastName(String name);

}
