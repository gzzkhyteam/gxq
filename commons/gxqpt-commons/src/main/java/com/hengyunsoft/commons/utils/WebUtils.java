package com.hengyunsoft.commons.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class WebUtils {

	static String FullRootPath = null;
	public static String getFullRootPath() {
        

        if(FullRootPath == null) {
        	initFullRootPath();
        }
        return FullRootPath;
    }
	private synchronized static void initFullRootPath() {
		if(FullRootPath != null)
			return ;
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
		StringBuilder url = new StringBuilder();
		url.append(request.getScheme());
		url.append("://");
		url.append(request.getRemoteHost());
		url.append(":");
		url.append(request.getRemotePort());
		url.append(request.getContextPath());
		FullRootPath = url.toString() ;
	}
	
	public static String linkUrl2Params(String url,Object params) {
		
		
		if(!url.contains("?")) {
			url += "?";
		} else {
			url += "&";
		}
		return url + params;
	}
	
	/**
	 * 	public static void main(String[] args) {
	 *	System.out.println( linkUri2Uri("sdf", "sdf"));
		System.out.println( linkUri2Uri("sdf/", "sdf"));
		System.out.println( linkUri2Uri("sdf/", "/sdf"));
		System.out.println( linkUri2Uri("sdf", "/sdf"));
	    }
	    sdf/sdf
		sdf/sdf
		sdf/sdf
		sdf/sdf
	 * @param uriBefor
	 * @param uriAfter
	 * @return
	 */
	public static String linkUri2Uri(String uriBefor,String uriAfter) {
		
		if(uriBefor.charAt(uriBefor.length()-1) == '/' || uriAfter.charAt(0) == '/') {
			
			if(uriBefor.charAt(uriBefor.length()-1) == '/' && uriAfter.charAt(0) == '/') {
				return uriBefor.substring(0, uriBefor.length()-1) + uriAfter;
			}
			return uriBefor + uriAfter ;
		}
		return uriBefor + '/' + uriAfter ;
	}
	

}
