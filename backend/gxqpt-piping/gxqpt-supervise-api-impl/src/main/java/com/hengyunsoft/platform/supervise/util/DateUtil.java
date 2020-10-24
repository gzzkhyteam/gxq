package com.hengyunsoft.platform.supervise.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class DateUtil {
	/**
	 * String转Date
	 * @param date
	 * @return
	 */
	public static Date stringToDate(String date){
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(StringUtils.isEmpty(date)){
				return null;
			}
			return format.parse(date);
		} catch (Exception e) {
			log.error("日期转换异常"+e);
			return null;
		}
	}
	/**
	 * 根据年份返回当年的1月1号00:00:00的Date
	 * @param date
	 * @return
	 */
	public static Date yearToDate(String year){
		try {
    		year = year+"-01-01 00:00:00";
    		return stringToDate(year);			
		} catch (Exception e) {
			log.error("年份转换异常"+e);
			return null;
		}
	}
}
