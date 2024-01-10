package com.ecom.auth.service;

import com.ecom.auth.dto.CustomJwt;
import com.ecom.common.dto.UserResponse;

public interface AuthService {

    CustomJwt generateToken(UserResponse userResponse);

    String validateToken(String jwtToken);

}
