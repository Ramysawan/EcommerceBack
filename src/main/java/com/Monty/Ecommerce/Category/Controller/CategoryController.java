package com.Monty.Ecommerce.Category.Controller;

import com.Monty.Ecommerce.Category.Entity.Category;
import com.Monty.Ecommerce.Category.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    //get all Category    ************************************************************************************************
    @GetMapping("/category")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    //get one Category by id    ******************************************************************************************
    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryId(@PathVariable UUID id){
        return categoryService.getCategoryId(id);
    }

    //get Category by name    ********************************************************************************************
    @GetMapping("/category/cat/{title}")
    public List<Category> getCategoryByName(@PathVariable String title){
        return categoryService.getCategoryByName(title);
    }

    //create one Category    *********************************************************************************************
    @PostMapping("/category")
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    //update one Category    *********************************************************************************************
    @PutMapping("/category/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable UUID id, @RequestBody Category categoryDetails){
        return categoryService.updateCategory(id, categoryDetails);
    }

    //delete one Category    *********************************************************************************************
    @DeleteMapping("/category/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCategory(@PathVariable UUID id){
        return categoryService.deleteCategory(id);
    }

    //delete all Category    *********************************************************************************************
    @DeleteMapping("/category")
    public ResponseEntity<Map<String, Boolean>> deleteAllCategory(){
        return categoryService.deleteAllCategory();
    }

    //create category and a parent category for it    *********************************************************************
    @PostMapping("/category/{categoryId}")
    public Category createComment(@PathVariable (value = "categoryId") UUID parentCategoryId, @RequestBody Category category) {
        Category cat = categoryService.findCategory(parentCategoryId);
        List<Category> categories = cat.getSubCategories();
        if(!isCategoryExist(categories, category)){
            categories.add(category);
            cat.setSubCategories(categories);
        }
        return categoryService.createCategory(category);
    }
    
    //delete category from list of categories    ***************************************************************************
    @DeleteMapping("/category/{categoryId}/categorydelete/{deletedCategoryId}")
    public Category daleteComment(@PathVariable (value = "categoryId") UUID parentCategoryId,
            @PathVariable (value = "deletedCategoryId") UUID deletedCategoryId) {
        
        Category cat = categoryService.findCategory(parentCategoryId);
        Category delcat = categoryService.findCategory(deletedCategoryId);
        List<Category> categories = cat.getSubCategories();
        if(isCategoryExist(categories, delcat)){
            categories.remove(delcat);
            cat.setSubCategories(categories);
        }
        return categoryService.updateListCategory(parentCategoryId, cat);
    }
    
    public boolean isCategoryExist(List<Category> currentCategories, Category category){
        for(int i = 0 ; i < currentCategories.size() ; i++){
            if(currentCategories.get(i).getCategoryId().equals(category.getCategoryId())){
                System.out.println("The category " + category.getTitle() + " exists");
                return true;
            }
            else{
                System.out.println("The category " + category.getTitle() + " doesn't exist");
            }
        }
        return false;
    }

}

