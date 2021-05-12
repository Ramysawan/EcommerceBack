package com.Monty.Ecommerce.ShipmentTracking.Controller;

import com.Monty.Ecommerce.Shipment.Entity.Shipment;
import com.Monty.Ecommerce.Shipment.Service.ShipmentService;
import com.Monty.Ecommerce.ShipmentTracking.Entity.ShipmentTracking;
import com.Monty.Ecommerce.ShipmentTracking.Service.ShipmentTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class ShipmentTrackingController {

    @Autowired
    ShipmentTrackingService shipmentTrackingService;
    @Autowired
    ShipmentService shipmentService;

    //get all shipment trackings
    @GetMapping("/shipmenttracking")
    public List<ShipmentTracking> getAllShipmentTracking(){
        return shipmentTrackingService.getAllShipmentTracking();
    }

    //get one shipment tracking by id
    @GetMapping("/shipmenttracking/{id}")
    public ResponseEntity<ShipmentTracking> getShipmentTrackingId(@PathVariable UUID id){
        return shipmentTrackingService.getShipmentTrackingId(id);
    }

    //get tracking by number
    @GetMapping("/shipmenttracking/tr/{trackingNumber}")
    public List<ShipmentTracking> getShipmentTrackingByTrackingNumber(@PathVariable long trackingNumber){
        return shipmentTrackingService.getShipmentTrackingByTrackingNumber(trackingNumber);
    }

    //create one shipment tracking
    @PostMapping("/shipmenttracking")
    public ShipmentTracking createShipmentTracking(@RequestBody ShipmentTracking shipmentTracking){
        return shipmentTrackingService.createShipmentTracking(shipmentTracking);
    }

    //update one shipment tracking
    @PutMapping("/shipmenttracking/{id}")
    public ResponseEntity<ShipmentTracking> updateShipmentTracking(@PathVariable UUID id, @RequestBody ShipmentTracking shipmentTrackingDetails){
        return shipmentTrackingService.updateShipmentTracking(id, shipmentTrackingDetails);
    }

    //delete one shipment tracking
    @DeleteMapping("/shipmenttracking/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteShipmentTracking(@PathVariable UUID id){
        return shipmentTrackingService.deleteShipmentTracking(id);
    }

    //delete all shipment tracking
    @DeleteMapping("/shipmenttracking")
    public ResponseEntity<Map<String, Boolean>> deleteAllShipmentTracking(){
        return shipmentTrackingService.deleteAllShipmentTracking();
    }
    
    @PostMapping("/shipment/{shipmentId}")
    public ShipmentTracking createComment(@PathVariable (value = "shipmentId") UUID shipmentId, @RequestBody ShipmentTracking shipmentTracking) {
        Shipment shipment = shipmentService.findShipmentById(shipmentId);

        shipmentTracking.setShipment(shipment);
        return shipmentTrackingService.createShipmentTracking(shipmentTracking);
    }

}

