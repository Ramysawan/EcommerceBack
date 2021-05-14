package com.Monty.Ecommerce.Orders.Controller;

import com.Monty.Ecommerce.Category.Entity.Category;
import com.Monty.Ecommerce.Customer.Entity.Customer;
import com.Monty.Ecommerce.Customer.Service.CustomerService;
import com.Monty.Ecommerce.Orders.Entity.Orders;
import com.Monty.Ecommerce.Orders.Service.OrdersService;
import com.Monty.Ecommerce.Product.Entity.Product;
import com.Monty.Ecommerce.Shipment.Entity.Shipment;
import com.Monty.Ecommerce.Shipment.Service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ShipmentService shipmentService;

    //get all orders    **********************************************************************************************************
    @GetMapping("/orders")
    public List<Orders> getAllOrders(){
        return ordersService.getAllOrders();
    }

    //get one order by id    *****************************************************************************************************
    @GetMapping("/orders/{id}")
    public ResponseEntity<Orders> getOrderId(@PathVariable UUID id){
        return ordersService.getOrderId(id);
    }

    //get order by number    *****************************************************************************************************
    @GetMapping("/orders/ord/{orderNumber}")
    public List<Orders> getOrderByOrderNumber(@PathVariable long orderNumber){
        return ordersService.getOrderByOrderNumber(orderNumber);
    }

    //create one order    ********************************************************************************************************
    @PostMapping("/orders")
    public Orders createOrder(@RequestBody Orders orders){
        return ordersService.createOrder(orders);
    }

    //update one order    ********************************************************************************************************
    @PutMapping("/orders/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable UUID id, @RequestBody Orders orderDetails){
        return ordersService.updateOrder(id, orderDetails);
    }

    //delete one order    ********************************************************************************************************
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteOrder(@PathVariable UUID id){
        return ordersService.deleteOrder(id);
    }

    //delete all orders    *******************************************************************************************************
    @DeleteMapping("/orders")
    public ResponseEntity<Map<String, Boolean>> deleteAllOrders(){
        return ordersService.deleteAllOrders();
    }

    //add new order with shipment    *********************************************************************************************
    @PostMapping("/shipmentOrder/{shipmentId}")
    public Orders createComments(@PathVariable (value = "shipmentId") UUID shipmentId, @RequestBody Orders order) {
        Shipment shipment = shipmentService.findShipmentById(shipmentId);
        order.setShipment(shipment);
        return ordersService.createOrder(order);
    }

    //add new order with customer    *********************************************************************************************
    @PostMapping("/customerOrder/{customerId}")
    public Orders createComments1(@PathVariable (value = "customerId") UUID customerId, @RequestBody Orders order) {
        Customer customer = customerService.findCustomer(customerId);
        order.setCustomer(customer);
        return ordersService.createOrder(order);
    }

    //update shipment of an order    *********************************************************************************************
    @PutMapping("/orders/{orderId}/shipment/{shipmentId}")
    public ResponseEntity<Orders> updateComments(@PathVariable (value = "orderId") UUID orderId,
                                               @PathVariable (value = "shipmentId") UUID shipmentId, @RequestBody Orders order) {
        
        Orders orders = ordersService.findOrderById(orderId);
        Shipment shipment = shipmentService.findShipmentById(shipmentId);
        order.setCustomer(orders.getCustomer());
        order.setShipment(shipment);
        return ordersService.updateOrder(orderId, order);
    }

    //update customer of an order    *********************************************************************************************
    @PutMapping("/orders/{orderId}/customer/{customerId}")
    public ResponseEntity<Orders> updateComments1(@PathVariable (value = "customerId") UUID customerId,
                                                 @PathVariable (value = "orderId") UUID orderId, @RequestBody Orders order) {
        
        Orders orders = ordersService.findOrderById(orderId);
        Customer customer = customerService.findCustomer(customerId);
        order.setCustomer(customer);
        order.setShipment(orders.getShipment());
        return ordersService.updateOrder(orderId, order);
    }
}