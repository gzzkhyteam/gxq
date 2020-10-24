package com.hengyunsoft.platform.developer.impl.fast;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.base.id.IdGenerate;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.fast.api.AttenceApi;
import com.hengyunsoft.platform.developer.api.fast.dto.*;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.Attence;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.AttenceRule;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.AttenceStatistic;
import com.hengyunsoft.platform.developer.entity.fast.po.domain.AttenceStatisticDO;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.AttenceRuleExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.AttenceStatisticExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.AttenceRuleService;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.AttenceService;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.AttenceStatisticService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Api(value = "API - AttenceApiImpl", description = "考勤管理")
@RestController
@RequestMapping("/attence")
@Slf4j
public class AttenceApiImpl implements AttenceApi {

    @Autowired
    private AttenceRuleService attenceRuleService;
    @Autowired
    private AttenceStatisticService attenceStatisticService;
    @Autowired
    private AttenceService attenceService;
    @Autowired
    private DozerUtils dozerUtils;

    @Override
    @ApiOperation(value = "查询考勤设置模块", notes = "查询考勤设置模块")
    @ApiResponses({})
    @RequestMapping(value = "/attencemng/find", method = RequestMethod.GET)
    public Result<AttenceRuleDTO> queryAttenceRule(String appId) {
        AttenceRuleExample example = new AttenceRuleExample();
        example.createCriteria().andAppIdEqualTo(appId);
        AttenceRule attenceRule = attenceRuleService.getUnique(example);
        AttenceRuleDTO resultObj = dozerUtils.map(attenceRule,AttenceRuleDTO.class);
        return Result.success(resultObj);
    }

    @Override
    @ApiOperation(value = "保存考勤设置模块", notes = "保存考勤设置模块")
    @ApiResponses({})
    @RequestMapping(value = "/attencemng/saveOrUpdate", method = RequestMethod.POST)
    public Result<Boolean> ruleSave(@RequestBody AttenceRuleDTO dto) {
        try{
            Long loginUser = BaseContextHandler.getAdminId();
            Integer count = 0;
            if(dto.getId() != null){
                AttenceRuleExample example = new AttenceRuleExample();
                example.createCriteria().andIdEqualTo(dto.getId()).andAppIdEqualTo(dto.getAppId());
                count = attenceRuleService.count(example);
            }
            AttenceRule attenceRule = dozerUtils.map(dto,AttenceRule.class);
            if(count > 0){
                //更新
                attenceRule.setUpdateTime(new Date());
                attenceRule.setUpdateUser(loginUser);
                attenceRuleService.updateByIdSelective(attenceRule);
            }else{
                //插入
                attenceRule.setAppId(dto.getAppId());
                attenceRule.setCreateTime(new Date());
                attenceRule.setCreateUser(loginUser);
                attenceRuleService.saveSelective(attenceRule);
            }
            return Result.success(true);
        }catch (Exception ex){
            log.info("Exception",ex);
            return Result.fail("插入数据错误！");
        }
    }

    @Override
    @ApiOperation(value = "考勤列表查询", notes = "考勤列表查询")
    @ApiResponses({})
    @RequestMapping(value = "/attencemng/findBy", method = RequestMethod.POST)
    public Result<PageInfo<AttenceStatisticDTO>> statisticFind(@RequestBody OpenApiReq<RequestAttenceStatisticDTO> openApiReq) {
        RequestAttenceStatisticDTO requestAttenceStatisticDTO = null;
        if(openApiReq.getData() != null){
            requestAttenceStatisticDTO = openApiReq.getData();
        }
        AttenceStatisticDO attenceStatisticDO = new AttenceStatisticDO();
        attenceStatisticDO.setUserName(requestAttenceStatisticDTO.getUserName());
        if(!StringUtils.isBlank(requestAttenceStatisticDTO.getStartDate())){
            String startDate = requestAttenceStatisticDTO.getStartDate();
            attenceStatisticDO.setStartDate(getDate(startDate));
        }
        if(!StringUtils.isBlank(requestAttenceStatisticDTO.getEndDate())){
            String endDate = requestAttenceStatisticDTO.getEndDate();
            attenceStatisticDO.setEndDate(getDate(endDate));
        }
        attenceStatisticDO.setAppId(requestAttenceStatisticDTO.getAppId());
        attenceStatisticDO.setExtraworkCondition(requestAttenceStatisticDTO.getExtraworkCondition());
        attenceStatisticDO.setExtraworkHour(requestAttenceStatisticDTO.getExtraworkHour());
        attenceStatisticDO.setLateHour(requestAttenceStatisticDTO.getLateHour());
        attenceStatisticDO.setLateCondition(requestAttenceStatisticDTO.getLateCondition());
        attenceStatisticDO.setLeaveHour(requestAttenceStatisticDTO.getLeaveHour());
        attenceStatisticDO.setLeaveCondition(requestAttenceStatisticDTO.getLeaveCondition());
        attenceStatisticDO.setEarlyCondition(requestAttenceStatisticDTO.getEarlyCondition());
        attenceStatisticDO.setEarlyHour(requestAttenceStatisticDTO.getEarlyHour());

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<AttenceStatisticDO> attenceStatisticList = attenceStatisticService.queryStatistic(attenceStatisticDO);
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        Integer day = aCalendar.getActualMaximum(Calendar.DATE);
        List<AttenceStatisticDO> result = new ArrayList<AttenceStatisticDO>();
        for (AttenceStatisticDO curObj:attenceStatisticList){
            AttenceStatisticDO curr = curObj;
            Random random = new Random();
            Integer pick = random.nextInt(2);
            curr.setYcqDay(day-6);
            curr.setSjcqDay((day-6)-pick);
            result.add(curr);
        }
        return Result.success(new PageInfo<>(dozerUtils.mapPage(attenceStatisticList, AttenceStatisticDTO.class)));
    }

