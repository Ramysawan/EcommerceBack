package com.Monty.Ecommerce.Customer.Controller;

import com.Monty.Ecommerce.Customer.Entity.Customer;
import com.Monty.Ecommerce.Customer.Service.CustomerService;
import com.Monty.Ecommerce.User.Entity.User;
import com.Monty.Ecommerce.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    private UserService userService;

    //get all customer    ***************************************************************************************************
    @GetMapping("/customer")
    public List<Customer> getCustomerAddress(){
        return customerService.getAllCustomer();
    }

    //get one customer by id    *********************************************************************************************
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerId(@PathVariable UUID id){
        return customerService.getCustomerId(id);
    }

    //create one customer    ************************************************************************************************
    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    //update one customer    ************************************************************************************************
    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable UUID id, @RequestBody Customer customer){
        return customerService.updateCustomer(id, customer);
    }

    //delete one customer    ************************************************************************************************
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable UUID id){
        return customerService.deleteCustomer(id);
    }

    //delete all customer    ************************************************************************************************
    @DeleteMapping("/customer")
    public ResponseEntity<Map<String, Boolean>> deleteAllCustomer(){
        return customerService.deleteAllCustomer();
    }

    //get customer by firstname or lastname    ******************************************************************************
    @GetMapping("/customer/cust/{name}")
    public List<Customer> getCustomerByFisrtLastName(@PathVariable String name){
        return customerService.getCustomerByFirstLastName(name);
    }

    //add new customer with user account    *********************************************************************************
    @PostMapping("/user/{username}")
    public Customer createComment(@PathVariable (value = "username") String username, @RequestBody Customer customer) {
        Optional<User> user = userService.findByUsername(username);   
        customer.setUser(user.get());
        return customerService.createCustomer(customer);
    }


}

