package com.Monty.Ecommerce.DeliveryDriver.Repository;

import com.Monty.Ecommerce.Brand.Entity.Brand;
import com.Monty.Ecommerce.DeliveryDriver.Entity.DeliveryDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface DeliveryDriverRepository extends JpaRepository<DeliveryDriver, Serializable> {

    @Query("select b from DeliveryDriver b where b.deliveryDriverId = ?1")
    DeliveryDriver findById(UUID id);

    @Query("select b from DeliveryDriver b where b.driverName like %?1%")
    List<DeliveryDriver> findByDeliveryDriverName(String deliveryDriverName);

}
