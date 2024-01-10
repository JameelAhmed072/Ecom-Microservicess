package com.ecom.product.model;

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
@Document(collection = "product")
public class Product  extends Auditable<String> implements Serializable {

    @Id
    @Column(name = "product_id",nullable = false)
    private Long _id;
    @Column(name = "product_name",nullable = false)
    private String productName;
    @Column(name = "product_title",nullable = false)
    private String title;
    @Column(name = "product_description",nullable = false)
    private String productDescription;
    @Column(name = "product_price",nullable = false)
    private BigDecimal productPrice;


}
