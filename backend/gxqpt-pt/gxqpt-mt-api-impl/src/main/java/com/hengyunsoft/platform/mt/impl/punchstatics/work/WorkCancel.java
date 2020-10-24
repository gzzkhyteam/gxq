package com.hengyunsoft.platform.mt.impl.punchstatics.work;

import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.platform.mt.entity.appr.po.ApprApply;
import com.hengyunsoft.platform.mt.entity.appr.po.ApprPerson;
import com.hengyunsoft.platform.mt.entity.apprwork.po.*;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClock;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClockRule;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.PunchAttendanceStaticsExt;
import com.hengyunsoft.platform.mt.impl.punchstatics.StaticsConst;
import com.hengyunsoft.platform.mt.repository.appr.service.ApprApplyService;
import com.hengyunsoft.platform.mt.repository.appr.service.ApprPersonService;
import com.hengyunsoft.platform.mt.repository.apprwork.service.*;
import com.hengyunsoft.platform.mt.repository.punchclock.service.PunchClockRuleService;
import com.hengyunsoft.platform.mt.repository.punchclock.service.PunchClockService;
import com.hengyunsoft.platform.mt.utils.BigDecimalUtil;
import com.hengyunsoft.platform.mt.utils.UnityUtil;
import com.hengyunsoft.utils.SpringUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

/***
 * 撤销统计业务类型,撤销审批通过了，才过来执行统计
 * 1:撤销要更新对应申请类型的统计时间
 */
public class WorkCancel implements IWorkStatics {
    @Override
    public String getWorkName() {
        return StaticsConst.TYPE_WORK_CANCEL;
    }

