package com.ecom.notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

@Configuration
public class NotificationConfig {


    @Bean
    @Primary
    public FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean(){
        FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean = new FreeMarkerConfigurationFactoryBean();
        freeMarkerConfigurationFactoryBean.setTemplateLoaderPath("classpath:/templates");
        return freeMarkerConfigurationFactoryBean;
    }
}
