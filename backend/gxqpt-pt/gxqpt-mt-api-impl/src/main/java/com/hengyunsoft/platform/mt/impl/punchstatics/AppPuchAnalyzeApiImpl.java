package com.hengyunsoft.platform.mt.impl.punchstatics;

import com.google.common.collect.Lists;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.admin.api.authority.api.RoleApi;
import com.hengyunsoft.platform.admin.api.authority.api.UserApi;
import com.hengyunsoft.platform.admin.api.authority.dto.UserDto;
import com.hengyunsoft.platform.admin.api.authority.dto.role.RoleDto;
import com.hengyunsoft.platform.admin.api.core.api.GxqptEmpApi;
import com.hengyunsoft.platform.admin.api.core.api.GxqptOrgApi;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgPolyResDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgResDTO;
import com.hengyunsoft.platform.admin.open.core.api.GxqptOrgOpenApi;
import com.hengyunsoft.platform.mt.api.punchclock.dto.clock.PunchClockDTO;
import com.hengyunsoft.platform.mt.api.punchclock.dto.clock.PunchClockHisDTO;
import com.hengyunsoft.platform.mt.api.punchclock.dto.clock.WorkListLogDTO;
import com.hengyunsoft.platform.mt.api.punchclock.dto.clock.WorkListLogReqDTO;
import com.hengyunsoft.platform.mt.api.punchstatics.dto.*;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClock;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClockHis;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.PunchAttendanceStatics;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.PunchAttendanceStaticsExt;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.SimpEmp;
import com.hengyunsoft.platform.mt.entity.work.po.WorkLog;
import com.hengyunsoft.platform.mt.entity.work.po.WorkLogDetail;
import com.hengyunsoft.platform.mt.repository.punchclock.example.PunchClockExample;
import com.hengyunsoft.platform.mt.repository.punchclock.example.PunchClockHisExample;
import com.hengyunsoft.platform.mt.repository.punchclock.service.PunchClockHisService;
import com.hengyunsoft.platform.mt.repository.punchclock.service.PunchClockService;
import com.hengyunsoft.platform.mt.repository.punchstatics.example.PunchAttendanceStaticsExample;
import com.hengyunsoft.platform.mt.repository.punchstatics.service.PunchAttendanceStaticsService;
import com.hengyunsoft.platform.mt.repository.work.example.WorkLogDetailExample;
import com.hengyunsoft.platform.mt.repository.work.example.WorkLogExample;
import com.hengyunsoft.platform.mt.repository.work.service.WorkLogDetailService;
import com.hengyunsoft.platform.mt.repository.work.service.WorkLogService;
import com.hengyunsoft.platform.mt.utils.UnityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * com.hengyunsoft.platform.mt.impl.punchstatics
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：app端考勤数据分析
 * 修改人：gbl
 * 修改时间：2018/7/24
 * 修改内容：新增基础接口
 */
@Api(value = "API - AppPuchAnalyzeApiImpl.java", description = "app端考勤数据分析")
@RestController
@RequestMapping("AppPuchAnalyzeApiImpl")
@Slf4j
public class AppPuchAnalyzeApiImpl {
    @Autowired
    private GxqptOrgOpenApi gxqptOrgOpenApi;
    @Autowired
    private GxqptOrgApi gxqptOrgApi;
    @Autowired
    private GxqptEmpApi gxqptEmpApi;
    @Autowired
    private RoleApi roleApi;
    @Autowired
    private UserApi userApi;
    @Autowired
    private PunchAttendanceStaticsService punchAttendanceStaticsService;
    @Autowired
    private PunchClockService punchClockService;
    @Autowired
    private PunchClockHisService punchClockHisService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private WorkLogService workLogService;
    @Autowired
    private WorkLogDetailService workLogDetailService;
    //能够查看所有单位数据的角色编码
    private static final String admin_code = "people_management";

