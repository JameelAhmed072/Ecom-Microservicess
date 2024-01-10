package com.ecom.notification.controller;

import com.ecom.common.dto.EmailResponse;
import com.ecom.common.dto.UserResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @PostMapping("/sendUserConfirmationEmail")
    public String sendUserConfirmationEmail(@RequestBody UserResponse userResponse){
        return "This is incomplete(   Code with Gaurav  )";
    }
}
