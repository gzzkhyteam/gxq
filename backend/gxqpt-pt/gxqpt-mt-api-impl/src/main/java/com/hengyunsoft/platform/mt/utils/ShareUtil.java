package com.hengyunsoft.platform.mt.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShareUtil {
    private static String simplifyFormat = "yyMMddHHmmss";
    private static String month = "MM";
    private static String year = "yyyy";
    /**
     * 获取申请编号
     * @param code
     * @return
     */
    public static String automaticCode(String code){
        StringBuilder b = new StringBuilder();
        String date =getSimplifyYearMonth(new Date());
        b.append(code);
        b.append(date);
        return b.toString();
    }
    public static String getSimplifyYearMonth(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(simplifyFormat);
        return dateFormat.format(date);
    }
    /**
     * 获取月
     * @param date
     * @return
     */
    public static String getMonth(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat(month);
        return dateFormat.format(date);
    }
    public static String getYear(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(year);
        return dateFormat.format(date);
    }
}
