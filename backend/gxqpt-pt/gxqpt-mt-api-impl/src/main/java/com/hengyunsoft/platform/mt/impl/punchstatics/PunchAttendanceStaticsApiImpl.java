package com.hengyunsoft.platform.mt.impl.punchstatics;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.MtExceptionCode;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.mt.api.punchstatics.dto.PunchAttendanceStaticsDTO;
import com.hengyunsoft.platform.mt.api.punchstatics.dto.StaticsDTO;
import com.hengyunsoft.platform.mt.api.punchstatics.dto.WebQueryMyStaticsParamDTO;
import com.hengyunsoft.platform.mt.api.punchstatics.dto.WebQueryStaticParamDTO;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprLeave;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.PunchAttendanceStatics;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.PunchAttendanceStaticsExt;
import com.hengyunsoft.platform.mt.entity.userconfig.po.UserConfig;
import com.hengyunsoft.platform.mt.impl.userconfig.UserConfigJobType;
import com.hengyunsoft.platform.mt.repository.apprwork.service.ApprLeaveService;
import com.hengyunsoft.platform.mt.repository.punchstatics.service.PunchAttendanceStaticsService;
import com.hengyunsoft.platform.mt.repository.userconfig.service.UserConfigService;
import com.hengyunsoft.platform.mt.utils.HolidayUtil;
import com.hengyunsoft.platform.mt.utils.UnityUtil;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;

/**
 * com.hengyunsoft.platform.mt.impl.punchstatics
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：数据统计展示接口
 * 修改人：gbl
 * 修改时间：2018/7/24
 * 修改内容：新增基础接口
 */
@Api(value = "API - PunchAttendanceStaticsApiImpl.java", description = "数据统计展示接口")
@RestController
@RequestMapping("punchAttendanceStatics")
@Slf4j
public class PunchAttendanceStaticsApiImpl /*implements PunchAttendanceStaticsApi*/ {
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private PunchAttendanceStaticsService punchAttendanceStaticsService;
    @Autowired
    private ApprLeaveService apprLeaveService;
    @Autowired
    private UserConfigService userConfigService;

    /***
     * 统计相关的时候，要从用户开始使用本系统时间
     * 用户有打开记录或者审批申请的开始时间
     * @param startDate
     * @return
     */
    private Date getStartAttDay(Date startDate) {
        Long userId = BaseContextHandler.getAdminId();
        UserConfig config = userConfigService.getUserConfigByidAndType(userId, UserConfigJobType.start_user_pt.jobId);
        if (config == null) {//如果没有的话就没有开始使用本系统时间
            //throw new BizException(-1, "您没有使用过该系统(没有打过卡，或者没有申请过审批)");
            return new Date();
        }
        String jobValue = config.getJobValue();
        Date date = DateUtils.string2Date(jobValue, DateUtils.DATE_TIME_FORMAT);
        if (startDate == null) {
            return date;
        }
        return startDate.after(date) ? startDate : date;

    }

    /**
     * 描述：web端查询我的考勤
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/7/24
     * 修改内容：
     */

