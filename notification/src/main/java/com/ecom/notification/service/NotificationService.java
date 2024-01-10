package com.ecom.notification.service;

import com.ecom.common.dto.EmailResponse;
import com.ecom.common.dto.UserResponse;

public interface NotificationService {

    EmailResponse sendUserConfirmationEmail(UserResponse userResponse);

}
