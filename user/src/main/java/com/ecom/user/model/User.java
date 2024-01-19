package com.ecom.user.model;

import com.ecom.common.model.Auditable;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class User extends Auditable<String> implements Serializable {

    @Id
    @Column(name = "user_id", nullable = false,unique = true)
    private Long _id;
    @Column(name = "user_name", nullable = false,unique = true)
    private String userName;
    @Column(name = "user_email",nullable = false,unique = true)
    private String userEmail;
    @Column(name = "user_mobile",nullable = false)
    private String userMobile;
    @Column(name = "user_address",nullable = false)
    private String userAddress;
    @Column(name = "user_role",nullable = false)
    private String userRole= "USER";
    @Column(name = "user_password",nullable = false)
    private String userPassword;

    private List<Permission> permission;

}