    @RequestMapping(value = "webQueryMyStatics", method = RequestMethod.POST)
    @ApiOperation(value = "web端查询我的考勤", notes = "web端查询我的考勤")
    @ApiResponses({
            @ApiResponse(code = 93058, message = "查询参数不能为空"),
    })
    public Result<PageInfo<PunchAttendanceStaticsDTO>> getWebQueryMyStatics(@RequestBody OpenApiReq<WebQueryMyStaticsParamDTO> openApiReq) {
        BizAssert.assertNotNull(MtExceptionCode.WEB_QUERY_MY_STATICS_PARAM_EMPTY, openApiReq);

        Map<String, Object> param = new HashMap<>();
        Long userId = BaseContextHandler.getAdminId();
        String unitId = UnityUtil.getUnityId(userId);
        param.put("unitId", unitId);
        param.put("userId", userId);//只看自己的
        Date startAttDay = getStartAttDay(openApiReq.getData().getStartAttDay());
        param.put("startAttDay", startAttDay);
        Date endAttDay = null;
        if (openApiReq.getData() != null && openApiReq.getData().getEndAttDay() != null) {
            //最多只能查到昨天的数据，因为如果用户没有操作那么要晚上跑job才能生成用户今天的数据
            endAttDay = openApiReq.getData().getEndAttDay();
            Date todayTime = DateUtils.getTodayTime("23:59:59");
            Date yesDate = DateUtils.addDays(todayTime, -1);
            if (endAttDay.after(yesDate)) {
                endAttDay = yesDate;
            }
        }
        param.put("endAttDay", endAttDay);

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<PunchAttendanceStaticsExt> list = punchAttendanceStaticsService.webQueryMyStatics(param);

        PageInfo<PunchAttendanceStaticsDTO> data = new PageInfo<>(dozerUtils.mapPage(list, PunchAttendanceStaticsDTO.class));
        if (data.getPageNum() == data.getPages() && data.getList() != null && data.getList().size() > 0) {
            PunchAttendanceStaticsExt total = punchAttendanceStaticsService.queryMyStaticsSum(param);
            if (total == null) {
                total = new PunchAttendanceStaticsExt();
                total.setUserId(userId);
            }
            total.setAttDay("合计");
            total.setWeekDay(null);
            PunchAttendanceStaticsDTO totalDTO = dozerUtils.map(total, PunchAttendanceStaticsDTO.class);
            setTimes(total, totalDTO, startAttDay, endAttDay);
            data.getList().add(totalDTO);
        }
        return Result.success(data);
    }

    /***
     * 设置次数
     * @param pExt
     * @param startAttDay
     * @param endAttDay
     */
    private void setTimes(PunchAttendanceStaticsExt total, PunchAttendanceStaticsDTO pExt, Date startAttDay, Date endAttDay) {
        //外勤次数
        pExt.setOutHousTime(total.getOutHousTime());
        //加班次数 getApprOverTimeByTimeAndState
        pExt.setWorkHousTime(total.getWorkHousTime());
        //请假次数
        pExt.setLeaveHousTime(total.getLeaveHousTime());
        //出差次数
        pExt.setTravelHousTime(total.getTravelHousTime());

        //应出勤和节假日
//        int holidays = HolidayUtil.getHolidays(startAttDay, endAttDay);//节假日
//        int needDays = DateUtils.getDistDates(startAttDay, endAttDay) + 1 - holidays;//应该出勤天数
//        pExt.setHolidays(holidays);

    }

    /**
     * 描述：web端考勤统计接口
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/7/25
     * 修改内容：
     */
    @RequestMapping(value = "webQueryStatics", method = RequestMethod.POST)
    @ApiOperation(value = "web端考勤统计接口", notes = "web端考勤统计接口")
    @ApiResponses({
            @ApiResponse(code = 93058, message = "查询参数不能为空"),
    })

