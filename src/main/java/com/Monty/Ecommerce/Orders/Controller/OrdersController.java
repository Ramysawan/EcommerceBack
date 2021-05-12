package com.Monty.Ecommerce.Orders.Controller;

import com.Monty.Ecommerce.Orders.Entity.Orders;
import com.Monty.Ecommerce.Orders.Service.OrdersService;
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

    //@Autowired
    //CustomerService customerService;

    @Autowired
    ShipmentService shipmentService;

    //get all orders
    @GetMapping("/orders")
    public List<Orders> getAllOrders(){
        return ordersService.getAllOrders();
    }

    //get one order by id
    @GetMapping("/orders/{id}")
    public ResponseEntity<Orders> getOrderId(@PathVariable UUID id){
        return ordersService.getOrderId(id);
    }

    //get order by number
    @GetMapping("/orders/ord/{orderNumber}")
    public List<Orders> getOrderByOrderNumber(@PathVariable long orderNumber){
        return ordersService.getOrderByOrderNumber(orderNumber);
    }

    //create one order
    @PostMapping("/orders")
    public Orders createOrder(@RequestBody Orders orders){
        return ordersService.createOrder(orders);
    }

    //update one order
    @PutMapping("/orders/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable UUID id, @RequestBody Orders orderDetails){
        return ordersService.updateOrder(id, orderDetails);
    }

    //delete one order
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteOrder(@PathVariable UUID id){
        return ordersService.deleteOrder(id);
    }

    //delete all orders
    @DeleteMapping("/orders")
    public ResponseEntity<Map<String, Boolean>> deleteAllOrders(){
        return ordersService.deleteAllOrders();
    }



    @PostMapping("/shipmentOrder/{shipmentId}")
    public Orders createComments(@PathVariable (value = "shipmentId") UUID shipmentId, @RequestBody Orders comment) {
        Shipment shipment = shipmentService.findShipmentById(shipmentId);

        comment.setShipment(shipment);
        return ordersService.createOrder(comment);
        //}).orElseThrow(() -> new ResourceNotFoundException("PostId " + vendorId + " not found"));
    }

    /*
    @PostMapping("/customerOrder/{customerId}")
    public Orders createComments(@PathVariable (value = "customerId") UUID customerId, @RequestBody Orders comment) {
        Customer customer = customerService.findCustomerById(customerId);
        comment.setCustomer(customer);
        return ordersService.createOrder(comment);
    }
    * */

    //****************************************************************************************************
    @PutMapping("/orders/{orderId}/shipment/{shipmentId}")
    public ResponseEntity<Orders> updateComments(@PathVariable (value = "orderId") UUID orderId,
                                                   @PathVariable (value = "shipmentId") UUID shipmentId) {

        Shipment shipment = shipmentService.findShipmentById(shipmentId);
        Orders ord = ordersService.findOrderById(orderId);
        ord.setShipment(shipment);
        return ordersService.updateOrder(orderId, ord);
    }

    /*
    @PutMapping("/orders/{orderId}/customer/{customerId}")
    public ResponseEntity<Orders> updateComments(@PathVariable (value = "customerId") UUID customerId,
                                                   @PathVariable (value = "orderId") UUID orderId) {
        Customer customer = customerService.findCustomerById(customerId);
        Orders ord = ordersService.findOrderById(orderId);
        ord.setCustomer(customer);
        return ordersService.updateOrder(orderId, orders);
    }
    */

}