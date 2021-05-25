package com.Monty.Ecommerce.Orders.Repository;

import com.Monty.Ecommerce.Orders.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface OrdersRepository extends JpaRepository<Orders, Serializable> {

    @Query("select b from Orders b where b.orderId = ?1")
    Orders findById(UUID id);

    @Query("select b from Orders b where b.orderNumber=?1")
    List<Orders> findByOrderNumber(long orderNumber);
}