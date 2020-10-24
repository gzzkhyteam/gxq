package com.hengyunsoft.platform.jobs;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.mybatis.annotation.IgnoreTx;
import com.hengyunsoft.platform.admin.api.base.api.HolidayOriginalDataApi;
import com.hengyunsoft.platform.mt.entity.appr.po.ApprApply;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprAttenceSupply;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprBusiness;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprLeave;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprOutside;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClock;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.PunchAttendanceStatics;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.PunchAttendanceStaticsExt;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.SimpEmp;
import com.hengyunsoft.platform.mt.repository.appr.service.ApprApplyService;
import com.hengyunsoft.platform.mt.repository.apprwork.service.ApprAttenceSupplyService;
import com.hengyunsoft.platform.mt.repository.apprwork.service.ApprBusinessService;
import com.hengyunsoft.platform.mt.repository.apprwork.service.ApprLeaveService;
import com.hengyunsoft.platform.mt.repository.apprwork.service.ApprOutsideService;
import com.hengyunsoft.platform.mt.repository.punchclock.service.PunchClockService;
import com.hengyunsoft.platform.mt.repository.punchstatics.service.PunchAttendanceStaticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 * 移动端考勤统计job,主要是处理每天缺勤(没有打卡)的人
 * ronExpression的配置说明，具体使用以及参数请百度google

 字段   允许值   允许的特殊字符

 秒    0-59    , - * /

 分    0-59    , - * /

 小时    0-23    , - * /

 日期    1-31    , - * ? / L W C

 月份    1-12 或者 JAN-DEC    , - * /

 星期    1-7 或者 SUN-SAT    , - * ? / L C #

 年（可选）    留空, 1970-2099    , - * /

 - 区间
 * 通配符

 ? 你不想设置那个字段

 下面只例出几个式子
 CRON表达式    含义

 "0 0 12 * * ?"    每天中午十二点触发

 "0 15 10 ? * *"    每天早上10：15触发

 "0 15 10 * * ?"    每天早上10：15触发

 "0 15 10 * * ? *"    每天早上10：15触发

 "0 15 10 * * ? 2005"    2005年的每天早上10：15触发

 "0 * 14 * * ?"    每天从下午2点开始到2点59分每分钟一次触发

 "0 0/5 14 * * ?"    每天从下午2点开始到2：55分结束每5分钟一次触发

 "0 0/5 14,18 * * ?"    每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发

 "0 0-5 14 * * ?"    每天14:00至14:05每分钟一次触发

 "0 10,44 14 ? 3 WED"    三月的每周三的14：10和14：44触发

 "0 15 10 ? * MON-FRI"    每个周一、周二、周三、周四、周五的10：15触发
 */
@RestController
@Slf4j
@IgnoreTx
public class MtPunchAttendanceStatics {
    @Autowired
    private HolidayOriginalDataApi holidayOriginalDataApi;
    @Autowired
    private PunchAttendanceStaticsService punchAttendanceStaticsService;
    @Autowired
    private PunchClockService punchClockService;
    @Autowired
    private ApprAttenceSupplyService apprAttenceSupplyService;
    @Autowired
    private ApprApplyService apprApplyService;
    @Autowired
    private ApprOutsideService apprOutsideService;
    @Autowired
    private ApprLeaveService apprLeaveService;
    @Autowired
    private ApprBusinessService apprBusinessService;
    @Autowired
    private DozerUtils dozerUtils;

    @Scheduled(cron = "0 0 1 * * ?")//每天晚上凌晨1点执行
    //@Scheduled(initialDelay = 10000, fixedRate = 5000000)
    public void saveRunDayStatic() {
        Date yesDate = DateUtils.addDays(new Date(), -1);
        //Date yesDate = DateUtils.addDays(new Date(), -3);
        saveDealStaticNotPunchClock(yesDate);
    }

    /***
     * 手动执行移动端考勤统计job
     * @param dateStr yyyy-MM-dd
     * @return
     */
    @RequestMapping(value = "/runDealStatic", method = RequestMethod.GET)
    //@IgnoreToken
    //@ApiIgnore
    public Result<String> saveRunDealStatic(@RequestParam("date") String dateStr) {
        Date date = DateUtils.string2Date(dateStr, DateUtils.DEFAULT_DATE_FORMAT);
        Date today = DateUtils.getTodayTime("00:00:00");
        Date yesDate = DateUtils.addDays(today, -1);
        if (date.after(yesDate)) {
            return Result.fail("只能执行昨天以前的统计");
        }
        Long adminId = BaseContextHandler.getAdminId();
        String name = BaseContextHandler.getName();
        log.info("手动移动端考勤统计job:{},执行用户{}:{}", LocalDateTime.now(), adminId, name);
        saveDealStaticNotPunchClock(date);
        return Result.success("执行成功");
    }