    @RequestMapping(value = "getManagementUnit", method = RequestMethod.GET)
    @ApiOperation(value = "得到能够查看数据的单位", notes = "得到能够查看数据的单位")
    @ApiResponses({

    })
    public Result<List<ManagementUnitDTO>> getManagementUnit() {
        Long userId = BaseContextHandler.getAdminId();
        RoleDto roleDto = new RoleDto();
        roleDto.setCode(admin_code);

        Result<List<Long>> users = roleApi.findUsers(roleDto);
        if (!users.isSuccess()) {
            log.error("roleApi.findUsers:{},{}", users.getErrcode(), users.getErrmsg());
            return Result.fail(users.getErrcode(), users.getErrmsg());
        }
        List<ManagementUnitDTO> res = new ArrayList<>();
        if (users.getData().contains(userId)) {
            //查询用户单位列表
            Result<List<GxqptOrgPolyResDTO>> listResult = gxqptOrgOpenApi.allOrg();
            if (!listResult.isSuccess()) {
                log.error("gxqptOrgOpenApi.allOrg:{},{}", listResult.getErrcode(), listResult.getErrmsg());
                return Result.fail(listResult.getErrcode(), listResult.getErrmsg());
            }
            listResult.getData().forEach(org -> {
                ManagementUnitDTO mu = new ManagementUnitDTO();
                mu.setId(org.getId());
                mu.setName(org.getName());
                res.add(mu);
            });
        } else {
            String unityId = UnityUtil.getUnityId(userId);
            Result<GxqptOrgResDTO> org = gxqptOrgApi.getById("gxqpt", unityId);
            if (!org.isSuccess()) {
                log.error("调用gxqptOrgApi.getById失败:{},{}", org.getErrcode(), org.getErrmsg());
                return Result.fail(org.getErrcode(), org.getErrmsg());
            }
            log.info("调用gxqptOrgApi.getById返回单位管理员账号,{}", org.getData().getOrgadmin());
            Result<UserDto> user = userApi.getById(userId);
            if (!user.isSuccess()) {
                log.error("调用 userApi.getById失败:{},{}", user.getErrcode(), user.getErrmsg());
                return Result.fail(user.getErrcode(), user.getErrmsg());
            }
            log.info("调用 userApi.getById返回用户账号{}", user.getData().getAccount());

            String orgadmin = org.getData().getOrgadmin();
            String account = user.getData().getAccount();
            if (orgadmin != null && orgadmin.equals(account)) {
                ManagementUnitDTO mu = new ManagementUnitDTO();
                mu.setId(org.getData().getId());
                mu.setName(org.getData().getName());
                res.add(mu);
            }
        }
        return Result.success(res);
    }

    @RequestMapping(value = "appStatics", method = RequestMethod.GET)
    @ApiOperation(value = "app端人员管理考勤统计", notes = "app端人员管理考勤统计")
    @ApiResponses({

    })
    public Result<AppStaticsDTO> appStatics(@RequestParam("orgId") String orgId) {
        AppStaticsDTO res = new AppStaticsDTO();
        Date date = DateUtils.addDays(new Date(), -1);
        String att_day = DateUtils.date2String(date, DateUtils.DEFAULT_DATE_FORMAT);
        PunchAttendanceStaticsExample yesExample = new PunchAttendanceStaticsExample();
        yesExample.createCriteria().andUnitIdEqualTo(orgId).andAttDayEqualTo(att_day);
        List<PunchAttendanceStatics> all = punchAttendanceStaticsService.find(yesExample);
        //昨天的考勤统计
        List<StaticsKVDTO> yes = classify(all);
        res.setYes(yes);
        //本月异常考勤排名
        String nowMonth = DateUtils.getNowMonth();

        StringBuffer whereSb = new StringBuffer();
        StringBuffer havingSb = new StringBuffer();

        whereSb.append(" AND unit_id = '" + orgId + "' ");
        whereSb.append(" AND att_month = '" + nowMonth + "' ");

        List<PunchAttendanceStaticsExt> list = punchAttendanceStaticsService.queryByAndSqlProvider(whereSb.toString(), havingSb.toString());
        list.sort(new Comparator<PunchAttendanceStaticsExt>() {
            @Override
            public int compare(PunchAttendanceStaticsExt o1, PunchAttendanceStaticsExt o2) {
                return o2.getExtDays().compareTo(o1.getExtDays());
            }
        });
        int i = 0;
        List<StaticsKVDTO> exs = Lists.newArrayList();
        for (PunchAttendanceStaticsExt p : list) {
            if (i < 5) {
                exs.add(new StaticsKVDTO(p.getUserName(), p.getExtDays()));
            }
            i++;
        }
        res.setExs(exs);
        //本月分类占比统计 classify
        PunchAttendanceStaticsExample monthExample = new PunchAttendanceStaticsExample();
        monthExample.createCriteria().andUnitIdEqualTo(orgId).andAttMonthEqualTo(nowMonth);
        List<PunchAttendanceStatics> monthAll = punchAttendanceStaticsService.find(monthExample);
        List<StaticsKVDTO> classify = classify(monthAll);
        res.setClassify(classify);
        //本年统计
        List<StaticsKVDTO> year = yearStatic(orgId);
        res.setYear(year);
        return Result.success(res);
    }

