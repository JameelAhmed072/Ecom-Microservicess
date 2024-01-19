package com.ecom.product.controller;

import com.ecom.common.dto.ProductResponse;
import com.ecom.product.annotation.SecureEndpoint;
import com.ecom.product.helper.ProductHelper;
import com.ecom.product.model.Product;
import com.ecom.product.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;
    @GetMapping("/{productId}")
    @SecureEndpoint({"ADMIN"})
    public ProductResponse getProductById(@PathVariable Long productId){
        ProductResponse productResponse = ProductHelper.makeProductResponseFromProduct(this.productService.getSingleProduct(productId));
        return productResponse;
    }
    @GetMapping("/")
    @SecureEndpoint({"USER"})
    public ResponseEntity<List<Product>> getAllProducts(){

        List<Product> allProducts = this.productService.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){

        Product product1 = this.productService.addProduct(product);
        return new ResponseEntity<>(product1, HttpStatus.OK);

    }
    @PutMapping("/")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product product1 = this.productService.updateProduct(product);
        return new ResponseEntity<>(product1,HttpStatus.CREATED);
    }
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId){
        this.productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
