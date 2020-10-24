package com.hengyunsoft.platform.commons.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class String2DateConverter implements Converter<String,Date> {
	
	@Override
	public Date convert(String source) {
		SimpleDateFormat dateFormat = null;
		
		if(source.length() == 10) {
			if(source.indexOf("-") >= 0) {
				   dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			} else if (source.indexOf("/") >= 0) {
				dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			} 
		} else {
			if(source.indexOf("-") >= 0) {
			   dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			} else if (source.indexOf("/") >= 0) {
				dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			} 
		}
		try {
			return dateFormat.parse(source);
		} catch (ParseException e) {
			
			return new Date(source);
			
		}
		
	}
	
	
}
