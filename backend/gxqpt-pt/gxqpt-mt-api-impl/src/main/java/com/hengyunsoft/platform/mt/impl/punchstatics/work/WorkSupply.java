package com.hengyunsoft.platform.mt.impl.punchstatics.work;

import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.platform.mt.entity.appr.po.ApprApply;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprAttenceSupply;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprOutside;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprOverTime;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClock;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClockRule;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.PunchAttendanceStaticsExt;
import com.hengyunsoft.platform.mt.impl.punchstatics.StaticsConst;
import com.hengyunsoft.platform.mt.repository.appr.service.ApprApplyService;
import com.hengyunsoft.platform.mt.repository.apprwork.service.ApprAttenceSupplyService;
import com.hengyunsoft.platform.mt.repository.apprwork.service.ApprOutsideService;
import com.hengyunsoft.platform.mt.repository.apprwork.service.ApprOverTimeService;
import com.hengyunsoft.platform.mt.repository.punchclock.service.PunchClockRuleService;
import com.hengyunsoft.platform.mt.repository.punchclock.service.PunchClockService;
import com.hengyunsoft.platform.mt.utils.BigDecimalUtil;
import com.hengyunsoft.utils.SpringUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

/***
 *补签统计业务类型,补签审批通过了，才过来执行统计
 * 1:补签之后，如果当天的有完整的签到签退，那么就要去更新 加班时间，外勤时间，旷工
 */
public class WorkSupply implements IWorkStatics {
    @Override
    public String getWorkName() {
        return StaticsConst.TYPE_WORK_SUPPLY;
    }

    @Override
    public void runStatics(PunchAttendanceStaticsExt statics, Long workId, Map<String, String> param) {
        ApprAttenceSupplyService apprAttenceSupplyService = SpringUtil.getBean(ApprAttenceSupplyService.class);
        PunchClockService punchClockService = SpringUtil.getBean(PunchClockService.class);
        PunchClockRuleService punchClockRuleService = SpringUtil.getBean(PunchClockRuleService.class);
        ApprApplyService apprApplyService = SpringUtil.getBean(ApprApplyService.class);
        ApprOutsideService apprOutsideService = SpringUtil.getBean(ApprOutsideService.class);
        ApprOverTimeService apprOverTimeService = SpringUtil.getBean(ApprOverTimeService.class);

        ApprAttenceSupply attenceSupply = apprAttenceSupplyService.getById(workId);

        Long userId = statics.getUserId();
        String unityId = statics.getUnitId();
        PunchClockRule rule = punchClockRuleService.getPunchClockRuleByUnityid(unityId);

        Date date = attenceSupply.getEndTime();//补签日期

        Date ruleInTime = DateUtils.getDateTime(date, rule.getInTime());
        Date ruleOutTime = DateUtils.getDateTime(date, rule.getOutTime());


        Date dayEndTime = DateUtils.getDateTime(date, StaticsConst.CROSS_DAY_TIME);

        Integer supplyType = attenceSupply.getSupplyType();//补签类型

        PunchClock punchClock = punchClockService.getPunchClockByUserAndUnitIdAndDate(userId, unityId, date);
        List<ApprAttenceSupply> apprAttences = apprAttenceSupplyService.getApprAttenceSupplysByDate(userId, date);

        boolean isAll = false;//是否已经签到和签退
        if (supplyType == 1) {//签到
            if (punchClock != null && punchClock.getSignOffTime() != null) {
                isAll = true;
            } else {
                for (ApprAttenceSupply as : apprAttences) {
                    ApprApply apply = apprApplyService.getById(as.getApplyId());
                    if (as.getSupplyType() == 2 && apply.getCurState() == 3) {
                        isAll = true;
                        break;
                    }
                }
            }

        } else if (supplyType == 2) {//2签退
            if (punchClock != null && punchClock.getSignInTime() != null) {
                isAll = true;
            } else {
                for (ApprAttenceSupply as : apprAttences) {
                    ApprApply apply = apprApplyService.getById(as.getApplyId());
                    if (as.getSupplyType() == 1 && apply.getCurState() == 3) {
                        isAll = true;
                        break;
                    }
                }
            }

        }
        //还没有被旷工，并且打卡签到签退不全，那么 签到更新迟到，签退更新早退
        if (!isAll || statics.getMinerCount() == null || statics.getMinerCount() == 0) {
            if (supplyType == 1) {//签到
                updateLater(statics, attenceSupply, ruleInTime, punchClock);
            } else if (supplyType == 2) {//签退
                updateEarly(statics, attenceSupply, ruleOutTime, punchClock);
            }
        }

        if (isAll) {
            //更新不在旷工，一天只能旷工1次
            statics.setMinerCount(0);
            //旷工取消了，更新迟到和早退时间
            updateLater(statics, attenceSupply, ruleInTime, punchClock);
            updateEarly(statics, attenceSupply, ruleOutTime, punchClock);
            //更新加班
            List<ApprOverTime> apprOverTimeByTime = apprOverTimeService.getApprOverTimeByTimeAndState(userId, unityId, 3, ruleInTime, dayEndTime);
            Double overTime = statics.getWorkHous();
            for (ApprOverTime ao : apprOverTimeByTime) {
                Double distHour = DateUtils.getDistHour(ao.getStartTime(), ao.getEndTime());
                overTime = BigDecimalUtil.add(overTime, distHour, 2);
            }
            statics.setWorkHous(overTime);
            //更新外勤时间
            Double outsideTime = statics.getOutHous();
            List<ApprOutside> apprOutsidesByDate = apprOutsideService.getApprOutsidesByDateAndState(userId, unityId, 3, ruleOutTime, dayEndTime);
            for (ApprOutside ao : apprOutsidesByDate) {
                Date startTime = ao.getStartTime();
                Date endTime = ao.getEndTime();
                if (ao.getStartTime().before(ruleInTime)) {
                    startTime = ruleInTime;
                }
                if (ao.getEndTime().after(ruleOutTime)) {
                    endTime = ruleOutTime;
                }
                Double distHour = DateUtils.getDistHour(startTime, endTime);
                outsideTime = BigDecimalUtil.add(outsideTime, distHour, 2);
            }
            statics.setOutHous(outsideTime);
        }
    }

