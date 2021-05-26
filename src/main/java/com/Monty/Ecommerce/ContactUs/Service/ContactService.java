package com.Monty.Ecommerce.ContactUs.Service;

import com.Monty.Ecommerce.ContactUs.Entity.Contact;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ContactService {

    List<Contact> getAllContact();

    List<Contact> getContactByFirstName(String firstName);

    ResponseEntity<Contact> getContactId(UUID id);

    Contact createContact(Contact contact);

    ResponseEntity<Contact> updateContact(UUID id, Contact contact);

    ResponseEntity<Map<String, Boolean>> deleteContact(UUID id);

    ResponseEntity<Map<String, Boolean>> deleteAllContact();

    Contact findContact(UUID id);
}