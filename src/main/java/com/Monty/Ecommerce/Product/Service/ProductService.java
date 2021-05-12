package com.Monty.Ecommerce.Product.Service;

import com.Monty.Ecommerce.Product.Entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ProductService {

    List<Product> getAllProduct();

    Product findProductById(UUID id);

    Product createProduct(Product product);

    ResponseEntity<Product> getProductId(UUID id);

    ResponseEntity<Product> updateProduct(UUID id, Product product);

    ResponseEntity<Map<String, Boolean>> deleteProduct(UUID id);

    ResponseEntity<Map<String, Boolean>> deleteAllProduct();

    List<Product> getProductByName(String title);

}
