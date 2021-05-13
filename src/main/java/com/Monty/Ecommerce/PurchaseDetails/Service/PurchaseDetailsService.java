package com.Monty.Ecommerce.PurchaseDetails.Service;

import com.Monty.Ecommerce.OrderDetails.Entity.OrderDetails;
import com.Monty.Ecommerce.PurchaseDetails.Entity.PurchaseDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PurchaseDetailsService {

    List<PurchaseDetails> getAllPurchaseDetails();

    PurchaseDetails findPurchaseDetailsById(UUID id);

    PurchaseDetails createPurchaseDetails(PurchaseDetails purchaseDetails);

    ResponseEntity<PurchaseDetails> getPurchaseDetailsId(UUID id);

    ResponseEntity<PurchaseDetails> updatePurchaseDetails(UUID id, PurchaseDetails purchaseDetails);

    ResponseEntity<Map<String, Boolean>> deletePurchaseDetails(UUID id);

    ResponseEntity<Map<String, Boolean>> deleteAllPurchaseDetails();
}