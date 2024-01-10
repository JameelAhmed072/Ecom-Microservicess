package com.ecom.user.service;

import com.ecom.user.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    User updateUser(User user);

    List<User> allUsers();

    User getUserById(Long id);

    boolean deleteUser(Long id);

}
