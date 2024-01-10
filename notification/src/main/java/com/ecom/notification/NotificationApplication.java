package com.ecom.notification;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.config.EnableMongoAuditing;


@SpringBootApplication
@EnableMongoAuditing
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Notification ECOM Application",
		version = "1.0",
		description = "Notification Microservice which deals with notification related stuff. ",
		termsOfService = "code with Jameel Ahmed",
		contact = @Contact(name = "Jameel Ahmed",url = "")
))
public class NotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}

}
