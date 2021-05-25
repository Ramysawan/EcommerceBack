package com.Monty.Ecommerce.Brand.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
@Table(name = "brand")
public class Brand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "brand_id")
    private UUID brandId;

    @Column(name = "title")
    private String title;

    @Column(name = "photo_url")
    private String photoURL;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "date_created")
    private Calendar dateCreated;

    @Column(name = "date_updated")
    private Calendar dateUpdated;

    public Brand(String title, String photoURL, boolean isActive, Calendar dateCreated, Calendar dateUpdated) {
        this.title = title;
        this.photoURL = photoURL;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

}
