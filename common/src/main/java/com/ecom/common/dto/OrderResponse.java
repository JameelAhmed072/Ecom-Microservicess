package com.ecom.common.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private Long _id;
    private String orderDescription;
    private Long productId;
    private Integer quantity;
    private BigDecimal orderPrice;
    private ProductResponse productResponse;
    private UserResponse userResponse;
}
