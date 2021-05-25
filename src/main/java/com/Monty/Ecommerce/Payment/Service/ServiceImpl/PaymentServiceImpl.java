package com.Monty.Ecommerce.Payment.Service.ServiceImpl;

import com.Monty.Ecommerce.Payment.Entity.Payment;
import com.Monty.Ecommerce.Payment.Repository.PaymentRepository;
import com.Monty.Ecommerce.Payment.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }

    @Override
    public ResponseEntity<Payment> getPaymentId(UUID id) {
        Payment payment = paymentRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));
        return ResponseEntity.ok(payment);
    }

    @Override
    public Payment createPayment(Payment payment) {
        Calendar dateCreated = Calendar.getInstance();
        payment.setDateCreated(dateCreated);
        return paymentRepository.save(payment);
    }

    @Override
    public ResponseEntity<Payment> updatePayment(UUID id, Payment payment) {
        Payment pay = paymentRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        pay.setPaymentType(payment.getPaymentType());
        pay.setPaymentAmount(payment.getPaymentAmount());
        pay.setPaid(payment.isPaid());
        pay.setActive(payment.isActive());
        pay.setDateCreated(payment.getDateCreated());
        Calendar dateUpdated = Calendar.getInstance();
        pay.setDateUpdated(dateUpdated);
        pay.setOrder(payment.getOrder());
        Payment updatePayment = paymentRepository.save(pay);
        return ResponseEntity.ok(updatePayment);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deletePayment(UUID id) {
        Payment payment = paymentRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        paymentRepository.delete(payment);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteAllPayment() {
        paymentRepository.deleteAll();

        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public Payment findPayment(UUID id) {
        Payment payment = paymentRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));
        return payment;
    }
}