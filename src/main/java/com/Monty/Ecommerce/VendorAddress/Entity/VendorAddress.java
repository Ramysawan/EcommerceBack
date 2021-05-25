package com.Monty.Ecommerce.VendorAddress.Entity;

import com.Monty.Ecommerce.Vendor.Entity.Vendor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

@Entity
@Table(name = "vendoraddress")
@NoArgsConstructor
@Data
public class VendorAddress implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vendor_address_id")
    private UUID vendoraddressId;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "address3")
    private String address3;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private long postalCode;

    @Column(name = "additionnal_description")
    private String additionnalDescription;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "date_created")
    private Calendar dateCreated;

    @Column(name = "date_updated")
    private Calendar dateUpdated;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    public VendorAddress(String address1, String address2, String address3, String country, String state, String city, long postalCode, String additionnalDescription, boolean isActive, Calendar dateCreated, Calendar dateUpdated, String title) {
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.country = country;
        this.state = state;
        this.city = city;
        this.postalCode = postalCode;
        this.additionnalDescription = additionnalDescription;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.title = title;
    }
}
