package com.Monty.Ecommerce.Payment.Service;

import com.Monty.Ecommerce.Payment.Entity.Payment;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PaymentService {

    List<Payment> getAllPayment();

    ResponseEntity<Payment> getPaymentId(UUID id);

    Payment createPayment(Payment payment);

    ResponseEntity<Payment> updatePayment(UUID id, Payment payment);

    ResponseEntity<Map<String, Boolean>> deletePayment(UUID id);

    ResponseEntity<Map<String, Boolean>> deleteAllPayment();

    Payment findPayment(UUID id);
}