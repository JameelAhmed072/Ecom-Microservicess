package com.ecom.order.controller;


import com.ecom.common.dto.OrderResponse;
import com.ecom.common.dto.ProductResponse;
import com.ecom.common.dto.UserResponse;
import com.ecom.order.feign.ProductService;
import com.ecom.order.feign.UserService;
import com.ecom.order.helper.OrderHelper;
import com.ecom.order.model.Order;
import com.ecom.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")

public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;
//
    @Autowired
    UserService userService;
    @PostMapping("/")
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
        Order order1 = this.orderService.addOrder(order);
        return new ResponseEntity<>(order1, HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
        Order order1 = this.orderService.updateOrder(order);
        return new ResponseEntity<>(order1, HttpStatus.OK);
    }
    @GetMapping("/")
    public List<OrderResponse> getAllOrders(){
        return this.orderService.allOrders().stream().map(e -> {
            try {
                return OrderHelper.makeOrderResponseFromOrder(
                        e,
                        this.productService.getProductById(e.getProductId()),
                        this.userService.getUserById(e.getUserId())
                );
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id){
        try {
            Order order = this.orderService.getOrderById(id);
            return ResponseEntity.ok(OrderHelper.
                    makeOrderResponseFromOrder(
                            order,
                            this.productService.getProductById(order.getProductId()),
                            this.userService.getUserById(order.getUserId()))
            );
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }
}
