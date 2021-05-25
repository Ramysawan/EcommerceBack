package com.Monty.Ecommerce.OrderDetails.Service.ServiceImpl;

import com.Monty.Ecommerce.OrderDetails.Entity.OrderDetails;
import com.Monty.Ecommerce.OrderDetails.Repository.OrderDetailsRepository;
import com.Monty.Ecommerce.OrderDetails.Service.OrderDetailsService;
import com.Monty.Ecommerce.Orders.Entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsRepository.findAll();
    }

    @Override
    public OrderDetails findOrderDetailsById(UUID id) {
        OrderDetails ordersDetails = orderDetailsRepository.findById(id);
        return ordersDetails;
    }

    @Override
    public OrderDetails createOrderDetails(OrderDetails orderDetails) {
        Calendar dateCreated = Calendar.getInstance();
        orderDetails.setDateCreated(dateCreated);
        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public ResponseEntity<OrderDetails> getOrderDetailsId(UUID id) {
        OrderDetails orderDetails = orderDetailsRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("DeliveryDriver doesn't exist with id: " + id));
        return ResponseEntity.ok(orderDetails);
    }

    @Override
    public ResponseEntity<OrderDetails> updateOrderDetails(UUID id, OrderDetails orderDetails) {
        OrderDetails ord = orderDetailsRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        //ord.setPrice(orderDetails.getPrice());
        ord.setQuantity(orderDetails.getQuantity());
        ord.setDiscount(orderDetails.getDiscount());
        ord.setTax(orderDetails.getTax());
        ord.setTotal(orderDetails.getTotal());
        ord.setActive(orderDetails.isActive());
        ord.setDateCreated(orderDetails.getDateCreated());
        Calendar dateUpdated = Calendar.getInstance();
        ord.setDateUpdated(dateUpdated);
        ord.setProductId(orderDetails.getProductId());
        ord.setOrders(orderDetails.getOrders());
        OrderDetails updateOrderDetails = orderDetailsRepository.save(ord);
        return ResponseEntity.ok(updateOrderDetails);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteOrderDetails(UUID id) {
        OrderDetails orderDetails = orderDetailsRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        orderDetailsRepository.delete(orderDetails);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteAllOrderDetails() {
        orderDetailsRepository.deleteAll();

        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}