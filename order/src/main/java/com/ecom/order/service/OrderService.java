package com.ecom.order.service;

import com.ecom.order.model.Order;

import java.util.List;

public interface OrderService {

    Order addOrder(Order order);

    Order updateOrder(Order order);

    List<Order> allOrders();

    Order getOrderById(Long id);
}
