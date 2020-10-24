package com.hengyunsoft.platform.mt.impl.punchstatics.work;

import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprBusiness;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClockRule;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.PunchAttendanceStaticsExt;
import com.hengyunsoft.platform.mt.impl.punchstatics.StaticsConst;
import com.hengyunsoft.platform.mt.repository.apprwork.service.ApprBusinessService;
import com.hengyunsoft.platform.mt.repository.punchclock.service.PunchClockRuleService;
import com.hengyunsoft.platform.mt.utils.UnityUtil;
import com.hengyunsoft.utils.SpringUtil;

import java.util.Date;
import java.util.Map;

/***
 * 出差统计业务类型,出差审批通过了，才过来执行统计
 * 1:出差不需要打外勤卡
 * 2:出差可以夸天，如果申请里面是夸天的，那么只统计PunchAttendanceStatics里日期的出差时间
 *
 */
public class WorkBusiness implements IWorkStatics {

    @Override
    public String getWorkName() {
        return StaticsConst.TYPE_WORK_BUSINESS;
    }

    @Override
    public void runStatics(PunchAttendanceStaticsExt statics, Long workId, Map<String, String> param) {
        PunchClockRuleService punchClockRuleService = SpringUtil.getBean(PunchClockRuleService.class);
        ApprBusinessService apprBusinessService = SpringUtil.getBean(ApprBusinessService.class);
        ApprBusiness apprBusiness = apprBusinessService.getById(workId);

        Long userId = statics.getUserId();
        String unityId = UnityUtil.getUnityId(userId);
        PunchClockRule rule = punchClockRuleService.getPunchClockRuleByUnityid(unityId);

        String attDay = statics.getAttDay();
        Date date = DateUtils.string2Date(attDay, DateUtils.DEFAULT_DATE_FORMAT);
        Date ruleInTime = DateUtils.getDateTime(date,rule.getInTime());
        Date ruleOutTime = DateUtils.getDateTime(date,rule.getOutTime());

        Date startTime = apprBusiness.getStartTime();
        Date endTime = apprBusiness.getEndTime();

        boolean crossDays = DateUtils.isCrossDays(startTime, endTime);
        if (crossDays) {
            if (startTime.before(ruleInTime)) {
                startTime = ruleInTime;
            }
            if (endTime.after(ruleOutTime)) {
                endTime = ruleOutTime;
            }
        }

        double distHour = DateUtils.getDistHour(startTime, endTime);
        statics.setTravelHous(distHour);

        //更新不在旷工，一天只能旷工1次
        statics.setMinerCount(0);
        //更新不在迟到和早退
        statics.setLateHour(0d);
        statics.setEarlyHour(0d);

    }
}
