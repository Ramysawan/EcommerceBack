package com.Monty.Ecommerce.Payment.Entity;

import com.Monty.Ecommerce.Orders.Entity.Orders;
import com.Monty.Ecommerce.User.Entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

@Entity
@Table(name = "payment")
@NoArgsConstructor
@Data
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    private UUID paymentId;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "payment_amount")
    private double paymentAmount;

    @Column(name = "is_paid")
    private boolean isPaid;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "date_created")
    private Calendar dateCreated;

    @Column(name = "date_updated")
    private Calendar dateUpdated;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    public Payment(String paymentType, double paymentAmount, boolean isPaid, boolean isActive, Calendar dateCreated, Calendar dateUpdated) {

        this.paymentType = paymentType;
        this.paymentAmount = paymentAmount;
        this.isPaid = isPaid;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }
}