    public void saveDealStaticNotPunchClock(Date date) {
        log.info("移动端考勤统计job:{}", LocalDateTime.now());
        String dateStr = DateUtils.date2String(date, DateUtils.DEFAULT_DATE_FORMAT);
        String dateMonth = DateUtils.date2String(date, DateUtils.DEFAULT_MONTH_FORMAT);
        String dateYear = DateUtils.date2String(date, DateUtils.DEFAULT_YEAR_FORMAT);
        Date startTime = DateUtils.getDateTime(date, "00:00:00");
        Date endTime = DateUtils.getDateTime(date, "23:59:59");

        boolean isHoliday = isHoliday(dateStr);

        int nowPage = 1;
        int pageSize = 100;
        PageInfo<SimpEmp> pageInfo = getSimpEmpList(nowPage, pageSize);
        while (nowPage <= pageInfo.getPages()) {
            try {
                pageInfo = getSimpEmpList(nowPage, pageSize);
                nowPage++;

                List<SimpEmp> empsList = pageInfo.getList();

                List<PunchAttendanceStatics> saveList = new ArrayList<>();
                List<PunchAttendanceStatics> updateList = new ArrayList<>();

                int count = 0;
                for (SimpEmp emp : empsList) {
                    try {
                        Long userId = emp.getGxqptEmpId();
                        count++;
                        PunchAttendanceStatics aStatics = punchAttendanceStaticsService.getPunchAttendanceStaticsByDate(userId, dateStr);
                        PunchAttendanceStaticsExt statics = dozerUtils.map(aStatics, PunchAttendanceStaticsExt.class);
                        boolean has = true;
                        if (statics == null) {
                            has = false;
                            statics = new PunchAttendanceStaticsExt();
                            statics.setIsholiday(isHoliday ? 1 : 0);
                            statics.setAttDay(dateStr);
                            statics.setAttMonth(dateMonth);
                            statics.setAttYear(dateYear);
                            statics.setUserId(userId);
                            statics.setUnitId(emp.getMainorgid());
                            statics.setMaindutyName(emp.getMaindutyname());
                            statics.setDeptName(emp.getMaindeptname());
                            statics.setUserName(emp.getName());
                            statics.setCreateUser(userId);
                        }
                        if (!isHoliday) {
                            saveDealIsKuangGong(date, startTime, endTime, emp, userId, statics);
                        } else {//如果是节假日，就把迟到啊早退啊这些清0
                            statics.setLateHour(0d);
                            statics.setEarlyHour(0d);
                            statics.setMinerCount(0);
                            statics.setIsholiday(1);
                        }
                        if (has) {
                            updateList.add(statics);
                        } else {
                            statics.setOutHous(statics.getOutHous() == null ? 0 : statics.getOutHous());
                            statics.setWorkHous(statics.getWorkHous() == null ? 0 : statics.getWorkHous());
                            statics.setLeaveHous(statics.getLeaveHous() == null ? 0 : statics.getLeaveHous());
                            statics.setTravelHous(statics.getTravelHous() == null ? 0 : statics.getTravelHous());
                            statics.setLateHour(statics.getLateHour() == null ? 0 : statics.getLateHour());
                            statics.setEarlyHour(statics.getEarlyHour() == null ? 0 : statics.getEarlyHour());
                            statics.setMinerCount(statics.getMinerCount() == null ? 0 : statics.getMinerCount());
                            saveList.add(statics);
                        }

                        if (count % 50 == 0) {//50条保存一次
                            punchAttendanceStaticsService.save(saveList);
                            saveList.clear();

                            punchAttendanceStaticsService.updateByIdSelective(updateList);
                            updateList.clear();
                        }
                    } catch (Exception e) {
                        log.error("移动端考勤统计job执行异常,userId:{}", emp.getGxqptEmpId());
                    }
                }
                punchAttendanceStaticsService.save(saveList);
                punchAttendanceStaticsService.updateByIdSelective(updateList);
            } catch (Exception e) {
                log.error("移动端考勤统计job执行异常");
            }

            log.info("移动端考勤统计job第{}页执行结束{}", nowPage - 1, LocalDateTime.now());
        }
        log.info("移动端考勤统计job执行结束{},共处理用户:{}", LocalDateTime.now(), pageInfo.getTotal());
    }

