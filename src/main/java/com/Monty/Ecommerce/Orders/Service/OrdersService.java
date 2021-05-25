package com.Monty.Ecommerce.Orders.Service;

import com.Monty.Ecommerce.Orders.Entity.Orders;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface OrdersService {

    List<Orders> getAllOrders();

    Orders findOrderById(UUID id);

    Orders createOrder(Orders orders);

    ResponseEntity<Orders> getOrderId(UUID id);

    ResponseEntity<Orders> updateOrder(UUID id, Orders orders);

    ResponseEntity<Map<String, Boolean>> deleteOrder(UUID id);

    ResponseEntity<Map<String, Boolean>> deleteAllOrders();

    List<Orders> getOrderByOrderNumber(long orderNumber);
}