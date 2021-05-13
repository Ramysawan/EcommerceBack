package com.Monty.Ecommerce.Purchase.Repository;

import com.Monty.Ecommerce.Orders.Entity.Orders;
import com.Monty.Ecommerce.Purchase.Entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface PurchaseRepository extends JpaRepository<Purchase, Serializable> {

    @Query("select b from Purchase b where b.purchaseId = ?1")
    Purchase findById(UUID id);

    @Query("select b from Purchase b where b.orderNumber=?1")
    List<Purchase> findByPurchaseNumber(long orderNumber);
}