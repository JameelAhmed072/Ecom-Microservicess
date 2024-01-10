package com.ecom.order.feign;

import com.ecom.common.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface UserService {

    @GetMapping("/user/{userId}")
    UserResponse getUserById(@PathVariable Long userId);
}