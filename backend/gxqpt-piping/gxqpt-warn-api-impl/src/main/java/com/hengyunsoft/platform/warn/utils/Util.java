package com.hengyunsoft.platform.warn.utils;

import java.util.*;

public class Util {
	private static final Map<String, String> htmlEntityMap;
	
	static{
		htmlEntityMap = new HashMap<>();
		htmlEntityMap.put("&nbsp;", " ");
		htmlEntityMap.put("&quot;", "\"");
		htmlEntityMap.put("&amp;", "&");
		htmlEntityMap.put("&lt;", "<");
		htmlEntityMap.put("&gt;", ">");
		
	}
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
		return collection == null || collection.isEmpty();
	}

	
	public static boolean isEmptyString(String str){
		return str == null || str.trim().length() == 0;
	}
	

}
