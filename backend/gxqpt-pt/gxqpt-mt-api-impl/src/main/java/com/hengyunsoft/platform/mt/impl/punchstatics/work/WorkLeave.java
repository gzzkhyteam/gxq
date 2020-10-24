package com.hengyunsoft.platform.mt.impl.punchstatics.work;


import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprLeave;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClock;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClockRule;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.PunchAttendanceStaticsExt;
import com.hengyunsoft.platform.mt.impl.punchstatics.StaticsConst;
import com.hengyunsoft.platform.mt.repository.apprwork.service.ApprLeaveService;
import com.hengyunsoft.platform.mt.repository.punchclock.service.PunchClockRuleService;
import com.hengyunsoft.platform.mt.repository.punchclock.service.PunchClockService;
import com.hengyunsoft.platform.mt.utils.UnityUtil;
import com.hengyunsoft.utils.SpringUtil;

import java.util.Date;
import java.util.Map;

/***
 * 请假统计业务类型，请假审批通过了，才过来执行统计</>
 * 1:请假可以夸天，如果申请里面是夸天的，那么只统计PunchAttendanceStatics里日期的请假时间
 */
public class WorkLeave implements IWorkStatics {

    @Override
    public String getWorkName() {
        return StaticsConst.TYPE_WORK_LEAVE;
    }

    @Override
    public void runStatics(PunchAttendanceStaticsExt statics, Long workId, Map<String, String> param) {
        ApprLeaveService apprLeaveService = SpringUtil.getBean(ApprLeaveService.class);
        ApprLeave apprLeave = apprLeaveService.getById(workId);
        PunchClockRuleService punchClockRuleService = SpringUtil.getBean(PunchClockRuleService.class);

        Long userId = statics.getUserId();
        String unityId = UnityUtil.getUnityId(userId);
        PunchClockRule rule = punchClockRuleService.getPunchClockRuleByUnityid(unityId);

        String attDay = statics.getAttDay();
        Date date = DateUtils.string2Date(attDay, DateUtils.DEFAULT_DATE_FORMAT);
        Date ruleInTime = DateUtils.getDateTime(date, rule.getInTime());
        Date ruleOutTime = DateUtils.getDateTime(date, rule.getOutTime());

        Date startTime = apprLeave.getStartTime();
        Date endTime = apprLeave.getEndTime();

        boolean crossDays = DateUtils.isCrossDays(startTime, endTime);
        if (crossDays) {
            if (startTime.before(ruleInTime)) {
                startTime = ruleInTime;
            }
            if (endTime.after(ruleOutTime)) {
                endTime = ruleOutTime;
            }
        }

        double distHour = DateUtils.getDistHour(startTime, endTime);//今天请假时间
        statics.setLeaveHous(distHour);

        //更新不在旷工，一天只能旷工1次
        statics.setMinerCount(0);

        PunchClockService punchClockService = SpringUtil.getBean(PunchClockService.class);
        PunchClock clock = punchClockService.getPunchClockByUserAndUnitIdAndDate(userId, unityId, date);
        //更新迟到时间
        Double lateHour = statics.getLateHour();
        if (lateHour != null && lateHour > 0) {
            if (clock != null) {
                Date signInTime = clock.getSignInTime();
                Date calEndTime = endTime;
                if (startTime.before(signInTime)) {
                    Double distLater = DateUtils.getDistHour(startTime, calEndTime);
                    Double lateTime = (lateHour - distLater) > 0 ? (lateHour - distLater) : 0;
                    statics.setLateHour(lateTime);
                }

            }
        }
        //更新早退时间
        Double earlyHour = statics.getEarlyHour();
        if (earlyHour != null && earlyHour > 0) {
            clock = punchClockService.getPunchClockByUserAndUnitIdAndDate(userId, unityId, date);
            if (clock != null) {
                Date signOffTime = clock.getSignOffTime();
                Date calEndTime = endTime;
                Date calStartTime = startTime;
                if (calEndTime.after(signOffTime)) {
                    Double distEarly = DateUtils.getDistHour(calStartTime, calEndTime);
                    Double earlyTime = (earlyHour - distEarly) > 0 ? (earlyHour - distEarly) : 0;
                    statics.setEarlyHour(earlyTime);
                }
            }
        }
    }
}
