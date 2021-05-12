package com.Monty.Ecommerce.Category.Service;

import com.Monty.Ecommerce.Category.Entity.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface CategoryService {

    List<Category> getAllCategory();

    List<Category> getCategoryByName(String title);

    ResponseEntity<Category> getCategoryId(UUID id);

    Category createCategory(Category category);

    ResponseEntity<Category> updateCategory(UUID id, Category category);

    ResponseEntity<Map<String, Boolean>> deleteCategory(UUID id);

    ResponseEntity<Map<String, Boolean>> deleteAllCategory();

    Category findCategory(UUID id);
    
    Category updateListCategory(UUID id, Category category);
}
