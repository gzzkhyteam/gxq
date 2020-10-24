package com.hengyunsoft.platform.commons.feign;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.cloud.netflix.feign.FeignFormatterRegistrar;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

public class DateFormatRegister implements FeignFormatterRegistrar {

	public DateFormatRegister() {
	}

	@Override
	public void registerFormatters(FormatterRegistry registry) {

		registry.addConverter(Date.class, String.class, new Date2StringConverter());
	}

	private class Date2StringConverter implements Converter<Date, String> {

		@Override
		public String convert(Date source) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format(source);
		}
	}
}
