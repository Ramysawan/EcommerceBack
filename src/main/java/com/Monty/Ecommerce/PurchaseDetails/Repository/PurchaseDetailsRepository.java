package com.Monty.Ecommerce.PurchaseDetails.Repository;

import com.Monty.Ecommerce.PurchaseDetails.Entity.PurchaseDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface PurchaseDetailsRepository extends JpaRepository<PurchaseDetails, Serializable> {
}
