package com.ecom.auth.helper;

import com.ecom.auth.dto.CustomJwt;
import com.ecom.auth.model.User;
import com.ecom.common.dto.UserResponse;

public class AuthHelper {

    public static CustomJwt makeCustomJwt(User userResponse, String jwtToken,String refreshToken){

        CustomJwt customJwt = new CustomJwt();
        customJwt.setRequestToken(jwtToken);
        customJwt.setRefreshToken(refreshToken);
        customJwt.setUserName(userResponse.getUserName());
        customJwt.setUserEmail(userResponse.getUserEmail());

        return customJwt;
    }
}
