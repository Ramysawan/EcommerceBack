package com.Monty.Ecommerce.Product.Service.ServiceImpl;

import com.Monty.Ecommerce.Product.Entity.Product;
import com.Monty.Ecommerce.Product.Repository.ProductRepository;
import com.Monty.Ecommerce.Product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(UUID id) {
        Product product = productRepository.findById(id);
        return product;
    }

    @Override
    public Product createProduct(Product product) {
        Calendar dateCreated = Calendar.getInstance();
        product.setDateCreated(dateCreated);
        return productRepository.save(product);
    }

    @Override
    public ResponseEntity<Product> getProductId(UUID id) {
        Product product = productRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("DeliveryDriver doesn't exist with id: " + id));
        return ResponseEntity.ok(product);
    }

    @Override
    public ResponseEntity<Product> updateProduct(UUID id, Product product) {
        Product prod = productRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        prod.setTitle(product.getTitle());
        prod.setDescription(product.getDescription());
        prod.setBarcode(product.getBarcode());
        prod.setPrice(product.getPrice());
        prod.setWeight(product.getWeight());
        prod.setStock(product.getStock());
        prod.setPhotoURL(product.getPhotoURL());
        //prod.setPriceAfterDiscount(product.getPriceAfterDiscount());
        prod.setAvailableSize(product.getAvailableSize());
        prod.setAvailableColor(product.getAvailableColor());
        prod.setActive(product.isActive());
        prod.setDateCreated(product.getDateCreated());
        
        Calendar dateUpdated = Calendar.getInstance();
        prod.setDateUpdated(dateUpdated);
        
        prod.setBrand(product.getBrand());
        prod.setCategory(product.getCategory());
        prod.setVendor(product.getVendor());
        
        Product updateProduct = productRepository.save(prod);
        return ResponseEntity.ok(updateProduct);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteProduct(UUID id) {
        Product product = productRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        productRepository.delete(product);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteAllProduct() {
        productRepository.deleteAll();

        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public List<Product> getProductByName(String title) {
        return productRepository.findByProductName(title);
    }
}
