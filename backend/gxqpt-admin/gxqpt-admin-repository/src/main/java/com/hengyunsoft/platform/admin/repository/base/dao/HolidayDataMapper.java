package com.hengyunsoft.platform.admin.repository.base.dao;

import com.hengyunsoft.platform.admin.entity.base.po.HolidayData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HolidayDataMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.admin.entity.base.po.HolidayData, com.hengyunsoft.platform.admin.repository.base.example.HolidayDataExample> {

    /**
     * 根据年份删除节假日信息
     *
     * @param year
     */
    void deleteByYear(@Param("year") String year);

    /**
     * 获取当前日期是否放假
     *
     * @param nowDay
     * @return
     */
    int getHolidayByNowDay(@Param("nowDay") String nowDay);

    /***
     * 根据时间段查询
     * @param startDate
     * @param endDate
     * @return
     */
    List<HolidayData> getByDisDate(@Param("startTime") Date startDate, @Param("endTime") Date endDate);
}