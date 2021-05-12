package com.Monty.Ecommerce.Shipment.Service;

import com.Monty.Ecommerce.Address.Entity.Address;
import com.Monty.Ecommerce.Shipment.Entity.Shipment;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ShipmentService {

    List<Shipment> getAllShipment();

    Shipment findShipmentById(UUID id);

    Shipment createShipment(Shipment shipment);

    ResponseEntity<Shipment> getShipmentId(UUID id);

    ResponseEntity<Shipment> updateShipment(UUID id, Shipment shipment);

    ResponseEntity<Map<String, Boolean>> deleteShipment(UUID id);

    ResponseEntity<Map<String, Boolean>> deleteAllShipment();

    List<Shipment> getShipmentByShipmentNumber(long shipmentNumber);
}
