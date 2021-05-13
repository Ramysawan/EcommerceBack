package com.Monty.Ecommerce.Customer.Service;

import com.Monty.Ecommerce.Address.Entity.Address;
import com.Monty.Ecommerce.Customer.Entity.Customer;
import com.Monty.Ecommerce.VendorAddress.Entity.VendorAddress;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface CustomerService {

    List<Customer> getAllCustomer();

    Customer createCustomer(Customer customer);

    ResponseEntity<Customer> getCustomerId(UUID id);

    ResponseEntity<Customer> updateCustomer(UUID id, Customer customer);

    ResponseEntity<Map<String, Boolean>> deleteCustomer(UUID id);

    ResponseEntity<Map<String, Boolean>> deleteAllCustomer();

    List<Customer> getCustomerByFirstLastName(String name);
}
