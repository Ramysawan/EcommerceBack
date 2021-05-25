package com.Monty.Ecommerce.DeliveryDriver.Service.ServiceImpl;

import com.Monty.Ecommerce.DeliveryDriver.Entity.DeliveryDriver;
import com.Monty.Ecommerce.DeliveryDriver.Repository.DeliveryDriverRepository;
import com.Monty.Ecommerce.DeliveryDriver.Service.DeliveryDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DeliveryDriverServiceImpl implements DeliveryDriverService {

    @Autowired
    private DeliveryDriverRepository deliveryDriverRepository;


    @Override
    public List<DeliveryDriver> getAllDeliveryDriver() {
        return deliveryDriverRepository.findAll();
    }

    @Override
    public List<DeliveryDriver> getDeliveryDriverByName(String deliveryDriverName) {
        return deliveryDriverRepository.findByDeliveryDriverName(deliveryDriverName);
    }

    @Override
    public ResponseEntity<DeliveryDriver> getDeliveryDriverId(UUID id) {
        DeliveryDriver deliveryDriver = deliveryDriverRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("DeliveryDriver doesn't exist with id: " + id));
        return ResponseEntity.ok(deliveryDriver);
    }

    @Override
    public DeliveryDriver createDeliveryDriver(DeliveryDriver deliveryDriver) {
        Calendar dateCreated = Calendar.getInstance();
        deliveryDriver.setDateCreated(dateCreated);
        return deliveryDriverRepository.save(deliveryDriver);
    }

    @Override
    public ResponseEntity<DeliveryDriver> updateDeliveryDriver(UUID id, DeliveryDriver deliveryDriver) {
        DeliveryDriver driver = deliveryDriverRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        driver.setDriverName(deliveryDriver.getDriverName());
        driver.setDriverPhoneNumber(deliveryDriver.getDriverPhoneNumber());
        driver.setDriverVehiclePlateNumber(deliveryDriver.getDriverVehiclePlateNumber());
        driver.setActive(deliveryDriver.isActive());
        driver.setDateCreated(deliveryDriver.getDateCreated());
        Calendar dateUpdated = Calendar.getInstance();
        driver.setDateUpdated(dateUpdated);

        DeliveryDriver updateDeliveryDriver = deliveryDriverRepository.save(driver);
        return ResponseEntity.ok(updateDeliveryDriver);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteDeliveryDriver(UUID id) {
        DeliveryDriver deliveryDriver = deliveryDriverRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        deliveryDriverRepository.delete(deliveryDriver);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteAllDeliveryDriver() {
        deliveryDriverRepository.deleteAll();

        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
    @Override
    public DeliveryDriver findDeliveryDriver(UUID id) {
        DeliveryDriver deliveryDriver = deliveryDriverRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));
        return deliveryDriver;
    }
}
