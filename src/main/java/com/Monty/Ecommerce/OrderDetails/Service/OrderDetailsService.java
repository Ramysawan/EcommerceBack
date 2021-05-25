package com.Monty.Ecommerce.OrderDetails.Service;

import com.Monty.Ecommerce.OrderDetails.Entity.OrderDetails;
import com.Monty.Ecommerce.Orders.Entity.Orders;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface OrderDetailsService {

    List<OrderDetails> getAllOrderDetails();

    OrderDetails findOrderDetailsById(UUID id);

    OrderDetails createOrderDetails(OrderDetails orderDetails);

    ResponseEntity<OrderDetails> getOrderDetailsId(UUID id);

    ResponseEntity<OrderDetails> updateOrderDetails(UUID id, OrderDetails orderDetails);

    ResponseEntity<Map<String, Boolean>> deleteOrderDetails(UUID id);

    ResponseEntity<Map<String, Boolean>> deleteAllOrderDetails();

}