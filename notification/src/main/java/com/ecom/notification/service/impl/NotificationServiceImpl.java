//package com.ecom.notification.service.impl;
//
//import com.ecom.common.dto.UserResponse;
//import com.ecom.notification.constants.ApplicationConstants;
//import com.ecom.notification.dto.EmailRequest;
//import com.ecom.notification.helper.SendEmail;
//import com.ecom.notification.service.NotificationService;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class NotificationServiceImpl implements NotificationService {
//
//    @Value("${spring.mail.username}")
//    private String SentFrom;
//
//    private SendEmail sendEmail;
//
//    public NotificationServiceImpl(SendEmail sendEmail) {
//        this.sendEmail = sendEmail;
//    }
//
//    @Override
//    public EmailResponse sendUserConfirmationEmail(UserResponse userResponse) {
//
//        EmailRequest emailRequest = new EmailRequest();
//        emailRequest.setTemplateName(ApplicationConstants.CONFIRMATION_TEMPLATE);
//        emailRequest.setSubject(ApplicationConstants.CONFIRMATION_SUBJECT);
//        emailRequest.setSentFrom(this.SentFrom);
//        Map<String, Object> emailObject = new HashMap<>();
//
//        emailObject.put(ApplicationConstants.REDIRECT_URL,ApplicationConstants.WEBSITE_REDIRECT_URL);
//        return this.sendEmail.sendEmail(userResponse,emailObject,emailRequest);
//
//
//    }
//}
