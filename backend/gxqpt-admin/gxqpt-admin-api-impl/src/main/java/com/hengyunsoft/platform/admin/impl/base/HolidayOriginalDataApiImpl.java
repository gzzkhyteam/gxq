package com.hengyunsoft.platform.admin.impl.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.base.dto.HolidayDataDTO;
import com.hengyunsoft.platform.admin.api.base.dto.HolidayDataSaveDTO;
import com.hengyunsoft.platform.admin.api.base.dto.HolidayDataUpdateDTO;
import com.hengyunsoft.platform.admin.api.base.dto.HolidayOriginalDataDTO;
import com.hengyunsoft.platform.admin.api.base.dto.HolidayOriginalDataQueryDTO;
import com.hengyunsoft.platform.admin.api.base.dto.HolidayOriginalDataSaveDTO;
import com.hengyunsoft.platform.admin.api.base.dto.HolidayOriginalDataUpdateDTO;
import com.hengyunsoft.platform.admin.entity.base.po.HolidayData;
import com.hengyunsoft.platform.admin.entity.base.po.HolidayOriginalData;
import com.hengyunsoft.platform.admin.impl.utils.holiday.Lunar;
import com.hengyunsoft.platform.admin.impl.utils.holiday.LunarSolarConverterUtil;
import com.hengyunsoft.platform.admin.impl.utils.holiday.Solar;
import com.hengyunsoft.platform.admin.repository.base.example.HolidayOriginalDataExample;
import com.hengyunsoft.platform.admin.repository.base.service.HolidayOriginalService;
import com.hengyunsoft.platform.admin.repository.base.service.HolidayService;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * @author tianai
 * @createTime 2018-02-2
 */
@Api(value = "API - HolidayOriginalDataApiImpl", description = "节假日元数据")
@RestController
@RequestMapping("holiday")
@Slf4j
public class HolidayOriginalDataApiImpl /*implements HolidayOriginalDataApi */ {

    @Autowired
    private HolidayOriginalService holidayOriginalService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private HolidayService holidayService;


    @ApiOperation(value = "查询节假日元数据信息List", notes = "查询节假日元数据信息List")
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public Result<List<HolidayOriginalDataDTO>> getList() {
        HolidayOriginalDataExample example = new HolidayOriginalDataExample();
        example.createCriteria().andStatusEqualTo(1);
        return Result.success(dozerUtils.mapList(holidayOriginalService.findByTypeId(example), HolidayOriginalDataDTO.class));
    }


    /**
     * 查询节假日元数据分页信息
     *
     * @param openApiReq
     * @return
     */

    @ApiOperation(value = "查询节假日元数据分页信息", notes = "查询节假日元数据分页信息")
    @RequestMapping(value = "/findHolidayOriginalPage", method = RequestMethod.POST)
    public Result<PageInfo<HolidayOriginalDataDTO>> findHolidayOriginalPage(@RequestBody OpenApiReq<HolidayOriginalDataQueryDTO> openApiReq) {
        HolidayOriginalDataQueryDTO data = openApiReq.getData();
        HolidayOriginalDataExample example = new HolidayOriginalDataExample();
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        example.createCriteria()
                .andStatusEqualTo(data.getStatus())
                .andNumberLike(HolidayOriginalDataExample.fullLike(data.getNumber()))
                .andNameLike(HolidayOriginalDataExample.fullLike(data.getName()));
        List<HolidayOriginalDataDTO> list = dozerUtils.mapPage(holidayOriginalService.find(example), HolidayOriginalDataDTO.class);
        return Result.success(new PageInfo<>(list));
    }


