package com.Monty.Ecommerce.Category.Repository;

import com.Monty.Ecommerce.Category.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, Serializable> {

    @Query("select b from Category b where b.categoryId = ?1")
    Category findById(UUID id);

    @Query("select b from Category b where b.title like %?1%")
    List<Category> findByCategoryName(String title);
}
