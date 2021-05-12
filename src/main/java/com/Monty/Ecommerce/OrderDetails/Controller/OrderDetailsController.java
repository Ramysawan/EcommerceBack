package com.Monty.Ecommerce.OrderDetails.Controller;

import com.Monty.Ecommerce.OrderDetails.Entity.OrderDetails;
import com.Monty.Ecommerce.OrderDetails.Service.OrderDetailsService;
import com.Monty.Ecommerce.Orders.Entity.Orders;
import com.Monty.Ecommerce.Orders.Service.OrdersService;
import com.Monty.Ecommerce.Product.Entity.Product;
import com.Monty.Ecommerce.Product.Service.ProductService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class OrderDetailsController {

    @Autowired
    OrderDetailsService orderDetailsService;

    @Autowired
    OrdersService ordersService;

    @Autowired
    ProductService productService;

    //get all order details
    @GetMapping("/orderdetails")
    public List<OrderDetails> getAllOrderDetails(){
        return orderDetailsService.getAllOrderDetails();
    }

    //get one order Details by id
    @GetMapping("/orderdetails/{id}")
    public ResponseEntity<OrderDetails> getOrderDetailsId(@PathVariable UUID id){
        return orderDetailsService.getOrderDetailsId(id);
    }


    //create one order Details
    @PostMapping("/orderdetails")
    public OrderDetails createOrderDetails(@RequestBody OrderDetails orderDetails){
        return orderDetailsService.createOrderDetails(orderDetails);
    }

    //update one order Details
    @PutMapping("/orderdetails/{id}")
    public ResponseEntity<OrderDetails> updateOrderDetails(@PathVariable UUID id, @RequestBody OrderDetails orderDetails){
        return orderDetailsService.updateOrderDetails(id, orderDetails);
    }

    //delete one order Details
    @DeleteMapping("/orderdetails/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteOrderDetails(@PathVariable UUID id){
        return orderDetailsService.deleteOrderDetails(id);
    }

    //delete all orders Details
    @DeleteMapping("/orderdetails")
    public ResponseEntity<Map<String, Boolean>> deleteAllOrderDetails(){
        return orderDetailsService.deleteAllOrderDetails();
    }



    @PostMapping("/productOrderDetails/{productId}")
    public OrderDetails createComments(@PathVariable (value = "productId") UUID productId, @RequestBody OrderDetails orderDetails) {
        Product product = productService.findProductById(productId);

        orderDetails.setProductId(product);
        return orderDetailsService.createOrderDetails(orderDetails);
    }

    @PostMapping("/ordersOrderDetails/{orderId}")
    public OrderDetails createComments1(@PathVariable (value = "orderId") UUID orderId, @RequestBody OrderDetails orderDetails) {
        Orders order = ordersService.findOrderById(orderId);

        orderDetails.setOrders(order);
        return orderDetailsService.createOrderDetails(orderDetails);
    }


    @PutMapping("/orderdetails/{orderDetailsId}/product/{productId}")
    public ResponseEntity<OrderDetails> updateComments(@PathVariable (value = "orderDetailsId") UUID orderDetailsId,
                                                 @PathVariable (value = "productId") UUID productId) {

        Product product = productService.findProductById(productId);
        OrderDetails ord = orderDetailsService.findOrderDetailsById(orderDetailsId);
        ord.setProductId(product);
        return orderDetailsService.updateOrderDetails(orderDetailsId, ord);
    }

    @PutMapping("/orderdetails/{orderDetailsId}/orders/{orderId}")
    public ResponseEntity<OrderDetails> updateComments1(@PathVariable (value = "orderDetailsId") UUID orderDetailsId,
                                                       @PathVariable (value = "orderId") UUID orderId) {

        Orders order = ordersService.findOrderById(orderId);
        OrderDetails ord = orderDetailsService.findOrderDetailsById(orderDetailsId);
        ord.setOrders(order);
        return orderDetailsService.updateOrderDetails(orderDetailsId, ord);
    }




}
