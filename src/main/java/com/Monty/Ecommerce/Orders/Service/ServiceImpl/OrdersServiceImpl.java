package com.Monty.Ecommerce.Orders.Service.ServiceImpl;

import com.Monty.Ecommerce.Orders.Entity.Orders;
import com.Monty.Ecommerce.Orders.Repository.OrdersRepository;
import com.Monty.Ecommerce.Orders.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public Orders findOrderById(UUID id) {
        Orders orders = ordersRepository.findById(id);
        return orders;
    }

    @Override
    public Orders createOrder(Orders orders) {
        Calendar dateCreated = Calendar.getInstance();
        orders.setDateCreated(dateCreated);
        return ordersRepository.save(orders);
    }

    @Override
    public ResponseEntity<Orders> getOrderId(UUID id) {
        Orders orders = ordersRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("DeliveryDriver doesn't exist with id: " + id));
        return ResponseEntity.ok(orders);
    }

    @Override
    public ResponseEntity<Orders> updateOrder(UUID id, Orders orders) {
        Orders ord = ordersRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        ord.setOrderNumber(orders.getOrderNumber());
        ord.setOrderDatePlaced(orders.getOrderDatePlaced());
        ord.setTransactionStatus(orders.getTransactionStatus());
        ord.setShipped(orders.isShipped());
        ord.setActive(orders.isActive());
        ord.setDateCreated(orders.getDateCreated());
        ord.setChannelType(orders.getChannelType());
        ord.setIsCart(orders.getIsCart());
        Calendar dateUpdated = Calendar.getInstance();
        ord.setDateUpdated(dateUpdated);
        ord.setShipment(orders.getShipment());
        ord.setCustomer(orders.getCustomer());
        Orders updateOrder = ordersRepository.save(ord);
        return ResponseEntity.ok(updateOrder);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteOrder(UUID id) {
        Orders orders = ordersRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        ordersRepository.delete(orders);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteAllOrders() {
        ordersRepository.deleteAll();

        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public List<Orders> getOrderByOrderNumber(long orderNumber) {
        return ordersRepository.findByOrderNumber(orderNumber);
    }
}