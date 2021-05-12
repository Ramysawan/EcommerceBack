package com.Monty.Ecommerce.Purchase.Repository;

import com.Monty.Ecommerce.Purchase.Entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface PurchaseRepository extends JpaRepository<Purchase, Serializable> {
}
