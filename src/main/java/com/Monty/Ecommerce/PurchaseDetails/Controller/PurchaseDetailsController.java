package com.Monty.Ecommerce.PurchaseDetails.Controller;

import com.Monty.Ecommerce.Product.Entity.Product;
import com.Monty.Ecommerce.Product.Service.ProductService;
import com.Monty.Ecommerce.Purchase.Entity.Purchase;
import com.Monty.Ecommerce.Purchase.Service.PurchaseService;
import com.Monty.Ecommerce.PurchaseDetails.Entity.PurchaseDetails;
import com.Monty.Ecommerce.PurchaseDetails.Service.PurchaseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class PurchaseDetailsController {

    @Autowired
    PurchaseDetailsService purchaseDetailsService;

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    ProductService productService;

    //get all purchase details    ***************************************************************************************************
    @GetMapping("/purchasedetails")
    public List<PurchaseDetails> getAllPurchaseDetails(){
        return purchaseDetailsService.getAllPurchaseDetails();
    }

    //get one Purchase Details by id    *********************************************************************************************
    @GetMapping("/purchasedetails/{id}")
    public ResponseEntity<PurchaseDetails> getPurchaseDetailsId(@PathVariable UUID id){
        return purchaseDetailsService.getPurchaseDetailsId(id);
    }

    //create one Purchase Details    ************************************************************************************************
    @PostMapping("/purchasedetails")
    public PurchaseDetails createPurchaseDetails(@RequestBody PurchaseDetails purchaseDetails){
        return purchaseDetailsService.createPurchaseDetails(purchaseDetails);
    }

    //update one Purchase Details    ************************************************************************************************
    @PutMapping("/purchasedetails/{id}")
    public ResponseEntity<PurchaseDetails> updatePurchaseDetails(@PathVariable UUID id, @RequestBody PurchaseDetails purchaseDetails){
        return purchaseDetailsService.updatePurchaseDetails(id, purchaseDetails);
    }

    //delete one Purchase Details    ************************************************************************************************
    @DeleteMapping("/purchasedetails/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePurchaseDetails(@PathVariable UUID id){
        return purchaseDetailsService.deletePurchaseDetails(id);
    }

    //delete all Purchase Details    ************************************************************************************************
    @DeleteMapping("/purchasedetails")
    public ResponseEntity<Map<String, Boolean>> deleteAllPurchaseDetails(){
        return purchaseDetailsService.deleteAllPurchaseDetails();
    }

    //add new purchase details with product    **************************************************************************************
    @PostMapping("/productPurchaseDetails/{productId}")
    public PurchaseDetails createComments(@PathVariable (value = "productId") UUID productId, @RequestBody PurchaseDetails purchaseDetails) {
        Product product = productService.findProductById(productId);
        purchaseDetails.setProductId(product);
        return purchaseDetailsService.createPurchaseDetails(purchaseDetails);
    }

    //add new purchase details with purchase    *************************************************************************************
    @PostMapping("/purchasePurchaseDetails/{purchaseId}")
    public PurchaseDetails createComments1(@PathVariable (value = "purchaseId") UUID purchaseId, @RequestBody PurchaseDetails purchaseDetails) {
        Purchase purchase = purchaseService.findPurchaseById(purchaseId);
        purchaseDetails.setPurchase(purchase);
        return purchaseDetailsService.createPurchaseDetails(purchaseDetails);
    }

    //update product of purchase details
    @PutMapping("/purchasedetails/{purchaseDetailsId}/product/{productId}")
    public ResponseEntity<PurchaseDetails> updateComments(@PathVariable (value = "purchaseDetailsId") UUID purchaseDetailsId,
                                                       @PathVariable (value = "productId") UUID productId, @RequestBody PurchaseDetails purchaseDetails) {

        Product product = productService.findProductById(productId);
        PurchaseDetails pur = purchaseDetailsService.findPurchaseDetailsById(purchaseDetailsId);
        pur.setProductId(product);
        return purchaseDetailsService.updatePurchaseDetails(purchaseDetailsId, pur);
    }

    //update purchase of purchase details 
    @PutMapping("/purchasedetails/{purchaseDetailsId}/purchase/{purchaseId}")
    public ResponseEntity<PurchaseDetails> updateComments1(@PathVariable (value = "purchaseDetailsId") UUID purchaseDetailsId,
                                                        @PathVariable (value = "purchaseId") UUID purchaseId, @RequestBody PurchaseDetails purchaseDetails) {

        Purchase purchase = purchaseService.findPurchaseById(purchaseId);
        PurchaseDetails pur = purchaseDetailsService.findPurchaseDetailsById(purchaseDetailsId);
        pur.setPurchase(purchase);
        return purchaseDetailsService.updatePurchaseDetails(purchaseDetailsId, pur);
    }
}
