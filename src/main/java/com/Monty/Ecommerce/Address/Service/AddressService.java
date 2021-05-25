package com.Monty.Ecommerce.Address.Service;

import com.Monty.Ecommerce.Address.Entity.Address;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface AddressService {
    
    List<Address> getAllAddress();
    
    Address createAddress(Address address);
    
    ResponseEntity<Address> getAddressId(UUID id);
    
    ResponseEntity<Address> updateAddress(UUID id, Address address);
    
    ResponseEntity<Map<String, Boolean>> deleteAddress(UUID id);
    
    ResponseEntity<Map<String, Boolean>> deleteAllAddress();
    
    List<Address> getAddressByAddressName(String name);
    
    List<Address> getAddressByCountry(String country);
    
    List<Address> getAddressByCity(String city);
    
    List<Address> getAddressByState(String state);
}
