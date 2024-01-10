package com.ecom.common.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserResponse {

    private Long _id;
    private String userName;
    private String userEmail;
    private String userMobile;
    private String userAddress;
    private String userRole;
    private String userPassword;
}
