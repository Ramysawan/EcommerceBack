package com.Monty.Ecommerce.Vendor.Controller;

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
public class VendorController {

    @Autowired
    VendorService vendorService;

    //get all vendors
    @GetMapping("/vendor")
    public List<Vendor> getAllVendor(){
        return vendorService.getAllVendor();
    }

    //get one vendor by id
    @GetMapping("/vendor/{id}")
    public ResponseEntity<Vendor> getVendorId(@PathVariable UUID id){
        return vendorService.getVendorId(id);
    }

    //get vendor by name
    @GetMapping("/vendor/vn/{vendorName}")
    public List<Vendor> getVendorByName(@PathVariable String vendorName){

        return vendorService.getVendorByName(vendorName);
    }

    //create one vendor
    @PostMapping("/vendor")
    public Vendor createVendor(@RequestBody Vendor vendor){
        return vendorService.createVendor(vendor);
    }

    //update one vendor
    @PutMapping("/vendor/{id}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable UUID id, @RequestBody Vendor vendorDetails){
        return vendorService.updateVendor(id, vendorDetails);
    }

    //delete one vendor
    @DeleteMapping("/vendor/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteVendor(@PathVariable UUID id){
        return vendorService.deleteVendor(id);
    }

    //delete all vendors
    @DeleteMapping("/vendor")
    public ResponseEntity<Map<String, Boolean>> deleteAllVendor(){
        return vendorService.deleteAllVendor();
    }

}

