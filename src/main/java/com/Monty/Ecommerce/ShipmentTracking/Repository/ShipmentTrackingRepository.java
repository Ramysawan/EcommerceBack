package com.Monty.Ecommerce.ShipmentTracking.Repository;

import com.Monty.Ecommerce.ShipmentTracking.Entity.ShipmentTracking;
import com.Monty.Ecommerce.Vendor.Entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface ShipmentTrackingRepository extends JpaRepository<ShipmentTracking, Serializable> {

    @Query("select b from ShipmentTracking b where b.shipmentTrackingId = ?1")
    ShipmentTracking findById(UUID id);

    @Query("select b from ShipmentTracking b where b.trackingNumber=?1")
    List<ShipmentTracking> findByTrackingNumber(long trackingNumber);
}
