package com.Monty.Ecommerce.OrderDetails.Repository;

import com.Monty.Ecommerce.OrderDetails.Entity.OrderDetails;
import com.Monty.Ecommerce.Orders.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.UUID;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Serializable> {

    @Query("select b from OrderDetails b where b.orderDetailsId = ?1")
    OrderDetails findById(UUID id);

}