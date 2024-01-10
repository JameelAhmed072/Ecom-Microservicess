package com.ecom.product.helper;

import com.ecom.common.dto.ProductResponse;
import com.ecom.product.model.Product;

public class ProductHelper {

    public static Product makeProductFromProduct(Product databaseProduct, Product newProduct){

        databaseProduct.setProductDescription(newProduct.getProductDescription());
        databaseProduct.setTitle(newProduct.getTitle());
        databaseProduct.setProductName(newProduct.getProductName());
        databaseProduct.setProductPrice(newProduct.getProductPrice());
        return databaseProduct;
    }

    public static ProductResponse makeProductResponseFromProduct(Product product){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductPrice(product.getProductPrice());
        productResponse.set_id(product.get_id());
        productResponse.setTitle(product.getTitle());
        productResponse.setProductName(product.getProductName());
        productResponse.setProductDescription(product.getProductDescription());
        return productResponse;
    }
}