    /***
     *
     * @param statics 统计对象
     * @param workId 业务表的主键id,这里撤销审批申请的id
     * @param param  参数
     */
    @Override
    public void runStatics(PunchAttendanceStaticsExt statics, Long workId, Map<String, String> param) {
        ApprOverTimeService apprOverTimeService = SpringUtil.getBean(ApprOverTimeService.class);
        ApprLeaveService apprLeaveService = SpringUtil.getBean(ApprLeaveService.class);
        ApprBusinessService apprBusinessService = SpringUtil.getBean(ApprBusinessService.class);
        ApprOutsideService apprOutsideService = SpringUtil.getBean(ApprOutsideService.class);
        ApprAttenceSupplyService apprAttenceSupplyService = SpringUtil.getBean(ApprAttenceSupplyService.class);
        ApprPersonService apprPersonService = SpringUtil.getBean(ApprPersonService.class);
        PunchClockService punchClockService = SpringUtil.getBean(PunchClockService.class);
        ApprApplyService apprApplyService = SpringUtil.getBean(ApprApplyService.class);
        PunchClockRuleService punchClockRuleService = SpringUtil.getBean(PunchClockRuleService.class);

        ApprApply apprApply = apprApplyService.getById(workId);
        long applyId = apprApply.getId();
        //原来的审批通过了，才去回退更新相应的时间,有一个不同意或者没有处理，那么就是审批没有通过
        List<ApprPerson> apprPersons = apprPersonService.getApprPersons(apprApply.getId(), 1);
        for (ApprPerson ap : apprPersons) {
            if(ap.getAgree() == null || ap.getAgree() ==1){
                return;
            }
        }
        String aprType = apprApply.getAprType();
        switch (aprType) {
            case "overtime"://加班
                ApprOverTime apprOverTime = apprOverTimeService.getApprOverTimeByApplyId(applyId);
                Date startTime = apprOverTime.getStartTime();
                Date endTime = apprOverTime.getEndTime();
                double disTime = DateUtils.getDistHour(startTime, endTime);
                double subtract = BigDecimalUtil.subtract(statics.getWorkHous(), disTime, 2);
                subtract = subtract < 0 ? 0 : subtract;
                statics.setWorkHous(subtract);
                break;
            case "leave"://请假
                ApprLeave apprLeave = apprLeaveService.getApprLeaveByApplyId(applyId);
                disTime = DateUtils.getDistHour(apprLeave.getStartTime(), apprLeave.getEndTime());
                subtract = BigDecimalUtil.subtract(statics.getLeaveHous(), disTime, 2);
                subtract = subtract < 0 ? 0 : subtract;
                statics.setLeaveHous(subtract);
                break;
            case "business"://出差
                ApprBusiness apprBusiness = apprBusinessService.getApprBusinessByApplyId(applyId);
                disTime = DateUtils.getDistHour(apprBusiness.getStartTime(), apprBusiness.getEndTime());
                subtract = BigDecimalUtil.subtract(statics.getTravelHous(), disTime, 2);
                subtract = subtract < 0 ? 0 : subtract;
                statics.setTravelHous(subtract);
                break;
            case "outside"://外勤
                ApprOutside apprOutside = apprOutsideService.getApprOutsideByApplyid(applyId);
                disTime = DateUtils.getDistHour(apprOutside.getStartTime(), apprOutside.getEndTime());
                subtract = BigDecimalUtil.subtract(statics.getOutHous(), disTime, 2);
                subtract = subtract < 0 ? 0 : subtract;
                statics.setOutHous(subtract);
                break;
            case "supply"://补签
                Date date = DateUtils.string2Date(statics.getAttDay(), DateUtils.DEFAULT_DATE_FORMAT);
                boolean hasSingIn = false;
                boolean hasSingOff = false;
                PunchClock punchClock = punchClockService.getPunchClockByUserAndUnitIdAndDate(statics.getUserId(),statics.getUnitId(), date);
                List<ApprAttenceSupply> supplys = apprAttenceSupplyService.getApprAttenceSupplysByDate(statics.getUserId(), date);
                for (ApprAttenceSupply as : supplys) {
                    if (as.getSupplyType() == 1) {
                        hasSingIn = true;
                    }
                    if (as.getSupplyType() == 2) {
                        hasSingOff = true;
                    }
                }
                if (punchClock != null && punchClock.getSignInTime() != null) {
                    hasSingIn = true;
                }
                if (punchClock != null && punchClock.getSignOffTime() != null) {
                    hasSingOff = true;
                }

                if (hasSingIn && hasSingOff) {
                    //更新旷工了，一天只能旷工1次
                    statics.setMinerCount(1);
                    //更新加班
                    String unityId = UnityUtil.getUnityId(statics.getUserId());
                    PunchClockRule rule = punchClockRuleService.getPunchClockRuleByUnityid(unityId);

                    Date ruleInTime = DateUtils.getDateTime(date,rule.getInTime());
                    Date ruleOutTime = DateUtils.getDateTime(date,rule.getOutTime());

                    Date dayEndTime = DateUtils.getDateTime(date, StaticsConst.CROSS_DAY_TIME);
                    List<ApprOverTime> apprOverTimeByTime = apprOverTimeService.getApprOverTimeByTime(statics.getUserId(),statics.getUnitId(), ruleOutTime, dayEndTime);
                    double overTime = 0;
                    for (ApprOverTime ao : apprOverTimeByTime) {
                        ApprApply apply = apprApplyService.getById(ao.getApplyId());
                        if (apply != null && apply.getCurState() == 3) {
                            Double distHour = DateUtils.getDistHour(ao.getStartTime(), ao.getEndTime());
                            overTime = BigDecimalUtil.subtract(overTime, distHour, 2);
                        }
                    }
                    statics.setWorkHous(overTime);
                    //更新外勤时间
                    double outsideTime = 0;
                    List<ApprOutside> apprOutsidesByDate = apprOutsideService.getApprOutsidesByDate(statics.getUserId(), statics.getUnitId(),ruleOutTime, dayEndTime);
                    for (ApprOutside ao : apprOutsidesByDate) {
                        ApprApply apply = apprApplyService.getById(ao.getApplyId());
                        if (apply != null && apply.getCurState() == 3) {
                             startTime = ao.getStartTime();
                             endTime = ao.getEndTime();
                            if (ao.getStartTime().before(ruleInTime)) {
                                startTime = ruleInTime;
                            }
                            if (ao.getEndTime().after(ruleOutTime)) {
                                endTime = ruleOutTime;
                            }

                            Double distHour = DateUtils.getDistHour(startTime, endTime);
                            outsideTime = BigDecimalUtil.subtract(outsideTime, distHour, 2);
                        }
                    }
                    statics.setOutHous(outsideTime);
                }
                break;
            default:
                break;
        }


    }
}