    @RequestMapping(value = "yesUnitChockList", method = RequestMethod.GET)
    @ApiOperation(value = "app端人查询昨天的打卡详情", notes = "app端人查询昨天的打卡详情")
    @ApiResponses({

    })
    public Result<List<PunchClockDTO>> yesUnitChockList(@RequestParam("orgId") String orgId) {
        Date date = DateUtils.addDays(new Date(), -1);
        String att_day = DateUtils.date2String(date, DateUtils.DEFAULT_DATE_FORMAT);
        Date yesDate = DateUtils.parse(att_day, DateUtils.DEFAULT_DATE_FORMAT);
        PunchClockExample example = new PunchClockExample();
        example.createCriteria().andUnitIdEqualTo(orgId).andClockDateEqualTo(yesDate);
        List<PunchClock> punchClocks = punchClockService.find(example);
        List<PunchClockDTO> res = dozerUtils.mapList(punchClocks, PunchClockDTO.class);
        return Result.success(res);
    }

    private List<StaticsKVDTO> yearStatic(String orgId) {
        List<StaticsKVDTO> year = Lists.newArrayList();
        String[] latest12Month = DateUtils.getLatest12Month();
        Date now = new Date();
        String newYear = DateUtils.date2String(now, DateUtils.DEFAULT_YEAR_FORMAT);
        for (int i = latest12Month.length - 1; i >= 0; i--) {
            String monStr = latest12Month[i];
            if (!monStr.contains(newYear)) {
                continue;
            }
            StringBuffer monWhereSb = new StringBuffer();
            monWhereSb.append(" AND unit_id = '" + orgId + "' ");
            monWhereSb.append(" AND att_month = '" + monStr + "' ");
            List<PunchAttendanceStaticsExt> monList = punchAttendanceStaticsService.queryByAndSqlProvider(monWhereSb.toString(), "");
            int normal = 0;
            int exNum = 0;
            for (PunchAttendanceStaticsExt ps : monList) {
                normal += ps.getNormalDays();
                exNum += ps.getExtDays();
            }
            monStr = monStr.replace(newYear + "-", "") + "月";
            StaticsKVDTO kv = new StaticsKVDTO(monStr, normal, exNum);
            year.add(kv);
        }
        return year;
    }

    private List<StaticsKVDTO> classify(List<PunchAttendanceStatics> list) {
        int normal = 0;
        int miner = 0;
        int late = 0;
        int early = 0;
        int leave = 0;
        int travel = 0;
        int out = 0;
        int work = 0;
        for (PunchAttendanceStatics ps : list) {
            miner += (ps.getMinerCount() != null && ps.getMinerCount() > 0 ? 1 : 0);
            late += (ps.getLateHour() != null && ps.getLateHour() > 0 ? 1 : 0);
            early += (ps.getEarlyHour() != null && ps.getEarlyHour() > 0 ? 1 : 0);
            leave += +(ps.getLeaveHous() != null && ps.getLeaveHous() > 0 ? 1 : 0);
            travel += (ps.getTravelHous() != null && ps.getTravelHous() > 0 ? 1 : 0);
            out += +(ps.getOutHous() != null && ps.getOutHous() > 0 ? 1 : 0);
            work += (ps.getWorkHous() != null && ps.getWorkHous() > 0 ? 1 : 0);
            if (ps.getIsholiday() == 1 ||
                    ((ps.getMinerCount() == null || ps.getMinerCount() <= 0) &&
                            (ps.getLateHour() == null || ps.getLateHour() <= 0) &&
                            (ps.getEarlyHour() == null || ps.getEarlyHour() <= 0) &&
                            (ps.getLeaveHous() == null || ps.getLeaveHous() <= 0)
                    )
            ) {
                normal += 1;
            }
        }

        // "昨天的考勤统计 k:类型(normal:正常打卡人数,miner:旷工人数 " +
        //"late:迟到人数 early:早退人数 travel:请假人数 out:外勤人数 work:加班人数) v1:值")
        StaticsKVDTO normalKV = new StaticsKVDTO("normal", normal);
        StaticsKVDTO minerKV = new StaticsKVDTO("miner", miner);
        StaticsKVDTO lateKV = new StaticsKVDTO("late", late);
        StaticsKVDTO earlyKV = new StaticsKVDTO("early", early);
        StaticsKVDTO leaveKV = new StaticsKVDTO("leave", leave);
        StaticsKVDTO travelKV = new StaticsKVDTO("travel", travel);
        StaticsKVDTO outKV = new StaticsKVDTO("out", out);
        StaticsKVDTO workKV = new StaticsKVDTO("work", work);
        List<StaticsKVDTO> rList = Lists.newArrayList(normalKV, minerKV, lateKV, earlyKV, leaveKV, travelKV, outKV, workKV);
        return rList;
    }


