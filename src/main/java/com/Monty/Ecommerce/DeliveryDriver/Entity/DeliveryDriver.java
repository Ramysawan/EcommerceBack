package com.Monty.Ecommerce.DeliveryDriver.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

@Entity
@Table(name = "deliverydriver")
@NoArgsConstructor
@Data
public class DeliveryDriver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "deliverydriver_id")
    private UUID deliveryDriverId;

    @Column(name = "driver_name")
    private String driverName;

    @Column(name = "driver_phonenumber")
    private String driverPhoneNumber;

    @Column(name = "driver_vehicle_platenumber")
    private String driverVehiclePlateNumber;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "date_created")
    private Calendar dateCreated;

    @Column(name = "date_updated")
    private Calendar dateUpdated;

    public DeliveryDriver(String driverName, String driverPhoneNumber, String driverVehiclePlateNumber, boolean isActive, Calendar dateCreated, Calendar dateUpdated) {

        this.driverName = driverName;
        this.driverPhoneNumber = driverPhoneNumber;
        this.driverVehiclePlateNumber = driverVehiclePlateNumber;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }
}
