package com.Monty.Ecommerce.ContactUs.Service.ServiceImpl;

import com.Monty.Ecommerce.Brand.Entity.Brand;
import com.Monty.Ecommerce.Brand.Service.BrandService;
import com.Monty.Ecommerce.ContactUs.Entity.Contact;
import com.Monty.Ecommerce.ContactUs.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ContactServiceImpl {

    @Autowired
    ContactService contactService;

    //get all contacted us    *************************************************************************************
    @GetMapping("/contact")
    public List<Contact> getAllContact(){
        return contactService.getAllContact();
    }

    //get one contact by id    ********************************************************************************
    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getContactId(@PathVariable UUID id){
        return contactService.getContactId(id);
    }

    //get Contact by name    **********************************************************************************
    @GetMapping("/contact/cn/{firstName}")
    public List<Contact> getContactByFirstName(@PathVariable String firstName){

        return contactService.getContactByFirstName(firstName);
    }

    //create one Contact   ***********************************************************************************
    @PostMapping("/contact")
    public Contact createContact(@RequestBody Contact contact){
        return contactService.createContact(contact);
    }

    //update one Contact   ***********************************************************************************
    @PutMapping("/contact/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable UUID id, @RequestBody Contact contactDetails){
        return contactService.updateContact(id, contactDetails);
    }

    //delete one Contact    ***********************************************************************************
    @DeleteMapping("/contact/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteContact(@PathVariable UUID id){
        return contactService.deleteContact(id);
    }

    //delete all Contact    ***********************************************************************************
    @DeleteMapping("/contact")
    public ResponseEntity<Map<String, Boolean>> deleteAllBrand(){
        return contactService.deleteAllContact();
    }

}