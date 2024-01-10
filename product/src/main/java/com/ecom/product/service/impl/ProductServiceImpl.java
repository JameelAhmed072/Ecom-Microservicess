package com.ecom.product.service.impl;

import com.ecom.product.helper.ProductHelper;
import com.ecom.product.model.Product;
import com.ecom.product.repo.ProductRepo;
import com.ecom.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Override
    public Product getSingleProduct(Long productId) {

        return productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product Not Found"));
    }
    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {

        Product databaseProduct = productRepo.findById(product.get_id()).orElseThrow(()-> new RuntimeException("Product Not Found"));
        databaseProduct = ProductHelper.makeProductFromProduct(databaseProduct,product);
        return productRepo.save(databaseProduct);
    }

    @Override
    public void deleteProduct(Long productId) {
        this.productRepo.deleteById(productId);
    }
}
