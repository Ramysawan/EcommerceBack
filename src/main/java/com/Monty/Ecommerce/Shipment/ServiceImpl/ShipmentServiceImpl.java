package com.Monty.Ecommerce.Shipment.ServiceImpl;

import com.Monty.Ecommerce.Shipment.Entity.Shipment;
import com.Monty.Ecommerce.Shipment.Repository.ShipmentRepository;
import com.Monty.Ecommerce.Shipment.Service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Override
    public List<Shipment> getAllShipment() {
        return shipmentRepository.findAll();
    }

    @Override
    public Shipment createShipment(Shipment shipment) {
        Calendar dateCreated = Calendar.getInstance();
        shipment.setDateCreated(dateCreated);
        return shipmentRepository.save(shipment);
    }

    @Override
    public ResponseEntity<Shipment> getShipmentId(UUID id) {
        Shipment shipment = shipmentRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("DeliveryDriver doesn't exist with id: " + id));
        return ResponseEntity.ok(shipment);
    }

    @Override
    public ResponseEntity<Shipment> updateShipment(UUID id, Shipment shipment) {
        Shipment ship = shipmentRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        ship.setPromisedDeliveryDate(shipment.getPromisedDeliveryDate());
        ship.setActualDeliveryDate(shipment.getActualDeliveryDate());
        ship.setShippingProvider(shipment.getShippingProvider());
        ship.setShippingMethod(shipment.getShippingMethod());
        ship.setShippingCost(shipment.getShippingCost());
        ship.setShippingStatus(shipment.getShippingStatus());
        ship.setSentToShippingProvider(shipment.isSentToShippingProvider());
        ship.setDueAmountPaid(shipment.isDueAmountPaid());
        ship.setShipmentNumber(shipment.getShipmentNumber());
        ship.setDateTimeDriverLeft(shipment.getDateTimeDriverLeft());
        ship.setDateTimeDriverReturned(shipment.getDateTimeDriverReturned());

        ship.setActive(shipment.isActive());
        ship.setDateCreated(shipment.getDateCreated());
        Calendar dateUpdated = Calendar.getInstance();
        ship.setDateUpdated(dateUpdated);
        //ship.setDeliveryDriver(shipment.getDeliveryDriver());
        Shipment updateShipment = shipmentRepository.save(ship);
        return ResponseEntity.ok(updateShipment);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteShipment(UUID id) {
        Shipment shipment = shipmentRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        shipmentRepository.delete(shipment);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteAllShipment() {
        shipmentRepository.deleteAll();

        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public List<Shipment> getShipmentByShipmentNumber(long shipmentNumber) {
        return shipmentRepository.findByShipmentNumber(shipmentNumber);
    }

    @Override
    public Shipment findShipmentById(UUID id) {
        Shipment shipment = shipmentRepository.findById(id);
        return shipment;
    }


}
