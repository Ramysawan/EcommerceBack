package com.Monty.Ecommerce.Shipment.Controller;

import com.Monty.Ecommerce.DeliveryDriver.Entity.DeliveryDriver;
import com.Monty.Ecommerce.DeliveryDriver.Service.DeliveryDriverService;
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
public class ShipmentController {

    @Autowired
    ShipmentService shipmentService;

    @Autowired
    ShipmentTrackingService shipmentTrackingService;

    @Autowired
    DeliveryDriverService deliveryDriverService;

    //get all shipments    ***********************************************************************************************
    @GetMapping("/shipment")
    public List<Shipment> getAllShipment(){
        return shipmentService.getAllShipment();
    }

    //get one shipment by id    ******************************************************************************************
    @GetMapping("/shipment/{id}")
    public ResponseEntity<Shipment> getShipmentId(@PathVariable UUID id){
        return shipmentService.getShipmentId(id);
    }

    //get shipment by number    ******************************************************************************************
    @GetMapping("/shipment/sh/{shipmentNumber}")
    public List<Shipment> getShipmentByShipmentNumber(@PathVariable long shipmentNumber){
        return shipmentService.getShipmentByShipmentNumber(shipmentNumber);
    }

    //create one shipment    *********************************************************************************************
    @PostMapping("/shipment")
    public Shipment createShipment(@RequestBody Shipment shipment){
        return shipmentService.createShipment(shipment);
    }

    //update one shipment    *********************************************************************************************
    @PutMapping("/shipment/{id}")
    public ResponseEntity<Shipment> updateShipment(@PathVariable UUID id, @RequestBody Shipment shipmentDetails){
        return shipmentService.updateShipment(id, shipmentDetails);
    }

    //delete one shipment    *********************************************************************************************
    @DeleteMapping("/shipment/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteShipment(@PathVariable UUID id){
        return shipmentService.deleteShipment(id);
    }

    //delete all shipment    *********************************************************************************************
    @DeleteMapping("/shipment")
    public ResponseEntity<Map<String, Boolean>> deleteAllShipment(){
        return shipmentService.deleteAllShipment();
    }

    //create new shipment with driver   **********************************************************************************
    @PostMapping("/deliverydriver/{deliveryDriverId}")
    public Shipment createComments(@PathVariable (value = "deliveryDriverId") UUID deliveryDriverId, @RequestBody Shipment shipment) {
        DeliveryDriver deliveryDriver = deliveryDriverService.findDeliveryDriver(deliveryDriverId);
        shipment.setDeliveryDriver(deliveryDriver);
        return shipmentService.createShipment(shipment);
    }

    //update driver of shipment   ****************************************************************************************
    @PutMapping("/shipment/{shipmentId}/deliverydriver/{deliveryDriverId}")
    public ResponseEntity<Shipment> updateComments(@PathVariable (value = "shipmentId") UUID shipmentId,
                                                   @PathVariable (value = "deliveryDriverId") UUID deliveryDriverId) {

        DeliveryDriver deliveryDriver = deliveryDriverService.findDeliveryDriver(deliveryDriverId);
        Shipment ship = shipmentService.findShipmentById(shipmentId);
        ship.setDeliveryDriver(deliveryDriver);
        return shipmentService.updateShipment(shipmentId, ship);
    }

}


