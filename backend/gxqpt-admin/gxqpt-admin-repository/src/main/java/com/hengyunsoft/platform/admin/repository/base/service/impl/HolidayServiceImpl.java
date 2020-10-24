package com.hengyunsoft.platform.admin.repository.base.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.platform.admin.entity.base.po.HolidayData;
import com.hengyunsoft.platform.admin.repository.base.dao.HolidayDataMapper;
import com.hengyunsoft.platform.admin.repository.base.example.HolidayDataExample;
import com.hengyunsoft.platform.admin.repository.base.service.HolidayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @author tianai
 * @createTime 2018-02-2
 */
@Service
@Slf4j
public class HolidayServiceImpl extends BaseServiceImpl<Long, HolidayData, HolidayDataExample> implements HolidayService {

    @Autowired
    private HolidayDataMapper holidayDataMapper;


    @Override
    protected BaseNormalDao<Long, HolidayData, HolidayDataExample> getDao() {
        return holidayDataMapper;
    }

    /**
     * 根據年份查詢节假日
     *
     * @param year  年份
     * @param month 月份
     * @return 节假日list
     */
    @Override
    public List<HolidayData> findByTypeId(String year, String month) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (Integer.valueOf(month) <= 9) {
            month = "0" + month;
        }
        String startTime = year + "-" + month + "-01";
        //处理跨年月问题，查询三个月的数据
        LocalDate startLocalDate = LocalDate.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate queryStart = startLocalDate.plusMonths(-1);
        Date start = localDateToDate(queryStart);
        String realStartTime = sdf.format(start);

        String endTime = year + "-" + month + "-31";
        LocalDate endLocalDate = LocalDate.parse(endTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate queryendStart = endLocalDate.plusMonths(1);
        Date end = localDateToDate(queryendStart);
        String realEndTime = sdf.format(end);

        HolidayDataExample example = new HolidayDataExample();
        example.createCriteria().andYearEqualTo(year).andStartTimeGreaterThanOrEqualTo(realStartTime)
                .andEndTimeLessThanOrEqualTo(realEndTime).andStatusEqualTo(1);
        List<HolidayData> holidayList = holidayDataMapper.selectByExample(example);
        return holidayList;
    }
    private Date localDateToDate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 生成节假日数据
     */
    @Override
    public HolidayData saveHolidayData(HolidayData entity) {
        HolidayData holidayData = this.save(entity);
        return holidayData;
    }

    /**
     * 判断编码是否存在
     *
     * @param number
     * @return
     */
    @Override
    public boolean checkNumber(String number) {
        HolidayDataExample example = new HolidayDataExample();
        example.createCriteria().andNumberEqualTo(number);
        return holidayDataMapper.countByExample(example) > 0 ? true : false;
    }

    /**
     * 根据年份删除历史节假日信息
     *
     * @param year
     */
    @Override
    public void deleteByYear(String year) {
        holidayDataMapper.deleteByYear(year);
    }

    /**
     * 获取当前日期是否放假
     *
     * @param nowDay
     * @return
     */
    @Override
    public HolidayData getHolidayByNowDay(String nowDay) {
        HolidayDataExample example = new HolidayDataExample();
        example.createCriteria().andStartTimeGreaterThanOrEqualTo(nowDay).andEndTimeLessThanOrEqualTo(nowDay);
        return getUnique(example);
    }

    @Override
    public List<HolidayData> getHolidays(Date start, Date end) {
        return holidayDataMapper.getByDisDate(start, end);
    }

    /**
     *  查询当前日期是否放假(要求一天只能属于一个节假日,加班只能是周末)
     * @param nowDay
     * @return
     */
    @Override
    public Boolean getBooleanResult(String nowDay) {
        boolean isWorkday = DateUtils.isWorkday(nowDay);
        HolidayData holidayData = getHolidayByNowDay(nowDay);
        boolean isHolidays;
        if (isWorkday) {
            isHolidays = holidayData != null && "1".equals(holidayData.getType());
        } else {
            isHolidays = holidayData == null || !"1".equals(holidayData.getType());
        }
        return isHolidays;
    }
}
