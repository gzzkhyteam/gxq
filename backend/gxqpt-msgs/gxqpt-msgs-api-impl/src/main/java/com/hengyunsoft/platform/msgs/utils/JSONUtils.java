package com.hengyunsoft.platform.msgs.utils;

import java.lang.reflect.Type;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JSONUtils {

	/***
	 * 将JavaBean 序列化成JSON格式的字符串
	 * <br>该方法采用fastjson处理
	 * @param obj
	 * @return JSON格式的字符串
	 */
	public static String toJSON(Object obj){
		if(obj==null){
			return null ;
		}
		return  JSON.toJSONString(obj);
	}	
	/**
	 * 将json 格式的字符串反序列化成对象
	 * @param jsonString
	 * @param clazz 对象的class
	 * @return T
	 */
	public static <T> T parseObject(String jsonString,Class<T> clazz){
		return JSON.parseObject(jsonString, clazz);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T parseObject(String jsonString,TypeReference<T> type){
		return (T)JSON.parseObject(jsonString, type);
	}
	
	public static JSONObject parse(String text){
		return JSON.parseObject(text);
	}

	@SuppressWarnings("rawtypes")
	public static class TypeReference<T> extends com.alibaba.fastjson.TypeReference{

		public TypeReference() {
			super();
		}

		public TypeReference(Type... arg0) {
			super(arg0);
		}
		
	}
}

