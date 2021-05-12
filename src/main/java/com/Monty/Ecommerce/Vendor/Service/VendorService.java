package com.Monty.Ecommerce.Vendor.Service;

import com.Monty.Ecommerce.Brand.Entity.Brand;
import com.Monty.Ecommerce.Vendor.Entity.Vendor;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface VendorService {

    List<Vendor> getAllVendor();

    List<Vendor> getVendorByName(String vendorName);

    ResponseEntity<Vendor> getVendorId(UUID id);

    Vendor createVendor(Vendor vendor);

    Vendor findVendor(UUID id);

    ResponseEntity<Vendor> updateVendor(UUID id, Vendor vendor);

    ResponseEntity<Map<String, Boolean>> deleteVendor(UUID id);

    ResponseEntity<Map<String, Boolean>> deleteAllVendor();

}
