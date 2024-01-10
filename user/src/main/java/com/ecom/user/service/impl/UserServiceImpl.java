package com.ecom.user.service.impl;

import com.ecom.user.helper.UserHelper;
import com.ecom.user.model.User;
import com.ecom.user.repo.UserRepo;
import com.ecom.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User addUser(User user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        return this.userRepo.save(user);
    }
    @Override
    public User updateUser(User user) {
        User databaseUser = this.userRepo.findById(user.get_id()).orElseThrow(() -> new RuntimeException("User Not Find with this id"));
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        databaseUser = UserHelper.makeUserFromUser(databaseUser,user);
        return userRepo.save(databaseUser);
    }

    @Override
    public List<User> allUsers() {
        return this.userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        User byId = this.userRepo.findById(id).orElseThrow(()-> new RuntimeException("User not found with this id : "));
        return byId;
    }

    @Override
    public boolean deleteUser(Long id) {
        try {
            userRepo.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
