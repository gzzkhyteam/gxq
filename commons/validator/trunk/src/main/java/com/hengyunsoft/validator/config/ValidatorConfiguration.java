package com.hengyunsoft.validator.config;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

@Configuration
public class ValidatorConfiguration {
    @Bean
    public Validator localSet(){
        Validator validator = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new ResourceBundleMessageInterpolator(new PlatformResourceBundleLocator("local/ValidationMessages_ko" )))
                .buildValidatorFactory()
                .getValidator();
        return validator;
    }
}
