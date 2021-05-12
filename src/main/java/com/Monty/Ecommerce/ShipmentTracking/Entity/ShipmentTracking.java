package com.Monty.Ecommerce.ShipmentTracking.Entity;


import com.Monty.Ecommerce.Shipment.Entity.Shipment;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

@Entity
@Table(name = "shipment_tracking")
@NoArgsConstructor
@Data
public class ShipmentTracking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shipment_tracking_id")
    private UUID shipmentTrackingId;

    @Column(name = "tracking_url")
    private String trackingURL;

    @Column(name = "shipment_departed_date")
    private Calendar shipmentDepartedDate;

    @Column(name = "is_orderreceivedbyshipper")
    private boolean isOrderReceivedByShipper;

    @Column(name = "tracking_number")
    private long trackingNumber;

    @Column(name = "is_in_transit")
    private boolean isInTransit;

    @Column(name = "is_outfordelivery")
    private boolean isOutForDelivery;

    @Column(name = "is_destinationreached")
    private boolean isDestinationReached;

    @Column(name = "expected_arrival_date")
    private Calendar expectedArrivalDate;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "date_created")
    private Calendar dateCreated;

    @Column(name = "date_updated")
    private Calendar dateUpdated;

    @OneToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;


    public ShipmentTracking(String trackingURL, Calendar shipmentDepartedDate, boolean isOrderReceivedByShipper, long trackingNumber, boolean isInTransit, boolean isOutForDelivery, boolean isDestinationReached, Calendar expectedArrivalDate, boolean isActive, Calendar dateCreated, Calendar dateUpdated) {

        this.trackingURL = trackingURL;
        this.shipmentDepartedDate = shipmentDepartedDate;
        this.isOrderReceivedByShipper = isOrderReceivedByShipper;
        this.trackingNumber = trackingNumber;
        this.isInTransit = isInTransit;
        this.isOutForDelivery = isOutForDelivery;
        this.isDestinationReached = isDestinationReached;
        this.expectedArrivalDate = expectedArrivalDate;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }
}
