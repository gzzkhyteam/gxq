package com.hengyunsoft.platform.msgs.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class Util {
	public static final int REQUEST_WEB = 1;
	public static final int REQUEST_MOBILE = 2;
	private static List<String> mobileNames;
	/**
	 * 得到一个uuid的字符串，用于得到一个不重复的字符串
	 * 
	 * @return
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	/**
	 * 判断一个集合是不是空
	 * 
	 * @param collection
	 * @return
	 */
	public static boolean isEmpty(Collection<?> collection) {
		return collection == null || collection.size() == 0;
	}

	

	public static String toHtmlString(String oriString) {
		String s = oriString;
		Pattern pattern = Pattern.compile("/(\\d{1,2}\\.gif);");
		s = s.replace("&",  "&#38;");
		s = s.replace(">",  "&#62;");
		s = s.replace("<",  "&#60;");
		s = s.replace("\"", "&#34;");
		if(oriString.length()>200){
			s = s.replace("\n", "</p><p class='duanluo'>");
			s=String.format("<p class='duanluo'>%s</p>", s);
		}else{
			s = s.replace("\n", "<br/>");
		}		
		Matcher m = pattern.matcher(oriString);
		String fmtString = "<img data-cke-saved-src=\"resources/img/face/%s\" src=\"resources/img/face/%1$s\">";		
		while (m.find()) {
			s = s.replace(m.group(0), String.format(fmtString, m.group(1)));
		}
		return s;
	}


	/**
	 * 判断空字符串
	 * @param str
	 * @return
	 */
	public static boolean isEmptyString(String str){
		return str == null || str.trim().length() == 0;
	}
	
	/**
	 * 计算字符串的行数
	 * @param str
	 * @param size 每行字符的个数
	 * @return
	 */
	public static int rows(String str, int size){
		String[] lines = str.trim().split("\n");
		int row = lines.length;
		
		for(String s: lines){
			int rowLen = s.length();
			
			if(rowLen >= size){
				int row_ = rowLen / size; 
				if(rowLen % size > 0){
					row_++;
				}				
				row += row_;
			}
		}
		
		return row;
	}
	/**
	 * 获取随机数
	 * @return
	 */
	public static String getRanNum(){
		Random r = new Random();
		int x = r.nextInt(999999); 		 
		 if(x < 100000) {
			 x += 100000;
		 }		 
		 return String.valueOf(x);
	}
	/**
	 * 去掉子集和中父类集合不存在的，得到包含于父类集合的子类集合
	 * @param childs
	 * @param parents
	 * @return
	 */
	public static List<String> getChildListInParentList(List<String> childs,List<String> parents){
		if(childs==null||parents==null){
			return null;
		}
		List<String> myFileIdsdel = new ArrayList<String>();
		for (String id : childs) {
			if(!parents.contains(id)){
				myFileIdsdel.add(id);
			}
		}
		if(myFileIdsdel.size()>0){
			childs.removeAll(myFileIdsdel);
		}
		return childs;
	}
	
	/**
	 * 判断请求是来自web还是移动端
	 * @param request
	 * @return REQUEST_WEB (1); REQUEST_MOBILE (2);
	 */
	public static int httpFrom(HttpServletRequest request){
		String requestHeader = request.getHeader("user-agent").toLowerCase();		
		for(String s: mobileNames){
			if(requestHeader.contains(s)){
				return REQUEST_MOBILE;
			}
		}		
		return REQUEST_WEB;
	}

	/**
	 * 19位long值
	 * @return
	 */
	public static long random(){
		Long a = System.currentTimeMillis();
		Long b = 0L;
		b = (long) (Math.random()*1000000);
		if(b>922337){
			b = (long) (Math.random()*100000);
		}
		String c = String.valueOf(b);
		long num = Long.parseLong(c+a); 
		return num;		
    }


	/**
	 * 校验内容是否包含网址
	 * @param args
	 */
	public static Boolean containURL(String url){
//		String http_reg = "(?i)(http|https|ftp)\\://([a-zA-Z0-9\\.\\-]+(\\:[a-zA-Z0-9\\.&amp;%\\$\\-]+)*@)*"
//		  		+ "((25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\\.(25[0-5]|2[0-4][0-9]"
//		  		+ "|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}"
//		  		+ "|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])|localhost"
//		  		+ "|([a-zA-Z0-9\\-]+\\.)*[a-zA-Z0-9\\-]+\\.(com|edu|gov|int|mil|net|org|biz|arpa|info|name|pro|aero|coop|museum"
//		  		+ "|[a-zA-Z]{2}))(\\:[0-9]+)*(/($|[a-zA-Z0-9\\.\\,\\?\\'\\\\\\+&amp;%\\$#\\=~_\\-]+))(?i)";
//		Matcher m = Pattern.compile(http_reg).matcher(content);
//		List<String> urlList = new ArrayList<String>();
//        while(m.find()){
//        	urlList.add(m.group());
//        }
//		if(urlList.size()!=0){
//			return true;
//		}
        if(StringUtils.isNotEmpty(url)){
            return url.contains("http://") ||url.contains("https://");
        }
		return false;
	}
	/**
	 * 过滤所有html标签和格式
	 */
	public static String slovtHtml(String html){
		if(isEmptyString(html)){
			return "";
		}		
		Pattern pattern = Pattern.compile("<([^>]*)>");   
        Matcher matcher = pattern.matcher(html);   
        StringBuffer sb = new StringBuffer();   
        boolean result1 = matcher.find();   
        while (result1) {   
            matcher.appendReplacement(sb, "");   
            result1 = matcher.find();   
        }   
        matcher.appendTail(sb);   
        return sb.toString();
	}
	
	/**
	 * 月份前加0
	 * @param month
	 * @return
	 */
	public static String getMonthAddZero(String month){
		try {
			if(isEmptyString(month)){
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
			min.setTime(sdf.parse(getYearBackDate()));
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

	public static void main(String[] args) {
		List<String> list = getHalfYearMonthBetween();
		list.forEach(System.out::println);
	}

	
	/**
	 * 半年之间的年份和月份集合
	 * @param minDate
	 * @param maxDate
	 * @return
	 */
	public static List<String> getHalfYearMonthBetween(){
		ArrayList<String> result = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月
		Calendar min = Calendar.getInstance();
		Calendar max = Calendar.getInstance();
		try {
			min.setTime(sdf.parse(getHalfYearBackDate()));
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
	public static String getYearBackDate(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.MONTH, -11);
		Date y = c.getTime();
		return formatter.format(y);
	}	
	/**
	 * 获取半年以前的月份
	 * @return
	 */
	public static String getHalfYearBackDate(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.MONTH, -5);
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
	 * 根据开始时间和结束时间返回时间段内的时间集合
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return List
	 */
	public static List<Date> getDatesBetweenTwoDate(Date beginDate, Date endDate) {
		List<Date> lDate = new ArrayList<Date>();
		//lDate.add(beginDate);// 把开始时间加入集合
		Calendar cal = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		cal.setTime(beginDate);
		boolean bContinue = true;
		while (bContinue) {
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			cal.add(Calendar.DAY_OF_MONTH, 1);
			// 测试此日期是否在指定日期之后
			if (endDate.after(cal.getTime())) {
				lDate.add(cal.getTime());
			} else {
				break;
			}
		}
		lDate.add(endDate);// 把结束时间加入集合
		return lDate;
	}
    /**
     * 获取上个月的时间
     * @return
     */
    public static Date getBeforeMonthTime(){
    	Calendar calendar = Calendar.getInstance();    
    	calendar.add(Calendar.MONTH, -1);
		return calendar.getTime();    	
    }
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
			return null;
		}
	}
	/**
	  * 将短时间格式时间转换为字符串 yyyy-MM-dd
	  * 
	  * @param dateDate
	  * @param k
	  * @return
	  */
	public static String dateToStr(Date dateDate) {
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   String dateString = formatter.format(dateDate);
	   return dateString;
	}
	/**
	 * String转Date
	 * @param date
	 * @return
	 */
	public static Date stringToDate1(String date){
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			if(StringUtils.isEmpty(date)){
				return null;
			}
			return format.parse(date);
		} catch (Exception e) {
			return null;
		}
	}
	/**
	  * 将短时间格式时间转换为字符串 yyyy-MM-dd
	  * 
	  * @param dateDate
	  * @param k
	  * @return
	  */
	public static String dateToStr1(Date dateDate) {
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	   String dateString = formatter.format(dateDate);
	   return dateString;
	}
}
