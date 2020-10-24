package com.hengyunsoft.platform.piping.utils;

public class LongUtil {		
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
}
