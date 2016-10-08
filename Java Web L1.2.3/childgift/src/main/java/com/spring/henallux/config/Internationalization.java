package com.spring.henallux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.DefaultMessageCodesResolver;

@Configuration
public class Internationalization {

	@Bean
	public DefaultMessageCodesResolver defaultMessageCodesResolver(){
		DefaultMessageCodesResolver defaultMessageCodesResolver = new DefaultMessageCodesResolver();
		return defaultMessageCodesResolver;
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource(){
		
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setBasenames("translations/general","translatoins/errors");
		messageSource.setUseCodeAsDefaultMessage(true);
		return messageSource;
	}
}
