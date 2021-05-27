package com.Monty.Ecommerce.ContactUs.Service.ServiceImpl;

import com.Monty.Ecommerce.ContactUs.Entity.Contact;
import com.Monty.Ecommerce.ContactUs.Repository.ContactRepository;
import com.Monty.Ecommerce.ContactUs.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> getContactByFirstName(String firstName) {
        return contactRepository.findByFirstName(firstName);
    }

    @Override
    public ResponseEntity<Contact> getContactId(UUID id) {
        Contact contact = contactRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));
        return ResponseEntity.ok(contact);
    }

    @Override
    public Contact createContact(Contact contact) {
        Calendar dateCreated = Calendar.getInstance();
        contact.setDateCreated(dateCreated);
        return contactRepository.save(contact);
    }

    @Override
    public ResponseEntity<Contact> updateContact(UUID id, Contact contact) {
        Contact con = contactRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        con.setFirstName(contact.getFirstName());
        con.setLastName(contact.getLastName());
        con.setEmail(contact.getEmail());
        con.setSubject(contact.getSubject());
        con.setMessage(contact.getMessage());
        con.setDateCreated(con.getDateCreated());
        Calendar dateUpdated = Calendar.getInstance();
        con.setDateUpdated(dateUpdated);

        Contact updateContact = contactRepository.save(con);
        return ResponseEntity.ok(updateContact);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteContact(UUID id) {
        Contact contact = contactRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        contactRepository.delete(contact);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteAllContact() {
        contactRepository.deleteAll();

        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public Contact findContact(UUID id) {
        Contact contact = contactRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));
        return contact;
    }
}