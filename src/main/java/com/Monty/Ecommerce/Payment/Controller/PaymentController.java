package com.Monty.Ecommerce.Payment.Controller;

import com.Monty.Ecommerce.Brand.Entity.Brand;
import com.Monty.Ecommerce.Brand.Service.BrandService;
import com.Monty.Ecommerce.DeliveryDriver.Entity.DeliveryDriver;
import com.Monty.Ecommerce.Orders.Entity.Orders;
import com.Monty.Ecommerce.Orders.Service.OrdersService;
import com.Monty.Ecommerce.Payment.Entity.Payment;
import com.Monty.Ecommerce.Payment.Service.PaymentService;
import com.Monty.Ecommerce.Shipment.Entity.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Autowired
    OrdersService ordersService;

    //get all payments    ************************************************************************************************************
    @GetMapping("/payment")
    public List<Payment> getAllPayment() {
        return paymentService.getAllPayment();
    }

    //get one payment by id    *******************************************************************************************************
    @GetMapping("/payment/{id}")
    public ResponseEntity<Payment> getPaymentId(@PathVariable UUID id) {
        return paymentService.getPaymentId(id);
    }

    //create one Payment    **********************************************************************************************************
    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    //update one Payment    **********************************************************************************************************
    @PutMapping("/payment/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable UUID id, @RequestBody Payment paymentDetails) {
        return paymentService.updatePayment(id, paymentDetails);
    }

    //delete one Payment    **********************************************************************************************************
    @DeleteMapping("/payment/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePayment(@PathVariable UUID id) {
        return paymentService.deletePayment(id);
    }

    //delete all Payment    **********************************************************************************************************
    @DeleteMapping("/payment")
    public ResponseEntity<Map<String, Boolean>> deleteAllPayment() {
        return paymentService.deleteAllPayment();
    }

    //add new payment with order    **************************************************************************************************
    @PostMapping("/paymentOrder/{orderId}")
    public Payment createComments(@PathVariable(value = "orderId") UUID orderId, @RequestBody Payment payment) {
        Orders order = ordersService.findOrderById(orderId);
        payment.setOrder(order);
        return paymentService.createPayment(payment);
    }

    //update order of a payment    ***************************************************************************************************
    @PutMapping("/payment/{paymentId}/orders/{orderId}")
    public ResponseEntity<Payment> updateComments(@PathVariable(value = "paymentId") UUID paymentId,
                                                   @PathVariable(value = "orderId") UUID orderId, @RequestBody Payment payment) {

        Orders order = ordersService.findOrderById(orderId);
        payment.setOrder(order);
        return paymentService.updatePayment(paymentId, payment);
    }
}