package com.Monty.Ecommerce.Purchase.Service;

import com.Monty.Ecommerce.Orders.Entity.Orders;
import com.Monty.Ecommerce.Purchase.Entity.Purchase;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PurchaseService {

    List<Purchase> getAllPurchase();

    Purchase findPurchaseById(UUID id);

    Purchase createPurchase(Purchase purchase);

    ResponseEntity<Purchase> getPurchaseId(UUID id);

    ResponseEntity<Purchase> updatePurchase(UUID id, Purchase purchase);

    ResponseEntity<Map<String, Boolean>> deletePurchase(UUID id);

    ResponseEntity<Map<String, Boolean>> deleteAllPurchase();

    List<Purchase> getPurchaseByOrderNumber(long orderNumber);
}