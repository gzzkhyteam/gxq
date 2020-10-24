package com.hengyunsoft.platform.mt.utils;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.platform.admin.api.base.api.HolidayOriginalDataApi;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.utils.SpringUtil;

import java.util.Date;

/***
 * 节假日工具类
 */
public class HolidayUtil {

    /***
     * 判断一天中，一个时间段的放假时间,z注意，必须是一天中的两个时间，不能跨天
     * 目前不考虑一天中单独放假的情况，所有暂时直接返回0
     * @param unityId 单位id
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 放假时间, 单位为小时
     */
    public static double getFreeTime(String unityId, Date startTime, Date endTime) {
        return 0;
    }

    /***
     * 是否是节假日,目前和单位不相关的，全局公用，但是参数单位id保留
     * @param unityId
     * @param date
     * @return
     */
    public static boolean isHoliday(String unityId, Date date) {
        HolidayOriginalDataApi holiddayApi = SpringUtil.getBean(HolidayOriginalDataApi.class);
        String dataStr = DateUtils.date2String(date, DateUtils.DEFAULT_DATE_FORMAT);
        Result<Boolean> res = holiddayApi.getHolidayByNowDay(dataStr);
        boolean isHoliday = false;
        if (res.isSuccess()) {
            isHoliday = res.getData();
        } else {
            BizAssert.fail(res.getErrcode(), res.getErrmsg());
        }
        return isHoliday;
    }

    /***
     *获取一段时间内的放假天数
     * @param start 开始时间
     * @param end 结束时间
     * @return
     */
    public static int getHolidays(Date start, Date end) {
        HolidayOriginalDataApi holiddayApi = SpringUtil.getBean(HolidayOriginalDataApi.class);
        Result<Integer> res = holiddayApi.getHolidays(start, end);
        int days = 0;
        if (res.isSuccess()) {
            days = res.getData();
        } else {
            BizAssert.fail(res.getErrcode(), res.getErrmsg());
        }
        return days;
    }
}
