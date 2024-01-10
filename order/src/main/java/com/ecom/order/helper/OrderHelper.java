package com.ecom.order.helper;

import com.ecom.common.dto.OrderResponse;
import com.ecom.common.dto.ProductResponse;
import com.ecom.common.dto.UserResponse;
import com.ecom.order.model.Order;

public class OrderHelper {

    public static OrderResponse makeOrderResponseFromOrder(Order order, ProductResponse productResponse,UserResponse userResponse){
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.set_id(order.get_id());
        orderResponse.setOrderPrice(order.getOrderPrice());
        orderResponse.setProductId(order.getProductId());
        orderResponse.setOrderDescription(order.getOrderDescription());
        orderResponse.setQuantity(order.getQuantity());
        orderResponse.setProductResponse(productResponse);
        orderResponse.setUserResponse(userResponse);
        return orderResponse;
    }
}
