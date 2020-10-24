package com.hengyunsoft.platform.commons.utils;

import java.util.concurrent.TimeUnit;

public class TimeUnitConverter {

	public final static String NANOSECONDS = "nanos"; 
	
	public final static String MICROSECONDS = "micros"; 
	
	public final static String MILLISECONDS = "millis"; 
	
	public final static String SECONDS = "s"; 
	
	
	public final static String MINUTES = "m"; 
	
	public final static String HOURS = "h"; 
	
	public final static String DAYS = "d"; 
	
	public static TimeUnit converter(String timeUnit) {
		
		if(timeUnit == null) {
		    return null;
		}
		switch (timeUnit) {
		
		case NANOSECONDS: return TimeUnit.NANOSECONDS;
		case MICROSECONDS: return TimeUnit.MICROSECONDS;
		case MILLISECONDS: return TimeUnit.MILLISECONDS;
		case SECONDS: return TimeUnit.SECONDS;
		case MINUTES: return TimeUnit.MINUTES;
		case HOURS: return TimeUnit.HOURS;
		case DAYS: return TimeUnit.DAYS;
		}
		return null;
	}
}
