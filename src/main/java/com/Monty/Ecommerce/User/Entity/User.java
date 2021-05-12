package com.Monty.Ecommerce.User.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

@Entity
@Table(name = "user_account", uniqueConstraints = { @UniqueConstraint(columnNames = "login_username"), @UniqueConstraint(columnNames = "email") })
@NoArgsConstructor
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "login_username")
    private String username;

    @Column(name = "login_password")
    private String loginPassword;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "date_created")
    private Calendar dateCreated;

    @Column(name = "date_updated")
    private Calendar dateUpdated;

    public User(String username, String loginPassword, String email, String role, boolean isActive, Calendar dateCreated, Calendar dateUpdated) {

        this.username = username;
        this.loginPassword = loginPassword;
        this.email = email;
        this.role = role;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;

    }



}
