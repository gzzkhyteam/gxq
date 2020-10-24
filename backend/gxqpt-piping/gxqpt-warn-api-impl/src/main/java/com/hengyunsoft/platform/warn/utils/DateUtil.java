package com.hengyunsoft.platform.warn.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
public class DateUtil {
//	/**
//	 * 判断刻度类型
//	 * @param startTime
//	 * @param endTime
//	 * @return
//	 */
//	public static String getDateType(String startTime,String endTime){
//		if((startTime==null||"".equals(startTime))&&(endTime==null||"".equals(endTime))){
//			return "halfYear";
//		}
//		if((startTime==null||"".equals(startTime))){
//			return "halfYear";
//		}
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			Date begin = format.parse(startTime);
//			Date end;
//			if(endTime==null||"".equals(endTime)){
//				end = new Date();
//			}
//			end = format.parse(endTime);
//			Long day = (end.getTime()-begin.getTime())/(24*60*60*1000);
//			if((end.getTime()-begin.getTime())<0){
//				return "false";
//			}
//			if(day>=0&&day<=30){
//				return "day";
//			}
//			if(day>30 && day<=90){
//				return "week";
//			}
//			if(day>90&&day<=365){
//				return "month";
//			}
//			if(day>365){
//				return "false";
//			}
//		} catch (ParseException e) {
//			e.printStackTrace();
//			return "false";
//		}
//		return null;
//	}
//	/**
//	 * String转Date
//	 * @param date
//	 * @return
//	 */
//	public static Date stringToDate(String date){
//		try {
//			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			if(StringUtils.isEmpty(date)){
//				return null;
//			}
//			return format.parse(date);
//		} catch (Exception e) {
//			return null;
//		}
//	}
//    /**
//     * 获取本月1号00:00:00的时间
//     * @return
//     */
//	public static Date getThisMonthTime(){
//    	Calendar calendar = Calendar.getInstance();
//    	calendar.add(Calendar.MONTH, 0);
//    	calendar.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
//    	//将小时至0
//    	calendar.set(Calendar.HOUR_OF_DAY, 0);
//    	//将分钟至0
//    	calendar.set(Calendar.MINUTE, 0);
//    	//将秒至0
//    	calendar.set(Calendar.SECOND,0);
//    	//将毫秒至0
//    	calendar.set(Calendar.MILLISECOND, 0);
//		return calendar.getTime();
//    }
//	/**
//	 * 月份前加0
//	 * @param month
//	 * @return
//	 */
//	public static String getMonthAddZero(String month){
//		try {
//			if(StringUtils.isEmpty(month)){
//				return null;
//			}
//			Integer yue = Integer.valueOf(month);
//			if(yue<10){
//				return "0"+yue;
//			}else{
//				return month;
//			}
//		} catch (Exception e) {
//			return null;
//		}
//	}
//	/**
//	 * 月份前去0
//	 * @param month
//	 * @return
//	 */
//	public static Integer getMonthDeleteZero(String month){
//		try {
//			if(StringUtils.isEmpty(month)){
//				return null;
//			}
//			Integer yue = Integer.valueOf(month);
//			if(yue<10){
//				return yue;
//			}else{
//				return Integer.valueOf(month);
//			}
//		} catch (Exception e) {
//			return null;
//		}
//	}
	/**
	 * 两个日期之间的年份和月份集合
	 * @return
	 */
	public static List<String> getMonthBetween(){
		ArrayList<String> result = new ArrayList<>();
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
//			e.printStackTrace();
			log.info("查询年份异常");
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
//	/**
//	 * String转Date
//	 * @param date
//	 * @return
//	 */
//	public static Date stringToDate1(String date){
//		try {
//			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//			if(StringUtils.isEmpty(date)){
//				return null;
//			}
//			return format.parse(date);
//		} catch (Exception e) {
//			return null;
//		}
//	}
//	/**
//	  * 将短时间格式时间转换为字符串 yyyy-MM-dd
//	  *
//	  * @param dateDate
//	  * @param k
//	  * @return
//	  */
//	public static String dateToStr1(Date dateDate) {
//	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//	   String dateString = formatter.format(dateDate);
//	   return dateString;
//	}
//	/**
//	 * 根据开始时间和结束时间返回时间段内的时间集合
//	 *
//	 * @param beginDate
//	 * @param endDate
//	 * @return List
//	 */
//	public static List<Date> getDatesBetweenTwoDate(Date beginDate, Date endDate) {
//		List<Date> lDate = new ArrayList<Date>();
//		//lDate.add(beginDate);// 把开始时间加入集合
//		Calendar cal = Calendar.getInstance();
//		// 使用给定的 Date 设置此 Calendar 的时间
//		cal.setTime(beginDate);
//		boolean bContinue = true;
//		while (bContinue) {
//			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
//			cal.add(Calendar.DAY_OF_MONTH, 1);
//			// 测试此日期是否在指定日期之后
//			if (endDate.after(cal.getTime())) {
//				lDate.add(cal.getTime());
//			} else {
//				break;
//			}
//		}
//		lDate.add(endDate);// 把结束时间加入集合
//		return lDate;
//	}
//    /**
//     * 获取上个月的时间
//     * @return
//     */
//    public static Date getBeforeMonthTime(){
//    	Calendar calendar = Calendar.getInstance();
//    	calendar.add(Calendar.MONTH, -1);
//		return calendar.getTime();
//    }
//    /**
//	 * 半年之间的年份和月份集合
//	 * @param minDate
//	 * @param maxDate
//	 * @return
//	 */
//	public static List<String> getHalfYearMonthBetween(){
//		ArrayList<String> result = new ArrayList<String>();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月
//		Calendar min = Calendar.getInstance();
//		Calendar max = Calendar.getInstance();
//		try {
//			min.setTime(sdf.parse(getHalfYearBackDate()));
//			min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
//			max.setTime(sdf.parse(getNowBackDate()));
//			max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
//			Calendar curr = min	;
//			while (curr.before(max)) {
//				result.add(sdf.format(curr.getTime()));
//				curr.add(Calendar.MONTH, 1);
//			}
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
//	/**
//	 * 获取半年以前的月份
//	 * @return
//	 */
//	public static String getHalfYearBackDate(){
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
//		Calendar c = Calendar.getInstance();
//		c.setTime(new Date());
//		c.add(Calendar.MONTH, -5);
//		Date y = c.getTime();
//		return formatter.format(y);
//	}
//
//	/**
//	 * 两个日期之间的年份和月份集合
//	 * @param minDate
//	 * @param maxDate
//	 * @return
//	 */
//	public static List<String> getMonthBetween(String startTime,String endTime){
//		ArrayList<String> result = new ArrayList<String>();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月
//		Calendar min = Calendar.getInstance();
//		Calendar max = Calendar.getInstance();
//		try {
//			if(startTime!=null&&!"".equals(startTime)){
//				startTime = startTime.substring(0, 7);
//			}
//			if(endTime!=null&&!"".equals(endTime)){
//				endTime = endTime.substring(0, 7);
//			}
//			min.setTime(sdf.parse(startTime));
//			min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
//			max.setTime(sdf.parse(endTime));
//			max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
//			Calendar curr = min	;
//			while (curr.before(max)) {
//				result.add(sdf.format(curr.getTime()));
//				curr.add(Calendar.MONTH, 1);
//			}
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
//
//
//	public static List<Date> getDatesBetweenTwoDate1(Date beginDate, Date endDate) {
//		List<Date> lDate = new ArrayList<Date>();
//		lDate.add(beginDate);// 把开始时间加入集合
//		Calendar cal = Calendar.getInstance();
//		// 使用给定的 Date 设置此 Calendar 的时间
//		cal.setTime(beginDate);
//		boolean bContinue = true;
//		while (bContinue) {
//			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
//			cal.add(Calendar.DAY_OF_MONTH, 1);
//			// 测试此日期是否在指定日期之后
//			if (endDate.after(cal.getTime())) {
//				lDate.add(cal.getTime());
//			} else {
//				break;
//			}
//		}
//		//lDate.add(endDate);// 把结束时间加入集合
//		return lDate;
//	}
//
//	/**
//	 * 两个日期之间的年份和周集合
//	 * @param minDate
//	 * @param maxDate
//	 * @return
//	 */
//	public static List<String> getWeekBetween(String startTime,String endTime){
//		List<String> result = new ArrayList<String>();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//格式化为年月
//		Calendar min = Calendar.getInstance();
//		Calendar max = Calendar.getInstance();
//		try {
//			if(startTime!=null&&!"".equals(startTime)){
//				startTime = startTime.substring(0, 10);
//			}
//			if(endTime!=null&&!"".equals(endTime)){
//				endTime = endTime.substring(0, 10);
//			}
//			min.setTime(sdf.parse(startTime));
//			max.setTime(sdf.parse(endTime));
//			Calendar curr = min	;
//			while (curr.before(max)) {
//				result.add(curr.get(Calendar.YEAR)+"-"+curr.get(Calendar.WEEK_OF_YEAR));
//				curr.add(Calendar.WEEK_OF_YEAR, 1);
//			}
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
}
