package com.hengyunsoft.platform.standard.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * 获取一年以前的时间
	 * @return
	 */
	public static Date getYearBackDate(){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.YEAR, -1);
		Date y = c.getTime();
		return y;
	}	
	
    /**
     * 获取本月1号00:00:00的时间
     * @return
     */
	public static Date getThisMonthTime(){
    	Calendar calendar = Calendar.getInstance();    
    	calendar.add(Calendar.MONTH, 0);
    	calendar.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
    	//将小时至0  
    	calendar.set(Calendar.HOUR_OF_DAY, 0);  
    	//将分钟至0  
    	calendar.set(Calendar.MINUTE, 0);  
    	//将秒至0  
    	calendar.set(Calendar.SECOND,0);  
    	//将毫秒至0  
    	calendar.set(Calendar.MILLISECOND, 0); 
		return calendar.getTime();    	
    }
}
