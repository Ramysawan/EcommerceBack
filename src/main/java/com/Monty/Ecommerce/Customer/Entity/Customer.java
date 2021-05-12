package com.Monty.Ecommerce.Customer.Entity;

import com.Monty.Ecommerce.User.Entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@Data
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "agree_to_mails")
    private boolean agreeToMails;

    @Column(name = "notes_about_customer")
    private String notesAboutCustomer;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "date_created")
    private Calendar dateCreated;

    @Column(name = "date_updated")
    private Calendar dateUpdated;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Customer(String firstName, String lastName, String phoneNumber, boolean agreeToMails, String notesAboutCustomer, boolean isActive, Calendar dateCreated, Calendar dateUpdated) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.agreeToMails = agreeToMails;
        this.notesAboutCustomer = notesAboutCustomer;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;

    }


}
