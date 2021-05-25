package com.Monty.Ecommerce.VendorAddress.ServiceImpl;

import com.Monty.Ecommerce.VendorAddress.Entity.VendorAddress;
import com.Monty.Ecommerce.VendorAddress.Repository.VendorAddressRepository;
import com.Monty.Ecommerce.VendorAddress.Service.VendorAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class VendorAddressServiceImpl implements VendorAddressService {

    @Autowired
    private VendorAddressRepository vendorAddressRepository;

    @Override
    public List<VendorAddress> getAllVendorAddress() {
        return vendorAddressRepository.findAll();
    }

    @Override
    public VendorAddress createVendorAddress(@RequestBody VendorAddress vendorAddress){
        Calendar dateCreated = Calendar.getInstance();
        vendorAddress.setDateCreated(dateCreated);
        return vendorAddressRepository.save(vendorAddress);
    }

    @Override
    public ResponseEntity<VendorAddress> getVendorAddressId(@PathVariable UUID id) {
        VendorAddress vendorAddress = vendorAddressRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));
        return ResponseEntity.ok(vendorAddress);
    }

    @Override
    public ResponseEntity<VendorAddress> updateVendorAddress(@PathVariable UUID id, @RequestBody VendorAddress vendorAddress) {
        VendorAddress add = vendorAddressRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        add.setAddress1(vendorAddress.getAddress1());
        add.setAddress2(vendorAddress.getAddress2());
        add.setAddress3(vendorAddress.getAddress3());
        add.setCountry(vendorAddress.getCountry());
        add.setState(vendorAddress.getState());
        add.setCity(vendorAddress.getCity());
        add.setPostalCode(vendorAddress.getPostalCode());
        add.setAdditionnalDescription(vendorAddress.getAdditionnalDescription());
        add.setActive(vendorAddress.isActive());
        add.setDateCreated(vendorAddress.getDateCreated());
        Calendar dateUpdated = Calendar.getInstance();
        add.setDateUpdated(dateUpdated);
        add.setTitle(vendorAddress.getTitle());
        add.setVendor(vendorAddress.getVendor());
        VendorAddress updateVendorAddress = vendorAddressRepository.save(add);
        return ResponseEntity.ok(updateVendorAddress);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteVendorAddress(@PathVariable UUID id) {
        VendorAddress vendorAddress = vendorAddressRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        vendorAddressRepository.delete(vendorAddress);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteAllVendorAddress() {
        vendorAddressRepository.deleteAll();

        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public List<VendorAddress> getVendorAddressByAddressName(String name) {
        return vendorAddressRepository.findByVendorAddressName(name);
    }

    @Override
    public List<VendorAddress> getVendorAddressByCountry(String country) {
        return vendorAddressRepository.findByCountry(country);
    }

    @Override
    public List<VendorAddress> getVendorAddressByCity(String city) {
        return vendorAddressRepository.findByCity(city);
    }

    @Override
    public List<VendorAddress> getVendorAddressByState(String state) {
        return vendorAddressRepository.findByState(state);
    }

}
