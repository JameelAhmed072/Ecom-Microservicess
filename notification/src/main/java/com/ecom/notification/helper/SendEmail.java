package com.ecom.notification.helper;


import com.ecom.common.dto.EmailResponse;
import com.ecom.common.dto.UserResponse;
import com.ecom.notification.dto.EmailRequest;
import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

@Component
public class SendEmail {

    private JavaMailSender javaMailSender;

    private Configuration configuration;

    public SendEmail(JavaMailSender javaMailSender, Configuration configuration) {
        this.javaMailSender = javaMailSender;
        this.configuration = configuration;
    }

    public EmailResponse sendEmail(UserResponse userResponse, Map<String, Object> emailObject, EmailRequest emailRequest){
        EmailResponse emailResponse = new EmailResponse();

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(
                    mimeMessage,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            Template userConfirmationTemplate = configuration.getTemplate(emailRequest.getTemplateName());

            String userConfirmationTemplatehtml = FreeMarkerTemplateUtils.processTemplateIntoString(userConfirmationTemplate, emailObject);

            mimeMessageHelper.setTo(userResponse.getUserEmail());
            mimeMessageHelper.setFrom(emailRequest.getSentFrom());
            mimeMessageHelper.setText(userConfirmationTemplatehtml);
            mimeMessageHelper.setSubject(emailRequest.getSubject());



        }catch (Exception e){
            e.printStackTrace();
        }
        return emailResponse;
    }

}
