package com.Monty.Ecommerce.Payment.Repository;

import com.Monty.Ecommerce.Brand.Entity.Brand;
import com.Monty.Ecommerce.Payment.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, Serializable> {

    @Query("select b from Payment b where b.paymentId = ?1")
    Payment findById(UUID id);
}