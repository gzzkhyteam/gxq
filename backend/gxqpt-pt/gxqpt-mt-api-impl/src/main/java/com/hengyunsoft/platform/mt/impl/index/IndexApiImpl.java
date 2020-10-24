package com.hengyunsoft.platform.mt.impl.index;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.mt.api.index.dto.HalfYearAttenceDTO;
import com.hengyunsoft.platform.mt.api.index.dto.IndexTotalDTO;
import com.hengyunsoft.platform.mt.api.version.dto.ClientVersionDTO;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.PunchAttendanceStaticsExt;
import com.hengyunsoft.platform.mt.entity.version.po.ClientVersion;
import com.hengyunsoft.platform.mt.repository.app.dao.ApplicationMapper;
import com.hengyunsoft.platform.mt.repository.app.example.ApplicationExample;
import com.hengyunsoft.platform.mt.repository.appr.dao.ApprApplyMapper;
import com.hengyunsoft.platform.mt.repository.appr.example.ApprApplyExample;
import com.hengyunsoft.platform.mt.repository.punchstatics.dao.PunchAttendanceStaticsMapper;
import com.hengyunsoft.platform.mt.repository.version.dao.ClientVersionMapper;
import com.hengyunsoft.platform.mt.repository.version.example.ClientVersionExample;
import com.hengyunsoft.platform.mt.repository.work.dao.WorkLogMapper;
import com.hengyunsoft.platform.mt.utils.HolidayUtil;
import com.hengyunsoft.platform.mt.utils.UnityUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.hengyunsoft.platform.mt.impl.index
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：首页Api
 * 修改人：zhaopengfei
 * 修改时间：2018/8/28
 * 修改内容：新增基础接口
 */
@Api(value = "API - IndexApiImpl.java", description = "首页")
@RestController
@RequestMapping("index")
@Slf4j
public class IndexApiImpl /*implements IndexApi */{
    @Autowired
    private ClientVersionMapper clientVersionMapper;
    @Autowired
    private ApplicationMapper applicationMapper;
    @Autowired
    private PunchAttendanceStaticsMapper punchAttendanceStaticsMapper;
    @Autowired
    private ApprApplyMapper apprApplyMapper;
    @Autowired
    private WorkLogMapper workLogMapper;

    @Autowired
    private DozerUtils dozerUtils;
    
    /**
     * 描述：查找总信息
     * 参数：
     * 返回值：Result<IndexTotalDTO>
     * 修改人：zhaopengfei
     * 修改时间：2018/8/28
     * 修改内容：
     */
    @RequestMapping(value = "getTotalInfo",method = RequestMethod.GET)
    @ApiOperation(value = "查找总信息", notes = "查找总信息")
    
    public Result<IndexTotalDTO> getTotalInfo() {
        Long userId = BaseContextHandler.getAdminId();
        IndexTotalDTO dto = new IndexTotalDTO();
        //查找版本总数
        ClientVersionExample clientVersion = new ClientVersionExample();
        clientVersion.createCriteria().andStateEqualTo(2);
        int appNum =clientVersionMapper.countByExample(clientVersion);
        dto.setAppNum(appNum);
        //查找最新版本更新人数
        ClientVersion lastVersion = clientVersionMapper.getLastVersionInfo();
        dto.setAppLastUpdateNum(lastVersion.getUpdateNum() == null ? 0:lastVersion.getUpdateNum());
        //查找应用程序数量
        ApplicationExample applicationExample = new ApplicationExample();
        applicationExample.createCriteria().andStateEqualTo(3);
        int applNum =applicationMapper.countByExample(applicationExample);
        dto.setApplNum(applNum);
        //查找基础应用程序数量
        dto.setBaseApplNum(3);
        //查找当月应出勤天数
        Date startDate = DateUtils.getMonthFirstDay(new Date());
        Date endDate = DateUtils.getMonthLastDay(new Date());
        int holidays = HolidayUtil.getHolidays(startDate, endDate);
        int needDays = DateUtils.getDistDates(startDate, endDate) + 1 - holidays;//应该出勤天数
        dto.setNowMonthDayNum(needDays);
        //查找当月正常出勤天数
        Map<String,Object> param = new HashMap<>();
        String unitId = UnityUtil.getUnityId(userId);
        param.put("unitId", unitId);
        param.put("userId",userId);
        param.put("startDate",startDate);
        param.put("endDate",endDate);
        int normalDay = punchAttendanceStaticsMapper.getNormalDay(param);
        dto.setNowNormalDayNum(normalDay);
        //查找考勤待审批条数
        ApprApplyExample apprApplyExample = new ApprApplyExample();
        apprApplyExample.createCriteria().andCurAprUserIdEqualTo(userId)
                .andCurStateEqualTo(1).andUnitIdEqualTo(unitId);
        int aprNum = apprApplyMapper.countByExample(apprApplyExample);
        dto.setAprNum(aprNum);
        //查找日志待查看条数
        int workLogNum = workLogMapper.selectNoViewNum(userId,unitId);
        dto.setWorkLogNum(workLogNum);
        return Result.success(dto);
    }

