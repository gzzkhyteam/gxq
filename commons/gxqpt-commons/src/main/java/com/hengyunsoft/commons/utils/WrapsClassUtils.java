package com.hengyunsoft.commons.utils;

public class WrapsClassUtils {

    public static Long longValueOf(String s) {
        try {
            return Long.valueOf(s);
        } catch (Exception e) {
            return 0L;
        }
    }

    public static Integer intValueOf(String s) {
        try {
            return Integer.valueOf(s);
        } catch (Exception e) {
            return 0;
        }
    }

}
