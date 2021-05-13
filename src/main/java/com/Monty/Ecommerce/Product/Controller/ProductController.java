package com.Monty.Ecommerce.Product.Controller;

import com.Monty.Ecommerce.Brand.Entity.Brand;
import com.Monty.Ecommerce.Brand.Service.BrandService;
import com.Monty.Ecommerce.Category.Entity.Category;
import com.Monty.Ecommerce.Category.Service.CategoryService;
import com.Monty.Ecommerce.Product.Entity.Product;
import com.Monty.Ecommerce.Product.Service.ProductService;
import com.Monty.Ecommerce.Vendor.Entity.Vendor;
import com.Monty.Ecommerce.Vendor.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    BrandService brandService;

    @Autowired
    VendorService vendorService;

    //get all products    **********************************************************************************************************
    @GetMapping("/product")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    //get one product by id    *****************************************************************************************************
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductId(@PathVariable UUID id){
        return productService.getProductId(id);
    }

    //get product by title    ******************************************************************************************************
    @GetMapping("/product/prod/{title}")
    public List<Product> getProductByName(@PathVariable String title){
        return productService.getProductByName(title);
    }

    //create one product    ********************************************************************************************************
    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    //update one product    ********************************************************************************************************
    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable UUID id, @RequestBody Product productDetails){
        return productService.updateProduct(id, productDetails);
    }

    //delete one product    ********************************************************************************************************
    @DeleteMapping("/product/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable UUID id){
        return productService.deleteProduct(id);
    }

    //delete all product    ********************************************************************************************************
    @DeleteMapping("/product")
    public ResponseEntity<Map<String, Boolean>> deleteAllProduct(){
        return productService.deleteAllProduct();
    }

    //add new product with brand    ************************************************************************************************
    @PostMapping("/brandProduct/{brandId}")
    public Product createComment(@PathVariable (value = "brandId") UUID brandId, @RequestBody Product product) {
        Brand brand = brandService.findBrand(brandId);
        product.setBrand(brand);
        return productService.createProduct(product);
        //}).orElseThrow(() -> new ResourceNotFoundException("PostId " + vendorId + " not found"));
    }
    
    //add new product with category    *********************************************************************************************
    @PostMapping("/categoryProduct/{categoryId}")
    public Product createComment1(@PathVariable (value = "categoryId") UUID categoryId, @RequestBody Product product) {
        Category category = categoryService.findCategory(categoryId);
        product.setCategory(category);
        return productService.createProduct(product);
        //}).orElseThrow(() -> new ResourceNotFoundException("PostId " + vendorId + " not found"));
    }
    
    //add new product with vendor    ***********************************************************************************************
    @PostMapping("/vendorProduct/{vendorId}")
    public Product createComment2(@PathVariable (value = "vendorId") UUID vendorId, @RequestBody Product product) {
        Vendor vendor = vendorService.findVendor(vendorId);
        product.setVendor(vendor);
        return productService.createProduct(product);
        //}).orElseThrow(() -> new ResourceNotFoundException("PostId " + vendorId + " not found"));
    }

    //update brand of a product    *************************************************************************************************
    @PutMapping("/product/{productId}/brand/{brandId}")
    public ResponseEntity<Product> updateComment(@PathVariable (value = "productId") UUID productId,
                                                  @PathVariable (value = "brandId") UUID brandId, @RequestBody Product product) {

        Brand brand = brandService.findBrand(brandId);
        Product prod = productService.findProductById(productId);
        product.setBrand(brand);
        product.setCategory(prod.getCategory());
        product.setVendor(prod.getVendor());
        return productService.updateProduct(productId, product);
    }
    
    //update category of a product    **********************************************************************************************
    @PutMapping("/product/{productId}/category/{categoryId}")
    public ResponseEntity<Product> updateComment1(@PathVariable (value = "productId") UUID productId,
                                                 @PathVariable (value = "categoryId") UUID categoryId, @RequestBody Product product) {

        Category category = categoryService.findCategory(categoryId);
        Product prod = productService.findProductById(productId);
        product.setBrand(prod.getBrand());
        product.setCategory(category);
        product.setVendor(prod.getVendor());
        return productService.updateProduct(productId, product);
    }
    
    //update vendor of a product    ************************************************************************************************
    @PutMapping("/product/{productId}/vendor/{vendorId}")
    public ResponseEntity<Product> updateComment2(@PathVariable (value = "productId") UUID productId,
                                                 @PathVariable (value = "vendorId") UUID vendorId, @RequestBody Product product) {

        Vendor vendor = vendorService.findVendor(vendorId);
        Product prod = productService.findProductById(productId);
        product.setBrand(prod.getBrand());
        product.setCategory(prod.getCategory());
        product.setVendor(vendor);
        return productService.updateProduct(productId, product);
    }

}