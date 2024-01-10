package com.ecom.product.service;

import com.ecom.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product getSingleProduct(Long productId);
    List<Product> getAllProducts();
    Product addProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(Long productId);

}
