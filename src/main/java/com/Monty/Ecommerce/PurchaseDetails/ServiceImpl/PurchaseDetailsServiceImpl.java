package com.Monty.Ecommerce.PurchaseDetails.ServiceImpl;

import com.Monty.Ecommerce.PurchaseDetails.Entity.PurchaseDetails;
import com.Monty.Ecommerce.PurchaseDetails.Repository.PurchaseDetailsRepository;
import com.Monty.Ecommerce.PurchaseDetails.Service.PurchaseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PurchaseDetailsServiceImpl implements PurchaseDetailsService {

    @Autowired
    PurchaseDetailsRepository purchaseDetailsRepository;

    @Override
    public List<PurchaseDetails> getAllPurchaseDetails() {
        return purchaseDetailsRepository.findAll();
    }

    @Override
    public PurchaseDetails findPurchaseDetailsById(UUID id) {
        PurchaseDetails purchaseDetails = purchaseDetailsRepository.findById(id);
        return purchaseDetails;
    }

    @Override
    public PurchaseDetails createPurchaseDetails(PurchaseDetails purchaseDetails) {
        Calendar dateCreated = Calendar.getInstance();
        purchaseDetails.setDateCreated(dateCreated);
        return purchaseDetailsRepository.save(purchaseDetails);
    }

    @Override
    public ResponseEntity<PurchaseDetails> getPurchaseDetailsId(UUID id) {
        PurchaseDetails purchaseDetails = purchaseDetailsRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("DeliveryDriver doesn't exist with id: " + id));
        return ResponseEntity.ok(purchaseDetails);
    }

    @Override
    public ResponseEntity<PurchaseDetails> updatePurchaseDetails(UUID id, PurchaseDetails purchaseDetails) {
        PurchaseDetails pur = purchaseDetailsRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        //pur.setPrice(purchaseDetails.getPrice());
        pur.setQuantity(purchaseDetails.getQuantity());
        pur.setDiscount(purchaseDetails.getDiscount());
        pur.setTax(purchaseDetails.getTax());
        pur.setTotal(purchaseDetails.getTotal());
        pur.setActive(purchaseDetails.isActive());
        pur.setDateCreated(purchaseDetails.getDateCreated());
        Calendar dateUpdated = Calendar.getInstance();
        pur.setDateUpdated(dateUpdated);
        pur.setPurchase(purchaseDetails.getPurchase());
        pur.setProductId(purchaseDetails.getProductId());
        PurchaseDetails updatePurchaseDetails = purchaseDetailsRepository.save(pur);
        return ResponseEntity.ok(updatePurchaseDetails);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deletePurchaseDetails(UUID id) {
        PurchaseDetails purchaseDetails = purchaseDetailsRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        purchaseDetailsRepository.delete(purchaseDetails);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteAllPurchaseDetails() {
        purchaseDetailsRepository.deleteAll();

        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}
