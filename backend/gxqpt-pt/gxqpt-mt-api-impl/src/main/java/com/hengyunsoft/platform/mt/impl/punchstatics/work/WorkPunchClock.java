package com.hengyunsoft.platform.mt.impl.punchstatics.work;

import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.platform.mt.entity.appr.po.ApprApply;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprBusiness;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprLeave;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprOutside;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprOverTime;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClock;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClockRule;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.PunchAttendanceStaticsExt;
import com.hengyunsoft.platform.mt.impl.punchstatics.StaticsConst;
import com.hengyunsoft.platform.mt.repository.appr.service.ApprApplyService;
import com.hengyunsoft.platform.mt.repository.apprwork.service.ApprBusinessService;
import com.hengyunsoft.platform.mt.repository.apprwork.service.ApprLeaveService;
import com.hengyunsoft.platform.mt.repository.apprwork.service.ApprOutsideService;
import com.hengyunsoft.platform.mt.repository.apprwork.service.ApprOverTimeService;
import com.hengyunsoft.platform.mt.repository.punchclock.service.PunchClockRuleService;
import com.hengyunsoft.platform.mt.repository.punchclock.service.PunchClockService;
import com.hengyunsoft.platform.mt.utils.BigDecimalUtil;
import com.hengyunsoft.platform.mt.utils.HolidayUtil;
import com.hengyunsoft.platform.mt.utils.UnityUtil;
import com.hengyunsoft.utils.SpringUtil;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/***
 * 打卡统计相关业务
 */
@Slf4j
public class WorkPunchClock implements IWorkStatics {

    public WorkPunchClock() {

    }

    @Override
    public String getWorkName() {
        return StaticsConst.TYPE_WORK_PUNCH_CLOCK;
    }

    @Override
    public void runStatics(PunchAttendanceStaticsExt statics, Long workId, Map<String, String> param) {
        //获取参数
        //打卡类型:1,签到；2，签退
        String clockType = param.get("clockType");
        //考勤类型:1,内勤；2，外勤
        String adceType = param.get("adceType");
        if (clockType == null || adceType == null) {
            log.error("参数错误，需要clockType和adceType两个参数");
            throw new RuntimeException("参数错误，需要clockType和adceType两个参数");
        }

        PunchClockService punchClockService = SpringUtil.getBean(PunchClockService.class);
        PunchClockRuleService punchClockRuleService = SpringUtil.getBean(PunchClockRuleService.class);
        //ApprApplyService apprApplyService = SpringUtil.getBean(ApprApplyService.class);
        ApprLeaveService apprLeaveService = SpringUtil.getBean(ApprLeaveService.class);
        ApprOverTimeService apprOverTimeService = SpringUtil.getBean(ApprOverTimeService.class);
        ApprOutsideService apprOutsideService = SpringUtil.getBean(ApprOutsideService.class);

        PunchClock punchClock = punchClockService.getById(workId);
        Long userId = punchClock.getUserId();
        String unityId = UnityUtil.getUnityId(userId);
        if(param.containsKey("unityId")){
            unityId = param.get("unityId");
        }
        PunchClockRule rule = punchClockRuleService.getPunchClockRuleByUnityid(unityId);
        //是否是节假日
        Date date = DateUtils.string2Date(statics.getAttDay(), DateUtils.DEFAULT_DATE_FORMAT);
        boolean isHoliday = HolidayUtil.isHoliday(unityId, date);

        Date ruleInTime = DateUtils.getDateTime(date,rule.getInTime());
        Date ruleOutTime = DateUtils.getDateTime(date,rule.getOutTime());

        if (clockType.equals("1") && !isHoliday) {//签到
            Date signInTime = punchClock.getSignInTime();
            if (signInTime.after(ruleInTime)) {//统计迟到,要看看有没有放假请假出差，有放假请假出差请假就不算迟到
                double total = getViolationTime(apprLeaveService, userId, unityId, ruleInTime, signInTime);
                //得到迟到时间
                if (total > 0) {//时间还大于0，说明迟到了
                    if (statics.getLateHour() == null || statics.getLateHour().doubleValue() == 0) {
                        statics.setLateHour(total);
                        punchClock.setStatus(2);
                    }
                }
            }
        } else if (clockType.equals("2") && !isHoliday) {//签退
            //不分内勤外勤，只要有签到和签退，加班时间、外勤时间都以审批通过的时间为准
            Date signOffTime = punchClock.getSignOffTime();
            if (!isHoliday) {
                if (signOffTime.before(ruleOutTime)) {//早退,看看有没有放假请假出差,有放假请假出差不算早退
                    double total = getViolationTime(apprLeaveService, userId, unityId, signOffTime, ruleOutTime);
                    if (total > 0) {//时间还大于0，说明早退了
                        statics.setEarlyHour(total);
                        punchClock.setStatus(3);
                    }
                }
            }
        }
        if (punchClock.getSignInTime() != null && punchClock.getSignOffTime() != null) {
            //看看有没有审批通过的外勤申请，有的话统计外勤时间
            Date queryStart = punchClock.getSignInTime().before(ruleInTime) ? punchClock.getSignInTime() : ruleInTime;
            Date queryEnd = punchClock.getSignOffTime().after(ruleOutTime) ? punchClock.getSignOffTime() : ruleOutTime;

            List<ApprOutside> apprOutsides = apprOutsideService.getApprOutsidesByDate(userId, statics.getUnitId(), queryStart, queryEnd);
            double totalOutTime = 0;
            for (ApprOutside ao : apprOutsides) {
                Date statTime = ao.getStartTime();
                Date endTime = ao.getEndTime();
                double distHour = DateUtils.getDistHour(statTime, endTime);
                totalOutTime += BigDecimalUtil.add(totalOutTime, distHour, 2);
            }
            statics.setOutHous(totalOutTime);

            //要去看看有没有申请加班，有的话统计加班时间
            List<ApprOverTime> apprOverTimeByTime = apprOverTimeService.getApprOverTimeByTime(userId, statics.getUnitId(), queryStart, queryEnd);
            double totalOverTime = 0;
            for (ApprOverTime ao : apprOverTimeByTime) {
                Double distHour = DateUtils.getDistHour(ao.getStartTime(), ao.getEndTime());
                totalOverTime = BigDecimalUtil.add(totalOverTime, distHour, 2);
            }
            statics.setWorkHous(totalOverTime);
        }

        punchClockService.updateByIdSelective(punchClock);
    }