    public Result<PageInfo<PunchAttendanceStaticsDTO>> getWebQueryStatics
    (@RequestBody OpenApiReq<WebQueryStaticParamDTO> openApiReq) {
        BizAssert.assertNotNull(MtExceptionCode.WEB_QUERY_MY_STATICS_PARAM_EMPTY, openApiReq);
        StringBuffer whereSb = new StringBuffer();
        StringBuffer havingSb = new StringBuffer();

        Date starDate = openApiReq.getData().getStartAttDay();
        Date endDate = openApiReq.getData().getEndAttDay();
        if (starDate == null) {
            starDate = DateUtils.string2Date("2017-1-1", DateUtils.DEFAULT_DATE_FORMAT);
        }
//        starDate = getStartAttDay(starDate);
        if (endDate == null) {
            endDate = new Date();
        }

        Long userId = BaseContextHandler.getAdminId();
        String unityId = UnityUtil.getUnityId(userId);
        whereSb.append(" AND unit_id = '" + unityId + "' ");//只看本单位的
        whereSb.append("  AND  att_day >= '" + DateUtils.date2String(starDate, DateUtils.DEFAULT_DATE_FORMAT) + "' ");
        whereSb.append("  AND  att_day <= '" + DateUtils.date2String(endDate, DateUtils.DEFAULT_DATE_FORMAT) + "' ");

        if (StringUtils.isNotEmpty(openApiReq.getData().getUserName())) {
            whereSb.append("  AND  name_ LIKE '%" + openApiReq.getData().getUserName().trim() + "%' ");
        }
        if (StringUtils.isNotEmpty(openApiReq.getData().getDeptName())) {
            whereSb.append("  AND  maindeptname = '" + openApiReq.getData().getDeptName() + "' ");
        }
        if (StringUtils.isNotEmpty(openApiReq.getData().getMaindutyName())) {
            whereSb.append("  AND  maindutyname = '" + openApiReq.getData().getMaindutyName() + "' ");
        }


        if (StringUtils.isNotEmpty(openApiReq.getData().getEarlyHour())) {
            havingSb.append("  AND  SUM(early_hour) " + openApiReq.getData().getEarlyHour() + " ");
        }
        if (StringUtils.isNotEmpty(openApiReq.getData().getLateHour())) {
            havingSb.append("  AND  SUM(late_hour) " + openApiReq.getData().getLateHour() + " ");
        }
        if (StringUtils.isNotEmpty(openApiReq.getData().getMinerCount())) {
            havingSb.append("  AND  SUM(miner_count) " + openApiReq.getData().getMinerCount() + " ");
        }
        if (StringUtils.isNotEmpty(openApiReq.getData().getLeaveHous())) {
            havingSb.append("  AND  SUM(leave_hous) " + openApiReq.getData().getLeaveHous() + " ");
        }
        if (StringUtils.isNotEmpty(openApiReq.getData().getOutHous())) {
            havingSb.append("  AND  SUM(out_hous) " + openApiReq.getData().getOutHous() + " ");
        }
        if (StringUtils.isNotEmpty(openApiReq.getData().getTravelHous())) {
            havingSb.append("  AND  SUM(travel_hous) " + openApiReq.getData().getTravelHous() + " ");
        }
        if (StringUtils.isNotEmpty(openApiReq.getData().getWorkHous())) {
            havingSb.append("  AND  SUM(work_hous) " + openApiReq.getData().getWorkHous() + " ");
        }

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<PunchAttendanceStaticsExt> list = punchAttendanceStaticsService.queryByAndSqlProvider(whereSb.toString(), havingSb.toString());
        PageInfo<PunchAttendanceStaticsDTO> pageInfo = new PageInfo<>(dozerUtils.mapPage(list, PunchAttendanceStaticsDTO.class));


        //Result<Boolean> holidayByNowDay = holidayOriginalDataApi.getHolidayByNowDay("2017-1-1");
        // Result<Integer> holidays1 = holidayOriginalDataApi.getHolidays(starDate, endDate);
//        int holidays = HolidayUtil.getHolidays(starDate, endDate);
//        int needDays = DateUtils.getDistDates(starDate, endDate) + 1 - holidays;//应该出勤天数
//        for (PunchAttendanceStaticsDTO puc : pageInfo.getList()) {
//            puc.setNeedDays(needDays);
//        }
        return Result.success(pageInfo);
    }

    /**
     * 描述：h5查询我的考勤统计
     * 参数： attMonth查询的月份
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/7/25
     * 修改内容：
     */

