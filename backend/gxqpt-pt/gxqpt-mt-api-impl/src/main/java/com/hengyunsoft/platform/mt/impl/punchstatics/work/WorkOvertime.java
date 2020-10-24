package com.hengyunsoft.platform.mt.impl.punchstatics.work;

import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.platform.mt.entity.appr.po.ApprApply;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprAttenceSupply;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprOverTime;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClock;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.PunchAttendanceStaticsExt;
import com.hengyunsoft.platform.mt.impl.punchstatics.StaticsConst;
import com.hengyunsoft.platform.mt.repository.appr.service.ApprApplyService;
import com.hengyunsoft.platform.mt.repository.apprwork.service.ApprAttenceSupplyService;
import com.hengyunsoft.platform.mt.repository.apprwork.service.ApprOverTimeService;
import com.hengyunsoft.platform.mt.repository.punchclock.service.PunchClockService;
import com.hengyunsoft.platform.mt.utils.BigDecimalUtil;
import com.hengyunsoft.utils.SpringUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

/***
 * 加班统计业务类型，加班审批通过了，才过来执行统计</>
 * 1:指定日期有签到签退记录就统计加班时间，加班时间以审批通过时间为准
 * 2:加班申请必须一天一提，不能夸天,所有只要当天打卡记录直接取审批时间作为加班时间
 * 3:如果是撤销的加班审批，那么必须恢复加班时间
 */
public class WorkOvertime implements IWorkStatics {
    @Override
    public String getWorkName() {
        return StaticsConst.TYPE_WORK_OVERTIME;
    }

    @Override
    public void runStatics(PunchAttendanceStaticsExt statics, Long workId, Map<String, String> param) {
        ApprOverTimeService apprOverTimeService = SpringUtil.getBean(ApprOverTimeService.class);
        ApprApplyService apprApplyService = SpringUtil.getBean(ApprApplyService.class);
        PunchClockService punchClockService = SpringUtil.getBean(PunchClockService.class);
        ApprAttenceSupplyService apprAttenceSupplyService = SpringUtil.getBean(ApprAttenceSupplyService.class);

        Long userId = statics.getUserId();
        Date date = DateUtils.string2Date(statics.getAttDay(), DateUtils.DEFAULT_DATE_FORMAT);

        ApprOverTime apprOverTime = apprOverTimeService.getById(workId);

        PunchClock punchClock = punchClockService.getPunchClockByUserAndUnitIdAndDate(userId, statics.getUnitId(), date);

        boolean haSigIn = punchClock != null && punchClock.getSignInTime() != null;
        boolean haSignOff = punchClock != null && punchClock.getSignOffTime() != null;
        List<ApprAttenceSupply> apprAttences = apprAttenceSupplyService.getApprAttenceSupplysByDateAndType(userId, date, 1);
        for (ApprAttenceSupply atts : apprAttences) {
            ApprApply apply = apprApplyService.getById(atts.getApplyId());
            if (statics.getUnitId().equals(apply.getUnitId()) && apply.getCurState() != null && apply.getCurState() == 3) {
                if (atts.getSupplyType() == 1) {
                    haSigIn = true;
                } else {
                    haSignOff = true;
                }
            }
        }

        if (haSigIn && haSignOff) {
            double distHour = DateUtils.getDistHour(apprOverTime.getStartTime(), apprOverTime.getEndTime());
            if (statics.getWorkHous() == null) {
                statics.setWorkHous(distHour);
            } else {
                double workHour = BigDecimalUtil.add(statics.getWorkHous(), distHour, 2);
                statics.setWorkHous(workHour);
            }
        }
    }
}