    /***
     * 更新早退
     * @param statics
     * @param attenceSupply
     * @param ruleOutTime
     * @param punchClock
     */
    private void updateEarly(PunchAttendanceStaticsExt statics, ApprAttenceSupply attenceSupply, Date ruleOutTime, PunchClock punchClock) {
        //更新早退时间
        double hour = 0;
        //补签早退时间
        Double offDistHour = DateUtils.getDistHour(attenceSupply.getEndTime(), ruleOutTime);
        offDistHour = offDistHour < 0 ? 0 : offDistHour;
        if (punchClock != null && punchClock.getSignOffTime() != null) {
            //打卡早退时间
            Double pucDistHour = DateUtils.getDistHour(punchClock.getSignOffTime(), ruleOutTime);
            pucDistHour = pucDistHour < 0 ? 0 : pucDistHour;
            hour = offDistHour < pucDistHour ? offDistHour : pucDistHour;
        } else {
            hour = offDistHour;
        }
        statics.setEarlyHour(hour);
    }

    /**
     * 更新迟到时间
     *
     * @param statics
     * @param attenceSupply
     * @param ruleInTime
     * @param punchClock
     */
    private void updateLater(PunchAttendanceStaticsExt statics, ApprAttenceSupply attenceSupply, Date ruleInTime, PunchClock punchClock) {
        //更新迟到时间
        double laterHour = 0;
        //补签迟到时间
        Double siDistHour = DateUtils.getDistHour(attenceSupply.getEndTime(), ruleInTime);
        siDistHour = siDistHour < 0 ? 0 : siDistHour;
        if (punchClock != null && punchClock.getSignInTime() != null) {
            //打卡迟到时间
            Double pucDistHour = DateUtils.getDistHour(punchClock.getSignInTime(), ruleInTime);
            pucDistHour = pucDistHour < 0 ? 0 : pucDistHour;
            laterHour = siDistHour < pucDistHour ? siDistHour : pucDistHour;
        } else {
            laterHour = siDistHour;
        }
        statics.setLateHour(laterHour);
    }
}
