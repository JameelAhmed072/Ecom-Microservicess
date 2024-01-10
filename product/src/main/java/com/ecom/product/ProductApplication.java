package com.ecom.product;

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
@OpenAPIDefinition(info = @Info(title = "Product ECOM Application",
		version = "1.0",
		description = "Product Microservice which deals with product related stuff. ",
		termsOfService = "code with Jameel Ahmed",
		contact = @Contact(name = "Jameel Ahmed",url = "")
))
public class ProductApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
