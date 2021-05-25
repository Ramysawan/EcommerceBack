package com.Monty.Ecommerce.Customer.ServiceImpl;

import com.Monty.Ecommerce.Customer.Entity.Customer;
import com.Monty.Ecommerce.Customer.Repository.CustomerRepository;
import com.Monty.Ecommerce.Customer.Service.CustomerService;
import com.Monty.Ecommerce.Vendor.Entity.Vendor;
import com.Monty.Ecommerce.VendorAddress.Entity.VendorAddress;
import com.Monty.Ecommerce.VendorAddress.Repository.VendorAddressRepository;
import com.Monty.Ecommerce.VendorAddress.Service.VendorAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(@RequestBody Customer customer){
        Calendar dateCreated = Calendar.getInstance();
        customer.setDateCreated(dateCreated);
        return customerRepository.save(customer);
    }

    @Override
    public ResponseEntity<Customer> getCustomerId(@PathVariable UUID id) {
        Customer customer = customerRepository.findById(id);
        return ResponseEntity.ok(customer);
    }

    @Override
    public ResponseEntity<Customer> updateCustomer(@PathVariable UUID id, @RequestBody Customer customer) {
        Customer cust = customerRepository.findById(id);

        cust.setFirstName(customer.getFirstName());
        cust.setLastName(customer.getLastName());
        cust.setPhoneNumber(customer.getPhoneNumber());
        cust.setAgreeToMails(customer.isAgreeToMails());
        cust.setActive(customer.isActive());
        cust.setDateCreated(customer.getDateCreated());
        Calendar dateUpdated = Calendar.getInstance();
        cust.setDateUpdated(dateUpdated);
        cust.setUser(customer.getUser());
        Customer updateCustomer = customerRepository.save(cust);
        return ResponseEntity.ok(updateCustomer);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable UUID id) {
        Customer customer = customerRepository.findById(id);

        customerRepository.delete(customer);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteAllCustomer() {
        customerRepository.deleteAll();

        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public List<Customer> getCustomerByFirstLastName(String name) {
        return customerRepository.findByFirstLastName(name);
    }
    
    @Override
    public Customer findCustomer(UUID id) {
        Customer customer = customerRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));
        return customer;
    }

}
