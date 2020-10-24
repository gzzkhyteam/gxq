package com.hengyunsoft.platform.admin.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.hengyunsoft.platform.commons.utils.String2DateConverter;

@Configuration
public class Config {
	@Autowired
    public void requestMappingHandlerAdapter(RequestMappingHandlerAdapter handlerAdapter)
			{

		ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) handlerAdapter
				.getWebBindingInitializer();
		if (initializer.getConversionService() != null) {
			GenericConversionService genericConversionService = (GenericConversionService) initializer
					.getConversionService();
			genericConversionService.addConverter(String.class, Date.class,
					new String2DateConverter());
		}
	}
}
