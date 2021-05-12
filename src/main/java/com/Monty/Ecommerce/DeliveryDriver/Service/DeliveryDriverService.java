package com.Monty.Ecommerce.DeliveryDriver.Service;

import com.Monty.Ecommerce.Brand.Entity.Brand;
import com.Monty.Ecommerce.DeliveryDriver.Entity.DeliveryDriver;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface DeliveryDriverService {


    List<DeliveryDriver> getAllDeliveryDriver();

    List<DeliveryDriver> getDeliveryDriverByName(String deliveryDriverName);

    ResponseEntity<DeliveryDriver> getDeliveryDriverId(UUID id);

    DeliveryDriver createDeliveryDriver(DeliveryDriver deliveryDriver);

    ResponseEntity<DeliveryDriver> updateDeliveryDriver(UUID id, DeliveryDriver deliveryDriver);

    ResponseEntity<Map<String, Boolean>> deleteDeliveryDriver(UUID id);

    ResponseEntity<Map<String, Boolean>> deleteAllDeliveryDriver();

    DeliveryDriver findDeliveryDriver(UUID id);
}
