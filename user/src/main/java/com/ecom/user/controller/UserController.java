package com.ecom.user.controller;


import com.ecom.common.dto.UserResponse;
import com.ecom.user.helper.UserHelper;
import com.ecom.user.model.User;
import com.ecom.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/{userId}")
    public UserResponse getUserById(@PathVariable Long userId){
        return UserHelper.makeUserResponseFromUser(this.userService.getUserById(userId));
    }
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = this.userService.allUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user){

        User user1 = this.userService.addUser(user);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User user1 = this.userService.updateUser(user);
        return new ResponseEntity<>(user1,HttpStatus.CREATED);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId){
        this.userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

}
