package com.ecom.order.service.impl;

import com.ecom.order.model.Order;
import com.ecom.order.repo.OrderRepository;
import com.ecom.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Override
    public Order addOrder(Order order) {
        return this.orderRepository.save(order);
    }
    @Override
    public Order updateOrder(Order order) {
        return this.orderRepository.save(order);
    }
    @Override
    public List<Order> allOrders() {
        return this.orderRepository.findAll();
    }
    @Override
    public Order getOrderById(Long id) {
        Order byId = this.orderRepository.findById(id).orElseThrow(()-> new RuntimeException("Order not found with this id : "));
        return byId;
    }
}