    @ApiOperation(value = "保存假日元数据信息", notes = "保存假日元数据信息")
    @ApiResponses({
            @ApiResponse(code = 55501, message = "节假日名称不能为空"),
            @ApiResponse(code = 55502, message = "节假日编码不能为空"),
            @ApiResponse(code = 55503, message = "节假日编码不能重复"),
            @ApiResponse(code = 55508, message = "节假日开始月日不能为空"),
            @ApiResponse(code = 55509, message = "节假日天数不能为空"),
    })
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<HolidayOriginalDataDTO> save(@RequestBody HolidayOriginalDataSaveDTO holidaySaveDto) {
        //验证
        BizAssert.assertNotNull(AuthorityExceptionCode.HOLIDAY_NAME_NULL, holidaySaveDto.getName());
        BizAssert.assertNotNull(AuthorityExceptionCode.HOLIDAY_NUMBER_NULL, holidaySaveDto.getNumber());
        BizAssert.assertNotNull(AuthorityExceptionCode.HOLIDAY_STARTDATE_NULL, holidaySaveDto.getStartDate());
        BizAssert.assertNotNull(AuthorityExceptionCode.HOLIDAY_DAYS_NULL, holidaySaveDto.getStartDate());
        BizAssert.assertFalse(AuthorityExceptionCode.HOLIDAY_NUMBER_EXSIST, holidayOriginalService.checkNumber(holidaySaveDto.getNumber()));
        Long adminId = BaseContextHandler.getAdminId();
        //转换
        HolidayOriginalData holiday = dozerUtils.map(holidaySaveDto, HolidayOriginalData.class);

        if (holidaySaveDto.getStartDate() != null && !"".equals(holidaySaveDto.getStartDate())) {
            String[] monthDays = holidaySaveDto.getStartDate().split("-");
            holiday.setMonth(monthDays[0]);
            holiday.setDay(monthDays[1]);
        }
        holiday.setCreateUser(adminId);
        holiday.setUpdateUser(adminId);
        holiday.setCreateTime(new Date());
        holiday.setUpdateTime(new Date());
        //保存
        holiday = holidayOriginalService.saveSelective(holiday);
        return Result.success(dozerUtils.map(holiday, HolidayOriginalDataDTO.class));
    }