    @RequestMapping(value = "h5GetMyStatics", method = RequestMethod.GET)
    @ApiOperation(value = "h5查询我的考勤统计 eg:2018-06", notes = "h5查询我的考勤统计")
    public Result<PunchAttendanceStaticsDTO> getH5GetMyStatics(@RequestParam("attMonth") String attMonth) {
        Long userId = BaseContextHandler.getAdminId();
        String unityId = UnityUtil.getUnityId(userId);
        String whereAndSql = " AND  user_id = " + userId
                + " AND att_month = '" + attMonth + "'"
                + " AND unit_id = '" + unityId + "' ";//只看本单位的

        List<PunchAttendanceStaticsExt> list = punchAttendanceStaticsService.queryByAndSqlProvider(whereAndSql, "");

        Date date = DateUtils.string2Date(attMonth + "-01", DateUtils.DEFAULT_DATE_FORMAT);
        Date starDate = DateUtils.getMonthFirstDay(date);
        starDate = getStartAttDay(starDate);
        Date endDate = DateUtils.getMonthLastDay(date);

        Map<String, Object> param = new HashMap<>();
        String unitId = UnityUtil.getUnityId(userId);
        param.put("unitId", unitId);
        param.put("userId", userId);//只看自己的
        param.put("startAttDay", starDate);
        param.put("endAttDay", endDate);
        //List<PunchAttendanceStaticsExt> allList = punchAttendanceStaticsService.webQueryMyStatics(param);
        PunchAttendanceStaticsExt total = punchAttendanceStaticsService.queryMyStaticsSum(param);

        PunchAttendanceStaticsDTO res = new PunchAttendanceStaticsDTO();
        if (list.size() > 0) {
            res = dozerUtils.map(list.get(0), PunchAttendanceStaticsDTO.class);
            setTimes(total, res, starDate, endDate);
        }
        if (res.getWorkHous() == null) {
            res.setWorkHous(0D);
        }
        if (res.getLeaveHous() == null) {
            res.setLeaveHous(0D);
        }
        if (res.getTravelHous() == null) {
            res.setTravelHous(0D);
        }
        if (res.getOutHous() == null) {
            res.setOutHous(0D);
        }
        if (res.getLateHour() == null) {
            res.setLateHour(0D);
        }
        if (res.getEarlyHour() == null) {
            res.setEarlyHour(0D);
        }
        return Result.success(res);
    }

    /**
     * 描述：h5查询统计查询具体的条目信息
     * 参数： type: 类型(overtime:加班，leave:请假，business:出差，outside:外勤， :supply:补签 : lateHour: 迟到 : earlyHour :早退 : minerCount:矿工)
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/7/26
     * 修改内容：
     */

    @RequestMapping(value = "h5GetMyStaticsByType", method = RequestMethod.GET)
    @ApiOperation(value = "h5查询统计查询具体的条目信息", notes = "h5查询统计查询具体的条目信息")
    @ApiResponses({
            @ApiResponse(code = 93059, message = "查询月不能为空"),
            @ApiResponse(code = 93060, message = "查询类型不能为空"),
    })
    public Result<List<StaticsDTO>> geth5GetMyStaticsByType(@RequestParam("attMonth") String
                                                                    attMonth, @RequestParam("type") String type) {
        BizAssert.assertNotEmpty(MtExceptionCode.QUERY_ATTMONTH_HAS_NULL, attMonth);
        BizAssert.assertNotEmpty(MtExceptionCode.QUERY_TYPE_HAS_NULL, type);

        Long userId = BaseContextHandler.getAdminId();
        String unityId = UnityUtil.getUnityId(userId);
        List<StaticsDTO> resList = new ArrayList<>();

        List<PunchAttendanceStatics> punchAttendanceStaticExts = punchAttendanceStaticsService.htGetMyStaticsByType(attMonth, userId, unityId, type);

        if (type.equals("leave")) {
            Date date = DateUtils.string2Date(attMonth + "-01", DateUtils.DEFAULT_DATE_FORMAT);
            Date start = DateUtils.getMonthFirstDay(date);
            Date end = DateUtils.getMonthLastDay(date);
            List<ApprLeave> allApprLeave = apprLeaveService.getApprLeaveByTime(userId, unityId, start, end);
            for (PunchAttendanceStatics ps : punchAttendanceStaticExts) {
                StaticsDTO d = new StaticsDTO();
                d.setAttDay(ps.getAttDay());
                for (ApprLeave al : allApprLeave) {
                    boolean dateInRange = DateUtils.isDateInRange(ps.getAttDay(), DateUtils.date2String(al.getStartTime(), DateUtils.DEFAULT_DATE_FORMAT),
                            DateUtils.date2String(al.getEndTime(), DateUtils.DEFAULT_DATE_FORMAT));
                    if (dateInRange) {
                        d.setExt(al.getLeaveType());
                        break;
                    }
                }
                d.setValue(ps.getLeaveHous());
                resList.add(d);
            }
        } else {
            for (PunchAttendanceStatics ps : punchAttendanceStaticExts) {
                StaticsDTO d = new StaticsDTO();
                d.setAttDay(ps.getAttDay());
                if (type.equals("overtime")) {
                    d.setValue(ps.getWorkHous());
                } else if (type.equals("business")) {
                    d.setValue(ps.getTravelHous());
                } else if (type.equals("outside")) {
                    d.setValue(ps.getOutHous());
                } else if (type.equals("lateHour")) {
                    d.setValue(ps.getLateHour());
                } else if (type.equals("earlyHour")) {
                    d.setValue(ps.getEarlyHour());
                } else if (type.equals("minerCount")) {
                    d.setValue(ps.getMinerCount());
                }
                resList.add(d);
            }
        }
        return Result.success(resList);
    }

