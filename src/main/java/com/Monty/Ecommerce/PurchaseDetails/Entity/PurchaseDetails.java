package com.Monty.Ecommerce.PurchaseDetails.Entity;

import com.Monty.Ecommerce.Orders.Entity.Orders;
import com.Monty.Ecommerce.Product.Entity.Product;
import com.Monty.Ecommerce.Purchase.Entity.Purchase;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

@Entity
@Table(name = "purchase_details")
@NoArgsConstructor
@Data
public class PurchaseDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "purchase_details_id")
    private UUID purchaseDetailsId;

    /*@Column(name = "price")
    private double price;*/

    @Column(name = "quantity")
    private long quantity;

    @Column(name = "discount")
    private double discount;

    @Column(name = "tax")
    private double tax;

    @Column(name = "total")
    private double total;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "date_created")
    private Calendar dateCreated;

    @Column(name = "date_updated")
    private Calendar dateUpdated;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product productId;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;


    public PurchaseDetails(long quantity, double discount, double tax, double total, boolean isActive, Calendar dateCreated, Calendar dateUpdated) {

        //this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.tax = tax;
        this.total = total;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }
}