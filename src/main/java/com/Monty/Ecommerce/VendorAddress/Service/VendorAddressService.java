package com.Monty.Ecommerce.VendorAddress.Service;

import com.Monty.Ecommerce.Address.Entity.Address;
import com.Monty.Ecommerce.VendorAddress.Entity.VendorAddress;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface VendorAddressService {

    List<VendorAddress> getAllVendorAddress();

    VendorAddress createVendorAddress(VendorAddress vendorAddress);

    ResponseEntity<VendorAddress> getVendorAddressId(UUID id);

    ResponseEntity<VendorAddress> updateVendorAddress(UUID id, VendorAddress vendorAddress);

    ResponseEntity<Map<String, Boolean>> deleteVendorAddress(UUID id);

    ResponseEntity<Map<String, Boolean>> deleteAllVendorAddress();

    List<VendorAddress> getVendorAddressByAddressName(String name);

    List<VendorAddress> getVendorAddressByCountry(String country);

    List<VendorAddress> getVendorAddressByCity(String city);

    List<VendorAddress> getVendorAddressByState(String state);
}
