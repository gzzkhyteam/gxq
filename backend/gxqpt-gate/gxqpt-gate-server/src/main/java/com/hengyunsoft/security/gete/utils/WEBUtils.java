package com.hengyunsoft.security.gete.utils;

import org.apache.commons.lang3.StringUtils;

public class WEBUtils {

	public final static char http_separator = '/';
	/**
	 * 格式化url   将url的分隔符开始的前缀全部去掉
	 * 	public static void main(String[] args) {
	 *	System.out.println(formatterUrl("//df//sdf/sd/f/sd/f/sdf"));
	 *	System.out.println(formatterUrl("df//sdf/sd/f/sd/f/sdf"));
	 *	System.out.println(formatterUrl("////df//sdf/sd/f/sd/f/sdf"));
	 *	System.out.println(formatterUrl("/df//sdf/sd/f/sd/f/sdf"));
	 *  }
	 *  
	 *  df//sdf/sd/f/sd/f/sdf
	 *	df//sdf/sd/f/sd/f/sdf
	 *	df//sdf/sd/f/sd/f/sdf
	 *	df//sdf/sd/f/sd/f/sdf
	 * @param url
	 * @return
	 */
	public static String formatterUrl(String url) {
		
		if(StringUtils.isNotEmpty(url) && url.charAt(0) == http_separator) {

			if(url.charAt(1) != http_separator) {
				return url.substring(1, url.length());
			} else {
				int i = 0;
				for (i = 1; i < url.length(); i++) {
					if(url.charAt(i) != http_separator) {
						break;
					}
				}
				return url.substring(i, url.length());
			}
		}
		return url;
	}
}
