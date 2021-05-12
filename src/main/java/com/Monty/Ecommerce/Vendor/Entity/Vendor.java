package com.Monty.Ecommerce.Vendor.Entity;

import com.Monty.Ecommerce.Product.Entity.Product;
import com.Monty.Ecommerce.User.Entity.User;
import com.Monty.Ecommerce.VendorAddress.Entity.VendorAddress;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "vendor")
@NoArgsConstructor
@Data
public class Vendor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vendor_id")
    private UUID vendorId;

    @Column(name = "vendor_name")
    private String vendorName;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "date_created")
    private Calendar dateCreated;

    @Column(name = "date_updated")
    private Calendar dateUpdated;


    public Vendor(String vendorName, boolean isActive, Calendar dateCreated, Calendar dateUpdated) {

        this.vendorName = vendorName;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }
}
