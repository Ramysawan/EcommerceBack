package com.Monty.Ecommerce.Shipment.Entity;

import com.Monty.Ecommerce.DeliveryDriver.Entity.DeliveryDriver;
import com.Monty.Ecommerce.Orders.Entity.Orders;
import com.Monty.Ecommerce.ShipmentTracking.Entity.ShipmentTracking;
import com.Monty.Ecommerce.User.Entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

@Entity
@Table(name = "shipment")
@NoArgsConstructor
@Data
public class Shipment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shipment_id")
    private UUID shipmentId;

    @Column(name = "promised_delivery_date")
    private Calendar promisedDeliveryDate;

    @Column(name = "actual_delivery_date")
    private Calendar actualDeliveryDate;

    @Column(name = "shipping_provider")
    private String shippingProvider;

    @Column(name = "shipping_method")
    private String shippingMethod;

    @Column(name = "shipping_cost")
    private double shippingCost;

    @Column(name = "shipping_status")
    private String shippingStatus;

    @Column(name = "is_senttoshippingprovider")
    private boolean isSentToShippingProvider;

    @Column(name = "is_dueamountpaid")
    private boolean isDueAmountPaid;

    @Column(name = "shipment_number")
    private long shipmentNumber;

    @Column(name = "datetime_driverleft")
    private Calendar dateTimeDriverLeft;

    @Column(name = "datetime_driverreturned")
    private Calendar dateTimeDriverReturned;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "date_created")
    private Calendar dateCreated;

    @Column(name = "date_updated")
    private Calendar dateUpdated;

    @OneToOne
    @JoinColumn(name = "delivery_driver_id")
    private DeliveryDriver deliveryDriver;



    public Shipment(Calendar promisedDeliveryDate, Calendar actualDeliveryDate, String shippingProvider, String shippingMethod, double shippingCost, String shippingStatus, boolean isSentToShippingProvider, boolean isDueAmountPaid, long shipmentNumber, Calendar dateTimeDriverLeft, Calendar dateTimeDriverReturned, boolean isActive, Calendar dateCreated, Calendar dateUpdated) {

        this.promisedDeliveryDate = promisedDeliveryDate;
        this.actualDeliveryDate = actualDeliveryDate;
        this.shippingProvider = shippingProvider;
        this.shippingMethod = shippingMethod;
        this.shippingCost = shippingCost;
        this.shippingStatus = shippingStatus;
        this.isSentToShippingProvider = isSentToShippingProvider;
        this.isDueAmountPaid = isDueAmountPaid;
        this.shipmentNumber = shipmentNumber;
        this.dateTimeDriverLeft = dateTimeDriverLeft;
        this.dateTimeDriverReturned = dateTimeDriverReturned;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }
}