    /**
     * 描述：查找首页中APP版本更新前五条数据
     * 参数：
     * 返回值：List<ClientVersionDTO>
     * 修改人：zhaopengfei
     * 修改时间：2018/8/28
     * 修改内容：
     */
    @RequestMapping(value = "getAppUpdateInfo",method = RequestMethod.GET)
    @ApiOperation(value = "查找首页中APP版本更新前五条数据", notes = "查找首页中APP版本更新前五条数据")
    
    public Result<List<ClientVersionDTO>> getAppUpdateInfo() {
        ClientVersionExample clientVersionExample = new ClientVersionExample();
        clientVersionExample.createCriteria().andStateEqualTo(2);
        clientVersionExample.setOrderByClause("publish_time desc");
        clientVersionExample.setLimitValue("5");
        List<ClientVersion> clientVersionList = clientVersionMapper.selectByExample(clientVersionExample);
        Collections.sort(clientVersionList, new Comparator<ClientVersion>() {
            
            public int compare(ClientVersion o1, ClientVersion o2) {
                return o1.getPublishTime().compareTo(o2.getPublishTime());
            }
        });
        return Result.success(dozerUtils.mapList(clientVersionList,ClientVersionDTO.class));
    }
    /**
     * 描述：查找登录用户近半年考勤
     * 参数：
     * 返回值：HalfYearAttenceDTO
     * 修改人：zhaopengfei
     * 修改时间：2018/8/28
     * 修改内容：
     */
    @RequestMapping(value = "queryHalfYearAttence",method = RequestMethod.GET)
    @ApiOperation(value = "查找登录用户近半年考勤", notes = "查找登录用户近半年考勤")
    
    public Result<HalfYearAttenceDTO> getQueryHalfYearAttence() {
        HalfYearAttenceDTO dto = new HalfYearAttenceDTO();
        Long userId = BaseContextHandler.getAdminId();
        List<String> yearMonths = Arrays.asList("","","","","","");
        List<Integer> normalDays = Arrays.asList(0,0,0,0,0,0);
        List<Double> workHous = Arrays.asList(0.0,0.0,0.0,0.0,0.0,0.0);
        List<Double> leaveHous = Arrays.asList(0.0,0.0,0.0,0.0,0.0,0.0);
        List<Double> travelHous = Arrays.asList(0.0,0.0,0.0,0.0,0.0,0.0);
        List<Double> lateHour =Arrays.asList(0.0,0.0,0.0,0.0,0.0,0.0);
        List<Double> earlyHour =Arrays.asList(0.0,0.0,0.0,0.0,0.0,0.0);
        List<Integer> minerCounts = Arrays.asList(0,0,0,0,0,0);
        Date nextMonth = new Date();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat yearMonth = new SimpleDateFormat("yyyy-MM");
        Date startDate = null;
        Date endDate = null;
        for (int i = 5;i>=0;i--){
            if (i==5){
                endDate = DateUtils.getMonthLastDay(nextMonth);
            }
            if (i==0){
                startDate = DateUtils.getMonthFirstDay(nextMonth);
            }
            String yearM = yearMonth.format(nextMonth);
            yearMonths.set(i,yearM);
            c.setTime(nextMonth);
            c.add(Calendar.MONTH,-1);
            nextMonth = c.getTime();
        }
        Map<String,Object> param = new HashMap<>();
        String unitId = UnityUtil.getUnityId(userId);
        param.put("unitId", unitId);
        param.put("userId",userId);
        param.put("startDate",startDate);
        param.put("endDate",endDate);
        List<PunchAttendanceStaticsExt> list = punchAttendanceStaticsMapper.queryHalfYearAttence(param);
        for (int i = 5;i>=0;i--){
            String ym = yearMonths.get(i);
            if (!ObjectUtils.isEmpty(list)){
                for (PunchAttendanceStaticsExt attence:list){
                    if (attence.getYearMonth().equals(ym)){
                        normalDays.set(i,attence.getNormalDays());
                        workHous.set(i,attence.getWorkHous());
                        leaveHous.set(i,attence.getLeaveHous());
                        travelHous.set(i,attence.getTravelHous());
                        lateHour.set(i,attence.getLateHour());
                        earlyHour.set(i,attence.getEarlyHour());
                        minerCounts.set(i,attence.getMinerCount());
                        list.remove(ym);
                        break;
                    }

                }
            }
        }
        dto.setYearMonths(yearMonths);
        dto.setNormalDays(normalDays);
        dto.setWorkHous(workHous);
        dto.setLeaveHous(leaveHous);
        dto.setTravelHous(travelHous);
        dto.setLateHour(lateHour);
        dto.setEarlyHour(earlyHour);
        dto.setMinerCounts(minerCounts);
        return Result.success(dto);
    }


}
