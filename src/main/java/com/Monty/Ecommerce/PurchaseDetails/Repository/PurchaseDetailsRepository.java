package com.Monty.Ecommerce.PurchaseDetails.Repository;

import com.Monty.Ecommerce.OrderDetails.Entity.OrderDetails;
import com.Monty.Ecommerce.PurchaseDetails.Entity.PurchaseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.UUID;

public interface PurchaseDetailsRepository extends JpaRepository<PurchaseDetails, Serializable> {

    @Query("select b from PurchaseDetails b where b.purchaseDetailsId = ?1")
    PurchaseDetails findById(UUID id);
}