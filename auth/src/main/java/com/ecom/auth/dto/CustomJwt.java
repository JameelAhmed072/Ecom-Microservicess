package com.ecom.auth.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomJwt {

    private String requestToken;
    private String refreshToken;
    private String userName;
    private String userEmail;

}