    private Date getDate(String dateStr){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            log.info("Exception",e);
        }
        return  date;
    }

    @Override
    @ApiOperation(value = "签到/签退", notes = "签到/签退")
    @ApiResponses({})
    @RequestMapping(value = "/attencemng/save", method = RequestMethod.POST)
    public Result<AttenceDTO> signInOrOut(@RequestBody AttenceDTO dto) {
        Long loginUser = BaseContextHandler.getAdminId();
        AttenceDTO result = null;
        Attence attence = new Attence();
        attence.setUserid(loginUser);
        attence.setAppId(dto.getAppId());
        if(dto.getInSignType() != null){
            if(dto.getInSignType() == 1){
                attence.setOutAddress(dto.getInAddress());
                attence.setOutAutoSign(dto.getInAutoSign());
                attence.setOutDeptId(dto.getInDeptId());
                attence.setOutEmpId(dto.getInEmpId());
                attence.setOutHandleType(dto.getInHandleType());
                attence.setOutLatitude(dto.getInLatitude());
                attence.setOutLongtude(dto.getInLongitude());
                attence.setOutPicture(dto.getInPicture());
                attence.setOutRemark(dto.getInRemark());
                attence.setOutSignType(dto.getInSignType());
                attence.setOutTime(dto.getInTime());
            }else{
                attence = dozerUtils.map(dto,Attence.class);
            }
            Attence retAttence = attenceService.saveSelective(attence);
            //保存统计表基础信息
            attenceStatisticSave(loginUser,dto);
            result = dozerUtils.map(retAttence,AttenceDTO.class);
        }
        return Result.success(result);
    }

    /**
     * 保存统计表基础信息
     * @param dto
     */
    private void attenceStatisticSave(Long loginUser,AttenceDTO dto){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date currDate = getDate(sdf.format(new Date()));
        AttenceStatisticExample example = new AttenceStatisticExample();
        example.createCriteria().andUserIdEqualTo(loginUser).andAppIdEqualTo(dto.getAppId())
        .andWorkDateEqualTo(currDate);
        Integer count = attenceStatisticService.count(example);
        if(count < 1){
            AttenceStatistic attenceStatistic = new AttenceStatistic();
            attenceStatistic.setUserId(loginUser);
            attenceStatistic.setAppId(dto.getAppId());
            attenceStatistic.setWorkDate(currDate);
            attenceStatistic.setCreateTime(new Date());
            attenceStatistic.setCreateUser(loginUser);
            attenceStatisticService.saveSelective(attenceStatistic);
        }

    }

    @Override
    @ApiOperation(value = "查询我的考勤总数", notes = "查询我的考勤总数")
    @ApiResponses({})
    @RequestMapping(value = "/attencemng/loadTotalView", method = RequestMethod.POST)
    @ResponseBody
    public Result<Map<String, Object>> loadTotalView(String startTime,String endTime) {
        Map<String, Object> result = new HashMap<String, Object>();
        Random random = new Random();
        result.put("sjWorkHour",random.nextInt(10));
        result.put("sjcqDay",random.nextInt(10));
        result.put("ycqDay",random.nextInt(10));
        return Result.success(result);
    }

    @Override
    @ApiOperation(value = "查询我的考勤忙碌", notes = "查询我的考勤忙碌")
    @ApiResponses({})
    @RequestMapping(value = "/attencemng/loadBusy", method = RequestMethod.POST)
    @ResponseBody
    public Result<Map<String, Object>> loadBusy(String startTime,String endTime){
        try{
            Long loginUser = BaseContextHandler.getAdminId();
            SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date startDate = new Date();
            Date endDate = new Date();
            if(!StringUtils.isBlank(startTime)){
                startDate = sf.parse(startTime +" 00:00:00");
            }
            if(!StringUtils.isBlank(endTime)){
                endDate = sf.parse(endTime +" 23:59:59");
            }
            AttenceStatisticExample example = new AttenceStatisticExample();
            example.createCriteria().andUserIdEqualTo(loginUser).andWorkDateBetween(startDate,endDate);
            List<AttenceStatistic> attenceStatisticList = attenceStatisticService.find(example);
            float jbHour = 0;
            float otherHour = 0;
            for (AttenceStatistic statistic : attenceStatisticList) {
                jbHour += statistic.getExtraWork();
                otherHour += statistic.getSickLeave() + statistic.getAffairLeave() + statistic.getNeglectHour() + statistic.getLateHour() + statistic.getEarlyHour();
            }
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("hour",jbHour - otherHour);
            return Result.success(result);
        }catch (Exception ex){
            log.info("Exception",ex);
            return Result.fail("查询错误");
        }
    }

    @Override
    @ApiOperation(value = "查询我的考勤明细", notes = "查询我的考勤明细")
    @ApiResponses({})
    @RequestMapping(value = "/attencemng/loadDetail", method = RequestMethod.POST)
    @ResponseBody
    public Result<Map<String, Object>> loadDetail(String startTime,String endTime) {
        try{
            Long loginUser = BaseContextHandler.getAdminId();
            SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date startDate = new Date();
            Date endDate = new Date();
            if(!StringUtils.isBlank(startTime)){
                startDate = sf.parse(startTime +" 00:00:00");
            }
            if(!StringUtils.isBlank(endTime)){
                endDate = sf.parse(endTime +" 23:59:59");
            }
            AttenceStatisticExample example = new AttenceStatisticExample();
            example.createCriteria().andUserIdEqualTo(loginUser).andWorkDateBetween(startDate,endDate);
            List<AttenceStatistic> attenceStatisticList = attenceStatisticService.find(example);
            float jbHour = 0;
            float otherHour = 0;
            float bjHour = 0;
            float sjHour = 0;
            float nxjHour = 0;
            float kgHour = 0;
            float cdHour = 0;
            float ztHour = 0;
            Map<String, Object> result = new HashMap<String, Object>();
            List<Float> list = new ArrayList<>();
            for (AttenceStatistic statistic : attenceStatisticList) {
                jbHour += statistic.getExtraWork();
                bjHour += statistic.getSickLeave();
                sjHour += statistic.getAffairLeave();
                nxjHour += statistic.getAnnualLeave();
                cdHour += statistic.getLateHour();
                ztHour += statistic.getEarlyHour();
                otherHour += statistic.getSickLeave() + statistic.getAffairLeave() + statistic.getNeglectHour() + statistic.getLateHour() + statistic.getEarlyHour();
            }
            AttenceRule rule = new AttenceRule();
            //获取考勤规则
            String signInTime = "09:00";
            String signOutTime = "17:00";
            AttenceRuleExample example1 = new AttenceRuleExample();
            example1.createCriteria().andIdIsNotNull();
            List<AttenceRule> rules = attenceRuleService.find(example1);
            if (rules != null) {
                rule = rules.get(0);
                //获取考勤的签到签退时间
                signInTime = rule.getInTime();
                signOutTime = rule.getOutTime();
            }
            String date = sf.format(new Date());
            Float inOffHour = DateUtils.getFloatDistHour(DateUtils.getDate(date + " " + signInTime + ":00"), DateUtils.getDate(date + " " + signOutTime + ":00"));
            Random random = new Random();
            kgHour = random.nextFloat()*inOffHour;
            otherHour += kgHour;
            list.add(jbHour);
            list.add(otherHour);
            list.add(bjHour);
            list.add(sjHour);
            list.add(nxjHour);
            list.add(kgHour);
            list.add(cdHour);
            list.add(ztHour);
            result.put("list",list);
        return Result.success(result);
        }catch (Exception ex){
            log.info("Exception",ex);
            return Result.fail("查询错误");
        }
    }
}
