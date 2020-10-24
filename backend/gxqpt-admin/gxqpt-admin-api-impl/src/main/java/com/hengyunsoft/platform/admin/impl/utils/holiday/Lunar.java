package com.hengyunsoft.platform.admin.impl.utils.holiday;

/**
 * 农历类
 */
public class Lunar {
    public boolean isleap;//是否闰月
    public int lunarDay;//日
    public int lunarMonth;//月
    public int lunarYear;//年
    public Lunar(){}
    public Lunar(boolean isleap,int lunarDay,int lunarMonth,int lunarYear){
        this.isleap = isleap;
        this.lunarDay = lunarDay;
        this.lunarMonth = lunarMonth;
        this.lunarYear = lunarYear;
    }
}
