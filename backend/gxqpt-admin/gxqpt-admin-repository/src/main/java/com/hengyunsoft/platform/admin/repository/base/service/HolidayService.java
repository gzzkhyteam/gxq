package com.hengyunsoft.platform.admin.repository.base.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.admin.entity.base.po.HolidayData;
import com.hengyunsoft.platform.admin.repository.base.example.HolidayDataExample;

import java.util.Date;
import java.util.List;

/**
 * @author tianai
 * @createTime 2018-02-2
 */
public interface HolidayService extends BaseService<Long, HolidayData, HolidayDataExample> {


    /**
     * 根據年份查詢节假日
     *
     * @param year  年份
     * @param month 月份
     * @return 实体list
     */
    List<HolidayData> findByTypeId(String year, String month);

    /**
     * 生成节假日数据
     */
    HolidayData saveHolidayData(HolidayData entity);

    /**
     * 判断编码是否存在
     *
     * @param number
     * @return
     */
    boolean checkNumber(String number);

    /**
     * 根据年份删除历史节假日信息
     *
     * @param data
     */
    void deleteByYear(String year);

    /**
     * 根据日期是否查询
     *
     * @param nowDay
     * @return
     */
    HolidayData getHolidayByNowDay(String nowDay);

    /***
     * 根据数据范围获取节假日
     * @param start
     * @param end
     * @return
     */
    List<HolidayData> getHolidays(Date start, Date end);

    /**
     * 查询当前日期是否放假(要求一天只能属于一个节假日,加班只能是周末)
     * @param nowDay
     * @return
     */
    Boolean getBooleanResult(String nowDay);
}
