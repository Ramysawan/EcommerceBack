package com.Monty.Ecommerce.Shipment.Repository;

import com.Monty.Ecommerce.Shipment.Entity.Shipment;
import com.Monty.Ecommerce.ShipmentTracking.Entity.ShipmentTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface ShipmentRepository extends JpaRepository<Shipment, Serializable> {
    @Query("select b from Shipment b where b.shipmentId = ?1")
    Shipment findById(UUID id);

    @Query("select b from Shipment b where b.shipmentNumber=?1")
    List<Shipment> findByShipmentNumber(long shipmentNumber);
}
