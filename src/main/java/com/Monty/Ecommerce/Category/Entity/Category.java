package com.Monty.Ecommerce.Category.Entity;

import com.Monty.Ecommerce.Product.Entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "category")
@NoArgsConstructor
@Data
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private UUID categoryId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "date_created")
    private Calendar dateCreated;

    @Column(name = "date_updated")
    private Calendar dateUpdated;

    @Column(name = "photo_url")
    private String photoURL;

    @OneToMany
    @JoinColumn(name = "parentcategory_id")
    private List<Category> subCategories;


    public Category(String title, String description, boolean isActive, Calendar dateCreated, Calendar dateUpdated, String photoURL) {
        this.title = title;
        this.description = description;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.photoURL = photoURL;
    }
}
