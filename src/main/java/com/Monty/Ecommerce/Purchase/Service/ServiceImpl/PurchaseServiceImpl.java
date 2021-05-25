package com.Monty.Ecommerce.Purchase.Service.ServiceImpl;

import com.Monty.Ecommerce.Purchase.Entity.Purchase;
import com.Monty.Ecommerce.Purchase.Repository.PurchaseRepository;
import com.Monty.Ecommerce.Purchase.Service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Override
    public List<Purchase> getAllPurchase() {
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase findPurchaseById(UUID id) {
        Purchase purchase = purchaseRepository.findById(id);
        return purchase;
    }

    @Override
    public Purchase createPurchase(Purchase purchase) {
        Calendar dateCreated = Calendar.getInstance();
        purchase.setDateCreated(dateCreated);
        return purchaseRepository.save(purchase);
    }

    @Override
    public ResponseEntity<Purchase> getPurchaseId(UUID id) {
        Purchase purchase = purchaseRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("DeliveryDriver doesn't exist with id: " + id));
        return ResponseEntity.ok(purchase);
    }

    @Override
    public ResponseEntity<Purchase> updatePurchase(UUID id, Purchase purchase) {
        Purchase pur = purchaseRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        pur.setOrderNumber(purchase.getOrderNumber());
        pur.setOrderDatePlaced(purchase.getOrderDatePlaced());
        pur.setTransactionStatus(purchase.getTransactionStatus());
        pur.setShipped(purchase.isShipped());
        pur.setActive(purchase.isActive());
        pur.setDateCreated(purchase.getDateCreated());
        pur.setChannelType(purchase.getChannelType());
        Calendar dateUpdated = Calendar.getInstance();
        pur.setDateUpdated(dateUpdated);
        pur.setVendor(purchase.getVendor());
        pur.setShipment(purchase.getShipment());
        Purchase updatePurchase = purchaseRepository.save(pur);
        return ResponseEntity.ok(updatePurchase);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deletePurchase(UUID id) {
        Purchase purchase = purchaseRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        purchaseRepository.delete(purchase);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteAllPurchase() {
        purchaseRepository.deleteAll();

        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public List<Purchase> getPurchaseByOrderNumber(long orderNumber) {
        return purchaseRepository.findByPurchaseNumber(orderNumber);
    }
}
