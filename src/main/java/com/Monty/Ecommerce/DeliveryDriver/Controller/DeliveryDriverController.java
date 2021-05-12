package com.Monty.Ecommerce.DeliveryDriver.Controller;

import com.Monty.Ecommerce.DeliveryDriver.Entity.DeliveryDriver;
import com.Monty.Ecommerce.DeliveryDriver.Service.DeliveryDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class DeliveryDriverController {

    @Autowired
    DeliveryDriverService deliveryDriverService;

    //get all drivers
    @GetMapping("/deliverydriver")
    public List<DeliveryDriver> getAllDeliveryDriver(){
        return deliveryDriverService.getAllDeliveryDriver();
    }

    //get one driver by id
    @GetMapping("/deliverydriver/{id}")
    public ResponseEntity<DeliveryDriver> getDeliveryDriverId(@PathVariable UUID id){
        return deliveryDriverService.getDeliveryDriverId(id);
    }

    //get driver by name
    @GetMapping("/deliverydriver/dr/{deliveryDriverName}")
    public List<DeliveryDriver> getDeliveryDriverByName(@PathVariable String deliveryDriverName){
        return deliveryDriverService.getDeliveryDriverByName(deliveryDriverName);
    }

    //create one delivery driver
    @PostMapping("/deliverydriver")
    public DeliveryDriver createDeliveryDriver(@RequestBody DeliveryDriver deliveryDriver){
        return deliveryDriverService.createDeliveryDriver(deliveryDriver);
    }

    //update one brand
    @PutMapping("/deliverydriver/{id}")
    public ResponseEntity<DeliveryDriver> updateDeliveryDriver(@PathVariable UUID id, @RequestBody DeliveryDriver deliveryDriverDetails){
        return deliveryDriverService.updateDeliveryDriver(id, deliveryDriverDetails);
    }

    //delete one brand
    @DeleteMapping("/deliverydriver/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteDeliveryDriver(@PathVariable UUID id){
        return deliveryDriverService.deleteDeliveryDriver(id);
    }

    //delete all brand
    @DeleteMapping("/deliverydriver")
    public ResponseEntity<Map<String, Boolean>> deleteAllDeliveryDriver(){
        return deliveryDriverService.deleteAllDeliveryDriver();
    }

}
