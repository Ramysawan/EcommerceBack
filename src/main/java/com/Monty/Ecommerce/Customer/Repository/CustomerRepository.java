package com.Monty.Ecommerce.Customer.Repository;

import com.Monty.Ecommerce.Customer.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface CustomerRepository extends JpaRepository<Customer, Serializable> {
}
