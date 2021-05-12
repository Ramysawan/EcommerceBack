package com.Monty.Ecommerce.ShipmentTracking.Service;

import com.Monty.Ecommerce.ShipmentTracking.Entity.ShipmentTracking;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ShipmentTrackingService {

    List<ShipmentTracking> getAllShipmentTracking();

    List<ShipmentTracking> getShipmentTrackingByTrackingNumber(long trackingNumber);

    ResponseEntity<ShipmentTracking> getShipmentTrackingId(UUID id);

    ShipmentTracking createShipmentTracking(ShipmentTracking shipmentTracking);

    ResponseEntity<ShipmentTracking> updateShipmentTracking(UUID id, ShipmentTracking shipmentTracking);

    ResponseEntity<Map<String, Boolean>> deleteShipmentTracking(UUID id);

    ResponseEntity<Map<String, Boolean>> deleteAllShipmentTracking();

    ShipmentTracking findShipmentTracking(UUID id);

}
