package com.Monty.Ecommerce.Vendor.Service.ServiceImpl;

import com.Monty.Ecommerce.Vendor.Entity.Vendor;
import com.Monty.Ecommerce.Vendor.Repository.VendorRepository;
import com.Monty.Ecommerce.Vendor.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Override
    public List<Vendor> getAllVendor() {
        return vendorRepository.findAll();
    }

    @Override
    public List<Vendor> getVendorByName(String vendorName) {
        return vendorRepository.findByVendorName(vendorName);
    }

    @Override
    public ResponseEntity<Vendor> getVendorId(UUID id) {
        Vendor vendor = vendorRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));
        return ResponseEntity.ok(vendor);
    }

    @Override
    public Vendor createVendor(Vendor vendor) {
        Calendar dateCreated = Calendar.getInstance();
        vendor.setDateCreated(dateCreated);
        return vendorRepository.save(vendor);
    }

    @Override
    public ResponseEntity<Vendor> updateVendor(UUID id, Vendor vendor) {

        Vendor ven = vendorRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        ven.setVendorName(vendor.getVendorName());
        ven.setActive(vendor.isActive());
        ven.setDateCreated(vendor.getDateCreated());
        Calendar dateUpdated = Calendar.getInstance();
        ven.setDateUpdated(dateUpdated);
        Vendor updateVendor = vendorRepository.save(ven);
        return ResponseEntity.ok(updateVendor);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteVendor(UUID id) {
        Vendor vendor = vendorRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        vendorRepository.delete(vendor);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteAllVendor() {
        vendorRepository.deleteAll();

        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public Vendor findVendor(UUID id) {
        Vendor vendor = vendorRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));
        return vendor;
    }
}
