package com.hengyunsoft.platform.admin.utils;

public class SystemUtil {
    private static final String[] SYSTEM_NAME = {"高新区一体化平台", "省电子政务网"};
    private static final String[] SYSTEM_CODE = {"gxqpt", "sdzzww"};
    public static String findSystem(String value) {
//        StringBuffer strs = new StringBuffer();
//        int cursor = 2;
//        for (int i = 0; i < SYSTEM_NAME.length; i++) {
//            if ((value & (int) Math.pow(cursor, i)) != 0) {
//                strs.append(SYSTEM_NAME[i] + ",");
//            }
//        }
//        if (strs.toString().length() > 0) {
//            return strs.toString().substring(0, strs.toString().length() - 1);
//        }
        if (value.equals(SYSTEM_CODE[0])){
            return SYSTEM_NAME[0];
        }else if(value.equals(SYSTEM_CODE[1])){
            return SYSTEM_NAME[1];
        }
        return "";
    }
    public static String findSysCode(String value) {
//        StringBuffer strs = new StringBuffer();
//        int cursor = 2;
//        for (int i = 0; i < SYSTEM_NAME.length; i++) {
//            if ((value & (int) Math.pow(cursor, i)) != 0) {
//                strs.append(SYSTEM_NAME[i] + ",");
//            }
//        }
//        if (strs.toString().length() > 0) {
//            return strs.toString().substring(0, strs.toString().length() - 1);
//        }
        if (value.equals(SYSTEM_NAME[0])){
            return SYSTEM_CODE[0];
        }else if(value.equals(SYSTEM_NAME[1])){
            return SYSTEM_CODE[1];
        }
        return "";
    }
}
