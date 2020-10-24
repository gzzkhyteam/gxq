package com.hengyunsoft.platform.admin.impl.utils.holiday;

/**
 * 公历类
 */
public class Solar {
    public int solarDay;//日
    public int solarMonth;//月
    public int solarYear;//年
    public Solar(){}
    public Solar(int solarYear,int solarMonth,int solarDay){
        this.solarDay = solarDay;
        this.solarMonth = solarMonth;
        this.solarYear = solarYear;
    }
}
