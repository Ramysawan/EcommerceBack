package com.Monty.Ecommerce.Category.ServiceImpl;

import com.Monty.Ecommerce.Category.Entity.Category;
import com.Monty.Ecommerce.Category.Repository.CategoryRepository;
import com.Monty.Ecommerce.Category.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getCategoryByName(String title) {
        return categoryRepository.findByCategoryName(title);
    }

    @Override
    public ResponseEntity<Category> getCategoryId(UUID id) {
        Category category = categoryRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));
        return ResponseEntity.ok(category);
    }

    @Override
    public Category createCategory(Category category) {
        Calendar dateCreated = Calendar.getInstance();
        category.setDateCreated(dateCreated);
        return categoryRepository.save(category);
    }

    @Override
    public ResponseEntity<Category> updateCategory(UUID id, Category category) {
        Category cat = categoryRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        cat.setTitle(category.getTitle());
        cat.setDescription(category.getDescription());
        cat.setActive(category.isActive());
        cat.setDateCreated(category.getDateCreated());
        Calendar dateUpdated = Calendar.getInstance();
        cat.setDateUpdated(dateUpdated);
        cat.setSubCategories(category.getSubCategories());

        Category updateCategory = categoryRepository.save(cat);
        return ResponseEntity.ok(updateCategory);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteCategory(UUID id) {
        Category category = categoryRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        categoryRepository.delete(category);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteAllCategory() {
        categoryRepository.deleteAll();

        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @Override
    public Category findCategory(UUID id) {
        Category category = categoryRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));
        return category;
    }

    @Override
    public Category updateListCategory(UUID id, Category category) {
        Category cat = categoryRepository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Address doesn't exist with id: " + id));

        cat.setTitle(category.getTitle());
        cat.setDescription(category.getDescription());
        cat.setActive(category.isActive());
        cat.setDateCreated(category.getDateCreated());
        Calendar dateUpdated = Calendar.getInstance();
        cat.setDateUpdated(dateUpdated);
        cat.setSubCategories(category.getSubCategories());

        Category updateCategory = categoryRepository.save(cat);
        return updateCategory;
    }
}