    /**
     * 描述：得到用户当前月已经出勤天数
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/8/7
     * 修改内容：
     */

    @RequestMapping(value = "getMonthWorkDays", method = RequestMethod.GET)
    @ApiOperation(value = "得到用户当前月已经出勤天数", notes = "得到用户当前月已经出勤天数")
    public Result<Integer> getMonthWorkDays() {
        Date now = new Date();
        Date starDate = DateUtils.getMonthFirstDay(now);
        starDate = getStartAttDay(starDate);
        //Date endDate = DateUtils.getMonthLastDay(now);
        Date endDate = DateUtils.getDateTime(now, "00:00:01");
        Map<String, Object> param = new HashMap<>();
        Long userId = BaseContextHandler.getAdminId();
        String unityId = UnityUtil.getUnityId(userId);
        param.put("unitId", unityId);
        param.put("userId", userId);//只看自己的
        param.put("startAttDay", starDate);
        param.put("endAttDay", endDate);

        //不是放假并且没有旷工就出勤,节假日有加班时间也算出勤
        int days = 0;
        List<PunchAttendanceStaticsExt> punchAttendanceStaticsExts = punchAttendanceStaticsService.webQueryMyStatics(param);
        for (PunchAttendanceStaticsExt pa : punchAttendanceStaticsExts) {
            if (pa.getIsWorkDay() == 1 && (pa.getMinerCount() == null || pa.getMinerCount() <= 0)) {
                days++;
            } else if (pa.getIsWorkDay() == 0 && pa.getWorkHous() != null && pa.getWorkHous() > 0) {
                days++;
            }
        }
        return Result.success(days);
    }

    /**
     * 描述：查询本月共请假了多少小时
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/8/7
     * 修改内容：
     */

    @RequestMapping(value = "getCurMonthLeveCount", method = RequestMethod.GET)
    @ApiOperation(value = "查询本月共请假了多少小时", notes = "查询本月共请假了多少小时")
    public Result<Double> getCurMonthLeveCount() {
        Timestamp currentTime = DateUtils.getCurrentTime();
        String attMonth = DateUtils.dateToString(currentTime, DateUtils.DEFAULT_MONTH_FORMAT);
        Long userId = BaseContextHandler.getAdminId();
        String unityId = UnityUtil.getUnityId(userId);
        String whereAndSql = " AND  user_id = " + userId
                + " AND att_month = '" + attMonth + "'"
                + " AND unit_id = '" + unityId + "' ";//只看本单位的
        List<PunchAttendanceStaticsExt> list = punchAttendanceStaticsService.queryByAndSqlProvider(whereAndSql, "");
        if (list.size() > 0) {
            PunchAttendanceStaticsExt punchAttendanceStaticsExt = list.get(0);
            double leaveHous = punchAttendanceStaticsExt.getLeaveHous() == null ? 0 : punchAttendanceStaticsExt.getLeaveHous();
            return Result.success(leaveHous);
        } else {
            return Result.success(0d);
        }

    }
}
