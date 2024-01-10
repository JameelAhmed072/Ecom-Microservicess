package com.ecom.order.feign;

import com.ecom.common.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductService {

    @GetMapping("/product/{productId}")
    ProductResponse getProductById(@PathVariable Long productId);

}
