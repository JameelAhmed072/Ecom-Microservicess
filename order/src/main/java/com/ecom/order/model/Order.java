package com.ecom.order.model;

import com.ecom.common.model.Auditable;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "order")
public class Order extends Auditable<String> implements Serializable {

    @Id
    @Column(name = "order_id", nullable = false)
    private Long _id;
    @Column(name = "order_description")
    private String orderDescription;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "order_price")
    private BigDecimal orderPrice;
    @Column(name = "user_id")
    private Long userId;
}
