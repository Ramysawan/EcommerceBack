package com.Monty.Ecommerce.VendorAddress.Controller;

import com.Monty.Ecommerce.Vendor.Entity.Vendor;
import com.Monty.Ecommerce.Vendor.Service.VendorService;
import com.Monty.Ecommerce.VendorAddress.Entity.VendorAddress;
import com.Monty.Ecommerce.VendorAddress.Service.VendorAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class VendorAddressController {

    @Autowired
    VendorAddressService vendorAddressService;

    @Autowired
    private VendorService vendorService;

    //get all address    *********************************************************************************************************
    @GetMapping("/vendoraddress")
    public List<VendorAddress> getAllVendorAddress(){
        return vendorAddressService.getAllVendorAddress();
    }

    //get one address by id    ***************************************************************************************************
    @GetMapping("/vendoraddress/{id}")
    public ResponseEntity<VendorAddress> getVendorAddressId(@PathVariable UUID id){
        return vendorAddressService.getVendorAddressId(id);
    }

    //create one address    ******************************************************************************************************
    @PostMapping("/vendoraddress")
    public VendorAddress createVendorAddress(@RequestBody VendorAddress vendorAddress){
        return vendorAddressService.createVendorAddress(vendorAddress);
    }

    //update one address    ******************************************************************************************************
    @PutMapping("/vendoraddress/{id}")
    public ResponseEntity<VendorAddress> updateVendorAddress(@PathVariable UUID id, @RequestBody VendorAddress vendorAddressDetails){
        return vendorAddressService.updateVendorAddress(id, vendorAddressDetails);
    }

    //delete one address    ******************************************************************************************************
    @DeleteMapping("/vendoraddress/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteVendorAddress(@PathVariable UUID id){
        return vendorAddressService.deleteVendorAddress(id);
    }

    //delete all address    ******************************************************************************************************
    @DeleteMapping("/vendoraddress")
    public ResponseEntity<Map<String, Boolean>> deleteAllVendorAddress(){
        return vendorAddressService.deleteAllVendorAddress();
    }

    //get address by nameAddress    **********************************************************************************************
    @GetMapping("/vendoraddress/add/{name}")
    public List<VendorAddress> getVendorAddressByAddressName(@PathVariable String name){
        return vendorAddressService.getVendorAddressByAddressName(name);
    }

    //get address by country    **************************************************************************************************
    @GetMapping("/vendoraddress/country/{country}")
    public List<VendorAddress> getVendorAddressByCountry(@PathVariable String country){
        return vendorAddressService.getVendorAddressByCountry(country);
    }

    //get address by city    *****************************************************************************************************
    @GetMapping("/vendoraddress/city/{city}")
    public List<VendorAddress> getVendorAddressByCity(@PathVariable String city){
        return vendorAddressService.getVendorAddressByCity(city);
    }

    //get address by state    ****************************************************************************************************
    @GetMapping("/vendoraddress/state/{state}")
    public List<VendorAddress> getVendorAddressByState(@PathVariable String state){
        return vendorAddressService.getVendorAddressByState(state);
    }

    //add vendor to an address    ************************************************************************************************
    @PostMapping("/vendor/{vendorId}")
    public VendorAddress createComment(@PathVariable (value = "vendorId") UUID vendorId, @RequestBody VendorAddress vendorAddress) {
        Vendor vendor = vendorService.findVendor(vendorId);

        vendorAddress.setVendor(vendor);
        return vendorAddressService.createVendorAddress(vendorAddress);
        //}).orElseThrow(() -> new ResourceNotFoundException("PostId " + vendorId + " not found"));
    }


}