    /***
     * 计算违规时间
     * @param apprLeaveService
     * @param userId
     * @param unityId
     * @param startTime
     * @param endTime
     * @return
     */
    private double getViolationTime(ApprLeaveService apprLeaveService, long userId, String unityId, Date startTime, Date endTime) {
        double total = DateUtils.getDistHour(startTime, endTime);
        //扣除放假时间
        double freeTime = HolidayUtil.getFreeTime(unityId, startTime, endTime);
        total = BigDecimalUtil.subtract(total, freeTime, 2);
        //扣除请假时间
        List<ApprLeave> apprLeaves = apprLeaveService.getApprLeaveByTime(userId, unityId, startTime, endTime);
        ApprApplyService apprApplyService = SpringUtil.getBean(ApprApplyService.class);
        for (ApprLeave a : apprLeaves) {
            ApprApply apply = apprApplyService.getById(a.getApplyId());
            if (apply != null && apply.getCurState() == 3) {
                double leaveHour = new BigDecimal(a.getLeaveHour()).doubleValue();
                total = BigDecimalUtil.subtract(total, leaveHour, 2);
            }
        }
        //扣除出差时间
        ApprBusinessService apprBusinessService = SpringUtil.getBean(ApprBusinessService.class);
        List<ApprBusiness> apprBusiness = apprBusinessService.getApprBusinessByTimeAndState(userId, unityId, 3, startTime, endTime);
        for (ApprBusiness a : apprBusiness) {
            ApprApply apply = apprApplyService.getById(a.getApplyId());
            if (apply != null && apply.getCurState() == 3) {
                double leaveHour = new BigDecimal(a.getBusinessHour()).doubleValue();
                total = BigDecimalUtil.subtract(total, leaveHour, 2);
            }
        }
        return total;
    }
}
