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
        userResponse.set_id(user.get_id());
        userResponse.setUserName(user.getUserName());
        userResponse.setUserEmail(user.getUserEmail());
        userResponse.setUserMobile(user.getUserMobile());
        userResponse.setUserAddress(user.getUserAddress());
        userResponse.setUserRole(user.getUserRole());
        userResponse.setUserPassword(user.getUserPassword());
        return userResponse;
    }

}
