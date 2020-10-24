package com.hengyunsoft.platform.admin.api.base.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.base.api.HolidayOriginalDataApi;
import com.hengyunsoft.platform.admin.api.base.dto.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * feign 熔断机制的实现， 默认返回超时响应
 * @author tianai
 * @createTime 2018-02-2
 */
@Component
public class HolidayOriginalDataHystrix implements HolidayOriginalDataApi{


    /**
     * 查询节假日元数据信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<List<HolidayOriginalDataDTO>> getList() {
        return Result.timeout();
    }

    /**
     * 查询节假日元数据分页数据
     * @param openApiReq
     * @return
     */
    @Override
    public Result<PageInfo<HolidayOriginalDataDTO>> findHolidayOriginalPage(OpenApiReq<HolidayOriginalDataQueryDTO> openApiReq) {
        return Result.timeout();
    }

    /**
     * 保存节假日元数据信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<HolidayOriginalDataDTO> save(HolidayOriginalDataSaveDTO holidaySaveDto) {
        return Result.timeout();
    }
    /**
     * 修改节假日元数据信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<Boolean> update(HolidayOriginalDataUpdateDTO holidayUpdateDto) {
        return Result.timeout();
    }
    /**
     * 删除节假日元数据信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<Boolean> delete(Long id) {
        return Result.timeout();
    }
    /**
     * 生成节假日信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<HolidayDataDTO> saveHolidayData(HolidayDataSaveDTO holidaySaveDto) {
        return Result.timeout();
    }
    /**
     * 根据年份查询节假日list信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<List<HolidayDataDTO>> getDataList(String year,String month) {
        return Result.timeout();
    }


    /**
     * 根据ID查询详情
     * @param id
     * @return
     */
    @Override
    public Result<HolidayOriginalDataDTO> getHolidayOriginal(Long id) {
        return Result.timeout();
    }


    /**
     * 修改节假日信息
     * @param holidaySaveDto
     * @return
     */
    @Override
    public Result<HolidayDataDTO> updateHolidayData(HolidayDataUpdateDTO updateDTO) {
        return Result.timeout();
    }

    /**
     * 节假日生成
     * @param year
     * @return
     */
    @Override
    public Result<String> createHolidayDate(String year) {
        return Result.timeout();
    }

    /**
     * 根据ID查询节假日信息
     * @param id
     * @return
     */
    @Override
    public Result<HolidayDataDTO> getHolidayById(Long id) {
        return Result.timeout();
    }

    /**
     * 查询当前日期是否放假
     * @param nowDay
     * @return
     */
    @Override
    public Result<Boolean> getHolidayByNowDay(String nowDay) {
        return Result.timeout();
    }

    @Override
    public Result<Integer> getHolidays(Date start, Date end) {
        return Result.timeout();
    }
}
