package com.Monty.Ecommerce.Product.Repository;

import com.Monty.Ecommerce.Category.Entity.Category;
import com.Monty.Ecommerce.Product.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, Serializable> {

    @Query("select b from Product b where b.productId = ?1")
    Product findById(UUID id);

    @Query("select b from Product b where b.title like %?1%")
    List<Product> findByProductName(String title);
}
