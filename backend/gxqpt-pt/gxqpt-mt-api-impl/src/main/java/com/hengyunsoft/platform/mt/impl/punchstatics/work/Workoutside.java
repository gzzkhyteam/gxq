package com.hengyunsoft.platform.mt.impl.punchstatics.work;

import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprOutside;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClock;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.PunchAttendanceStaticsExt;
import com.hengyunsoft.platform.mt.impl.punchstatics.StaticsConst;
import com.hengyunsoft.platform.mt.repository.apprwork.service.ApprOutsideService;
import com.hengyunsoft.platform.mt.repository.punchclock.service.PunchClockService;
import com.hengyunsoft.platform.mt.utils.BigDecimalUtil;
import com.hengyunsoft.platform.mt.utils.UnityUtil;
import com.hengyunsoft.utils.SpringUtil;

import java.util.Date;
import java.util.Map;

/***
 * 外勤统计业务类型,外勤审批通过了，才过来执行统计
 * 1:外勤需要打卡
 * 2:外勤申请不能跨天，必须一天一天申请,时间以审批时间为准
 */
public class Workoutside implements IWorkStatics {
    @Override
    public String getWorkName() {
        return StaticsConst.TYPE_WORK_OUTSIDE;
    }

    @Override
    public void runStatics(PunchAttendanceStaticsExt statics, Long workId, Map<String, String> param) {
        //    PunchClockRuleService punchClockRuleService = SpringUtil.getBean(PunchClockRuleService.class);
        ApprOutsideService apprOutsideService = SpringUtil.getBean(ApprOutsideService.class);
        PunchClockService punchClockService = SpringUtil.getBean(PunchClockService.class);

        ApprOutside apprOutside = apprOutsideService.getById(workId);

        Long userId = statics.getUserId();
        //String unityId = UnityUtil.getUnityId(userId);
        //       PunchClockRule rule = punchClockRuleService.getPunchClockRuleByUnityid(unityId);

//        Date ruleInTime = DateUtils.getTodayTime(rule.getInTime());
//        Date ruleOutTime = DateUtils.getTodayTime(rule.getOutTime());

        Date startTime = apprOutside.getStartTime();
        Date endTime = apprOutside.getEndTime();

//        boolean crossDays = DateUtils.isCrossDays(startTime, endTime);
//        if (crossDays) {
//            if (startTime.before(ruleInTime)) {
//                startTime = ruleInTime;
//            }
//            if (endTime.after(ruleOutTime)) {
//                endTime = ruleOutTime;
//            }
//        }

        //有打卡记录才统计时间
        PunchClock punchClock = punchClockService.getPunchClockByUserAndUnitIdAndDate(userId,statics.getUnitId(), startTime);
        if (punchClock != null && punchClock.getSignInTime() != null && punchClock.getSignOffTime() != null) {
            double distHour = DateUtils.getDistHour(startTime, endTime);
            double total = BigDecimalUtil.add(statics.getOutHous(), distHour, 2);
            statics.setOutHous(total);

            //更新不在旷工，一天只能旷工1次
            statics.setMinerCount(0);
        }
    }
}
