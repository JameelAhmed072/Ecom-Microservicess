package com.ecom.user.helper;

import com.ecom.common.dto.UserResponse;
import com.ecom.user.model.User;

public class UserHelper {

    public static User makeUserFromUser(User databaseUser, User newUser){
        databaseUser.setUserAddress(newUser.getUserAddress());
        databaseUser.setUserName(newUser.getUserName());
        databaseUser.setUserPassword(newUser.getUserPassword());
        return databaseUser;
    }

    public static UserResponse makeUserResponseFromUser(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setUserEmail(user.getUserEmail());
        userResponse.setUserMobile(user.getUserMobile());
        userResponse.setUserRole(user.getUserRole());
        userResponse.setUserAddress(user.getUserAddress());
        userResponse.set_id(user.get_id());
        userResponse.setUserName(user.getUserName());
        return userResponse;
    }

}