    @ApiOperation(value = "app端查询一周工作日志)", notes = "app端查询一周工作日志")
    @RequestMapping(value = "/pageApp", method = RequestMethod.POST)
    public Result<List<WorkListLogDTO>> getLogApp(@RequestBody WorkListLogReqDTO req) {
        String nowStr = DateUtils.dateToString(new Date(), DateUtils.DEFAULT_DATE_FORMAT);
        Date now = DateUtils.parse(nowStr, DateUtils.DEFAULT_DATE_FORMAT);
        Date end = DateUtils.getDateTime(now, "23:59:59");
        Date start = DateUtils.getDateTime(DateUtils.addDays(now, -7), "00:00:00");

        String unitId = req.getUnitId();
        List<SimpEmp> emps = punchAttendanceStaticsService.querySimpEmpByOrgId(unitId);

        int days = DateUtils.subDays(end, start);
        List<WorkListLogDTO> res = Lists.newArrayList();
        for (int i = 0; i < days; i++) {
            Date dayDate = DateUtils.addDays(now, -i);
            Date dayStart = DateUtils.getDateTime(dayDate, "00:00:00");
            Date dayEnd = DateUtils.getDateTime(dayDate, "23:59:59");

            WorkLogExample workLogExample = new WorkLogExample();
            workLogExample.createCriteria().andMainOrgIdEqualTo(unitId).andCreateDateBetween(dayStart, dayEnd);
            workLogExample.setOrderByClause("create_date desc");

            List<WorkLog> list = workLogService.find(workLogExample);
            Map<Long, WorkLog> userLog = list.stream().collect(Collectors.toMap(WorkLog::getUserId, log -> log, (k1, k2) -> k1));

            for (SimpEmp emp : emps) {
                WorkListLogDTO workListLogDTO = new WorkListLogDTO();
                workListLogDTO.setUserId(emp.getGxqptEmpId());
                workListLogDTO.setUserName(emp.getName());

                WorkLog workLog = userLog.get(emp.getGxqptEmpId());
                if (workLog != null) {
                    WorkLogDetailExample workLogDetailExample = new WorkLogDetailExample();
                    workLogDetailExample.createCriteria().andLogIdEqualTo(workLog.getId());
                    workLogDetailExample.setOrderByClause("create_time asc");
                    List<WorkLogDetail> workLogDetails = workLogDetailService.find(workLogDetailExample);
                    if (!workLogDetails.isEmpty()) {
                        WorkLogDetail detail = workLogDetails.get(0);
                        workListLogDTO.setDescription(detail.getDescription());
                    }
                    workListLogDTO.setCreateDate(workLog.getCreateDate());
                    workListLogDTO.setState("已提交");
                } else {
                    workListLogDTO.setCreateDate(dayStart);
                    workListLogDTO.setState("未提交");
                }
                res.add(workListLogDTO);
            }
        }
        return Result.success(res);
    }

    @RequestMapping(value = "oneWeekUnitChock", method = RequestMethod.POST)
    @ApiOperation(value = "app查询一周的打卡记录", notes = "app查询一周的打卡记录")
    @ApiResponses({

    })
    public Result<List<AppPunchInfoDTO>> oneWeekUnitChock(@RequestBody AppPunchInfoReqParamDTO param) {
        Date yes = DateUtils.addDays(new Date(), -1);
        Date end = DateUtils.getDateTime(yes, "23:59:59");
        Date start = DateUtils.getDateTime(DateUtils.addDays(yes, -7), "00:00:00");

        List<AppPunchInfoDTO> res = qunitchock(param.getOrgId(), param.getName(), start,
                end, param.getState());
        return Result.success(res);
    }

