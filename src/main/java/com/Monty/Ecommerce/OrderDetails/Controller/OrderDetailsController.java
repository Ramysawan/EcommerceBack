package com.Monty.Ecommerce.OrderDetails.Controller;

import com.Monty.Ecommerce.OrderDetails.Entity.OrderDetails;
import com.Monty.Ecommerce.OrderDetails.Service.OrderDetailsService;
import com.Monty.Ecommerce.Orders.Entity.Orders;
import com.Monty.Ecommerce.Orders.Service.OrdersService;
import com.Monty.Ecommerce.Product.Entity.Product;
import com.Monty.Ecommerce.Product.Service.ProductService;
import com.Monty.Ecommerce.Shipment.Entity.Shipment;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class OrderDetailsController {

    @Autowired
    OrderDetailsService orderDetailsService;

    @Autowired
    OrdersService ordersService;

    @Autowired
    ProductService productService;

    //get all order details    ***********************************************************************************************************
    @GetMapping("/orderdetails")
    public List<OrderDetails> getAllOrderDetails(){
        return orderDetailsService.getAllOrderDetails();
    }

    //get one order Details by id    *****************************************************************************************************
    @GetMapping("/orderdetails/{id}")
    public ResponseEntity<OrderDetails> getOrderDetailsId(@PathVariable UUID id){
        return orderDetailsService.getOrderDetailsId(id);
    }

    //create one order Details    ********************************************************************************************************
    @PostMapping("/orderdetails")
    public OrderDetails createOrderDetails(@RequestBody OrderDetails orderDetails){
        return orderDetailsService.createOrderDetails(orderDetails);
    }

    //update one order Details    ********************************************************************************************************
    @PutMapping("/orderdetails/{id}")
    public ResponseEntity<OrderDetails> updateOrderDetails(@PathVariable UUID id, @RequestBody OrderDetails orderDetails){
        return orderDetailsService.updateOrderDetails(id, orderDetails);
    }

    //delete one order Details    ********************************************************************************************************
    @DeleteMapping("/orderdetails/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteOrderDetails(@PathVariable UUID id){
        return orderDetailsService.deleteOrderDetails(id);
    }

    //delete all orders Details    *******************************************************************************************************
    @DeleteMapping("/orderdetails")
    public ResponseEntity<Map<String, Boolean>> deleteAllOrderDetails(){
        return orderDetailsService.deleteAllOrderDetails();
    }

    //add new order details with product    **********************************************************************************************
    @PostMapping("/productOrderDetails/{productId}")
    public OrderDetails createComments(@PathVariable (value = "productId") UUID productId, @RequestBody OrderDetails orderDetails) {
        Product product = productService.findProductById(productId);

        orderDetails.setProductId(product);
        return orderDetailsService.createOrderDetails(orderDetails);
    }

    //add new order details with order    ************************************************************************************************
    @PostMapping("/ordersOrderDetails/{orderId}")
    public OrderDetails createComments1(@PathVariable (value = "orderId") UUID orderId, @RequestBody OrderDetails orderDetails) {
        Orders order = ordersService.findOrderById(orderId);

        orderDetails.setOrders(order);
        return orderDetailsService.createOrderDetails(orderDetails);
    }

    //update product of an order details    **********************************************************************************************
    @PutMapping("/orderdetails/{orderDetailsId}/product/{productId}")
    public ResponseEntity<OrderDetails> updateComments(@PathVariable (value = "orderDetailsId") UUID orderDetailsId,
                                                 @PathVariable (value = "productId") UUID productId, @RequestBody OrderDetails orderDetails) {

        OrderDetails ordDetails = orderDetailsService.findOrderDetailsById(orderDetailsId);
        Product product = productService.findProductById(productId);
        orderDetails.setProductId(product);
        orderDetails.setOrders(ordDetails.getOrders());
        return orderDetailsService.updateOrderDetails(orderDetailsId, orderDetails);
    }

    //update order of an order details    ************************************************************************************************
    @PutMapping("/orderdetails/{orderDetailsId}/orders/{orderId}")
    public ResponseEntity<OrderDetails> updateComments1(@PathVariable (value = "orderDetailsId") UUID orderDetailsId,
                                                       @PathVariable (value = "orderId") UUID orderId, @RequestBody OrderDetails orderDetails) {

        OrderDetails ordDetails = orderDetailsService.findOrderDetailsById(orderDetailsId);
        Orders order = ordersService.findOrderById(orderId);
        orderDetails.setProductId(ordDetails.getProductId());
        orderDetails.setOrders(order);
        return orderDetailsService.updateOrderDetails(orderDetailsId, orderDetails);
    }
}
