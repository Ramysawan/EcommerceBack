package com.Monty.Ecommerce.Purchase.Controller;

import com.Monty.Ecommerce.Purchase.Entity.Purchase;
import com.Monty.Ecommerce.Purchase.Service.PurchaseService;
import com.Monty.Ecommerce.Shipment.Entity.Shipment;
import com.Monty.Ecommerce.Shipment.Service.ShipmentService;
import com.Monty.Ecommerce.Vendor.Entity.Vendor;
import com.Monty.Ecommerce.Vendor.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    VendorService vendorService;

    @Autowired
    ShipmentService shipmentService;

    //get all purchase    ************************************************************************************************
    @GetMapping("/purchase")
    public List<Purchase> getAllPurchase(){
        return purchaseService.getAllPurchase();
    }

    //get one purchase by id    ******************************************************************************************
    @GetMapping("/purchase/{id}")
    public ResponseEntity<Purchase> getPurchaseId(@PathVariable UUID id){
        return purchaseService.getPurchaseId(id);
    }

    //get purchase by number    ******************************************************************************************
    @GetMapping("/purchase/ord/{orderNumber}")
    public List<Purchase> getPurchaserByOrderNumber(@PathVariable long orderNumber){
        return purchaseService.getPurchaseByOrderNumber(orderNumber);
    }

    //create one purchase    *********************************************************************************************
    @PostMapping("/purchase")
    public Purchase createPurchase(@RequestBody Purchase purchase){
        return purchaseService.createPurchase(purchase);
    }

    //update one purchase    *********************************************************************************************
    @PutMapping("/purchase/{id}")
    public ResponseEntity<Purchase> updatePurchase(@PathVariable UUID id, @RequestBody Purchase purchaseDetails){
        return purchaseService.updatePurchase(id, purchaseDetails);
    }

    //delete one purchase    *********************************************************************************************
    @DeleteMapping("/purchase/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePurchase(@PathVariable UUID id){
        return purchaseService.deletePurchase(id);
    }

    //delete all purchase    *********************************************************************************************
    @DeleteMapping("/purchase")
    public ResponseEntity<Map<String, Boolean>> deleteAllPurchase(){
        return purchaseService.deleteAllPurchase();
    }

    //create new purchase with shipment    *******************************************************************************
    @PostMapping("/shipmentPurchase/{shipmentId}")
    public Purchase createComments(@PathVariable (value = "shipmentId") UUID shipmentId, @RequestBody Purchase purchase) {
        Shipment shipment = shipmentService.findShipmentById(shipmentId);
        purchase.setShipment(shipment);
        return purchaseService.createPurchase(purchase);
    }

    //create new purchase with vendor    *********************************************************************************
    @PostMapping("/vendorPurchase/{vendorId}")
    public Purchase createComments1(@PathVariable (value = "vendorId") UUID vendorId, @RequestBody Purchase purchase) {
        Vendor vendor = vendorService.findVendor(vendorId);
        purchase.setVendor(vendor);
        return purchaseService.createPurchase(purchase);
    }
    
    //update shipment of purchase    *************************************************************************************
    @PutMapping("/purchase/{purchaseId}/shipment/{shipmentId}")
    public ResponseEntity<Purchase> updateComments(@PathVariable (value = "purchaseId") UUID purchaseId,
                                                   @PathVariable (value = "shipmentId") UUID shipmentId, @RequestBody Purchase purchase) {

        Shipment shipment = shipmentService.findShipmentById(shipmentId);
        Purchase pur = purchaseService.findPurchaseById(purchaseId);
        purchase.setVendor(purchase.getVendor());
        purchase.setShipment(shipment);
        return purchaseService.updatePurchase(purchaseId, purchase);
    }
    
    //update vendor of purchase    ***************************************************************************************
    @PutMapping("/purchase/{purchaseId}/vendor/{vendorId}")
    public ResponseEntity<Purchase> updateComments1(@PathVariable (value = "vendorId") UUID vendorId,
                                                    @PathVariable (value = "purchaseId") UUID purchaseId, @RequestBody Purchase purchase) {

        Vendor vendor = vendorService.findVendor(vendorId);
        Purchase pur = purchaseService.findPurchaseById(purchaseId);
        purchase.setShipment(pur.getShipment());
        purchase.setVendor(vendor);
        return purchaseService.updatePurchase(purchaseId, purchase);
    }


}