    @RequestMapping(value = "yesUnitChock", method = RequestMethod.POST)
    @ApiOperation(value = "app查询昨天的打卡记录", notes = "app查询昨天的打卡记录")
    @ApiResponses({

    })
    public Result<List<AppPunchInfoDTO>> yesUnitChock(@RequestBody AppPunchInfoReqParamDTO param) {
        Date yes = DateUtils.addDays(new Date(), -1);
        Date start = DateUtils.getDateTime(yes, "00:00:00");
        Date end = DateUtils.getDateTime(yes, "23:59:59");
        List<AppPunchInfoDTO> res = qunitchock(param.getOrgId(), param.getName(), start,
                end, param.getState());
        return Result.success(res);
    }

    private List<AppPunchInfoDTO> qunitchock(String ounitId, String name, Date startAttDay, Date endAttDay, String state) {
        Map<String, Object> params = new HashMap<>();
        params.put("unitId", ounitId);
        params.put("name", name);
        params.put("startAttDay", startAttDay);
        params.put("endAttDay", endAttDay);
        List<PunchAttendanceStaticsExt> statics = punchAttendanceStaticsService.appPeronManaList(params);

        List<AppPunchInfoDTO> res = Lists.newArrayList();
        statics.forEach(ps -> {
            AppPunchInfoDTO pi = new AppPunchInfoDTO();
            pi.setId(ps.getId());
            pi.setUserId(ps.getUserId());
            pi.setName(ps.getUserName());
            pi.setDate(ps.getAttDay());

            //签到状态  normal:正常,miner:旷工 late:迟到  travel:出差 leave:请假 out:外勤
            List<String> siginStage = Lists.newArrayList();
            //签退状态 normal:正常  miner:旷工 early:早退 travel:出差 leave:请假 out:外勤 work:加班
            List<String> sigiOffState = Lists.newArrayList();
            boolean siginNormal = true;
            boolean sigiOffNormal = true;
            if (ps.getMinerCount() != null && ps.getMinerCount() > 0) {
                siginStage.add("miner");
                sigiOffState.add("miner");
                siginNormal = false;
                sigiOffNormal = false;
            }
            if (ps.getLateHour() != null && ps.getLateHour() > 0) {
                siginStage.add("late");
                siginNormal = false;
            }
            if (ps.getTravelHous() != null && ps.getTravelHous() > 0) {
                siginStage.add("travel");
                sigiOffState.add("travel");
                siginNormal = false;
                sigiOffNormal = false;
            }
            if (ps.getLeaveHous() != null && ps.getLeaveHous() > 0) {
                siginStage.add("leave");
                sigiOffState.add("leave");
                siginNormal = false;
                sigiOffNormal = false;
            }

            if (ps.getEarlyHour() != null && ps.getEarlyHour() > 0) {
                sigiOffState.add("early");
                sigiOffNormal = false;
            }

            if (ps.getOutHous() != null && ps.getOutHous() > 0) {
                siginStage.add("out");
                sigiOffState.add("out");
                siginNormal = false;
                sigiOffNormal = false;
            }
            if (ps.getWorkHous() != null && ps.getWorkHous() > 0) {
                sigiOffState.add("work");
                sigiOffNormal = false;
            }
            if (siginNormal) {
                siginStage.add("normal");
            }
            if (sigiOffNormal) {
                sigiOffState.add("normal");
            }
            pi.setSiginState(siginStage);
            pi.setSigiOffState(sigiOffState);
            if (StringUtils.isEmpty(state) || siginStage.contains(state) || sigiOffState.contains(state)) {
                res.add(pi);
            }
        });
        return res;
    }

    /***
     *
     * @param orgId
     * @param userId
     * @param attDay
     * @param type  1签到2签退
     * @return
     */
    @RequestMapping(value = "getClockHisByTypeAndDate", method = RequestMethod.GET)
    @ApiOperation(value = "app查询指定打卡记录", notes = "app查询指定打卡记录")
    @ApiResponses({

    })
    public Result<List<PunchClockHisDTO>> getClockHisByTypeAndDate(@RequestParam("orgId") String orgId, @RequestParam("userId") Long userId,
                                                                   @RequestParam("attDay") String attDay, @RequestParam("type") int type) {
        PunchClockHisExample example = new PunchClockHisExample();
        Date date = DateUtils.parse(attDay, DateUtils.DEFAULT_DATE_FORMAT);
        example.createCriteria().andUnitIdEqualTo(orgId).andUserIdEqualTo(userId)
                .andClockDateEqualTo(date).andClockTypeEqualTo(type);
        List<PunchClockHis> punchClockHis = punchClockHisService.find(example);
        List<PunchClockHisDTO> res = dozerUtils.mapList(punchClockHis, PunchClockHisDTO.class);
        return Result.success(res);
    }
}
