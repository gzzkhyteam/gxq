package com.hengyunsoft.platform.mt.utils;

import java.math.BigDecimal;

public class BigDecimalUtil {
    /***
     * 相加
     * @param value1
     * @param value2
     * @param scale
     * @return
     */
    public static double add(Double value1, Double value2, int scale) {
        value1 = value1 == null ? 0 : value1;
        value2 = value2 == null ? 0 : value2;
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.add(b2).setScale(scale, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

    /***
     * 相加
     * @param value1
     * @param value2
     * @param scale
     * @return
     */
    public static float add(BigDecimal value1, BigDecimal value2, int scale) {
        return value1.add(value2).setScale(scale, BigDecimal.ROUND_HALF_DOWN).floatValue();
    }

    /***
     * 相减
     * @param value1
     * @param value2
     * @param scale
     * @return
     */
    public static double subtract(Double value1, Double value2, int scale) {
        value1 = value1 == null ? 0 : value1;
        value2 = value2 == null ? 0 : value2;
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.subtract(b2).setScale(scale, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

    /***
     * 相减
     * @param value1
     * @param value2
     * @param scale
     * @return
     */
    public static double subtract(BigDecimal value1, BigDecimal value2, int scale) {
        return value1.subtract(value2).setScale(scale, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }
}
