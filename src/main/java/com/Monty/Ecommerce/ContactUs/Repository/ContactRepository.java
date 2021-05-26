package com.Monty.Ecommerce.ContactUs.Repository;

import com.Monty.Ecommerce.ContactUs.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, Serializable> {

    @Query("select b from Contact b where b.contactId = ?1")
    Contact findById(UUID id);

    @Query("select b from Contact b where b.firstName like %?1%")
    List<Contact> findByFirstName(String firstName);
}