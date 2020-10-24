package com.hengyunsoft.platform.admin.api.base.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.base.api.hystrix.HolidayOriginalDataHystrix;
import com.hengyunsoft.platform.admin.api.base.dto.*;
import com.hengyunsoft.platform.admin.api.core.api.hystrix.GxqptEmpApiHystrix;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * @author tianai  ${gxqpt.feign.admin-server:gxqpt-admin-server}
 * @createTime 2018-02-2
 */
//@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-admin-server}", path = "/api/admin", fallback = HolidayOriginalDataHystrix.class)
@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-admin-server}", fallback = HolidayOriginalDataHystrix.class)
public interface HolidayOriginalDataApi {
    /**
     * 查询节假日元数据列表
     * @param
     * @return
     */
    @RequestMapping(value = "/holiday/getList", method = RequestMethod.GET)
    Result<List<HolidayOriginalDataDTO>> getList();

    /**
     * 查询节假日元数据分页数据
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/holiday/findHolidayOriginalPage", method = RequestMethod.POST)
    Result<PageInfo<HolidayOriginalDataDTO>> findHolidayOriginalPage(@RequestBody OpenApiReq<HolidayOriginalDataQueryDTO> openApiReq);

    /**
     * 保存节假日元数据信息
     *
     * @param holidaySaveDto
     * @return
     */
    @RequestMapping(value = "/holiday/save", method = RequestMethod.POST)
    Result<HolidayOriginalDataDTO> save(@RequestBody HolidayOriginalDataSaveDTO holidaySaveDto);

    /**
     * 修改节假日元数据信息
     *
     * @param holidayUpdateDto
     * @return
     */
    @RequestMapping(value = "/holiday/update", method = RequestMethod.POST)
    Result<Boolean> update(@RequestBody HolidayOriginalDataUpdateDTO holidayUpdateDto);

    /**
     * 删除节假日元数据信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/holiday/delete", method = RequestMethod.POST)
    Result<Boolean> delete(@RequestParam(value = "id") Long id);

    /**
     * 生成节假日信息
     *
     * @param holidaySaveDto
     * @return
     */
    @RequestMapping(value = "/holiday/saveHolidayData", method = RequestMethod.POST)
    Result<HolidayDataDTO> saveHolidayData(@RequestBody HolidayDataSaveDTO holidaySaveDto);

    /**
     * 修改节假日信息
     * @param holidaySaveDto
     * @return
     */
    @RequestMapping(value = "/holiday/updateHolidayData", method = RequestMethod.POST)
    Result<HolidayDataDTO> updateHolidayData(@RequestBody HolidayDataUpdateDTO updateDTO);

    /**
     * 查询节假日列表
     * @param
     * @return
     */
    @RequestMapping(value = "/holiday/getDataList", method = RequestMethod.GET)
    Result<List<HolidayDataDTO>> getDataList(@RequestParam(value = "year") String year,@RequestParam(value = "month") String month);

    /**
     * 查询节假日元数据信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/holiday/getHolidayOriginal", method = RequestMethod.GET)
    Result<HolidayOriginalDataDTO> getHolidayOriginal(@RequestParam(value = "id") Long id);

    /**
     * 节假日生成
     * @param year
     * @return
     */
    @RequestMapping(value = "/holiday/createHolidayDate", method = RequestMethod.GET)
    Result<String> createHolidayDate(@RequestParam(value = "year") String year);

    /**
     * 根据ID查询节假日
     * @param id
     * @return
     */
    @RequestMapping(value = "/holiday/getHolidayById", method = RequestMethod.GET)
    Result<HolidayDataDTO> getHolidayById(@RequestParam(value = "id") Long id);

    /**
     * 查询当前日期是否放假
     * @param nowDay
     * @return
     */
    @RequestMapping(value = "/holiday/getHolidayByNowDay", method = RequestMethod.GET)
    Result<Boolean> getHolidayByNowDay(@RequestParam(value="nowDay") String nowDay) ;

    /**
     * 描述：查询一个时间段的节假日天数
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/7/25
     * 修改内容：
     */
    @RequestMapping(value = "/holiday/getHolidays", method = RequestMethod.GET)
    Result<Integer> getHolidays(@RequestParam("start") Date start, @RequestParam("end") Date end);
}