    private void saveDealIsKuangGong(Date date, Date startTime, Date endTime, SimpEmp emp, Long
            userId, PunchAttendanceStaticsExt statics) {
        //旷工：1:(打卡记录不全 and 没有补卡记录and 没有请假记录 and 没有出差 ) 2: (外勤卡，但是没有申请通过外勤审批)
        PunchClock punchClock = punchClockService.getPunchClockByUserAndUnitIdAndDate(userId, statics.getUnitId(), date);

        boolean isKuangGong = false;

        if (punchClock == null || punchClock.getSignInTime() == null) {
            isKuangGong = true;
            List<ApprAttenceSupply> apprAttenceSupplys = apprAttenceSupplyService.getApprAttenceSupplysByDateAndType(userId, date, 1);
            if (apprAttenceSupplys != null && apprAttenceSupplys.size() > 0) {
                for (ApprAttenceSupply as : apprAttenceSupplys) {
                    ApprApply apply = apprApplyService.getById(as.getApplyId());
                    if (apply != null && apply.getCurState() == 3) {
                        isKuangGong = false;
                        break;
                    }
                }
            }
        }
        if (!isKuangGong && (punchClock == null || punchClock.getSignOffTime() == null)) {
            isKuangGong = true;
            List<ApprAttenceSupply> apprAttenceSupplys = apprAttenceSupplyService.getApprAttenceSupplysByDateAndType(userId, date, 2);
            if (apprAttenceSupplys != null && apprAttenceSupplys.size() > 0) {
                for (ApprAttenceSupply as : apprAttenceSupplys) {
                    ApprApply apply = apprApplyService.getById(as.getApplyId());
                    if (apply != null && apply.getCurState() == 3) {
                        isKuangGong = false;
                        break;
                    }
                }
            }
        }

        if (!isKuangGong) {
            Integer adceType = punchClock.getAdceType();//考勤类型:1,内勤；2，外勤
            if (adceType == 2) {
                isKuangGong = true;

                List<ApprOutside> outsides = apprOutsideService.getApprOutsidesByDate(userId, statics.getUnitId(), startTime, endTime);
                for (ApprOutside ao : outsides) {
                    ApprApply apply = apprApplyService.getById(ao.getApplyId());
                    if (apply != null && apply.getCurState() == 3) {
                        isKuangGong = false;
                    }
                }
            }
        }
        //有请假和出差不顾算旷工
        if (isKuangGong) {
            List<ApprLeave> apprLeaves = apprLeaveService.getApprLeaveByTimeAndState(userId, emp.getMainorgid(), 3, startTime, endTime);
            if (apprLeaves != null && apprLeaves.size() > 0) {
                isKuangGong = false;
            }
        }
        if (isKuangGong) {
            List<ApprBusiness> businesses = apprBusinessService.getApprBusinessByTimeAndState(userId, emp.getMainorgid(), 3, startTime, endTime);
            if (businesses != null && businesses.size() > 0) {
                isKuangGong = false;
            }
        }

        if (isKuangGong) {
            statics.setMinerCount(1);
            // 旷工了就不算迟到早退了
            statics.setLateHour(0d);
            statics.setEarlyHour(0d);
        }

    }

    private PageInfo<SimpEmp> getSimpEmpList(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<SimpEmp> list = punchAttendanceStaticsService.querySimpEmpByProvider();
        return new PageInfo<>(dozerUtils.mapPage(list, SimpEmp.class));
//        Result<List<SimpEmpDTO>> empsRes = gxqptEmpApi.getAllEmpUserGxqpt();
//        int twoCount = 0;
//        while (!empsRes.isSuccess()) {
//            try {
//                twoCount++;
//                Thread.sleep(5 * 5000);
//                empsRes = gxqptEmpApi.getAllEmpUserGxqpt();
//                if (twoCount > 5) {
//                    break;
//                }
//
//            } catch (Exception e) {
//                log.error("远程调用用户接口失败", e);
//            }
//
//        }
//        return empsRes.getData();
    }

    private boolean isHoliday(String dateStr) {
        int oneCount = 0;
        Result<Boolean> holodeRes = holidayOriginalDataApi.getHolidayByNowDay(dateStr);
        while (!holodeRes.isSuccess()) {
            try {
                Thread.sleep(5 * 5000);
                holodeRes = holidayOriginalDataApi.getHolidayByNowDay(dateStr);
                if (oneCount > 5) {
                    break;
                }
                oneCount++;
            } catch (Exception e) {
                log.error("远程调用是否是节假日接口失败", e);
            }

        }
        if (holodeRes.isSuccess()) {
            return holodeRes.getData();
        } else {
            throw new RuntimeException("移动端考勤统计job,远程调用是否是节假日接口失败，请修正后手动执行");
        }
    }
}
