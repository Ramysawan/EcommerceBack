package com.Monty.Ecommerce.Orders.Entity;

import com.Monty.Ecommerce.Customer.Entity.Customer;
import com.Monty.Ecommerce.OrderDetails.Entity.OrderDetails;
import com.Monty.Ecommerce.Shipment.Entity.Shipment;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Data
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private UUID orderId;

    @Column(name = "order_number")
    private long orderNumber;

    @Column(name = "order_date_placed")
    private Calendar orderDatePlaced;

    @Column(name = "transactionstatus")
    private String transactionStatus;

    @Column(name = "is_shipped")
    private boolean isShipped;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "date_created")
    private Calendar dateCreated;

    @Column(name = "date_updated")
    private Calendar dateUpdated;

    @Column(name = "channel_type")
    private String channelType;

    @Column(name = "is_cart")
    private Boolean isCart;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;


    public Orders(long orderNumber, Calendar orderDatePlaced, String transactionStatus, boolean isShipped, boolean isActive, Calendar dateCreated, Calendar dateUpdated, String channelType,boolean isCart) {

        this.orderNumber = orderNumber;
        this.orderDatePlaced = orderDatePlaced;
        this.transactionStatus = transactionStatus;
        this.isShipped = isShipped;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.channelType = channelType;
        this.isCart = isCart;
    }
}