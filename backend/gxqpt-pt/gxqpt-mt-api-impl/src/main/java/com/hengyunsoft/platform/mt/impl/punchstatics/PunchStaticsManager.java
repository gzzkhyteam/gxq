package com.hengyunsoft.platform.mt.impl.punchstatics;

import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClockHis;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.PunchAttendanceStatics;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.PunchAttendanceStaticsExt;
import com.hengyunsoft.platform.mt.entity.userconfig.po.UserConfig;
import com.hengyunsoft.platform.mt.impl.punchstatics.work.*;
import com.hengyunsoft.platform.mt.impl.userconfig.UserConfigJobType;
import com.hengyunsoft.platform.mt.repository.punchclock.example.PunchClockHisExample;
import com.hengyunsoft.platform.mt.repository.punchclock.service.PunchClockHisService;
import com.hengyunsoft.platform.mt.repository.punchstatics.example.PunchAttendanceStaticsExample;
import com.hengyunsoft.platform.mt.repository.punchstatics.service.PunchAttendanceStaticsService;
import com.hengyunsoft.platform.mt.repository.userconfig.service.UserConfigService;
import com.hengyunsoft.platform.mt.utils.HolidayUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 考勤统计逻辑处理
 */
@Service
@Slf4j
public class PunchStaticsManager {
    @Autowired
    private PunchAttendanceStaticsService punchAttendanceStaticsService;
    @Autowired
    private UserConfigService userConfigService;
    @Autowired
    private PunchClockHisService punchClockHisService;
    @Autowired
    private  DozerUtils dozerUtils;

    /**
     * key:  业务类型 value:处理业务统计的对象
     */
    private Map<String, IWorkStatics> workStaticsMap;

    @PostConstruct
    public void init() {
        workStaticsMap = new HashMap<>();

        IWorkStatics punchClocknew = new WorkPunchClock();
        workStaticsMap.put(punchClocknew.getWorkName(), punchClocknew);

        IWorkStatics workOvertime = new WorkOvertime();
        workStaticsMap.put(workOvertime.getWorkName(), workOvertime);

        IWorkStatics workLeave = new WorkLeave();
        workStaticsMap.put(workLeave.getWorkName(), workLeave);

        IWorkStatics workSupply = new WorkSupply();
        workStaticsMap.put(workSupply.getWorkName(), workSupply);

        IWorkStatics workBusiness = new WorkBusiness();
        workStaticsMap.put(workBusiness.getWorkName(), workBusiness);

        IWorkStatics workCancel = new WorkCancel();
        workStaticsMap.put(workCancel.getWorkName(), workCancel);

        IWorkStatics workoutside = new Workoutside();
        workStaticsMap.put(workoutside.getWorkName(), workoutside);
    }


    /***
     * 统计
     * @param userId 用户id
     * @param unitId 单位id
     * @param data 统计日期,一天一天统计
     * @param type 业务类型  punchClock:打卡，overtime:加班，leave:请假，business:出差，outside:外勤，:supply:补签, cancel:撤销
     *              除打卡和撤销外，其他和申请审批类型一致,使用StaticsConst引用
     * @param workId  业务在业务表的主键id
     * @param param 各个业务统计自定义的参数
     */
    public void saveStatics(Long userId, String unitId, Date data, String type, Long workId, Map<String, String> param) {
        //取统计日期的考勤数据
        String dateStr = DateUtils.dateToString(data, DateUtils.DEFAULT_DATE_FORMAT);
        PunchAttendanceStatics statics = punchAttendanceStaticsService.getPunchAttendanceStaticsByDate(userId, dateStr);
        boolean isHas = true;
        if (statics == null) {
            isHas = false;
            statics = createStaticsExt(userId, unitId, data, dateStr);
        }

        //根据type得到不同的处理对象去处理对应的统计业务逻辑
        IWorkStatics iWorkStatics = workStaticsMap.get(type);
        if (iWorkStatics == null) {
            log.error("统计业务类型错误，没有对应的业务处理类型:{}", type);
            throw new RuntimeException();
        }
        //执行统计逻辑
        PunchAttendanceStaticsExt staticsExtxt = dozerUtils.map(statics,PunchAttendanceStaticsExt.class);
        iWorkStatics.runStatics(staticsExtxt, workId, param);
        //保存考勤数据
        if (isHas) {
            punchAttendanceStaticsService.updateByIdSelective(statics);
        } else {
            punchAttendanceStaticsService.saveSelective(statics);
        }
        setStarUserDate();

    }

    /***
     * 设置用户第一次使用本系统时间
     */
    private void setStarUserDate() {
        Long userId = BaseContextHandler.getAdminId();
        UserConfig config = userConfigService.getUserConfigByidAndType(userId, UserConfigJobType.start_user_pt.jobId);
        if (config == null) {
            config = new UserConfig();

            Date now = new Date();
            Date pcDate = null;
            PunchClockHisExample pcexample = new PunchClockHisExample();
            pcexample.createCriteria().andUserIdEqualTo(userId);
            pcexample.setOrderByClause("clock_time");
            pcexample.setLimitValue("0,1");
            List<PunchClockHis> punchClockHis = punchClockHisService.find(pcexample);
            if (punchClockHis != null && !punchClockHis.isEmpty()) {
                pcDate = punchClockHis.get(0).getClockTime();
            }

            Date paDate = null;
            PunchAttendanceStaticsExample example = new PunchAttendanceStaticsExample();
            example.createCriteria().andUserIdEqualTo(userId);
            example.setOrderByClause("att_day");
            example.setLimitValue("0,1");
            List<PunchAttendanceStatics> punchAttendanceStaticsExts = punchAttendanceStaticsService.find(example);
            if (punchAttendanceStaticsExts != null && !punchAttendanceStaticsExts.isEmpty()) {
                paDate = DateUtils.string2Date(punchAttendanceStaticsExts.get(0).getAttDay(), DateUtils.DEFAULT_DATE_FORMAT);
            }

            if (pcDate == null) {
                pcDate = now;
            }
            if (paDate == null) {
                paDate = now;
            }
            Date startTime = pcDate.before(paDate) ? pcDate : paDate;
            String s = DateUtils.dateToString(DateUtils.getDateTime(startTime, "00:00:00"), DateUtils.DATE_TIME_FORMAT);
            config.setJobValue(s);
            config.setJobId(UserConfigJobType.start_user_pt.jobId);
            config.setUserId(userId);
            config.setCreateUser(userId);
            userConfigService.saveSelective(config);
        }
    }

    /***
     * 创建统计对象
     * @param userId
     * @param unitId
     * @param data
     * @param dateStr
     * @return
     */
    private PunchAttendanceStaticsExt createStaticsExt(Long userId, String unitId, Date data, String dateStr) {
        PunchAttendanceStaticsExt statics;
        String year = DateUtils.dateToString(data, DateUtils.DEFAULT_YEAR_FORMAT);
        String month = DateUtils.dateToString(data, DateUtils.DEFAULT_MONTH_FORMAT);
        statics = new PunchAttendanceStaticsExt();
        boolean holiday = HolidayUtil.isHoliday(unitId, data);
        statics.setUserId(userId);
        statics.setIsholiday(holiday ? 1 : 0);
        statics.setUnitId(unitId);
        statics.setAttYear(year);
        statics.setAttMonth(month);
        statics.setAttDay(dateStr);
        statics.setCreateUser(userId);
        return statics;
    }
}
