package com.Monty.Ecommerce.ShipmentTracking.Service.ServiceImpl;

import com.Monty.Ecommerce.Shipment.Entity.Shipment;
import com.Monty.Ecommerce.ShipmentTracking.Entity.ShipmentTracking;
import com.Monty.Ecommerce.ShipmentTracking.Repository.ShipmentTrackingRepository;
import com.Monty.Ecommerce.ShipmentTracking.Service.ShipmentTrackingService;
import com.Monty.Ecommerce.Vendor.Entity.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShipmentTrackingServiceImpl implements ShipmentTrackingService {

    @Autowired
    private ShipmentTrackingRepository shipmentTrackingRepository;

    @Override
    public List<ShipmentTracking> getAllShipmentTracking() {
        return shipmentTrackingRepository.findAll();
    }

    @Override
    public List<ShipmentTracking> getShipmentTrackingByTrackingNumber(long trackingNumber) {
        return shipmentTrackingRepository.findByTrackingNumber(trackingNumber);
    }

    @Override
    public ResponseEntity<ShipmentTracking> getShipmentTrackingId(UUID id) {
        ShipmentTracking shipmentTracking = shipmentTrackingRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("DeliveryDriver doesn't exist with id: " + id));
        return ResponseEntity.ok(shipmentTracking);
    }

    @Override
    public ShipmentTracking createShipmentTracking(ShipmentTracking shipmentTracking) {
        Calendar dateCreated = Calendar.getInstance();
        shipmentTracking.setDateCreated(dateCreated);
        return shipmentTrackingRepository.save(shipmentTracking);
    }

    @Override
    public ResponseEntity<ShipmentTracking> updateShipmentTracking(UUID id, ShipmentTracking shipmentTracking) {
        ShipmentTracking ship = shipmentTrackingRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        ship.setTrackingURL(shipmentTracking.getTrackingURL());
        ship.setShipmentDepartedDate(shipmentTracking.getShipmentDepartedDate());
        ship.setOrderReceivedByShipper(shipmentTracking.isOrderReceivedByShipper());
        ship.setTrackingNumber(shipmentTracking.getTrackingNumber());
        ship.setInTransit(shipmentTracking.isInTransit());
        ship.setOutForDelivery(shipmentTracking.isOutForDelivery());
        ship.setDestinationReached(shipmentTracking.isDestinationReached());
        ship.setExpectedArrivalDate(shipmentTracking.getExpectedArrivalDate());
        ship.setActive(shipmentTracking.isActive());
        ship.setDateCreated(shipmentTracking.getDateCreated());
        Calendar dateUpdated = Calendar.getInstance();
        ship.setDateUpdated(dateUpdated);
        ship.setShipment(shipmentTracking.getShipment());

        ShipmentTracking updateShipmentTracking = shipmentTrackingRepository.save(ship);
        return ResponseEntity.ok(updateShipmentTracking);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteShipmentTracking(UUID id) {
        ShipmentTracking shipmentTracking = shipmentTrackingRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        shipmentTrackingRepository.delete(shipmentTracking);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteAllShipmentTracking() {
        shipmentTrackingRepository.deleteAll();

        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
    @Override
    public ShipmentTracking findShipmentTracking(UUID id) {
        ShipmentTracking shipmentTracking = shipmentTrackingRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));
        return shipmentTracking;
    }
}