    @ApiOperation(value = "修改节假日元数据信息", notes = "修改节假日元数据信息")
    @ApiResponses({
            @ApiResponse(code = 55500, message = "节假日id不能为空"),
            @ApiResponse(code = 55501, message = "节假日名称不能为空"),
            @ApiResponse(code = 55502, message = "节假日编码不能为空"),
            @ApiResponse(code = 55508, message = "节假日开始月日不能为空"),
            @ApiResponse(code = 55509, message = "节假日天数不能为空"),
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody HolidayOriginalDataUpdateDTO holidayUpdateDto) {
        //验证
        BizAssert.assertNotNull(AuthorityExceptionCode.HOLIDAY_ID_NULL, holidayUpdateDto.getId());
        BizAssert.assertNotNull(AuthorityExceptionCode.HOLIDAY_NAME_NULL, holidayUpdateDto.getName());
        BizAssert.assertNotNull(AuthorityExceptionCode.HOLIDAY_STARTDATE_NULL, holidayUpdateDto.getStartDate());
        BizAssert.assertNotNull(AuthorityExceptionCode.HOLIDAY_DAYS_NULL, holidayUpdateDto.getStartDate());
        Long adminId = BaseContextHandler.getAdminId();
        //转换
        HolidayOriginalData holiday = dozerUtils.map(holidayUpdateDto, HolidayOriginalData.class);
        holiday.setUpdateUser(adminId);
        if (!StringUtils.isEmpty(holidayUpdateDto.getStartDate())) {
            String[] monthDays = holidayUpdateDto.getStartDate().split("-");
            holiday.setMonth(monthDays[0]);
            holiday.setDay(monthDays[1]);
        }
        //更新
        holidayOriginalService.updateHolidayOriginalById(holiday);
        return Result.success(true);
    }


    @ApiOperation(value = "删除节假日元数据信息", notes = "删除节假日元数据信息")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Result<Boolean> delete(@RequestParam(value = "id") Long id) {
        if (id == null) {
            return Result.success(null);
        }
        holidayOriginalService.deleteHolidayOriginalById(id);
        return Result.success(true);
    }


    @ApiOperation(value = "根据年份查询节假日信息List", notes = "根据年份查询节假日信息List")
    @RequestMapping(value = "/getDataList", method = RequestMethod.GET)
    public Result<List<HolidayDataDTO>> getDataList(@RequestParam(value = "year") String year
            , @RequestParam(value = "month") String month) {
        List<HolidayData> list = holidayService.findByTypeId(year, month);
        return Result.success(dozerUtils.mapList(list, HolidayDataDTO.class));
    }


    @ApiOperation(value = "保存假日信息", notes = "保存假日信息")
    @ApiResponses({
            @ApiResponse(code = 55501, message = "节假日名称不能为空"),
            @ApiResponse(code = 55502, message = "节假日编码不能为空"),
            @ApiResponse(code = 55503, message = "节假日编码不能重复"),
            @ApiResponse(code = 55505, message = "节假日开始日期不能为空"),
            @ApiResponse(code = 55506, message = "节假日结束日期不能为空"),
            @ApiResponse(code = 55507, message = "节假日年不能为空"),
    })
    @RequestMapping(value = "/saveHolidayData", method = RequestMethod.POST)
    public Result<HolidayDataDTO> saveHolidayData(@RequestBody HolidayDataSaveDTO holidaySaveDto) {
        //验证
        BizAssert.assertNotNull(AuthorityExceptionCode.HOLIDAY_NAME_NULL, holidaySaveDto.getName());
        BizAssert.assertNotNull(AuthorityExceptionCode.HOLIDAY_NUMBER_NULL, holidaySaveDto.getNumber());
        BizAssert.assertFalse(AuthorityExceptionCode.HOLIDAY_NUMBER_EXSIST, holidayService.checkNumber(holidaySaveDto.getNumber()));
        BizAssert.assertNotEmpty(AuthorityExceptionCode.HOLIDAY_STARTTIME_NULL, String.valueOf(holidaySaveDto.getStartTime()));
        BizAssert.assertNotEmpty(AuthorityExceptionCode.HOLIDAY_ENDTIME_NULL, String.valueOf(holidaySaveDto.getEndTime()));
        BizAssert.assertNotEmpty(AuthorityExceptionCode.HOLIDAY_YEAR_NULL, String.valueOf(holidaySaveDto.getYear()));
        Long adminId = BaseContextHandler.getAdminId();
        //转换
        HolidayData holiday = dozerUtils.map(holidaySaveDto, HolidayData.class);
        holiday.setYear(holidaySaveDto.getStartTime().substring(0, 4));
        holiday.setCreateUser(adminId);
        holiday.setUpdateUser(adminId);
        holiday.setCreateTime(new Date());
        holiday.setUpdateTime(new Date());
        //保存
        holiday = holidayService.saveHolidayData(holiday);
        return Result.success(dozerUtils.map(holiday, HolidayDataDTO.class));
    }

    /**
     * 查询节假日元数据信息
     *
     * @param id
     * @return
     */

    @ApiOperation(value = "查询节假日元数据信息", notes = "查询节假日元数据信息")
    @RequestMapping(value = "/getHolidayOriginal", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 55500, message = "节假日id不能为空"),
    })
    public Result<HolidayOriginalDataDTO> getHolidayOriginal(@RequestParam(value = "id") Long id) {
        BizAssert.assertNotNull(AuthorityExceptionCode.HOLIDAY_ID_NULL, id);
        HolidayOriginalData holidayOriginal = holidayOriginalService.getById(id);
        return Result.success(dozerUtils.map(holidayOriginal, HolidayOriginalDataDTO.class));
    }

    /**
     * 修改节假日信息
     *
     * @param updateDTO
     * @return
     */

    @ApiOperation(value = "修改假日信息", notes = "修改假日信息")
    @ApiResponses({
            @ApiResponse(code = 55504, message = "节假日信息不能为空"),
            @ApiResponse(code = 55500, message = "节假日id不能为空"),
            @ApiResponse(code = 55501, message = "节假日名称不能为空"),
            @ApiResponse(code = 55505, message = "节假日开始日期不能为空"),
            @ApiResponse(code = 55506, message = "节假日结束日期不能为空"),
            @ApiResponse(code = 55507, message = "节假日年不能为空"),
    })
    @RequestMapping(value = "/updateHolidayData", method = RequestMethod.POST)
    public Result<HolidayDataDTO> updateHolidayData(@RequestBody HolidayDataUpdateDTO updateDTO) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.HOLIDAY_NULL, updateDTO);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.HOLIDAY_ID_NULL, String.valueOf(updateDTO.getId()));
        BizAssert.assertNotEmpty(AuthorityExceptionCode.HOLIDAY_NAME_NULL, String.valueOf(updateDTO.getName()));
        BizAssert.assertNotEmpty(AuthorityExceptionCode.HOLIDAY_STARTTIME_NULL, String.valueOf(updateDTO.getStartTime()));
        BizAssert.assertNotEmpty(AuthorityExceptionCode.HOLIDAY_ENDTIME_NULL, String.valueOf(updateDTO.getEndTime()));
        BizAssert.assertNotEmpty(AuthorityExceptionCode.HOLIDAY_YEAR_NULL, String.valueOf(updateDTO.getYear()));
        //转换
        Long adminId = BaseContextHandler.getAdminId();
        HolidayData holiday = dozerUtils.map(updateDTO, HolidayData.class);
        holiday.setUpdateUser(adminId);
        holiday.setUpdateTime(new Date());
        //保存
        int result = holidayService.updateByIdSelective(holiday);
        if (result > 0) {
            return Result.success(dozerUtils.map(holiday, HolidayDataDTO.class));
        }
        return Result.fail("修改失败");
    }


    /**
     * 生成节假日
     *
     * @param year
     * @return
     */

    @ApiOperation(value = "生成节假日", notes = "生成节假日")
    @ApiResponses({
            @ApiResponse(code = 55507, message = "节假日年不能为空"),
    })
    @RequestMapping(value = "/createHolidayDate", method = RequestMethod.GET)
    public Result<String> createHolidayDate(@RequestParam(value = "year") String year) {
        //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.HOLIDAY_YEAR_NULL, year);
        Date date = new Date();
        Integer nowYear = Calendar.getInstance().get(Calendar.YEAR);
        if (Integer.valueOf(year) < nowYear) {
            return Result.fail("只能生成今年之后的数据。");
        }
        List<HolidayData> list = new ArrayList<>();
        Long adminId = BaseContextHandler.getAdminId();
        Integer lyear = Integer.valueOf(year);
        HolidayOriginalDataExample example = new HolidayOriginalDataExample();
        example.createCriteria().andStatusEqualTo(1);
        List<HolidayOriginalData> holidayOri = holidayOriginalService.findByTypeId(example);
        dateRuleOfGeneration(year, list, adminId, lyear, holidayOri);
        //删除日期表数据
        holidayService.deleteByYear(year);
        holidayService.save(list);
        return Result.success("生成成功。");
    }

    /**
     * 日期生成规则
     *
     * @param year
     * @param list
     * @param adminId
     * @param lyear
     * @param holidayOri
     */
    private void dateRuleOfGeneration(String year, List<HolidayData> list,
                                      Long adminId, Integer lyear,
                                      List<HolidayOriginalData> holidayOri) {
        for (HolidayOriginalData ho : holidayOri) {
            HolidayData hd = new HolidayData();
            if ("0".equals(ho.getCalendarType())) {
                int lunarMonth = Integer.parseInt(ho.getMonth());
                int lunarDay = Integer.parseInt(ho.getDay());
                //农历先不处理闰月情况
                Lunar lunar = new Lunar(false, lunarDay, lunarMonth, lyear);
                Solar solar = LunarSolarConverterUtil.LunarToSolar(lunar);
                String month = solar.solarMonth + "";
                String lday = solar.solarDay + "";
                if (solar.solarMonth <= 9) {
                    month = "0" + month;
                }
                if (solar.solarDay <= 9) {
                    lday = "0" + lday;
                }
                //判断是否允许生成
                boolean tp = checkCanCreate(ho.getStarTime(), ho.getEndTime(), solar.solarYear + "-" + month + "-" + lday);
                if (!tp) {
                    continue;
                }
                String smonth = "" + month;
                smonth = getDayOrMonthValue(smonth, Integer.valueOf(month));
                String sday = "" + lday;
                sday = getDayOrMonthValue(sday, Integer.valueOf(lday));
                hd.setStartTime(solar.solarYear + "-" + smonth + "-" + sday);
                //处理跨月、跨年问题
                String cmonth = "" + solar.solarMonth;
                String cday = "" + solar.solarDay;
                int mont = solar.solarMonth;
                cmonth = getDayOrMonthValue(cmonth, mont);
                int dayt = solar.solarDay;
                cday = getDayOrMonthValue(cday, dayt);
                LocalDate startLocalDate = LocalDate.parse(solar.solarYear + "-" + cmonth + "-" + cday, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                paseLocalDateSetValue(ho, hd, startLocalDate);
                hd.setYear(solar.solarYear + "");
            } else {
                //判断是否允许生成
                boolean tp = checkCanCreate(ho.getStarTime(), ho.getEndTime(), year + "-" + ho.getMonth() + "-" + ho.getDay());
                if (!tp) {
                    continue;
                }
                String smonth = "" + ho.getMonth();
                smonth = getDayOrMonthValue(smonth, Integer.valueOf(ho.getMonth()));
                String sday = "" + ho.getDay();
                sday = getDayOrMonthValue(sday, Integer.valueOf(ho.getDay()));
                hd.setStartTime(year + "-" + smonth + "-" + sday);
                //处理跨年、跨月问题
                String cmonth = "" + ho.getMonth();
                String cday = "" + ho.getDay();
                int mont = Integer.valueOf(ho.getMonth());
                cmonth = getDayOrMonthValue(cmonth, mont);
                int dayt = Integer.valueOf(ho.getDay());
                cday = getDayOrMonthValue(cday, dayt);
                LocalDate startLocalDate = LocalDate.parse(year + "-" + cmonth + "-" + cday, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                paseLocalDateSetValue(ho, hd, startLocalDate);
                hd.setYear(year);
            }
            hd.setName(ho.getName());
            hd.setNumber(ho.getNumber());
            hd.setCreateTime(new Date());
            hd.setUpdateTime(new Date());
            hd.setCreateUser(adminId);
            hd.setUpdateUser(adminId);
            hd.setStatus(1);
            hd.setType("1");
            list.add(hd);
        }
    }

    private void paseLocalDateSetValue(HolidayOriginalData ho, HolidayData hd, LocalDate startLocalDate) {
        LocalDate endLocalDate = startLocalDate.plusDays(Integer.valueOf(ho.getHolidayDays())-1);
        String emonth = "" + endLocalDate.getMonth().getValue();
        emonth = getDayOrMonthValue(emonth, endLocalDate.getMonth().getValue());
        String eday = "" + endLocalDate.getDayOfMonth();
        eday = getDayOrMonthValue(eday, endLocalDate.getDayOfMonth());
        hd.setEndTime(endLocalDate.getYear() + "-" + emonth + "-" + eday);
    }

    private String getDayOrMonthValue(String value, int ivalue) {
        if (ivalue <= 9) {
            value = "0" + ivalue;
        }
        return value;
    }

    /**
     * 生成节假日比较是否可以生成
     *
     * @param startTime
     * @param endTime
     * @param holidayTime
     * @return
     */
    private boolean checkCanCreate(String startTime, String endTime, String holidayTime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date start = format.parse(startTime);
            Date end = format.parse(endTime);
            Date holiday = format.parse(holidayTime);
            if (holiday.getTime() >= start.getTime() && holiday.getTime() <= end.getTime()) {
                return true;
            }
        } catch (Exception e) {
            log.info("日期转换出错.");
            return true;
        }
        return false;
    }

    /**
     * 根据ID查询节假日信息
     *
     * @param id
     * @return
     */

    @ApiOperation(value = "查询节假日信息", notes = "查询节假日信息")
    @RequestMapping(value = "/getHolidayById", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 55500, message = "节假日id不能为空"),
    })
    public Result<HolidayDataDTO> getHolidayById(@RequestParam(value = "id") Long id) {
        BizAssert.assertNotNull(AuthorityExceptionCode.HOLIDAY_ID_NULL, id);
        HolidayData ho = holidayService.getById(id);
        return Result.success(dozerUtils.map(ho, HolidayDataDTO.class));
    }

    /***
     * 查询当前日期是否放假(要求一天只能属于一个节假日,加班只能是周末)
     * eg:2018-10-02
     * @param nowDay
     * @return
     */

    @ApiOperation(value = "查询当前日期是否放假eg:2018-10-02", notes = "查询当前日期是否放假eg:2018-10-02")
    @RequestMapping(value = "getHolidayByNowDay", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 55509, message = "节假日天数不能为空"),
    })
    @IgnoreToken
    public Result<Boolean> getHolidayByNowDay(@RequestParam(value = "nowDay") String nowDay) {
        BizAssert.assertNotNull(AuthorityExceptionCode.HOLIDAY_DAYS_NULL, nowDay);
        return Result.success(holidayService.getBooleanResult(nowDay));
    }

    /**
     * 描述：查询一个时间段的节假日天数(要求一天只能属于一个节假日,加班只能是周末)
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/7/25
     * 修改内容：
     */

    @RequestMapping(value = "getHolidays", method = RequestMethod.GET)
    @ApiOperation(value = "查询一个时间段的节假日天数", notes = "查询一个时间段的节假日天数")
    @ApiResponses({
            @ApiResponse(code = 55505, message = "节假日开始日期不能为空"),
            @ApiResponse(code = 55506, message = "节假日结束日期不能为空"),
    })
    public Result<Integer> getHolidays(@RequestParam("start") Date start,
                                       @RequestParam("end") Date end) {
        BizAssert.assertNotNull(AuthorityExceptionCode.HOLIDAY_STARTTIME_NULL, start);
        BizAssert.assertNotNull(AuthorityExceptionCode.HOLIDAY_ENDTIME_NULL, end);

        int holiday = 0;//放假天  周末 + 除去周末的假期  - 周末的加班

        int totalWeekDays = DateUtils.hasWeekEndContain(start, end);//总周末天数
        holiday += totalWeekDays;//加上周末天数

        List<HolidayData> holidayDatas = holidayService.getHolidays(start, end);

        for (HolidayData hd : holidayDatas) {
            Date startTime = DateUtils.parse(hd.getStartTime(), DateUtils.DEFAULT_DATE_FORMAT);
            if (startTime.before(start)) {
                startTime = start;
            }
            Date endTime = DateUtils.parse(hd.getEndTime(), DateUtils.DEFAULT_DATE_FORMAT);
            if (endTime.after(end)) {
                endTime = end;
            }
            int hasWeeknds = DateUtils.hasWeekEndContain(startTime, endTime);
            if (hd.getType().equals(String.valueOf(1))) {//加上除去周末的放假天数
                holiday += ((DateUtils.getDistDates(startTime, endTime) + 1) - hasWeeknds);
            } else if (!hd.getType().equals(String.valueOf(1))) {//加班(只能是周末加班)
                holiday -= (DateUtils.getDistDates(startTime, endTime) + 1);
            }
        }
        return Result.success(holiday);
    }
}
