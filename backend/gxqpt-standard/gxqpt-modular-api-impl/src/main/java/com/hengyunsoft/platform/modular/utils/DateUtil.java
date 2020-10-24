package com.hengyunsoft.platform.modular.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

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
	
	/**
	 * 两个日期之间的年份和月份集合
	 * @param minDate
	 * @param maxDate
	 * @return
	 */
	public static List<String> getMonthBetween(){
		ArrayList<String> result = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月
		Calendar min = Calendar.getInstance();
		Calendar max = Calendar.getInstance();
		try {
			min.setTime(sdf.parse(getOneYearBackDate()));
			min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);	
			max.setTime(sdf.parse(getNowBackDate()));
			max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
			Calendar curr = min	;
			while (curr.before(max)) {
				result.add(sdf.format(curr.getTime()));
				curr.add(Calendar.MONTH, 1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 获取一年以前的月份
	 * @return
	 */
	public static String getOneYearBackDate(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.MONTH, -11);
		Date y = c.getTime();
		return formatter.format(y);
	}	
	/**
	 * 获取当前月份
	 * @return
	 */
	public static String getNowBackDate(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
		return formatter.format(new Date());
	}
	/**
	 * 月份前加0
	 * @param month
	 * @return
	 */
	public static String getMonthAddZero(String month){
		try {
			if(StringUtils.isEmpty(month)){
				return null;
			}
			Integer yue = Integer.valueOf(month);
			if(yue<10){
				return "0"+yue;
			}else{
				return month;
			}			
		} catch (Exception e) {
			return null;
		}				
	}
	/**
	 * 月份前去0
	 * @param month
	 * @return
	 */
	public static Integer getMonthDeleteZero(String month){
		try {
			if(StringUtils.isEmpty(month)){
				return null;
			}
			Integer yue = Integer.valueOf(month);
			if(yue<10){
				return yue;
			}else{
				return Integer.valueOf(month);
			}			
		} catch (Exception e) {
			return null;
		}				
	}
}
