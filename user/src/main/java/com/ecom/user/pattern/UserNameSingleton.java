package com.ecom.user.pattern;

import lombok.Data;

@Data
public class UserNameSingleton {

    private String userName;
    private static UserNameSingleton instance;
    public UserNameSingleton() {}

    public static UserNameSingleton getInstance(){
        if (instance == null){
            instance = new UserNameSingleton();
        }
        return instance;
    }

}
