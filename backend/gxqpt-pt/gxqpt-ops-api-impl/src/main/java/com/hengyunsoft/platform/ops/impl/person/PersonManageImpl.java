package com.hengyunsoft.platform.ops.impl.person;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.OperationExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.GxqptEmpApi;
import com.hengyunsoft.platform.admin.api.core.api.GxqptOrgApi;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpRetDTO;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationAllDTO;
import com.hengyunsoft.platform.ops.entity.fault.domain.FaultMonitoringDO;
import com.hengyunsoft.platform.ops.entity.fault.domain.ScoreCountDO;
import com.hengyunsoft.platform.ops.entity.person.po.ChargeSystem;
import com.hengyunsoft.platform.ops.entity.person.po.PersonManage;
import com.hengyunsoft.platform.ops.persondto.ChargeSystemDTO;
import com.hengyunsoft.platform.ops.persondto.OperationAnalysisDTO;
import com.hengyunsoft.platform.ops.persondto.PersonManageDTO;
import com.hengyunsoft.platform.ops.persondto.PersonManageSaveDTO;
import com.hengyunsoft.platform.ops.repository.person.example.ChargeSystemExample;
import com.hengyunsoft.platform.ops.repository.person.service.ChargeSystemService;
import com.hengyunsoft.platform.ops.repository.person.service.PersonService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;


@RestController
@Slf4j
@RequestMapping("person")
@Api(value = "API - PersonManageImpl", description = "运维人员管理")
public class PersonManageImpl {

    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    GxqptEmpApi gxqptEmpApi;
    @Autowired
    ApplicationApi applicationApi;
    @Autowired
    GxqptOrgApi gxqptOrgApi;
    @Autowired
    private ChargeSystemService chargeSystemService;
    @Autowired
    private PersonService personService;


    @ApiOperation(value = "查询运维评价", notes = "查询运维评价")
    @RequestMapping(value = "/getOperationAnalysis", method = RequestMethod.GET)
    public Result<OperationAnalysisDTO> getOperationAnalysis(@RequestParam(value = "userId") Long userId, @RequestParam(value = "time") String time) {
           //当天时间段
        List<String> dayList = Arrays.asList("昨天", "今天");
        //本周时间段
        List<String> weekList = Arrays.asList("上周", "本周");
        //本月时间段
        List<String> monthList = Arrays.asList("上月", "本月");
        //本年时间段
        List<String> yearList = Arrays.asList("去年", "今年");
        //当下//平均处理时长
        Double hour = 0.00;
        Double oneScore = 0.00;
        Double shreeScore = 0.00;
        //历史
        Double oneScoreLast = 0.00;
        Double shreeScoreLast = 0.00;
        //平均处理时长
        Double hourLast = 0.00;

        OperationAnalysisDTO dto = new OperationAnalysisDTO();
        if (userId == null) {
            return Result.fail("用户id不能为空！");
        }
        if (time == null || time == "") {
            return Result.fail("查询时间段不能为空！");
        } else if (time.equals("当天")) {
            getDay(userId, dayList, hour, oneScore, shreeScore, oneScoreLast, shreeScoreLast, hourLast, dto);
        } else if (time.equals("本周")) {
            getWeek(userId, weekList, hour, oneScore, shreeScore, oneScoreLast, shreeScoreLast, hourLast, dto);
        } else if (time.equals("本月")) {
            getMonth(userId, monthList, hour, oneScore, shreeScore, oneScoreLast, shreeScoreLast, hourLast, dto);
        } else if (time.equals("本年")) {
            getYear(userId, yearList, hour, oneScore, shreeScore, oneScoreLast, shreeScoreLast, hourLast, dto);
        }

        return Result.success(dto);
    }

    /**
     * 查询本年运维评价
     */
    private void getYear(@RequestParam(value = "userId") Long userId, List<String> yearList, Double hour, Double oneScore, Double shreeScore, Double oneScoreLast, Double shreeScoreLast, Double hourLast, OperationAnalysisDTO dto) {
        Double twoScore = 0.00;
        Double applicationScore = 0.00;
        BigDecimal appScore = null;
        BigDecimal opScore = null;
        Double twoScoreLast = 0.00;
        Double applicationScoreLast = 0.00;
        BigDecimal appScoreLast = null;
        //根据用户id、查询本年产生故障数量
        Integer allCount = chargeSystemService.faultAllCountYear(userId);
        //根据用户id、查询本年已处理故障数和处理时长（按应用）
        FaultMonitoringDO hourDO = chargeSystemService.faultCountAndHourYear(userId);
        List<ChargeSystem> systemIdList = chargeSystemService.findBySystemId(userId);
        if (hourDO.getCount() != 0 && hourDO.getHour() != 0) {
            Integer intHour = hourDO.getHour();
            hour = new BigDecimal((float) intHour / (hourDO.getCount() * 60)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        twoScore = 1 - new BigDecimal(hour / 12).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        if (twoScore < 0) {
            twoScore = 0.00;
        }
        //根据用户id、查询本年的未处理故障数
        Integer count = chargeSystemService.faultCountYear(userId);
        if (systemIdList != null && systemIdList.size() > 0) {
            oneScore = 1 - new BigDecimal((float) allCount / (systemIdList.size() * 120)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            shreeScore = 1 - new BigDecimal((float) count / (systemIdList.size())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (oneScore < 0) {
                oneScore = 0.00;
            }
            if (shreeScore < 0) {
                shreeScore = 0.00;
            }
        }
        if (systemIdList != null && systemIdList.size() == 0) {
            oneScore = 1.00;
            shreeScore = 1.00;
            oneScoreLast = 1.00;
            shreeScoreLast = 1.00;
        }
        applicationScore = ((oneScore + twoScore + shreeScore) / 3) * 100;
        appScore = new BigDecimal(applicationScore).setScale(0, BigDecimal.ROUND_HALF_UP);
        if (appScore.doubleValue() <= 0) {
            dto.setApplicationScore(100.00);
            applicationScore = 100.00;
        } else {
            dto.setApplicationScore(appScore.doubleValue());
        }
        //根据用户id、查询本年的服务评分
        ScoreCountDO serviceScore = chargeSystemService.serviceScoreYear(userId);
        Double serviceScoreA = null;
        if (serviceScore != null && serviceScore.getCount() != 0) {
            serviceScoreA = (double) serviceScore.getScore() / serviceScore.getCount();
            dto.setServiceScore(serviceScoreA);
        } else {
            dto.setServiceScore(100.00);
            serviceScoreA = 100.00;
        }
        //根据用户id、查询本年的培训评分
        ScoreCountDO trainScore = chargeSystemService.trainScoreYear(userId);
        Double trainScoreB = null;
        if (trainScore != null && trainScore.getCount() != 0) {
            trainScoreB = (double) trainScore.getScore() / trainScore.getCount();
            dto.setTrainScore(trainScoreB);
        } else {
            trainScoreB = 100.00;
            dto.setTrainScore(100.00);
        }
        //根据用户id、查询本年的咨询评分
        ScoreCountDO consult = chargeSystemService.consulttationScoreYear(userId);
        Double trainScoreC = null;
        if (consult != null && consult.getCount() != 0) {
            trainScoreC = (double) consult.getScore() / consult.getCount();
            dto.setConsultationScore(trainScoreC);
        } else {
            trainScoreC = 100.00;
            dto.setConsultationScore(100.00);
        }
        Double operationScore = applicationScore + serviceScoreA + trainScoreB + trainScoreC;
        if (operationScore != null && operationScore != 0.00) {
            opScore = new BigDecimal(operationScore / 4).setScale(0, BigDecimal.ROUND_HALF_UP);
            dto.setOperationScore(opScore.doubleValue());
        } else {
            dto.setOperationScore(100.00);
        }
        //计算上年的运维综合评分 （运维评分=（应用评分+服务评分+培训评分+咨询评分）/4）
        //根据用户id、查询本年产生故障数量
        Integer allCountLast = chargeSystemService.faultAllCountYearLast(userId);
        //根据用户id、查询本年已处理故障数和处理时长（按应用）
        FaultMonitoringDO hourDOYearLast = chargeSystemService.faultCountAndHourYearLast(userId);
        if (hourDOYearLast.getCount() != 0 && hourDOYearLast.getHour() != 0) {
            Integer intHour = hourDOYearLast.getHour();
            hourLast = new BigDecimal((float) intHour / (hourDOYearLast.getCount() * 60)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        twoScoreLast = 1 - new BigDecimal(hourLast / 12).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        if (twoScoreLast < 0) {
            twoScoreLast = 0.00;
        }
        //根据用户id、查询本年的未处理故障数
        Integer countLast = chargeSystemService.faultCountYearLast(userId);
        if (systemIdList != null && systemIdList.size() > 0) {
            oneScoreLast = 1 - new BigDecimal((float) allCountLast / (systemIdList.size() * 120)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (oneScoreLast < 0) {
                oneScoreLast = 0.00;
            }
            shreeScoreLast = 1 - new BigDecimal((float) countLast / (systemIdList.size())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (shreeScoreLast < 0) {
                shreeScoreLast = 0.00;
            }
        }
        applicationScoreLast = ((oneScoreLast + twoScoreLast + shreeScoreLast) / 3) * 100;
        if (applicationScoreLast <= 0) {
            applicationScoreLast = 100.00;
        }
        //根据用户id、查询本年的服务评分
        ScoreCountDO serviceScoreLast = chargeSystemService.serviceScoreYearLast(userId);
        Double serviceScoreALast = null;
        if (serviceScoreLast != null && serviceScoreLast.getCount() != 0) {
            serviceScoreALast = (double) serviceScoreLast.getScore() / serviceScoreLast.getCount();
        } else {
            serviceScoreALast = 100.00;
        }
        //根据用户id、查询本年的培训评分
        ScoreCountDO trainScoreLast = chargeSystemService.trainScoreYearLast(userId);
        Double trainScoreBLast = null;
        if (trainScoreLast != null && trainScoreLast.getCount() != 0) {
            trainScoreBLast = (double) trainScoreLast.getScore() / trainScoreLast.getCount();
        } else {
            trainScoreBLast = 100.00;
        }
        //根据用户id、查询本年的咨询评分
        ScoreCountDO consultLast = chargeSystemService.consulttationScoreYearLast(userId);
        Double trainScoreCLast = null;
        if (consultLast != null && consultLast.getCount() != 0) {
            trainScoreCLast = (double) consultLast.getScore() / consultLast.getCount();
        } else {
            trainScoreCLast = 100.00;
        }
        Double operationScoreLast = applicationScoreLast + serviceScoreALast + trainScoreBLast + trainScoreCLast;
        if (operationScore != null && operationScore != 0.00) {
            appScoreLast = new BigDecimal(operationScoreLast / 4).setScale(0, BigDecimal.ROUND_HALF_UP);
            dto.setOperationScoreLast(appScoreLast.doubleValue());
        } else {
            dto.setOperationScoreLast(100.00);
        }
        //本年目的数据
        List<Double> data = new ArrayList<Double>();
        Map<String, Object> map = new HashMap<String, Object>();
        data.add(dto.getOperationScoreLast());
        data.add(dto.getOperationScore());
        map.put("data", data);
        map.put("yearList", yearList);
        dto.setMap(map);
    }

    /**
     * 查询本月运维评价
     */
    private void getMonth(@RequestParam(value = "userId") Long userId, List<String> monthList, Double hour, Double oneScore, Double shreeScore, Double oneScoreLast, Double shreeScoreLast, Double hourLast, OperationAnalysisDTO dto) {
        Double twoScore = 0.00;
        Double applicationScore = 0.00;
        BigDecimal appScore = null;
        BigDecimal opScore = null;
        Double twoScoreLast = 0.00;
        Double applicationScoreLast = 0.00;
        BigDecimal appScoreLast = null;
        //根据用户id、查询本月产生故障数量
        Integer allCount = chargeSystemService.faultAllCountMonth(userId);
        //根据用户id、查询本月已处理故障数和处理时长（按应用）
        FaultMonitoringDO hourDO = chargeSystemService.faultCountAndHourMonth(userId);
        List<ChargeSystem> systemIdList = chargeSystemService.findBySystemId(userId);
        if (hourDO.getCount() != 0 && hourDO.getHour() != 0) {
            Integer intHour = hourDO.getHour();
            hour = new BigDecimal((float) intHour / (hourDO.getCount() * 60)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        twoScore = 1 - new BigDecimal(hour / 12).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        if (twoScore < 0) {
            twoScore = 0.00;
        }
        //根据用户id、查询本月的未处理故障数
        Integer count = chargeSystemService.faultCountMonth(userId);
        if (systemIdList != null && systemIdList.size() > 0) {
            oneScore = 1 - new BigDecimal((float) allCount / (systemIdList.size() * 10)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            shreeScore = 1 - new BigDecimal((float) count / (systemIdList.size())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (oneScore < 0) {
                oneScore = 0.00;
            }
            if (shreeScore < 0) {
                shreeScore = 0.00;
            }
        }
        if (systemIdList != null && systemIdList.size() == 0) {
            oneScore = 1.00;
            shreeScore = 1.00;
            oneScoreLast = 1.00;
            shreeScoreLast = 1.00;
        }
        applicationScore = ((oneScore + twoScore + shreeScore) / 3) * 100;
        appScore = new BigDecimal(applicationScore).setScale(0, BigDecimal.ROUND_HALF_UP);
        if (appScore.doubleValue() <= 0) {
            dto.setApplicationScore(100.00);
            applicationScore = 100.00;
        } else {
            dto.setApplicationScore(appScore.doubleValue());
        }
        //根据用户id、查询本月的服务评分
        ScoreCountDO serviceScore = chargeSystemService.serviceScoreMonth(userId);
        Double serviceScoreA = null;
        if (serviceScore != null && serviceScore.getCount() != 0) {
            serviceScoreA = (double) serviceScore.getScore() / serviceScore.getCount();
            dto.setServiceScore(serviceScoreA);
        } else {
            dto.setServiceScore(100.00);
            serviceScoreA = 100.00;
        }
        //根据用户id、查询本月的培训评分
        ScoreCountDO trainScore = chargeSystemService.trainScoreMonth(userId);
        Double trainScoreB = null;
        if (trainScore != null && trainScore.getCount() != 0) {
            trainScoreB = (double) trainScore.getScore() / trainScore.getCount();
            dto.setTrainScore(trainScoreB);
        } else {
            trainScoreB = 100.00;
            dto.setTrainScore(100.00);
        }
        //根据用户id、查询本月的咨询评分
        ScoreCountDO consult = chargeSystemService.consulttationScoreMonth(userId);
        Double trainScoreC = null;
        if (consult != null && consult.getCount() != 0) {
            trainScoreC = (double) consult.getScore() / consult.getCount();
            dto.setConsultationScore(trainScoreC);
        } else {
            trainScoreC = 100.00;
            dto.setConsultationScore(100.00);
        }
        Double operationScore = applicationScore + serviceScoreA + trainScoreB + trainScoreC;
        if (operationScore != null && operationScore != 0.00) {
            opScore = new BigDecimal(operationScore / 4).setScale(0, BigDecimal.ROUND_HALF_UP);
            dto.setOperationScore(opScore.doubleValue());
        } else {
            dto.setOperationScore(100.00);
        }
        //计算上月天的运维综合评分 （运维评分=（应用评分+服务评分+培训评分+咨询评分）/4）
        //根据用户id、查询上月产生故障数量
        Integer allCountLast = chargeSystemService.faultAllCountMonthLast(userId);
        //根据用户id、查询上月已处理故障数和处理时长（按应用）
        FaultMonitoringDO hourDOLast = chargeSystemService.faultCountAndHourMonthLast(userId);
        if (hourDOLast.getCount() != 0 && hourDOLast.getHour() != 0) {
            Integer intHour = hourDOLast.getHour();
            hourLast = new BigDecimal((float) intHour / (hourDOLast.getCount() * 60)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        twoScoreLast = 1 - new BigDecimal(hourLast / 12).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        if (twoScoreLast < 0) {
            twoScoreLast = 0.00;
        }
        //根据用户id、查询上月的未处理故障数
        Integer countLast = chargeSystemService.faultCountMonthLast(userId);
        if (systemIdList != null && systemIdList.size() > 0) {
            shreeScoreLast = 1 - new BigDecimal((float) countLast / (systemIdList.size())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            oneScoreLast = 1 - new BigDecimal((float) allCountLast / (systemIdList.size() * 10)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (oneScoreLast < 0) {
                oneScoreLast = 0.00;
            }
            if (shreeScoreLast < 0) {
                shreeScoreLast = 0.00;
            }
        }
        applicationScoreLast = ((oneScoreLast + twoScoreLast + shreeScoreLast) / 3) * 100;
        if (applicationScoreLast <= 0) {
            applicationScoreLast = 100.00;
        }
        //根据用户id、查询上月的服务评分
        ScoreCountDO serviceScoreLast = chargeSystemService.serviceScoreMonthLast(userId);
        Double serviceScoreALast = null;
        if (serviceScoreLast != null && serviceScoreLast.getCount() != 0) {
            serviceScoreALast = (double) serviceScoreLast.getScore() / serviceScoreLast.getCount();
        } else {
            serviceScoreALast = 100.00;
        }
        //根据用户id、查询上月的培训评分
        ScoreCountDO trainScoreLast = chargeSystemService.trainScoreMonthLast(userId);
        Double trainScoreBLast = null;
        if (trainScoreLast != null && trainScoreLast.getCount() != 0) {
            trainScoreBLast = (double) trainScoreLast.getScore() / trainScoreLast.getCount();
        } else {
            trainScoreBLast = 100.00;
        }
        //根据用户id、查询上月的咨询评分
        ScoreCountDO consultLast = chargeSystemService.consulttationScoreMonthLast(userId);
        Double trainScoreCLast = null;
        if (consultLast != null && consultLast.getCount() != 0) {
            trainScoreCLast = (double) consultLast.getScore() / consultLast.getCount();
            dto.setConsultationScore(trainScoreCLast);
        } else {
            trainScoreCLast = 100.00;
        }
        Double operationScoreLast = applicationScoreLast + serviceScoreALast + trainScoreBLast + trainScoreCLast;
        if (operationScore != null && operationScore != 0.00) {
            appScoreLast = new BigDecimal(operationScoreLast / 4).setScale(0, BigDecimal.ROUND_HALF_UP);
            dto.setOperationScoreLast(appScoreLast.doubleValue());
        } else {
            dto.setOperationScoreLast(100.00);
        }
        //本月目的数据
        List<Double> data = new ArrayList<Double>();
        Map<String, Object> map = new HashMap<String, Object>();
        data.add(dto.getOperationScoreLast());
        data.add(dto.getOperationScore());
        map.put("data", data);
        map.put("monthList", monthList);
        dto.setMap(map);
    }

    /**
     * 查询本周运维评价
     */
    private void getWeek(@RequestParam(value = "userId") Long userId, List<String> weekList, Double hour, Double oneScore, Double shreeScore, Double oneScoreLast, Double shreeScoreLast, Double hourLast, OperationAnalysisDTO dto) {
        Double twoScore = 0.00;
        Double applicationScore = 0.00;
        BigDecimal appScore = null;
        BigDecimal opScore = null;
        Double twoScoreLast = 0.00;
        Double applicationScoreLast = 0.00;
        BigDecimal appScoreLast = null;
        //根据用户id、查询本周产生故障数量
        Integer allCount = chargeSystemService.faultAllCountWeek(userId);
        //根据用户id、查询本周已处理故障数和处理时长（按应用）
        FaultMonitoringDO hourDO = chargeSystemService.faultCountAndHourWeek(userId);
        List<ChargeSystem> systemIdList = chargeSystemService.findBySystemId(userId);
        if (hourDO.getCount() != 0 && hourDO.getHour() != 0) {
            Integer intHour = hourDO.getHour();
            hour = new BigDecimal((float) intHour / (hourDO.getCount() * 60)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        twoScore = 1 - new BigDecimal(hour / 12).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        if (twoScore < 0) {
            twoScore = 0.00;
        }
        //根据用户id、查询本周的未处理故障数
        Integer count = chargeSystemService.faultCountWeek(userId);
        if (systemIdList != null && systemIdList.size() > 0) {
            oneScore = 1 - new BigDecimal((float) allCount / (systemIdList.size() * 3)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            shreeScore = 1 - new BigDecimal((float) count / (systemIdList.size())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (oneScore < 0) {
                oneScore = 0.00;
            }
            if (shreeScore < 0) {
                shreeScore = 0.00;
            }
        }
        if (systemIdList != null && systemIdList.size() == 0) {
            oneScore = 1.00;
            shreeScore = 1.00;
            oneScoreLast = 1.00;
            shreeScoreLast = 1.00;
        }
        applicationScore = ((oneScore + twoScore + shreeScore) / 3) * 100;
        appScore = new BigDecimal(applicationScore).setScale(0, BigDecimal.ROUND_HALF_UP);
        if (appScore.doubleValue() <= 0) {
            dto.setApplicationScore(100.00);
            applicationScore = 100.00;
        } else {
            dto.setApplicationScore(appScore.doubleValue());
        }
        //根据用户id、查询本周的服务评分
        ScoreCountDO serviceScore = chargeSystemService.serviceScoreWeek(userId);
        Double serviceScoreA = null;
        if (serviceScore != null && serviceScore.getCount() != 0) {
            serviceScoreA = (double) serviceScore.getScore() / serviceScore.getCount();
            dto.setServiceScore(serviceScoreA);
        } else {
            dto.setServiceScore(100.00);
            serviceScoreA = 100.00;
        }
        //根据用户id、查询本周的培训评分
        ScoreCountDO trainScore = chargeSystemService.trainScoreWeek(userId);
        Double trainScoreB = null;
        if (trainScore != null && trainScore.getCount() != 0) {
            trainScoreB = (double) trainScore.getScore() / trainScore.getCount();
            dto.setTrainScore(trainScoreB);
        } else {
            trainScoreB = 100.00;
            dto.setTrainScore(100.00);
        }
        //根据用户id、查询本周的咨询评分
        ScoreCountDO consult = chargeSystemService.consulttationScoreWeek(userId);
        Double trainScoreC = null;
        if (consult != null && consult.getCount() != 0) {
            trainScoreC = (double) consult.getScore() / consult.getCount();
            dto.setConsultationScore(trainScoreC);
        } else {
            trainScoreC = 100.00;
            dto.setConsultationScore(100.00);
        }
        Double operationScore = applicationScore + serviceScoreA + trainScoreB + trainScoreC;
        if (operationScore != null && operationScore != 0.00) {
            opScore = new BigDecimal(operationScore / 4).setScale(0, BigDecimal.ROUND_HALF_UP);
            dto.setOperationScore(opScore.doubleValue());
        } else {
            dto.setOperationScore(100.00);
        }
        //计算上周天的运维综合评分 （运维评分=（应用评分+服务评分+培训评分+咨询评分）/4）
        //根据用户id、查询上周产生故障数量
        Integer allCountLast = chargeSystemService.faultAllCountWeekLast(userId);
        //根据用户id、查询上周已处理故障数和处理时长（按应用）
        FaultMonitoringDO hourDOLast = chargeSystemService.faultCountAndHourWeekLast(userId);
        if (hourDOLast.getCount() != 0 && hourDOLast.getHour() != 0) {
            Integer intHour = hourDOLast.getHour();
            hourLast = new BigDecimal((float) intHour / (hourDOLast.getCount() * 60)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        twoScoreLast = 1 - new BigDecimal(hourLast / 12).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        if (twoScoreLast < 0) {
            twoScoreLast = 0.00;
        }
        //根据用户id、查询上周的未处理故障数
        Integer countLast = chargeSystemService.faultCountWeekLast(userId);
        if (systemIdList != null && systemIdList.size() > 0) {
            oneScoreLast = 1 - new BigDecimal((float) allCountLast / (systemIdList.size() * 3)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            shreeScoreLast = 1 - new BigDecimal((float) countLast / (systemIdList.size())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (oneScoreLast < 0) {
                oneScoreLast = 0.00;
            }
            if (shreeScoreLast < 0) {
                shreeScoreLast = 0.00;
            }
        }
        applicationScoreLast = ((oneScoreLast + twoScoreLast + shreeScoreLast) / 3) * 100;
        if (applicationScoreLast <= 0) {
            applicationScoreLast = 100.00;
        }
        //根据用户id、查询当天的服务评分
        ScoreCountDO serviceScoreLast = chargeSystemService.serviceScoreWeekLast(userId);
        Double serviceScoreALast = null;
        if (serviceScoreLast != null && serviceScoreLast.getCount() != 0) {
            serviceScoreALast = (double) serviceScoreLast.getScore() / serviceScoreLast.getCount();
        } else {
            serviceScoreALast = 100.00;
        }
        //根据用户id、查询当天的培训评分
        ScoreCountDO trainScoreLast = chargeSystemService.trainScoreWeekLast(userId);
        Double trainScoreBLast = null;
        if (trainScoreLast != null && trainScoreLast.getCount() != 0) {
            trainScoreBLast = (double) trainScoreLast.getScore() / trainScoreLast.getCount();
        } else {
            trainScoreBLast = 100.00;
        }
        //根据用户id、查询当天的咨询评分
        ScoreCountDO consultLast = chargeSystemService.consulttationScoreWeekLast(userId);
        Double trainScoreCLast = null;
        if (consultLast != null && consultLast.getCount() != 0) {
            trainScoreCLast = (double) consultLast.getScore() / consultLast.getCount();
        } else {
            trainScoreCLast = 100.00;
        }
        Double operationScoreLast = applicationScoreLast + serviceScoreALast + trainScoreBLast + trainScoreCLast;
        if (operationScore != null && operationScore != 0.00) {
            appScoreLast = new BigDecimal(operationScoreLast / 4).setScale(0, BigDecimal.ROUND_HALF_UP);
            dto.setOperationScoreLast(appScoreLast.doubleValue());
        } else {
            dto.setOperationScoreLast(100.00);
        }
        //本周目的数据
        List<Double> data = new ArrayList<Double>();
        Map<String, Object> map = new HashMap<String, Object>();
        data.add(dto.getOperationScoreLast());
        data.add(dto.getOperationScore());
        map.put("data", data);
        map.put("weekList", weekList);
        dto.setMap(map);
    }

    /**
     * 查询当天运维评价
     */
    private void getDay(@RequestParam(value = "userId") Long userId, List<String> dayList, Double hour, Double oneScore, Double shreeScore, Double oneScoreLast, Double shreeScoreLast, Double hourLast, OperationAnalysisDTO dto) {
        Double twoScore = 0.00;
        Double applicationScore = 0.00;
        BigDecimal appScore = null;
        BigDecimal opScore = null;
        Double twoScoreLast = 0.00;
        Double applicationScoreLast = 0.00;
        BigDecimal appScoreLast = null;
        //根据用户id、查询当天产生故障数量
        Integer allCount = chargeSystemService.faultAllCount(userId);
        //根据用户id、查询当天已处理故障数和处理时长（按应用）
        FaultMonitoringDO hourDO = chargeSystemService.faultCountAndHour(userId);
        List<ChargeSystem> systemIdList = chargeSystemService.findBySystemId(userId);
        if (hourDO.getCount() != 0 && hourDO.getHour() != 0) {
            Integer intHour = hourDO.getHour();
            hour = new BigDecimal((float) intHour / (hourDO.getCount() * 60)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        twoScore = 1 - new BigDecimal(hour / 12).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        if (twoScore < 0) {
            twoScore = 0.00;
        }
        //根据用户id、查询当天的未处理故障数
        Integer count = chargeSystemService.faultCount(userId);
        if (systemIdList != null && systemIdList.size() > 0) {
            oneScore = 1 - new BigDecimal((float) allCount / systemIdList.size() * 1).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (oneScore < 0) {
                oneScore = 0.00;
            }
            shreeScore = 1 - new BigDecimal((float) count / systemIdList.size()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (shreeScore < 0) {
                shreeScore = 0.00;
            }
        }
        if (systemIdList != null && systemIdList.size() == 0) {
            oneScore = 1.00;
            shreeScore = 1.00;
            oneScoreLast = 1.00;
            shreeScoreLast = 1.00;
        }
        applicationScore = ((oneScore + twoScore + shreeScore) / 3) * 100;
        appScore = new BigDecimal(applicationScore).setScale(0, BigDecimal.ROUND_HALF_UP);
        if (appScore.doubleValue() <= 0) {
            dto.setApplicationScore(100.00);
            applicationScore = 100.00;
        } else {
            dto.setApplicationScore(appScore.doubleValue());
        }
        //根据用户id、查询当天的服务评分
        ScoreCountDO serviceScore = chargeSystemService.serviceScore(userId);
        Double serviceScoreA = null;
        if (serviceScore != null && serviceScore.getCount() != 0) {
            serviceScoreA = (double) serviceScore.getScore() / serviceScore.getCount();
            dto.setServiceScore(serviceScoreA);
        } else {
            dto.setServiceScore(100.00);
            serviceScoreA = 100.00;
        }
        //根据用户id、查询当天的咨询评分
        ScoreCountDO consult = chargeSystemService.consulttationScore(userId);
        Double trainScoreC = null;
        if (consult != null && consult.getCount() != 0) {
            trainScoreC = (double) consult.getScore() / consult.getCount();
            dto.setConsultationScore(trainScoreC);
        } else {
            trainScoreC = 100.00;
            dto.setConsultationScore(100.00);
        }
        //根据用户id、查询当天的培训评分
        ScoreCountDO trainScore = chargeSystemService.trainScore(userId);
        Double trainScoreB = null;
        if (trainScore != null && trainScore.getCount() != 0) {
            trainScoreB = (double) trainScore.getScore() / trainScore.getCount();
            dto.setTrainScore(trainScoreB);
        } else {
            trainScoreB = 100.00;
            dto.setTrainScore(100.00);
        }
        Double operationScore = applicationScore + serviceScoreA + trainScoreB + trainScoreC;
        if (operationScore != null && operationScore != 0.00) {
            opScore = new BigDecimal(operationScore / 4).setScale(0, BigDecimal.ROUND_HALF_UP);
            dto.setOperationScore(opScore.doubleValue());
        } else {
            dto.setOperationScore(100.00);
        }
        //计算昨天的运维综合评分 （运维评分=（应用评分+服务评分+培训评分+咨询评分）/4）
        //根据用户id、查询当天产生故障数量
        Integer allCountLast = chargeSystemService.faultAllCountLast(userId);
        //根据用户id、查询当天已处理故障数和处理时长（按应用）
        FaultMonitoringDO hourDOLast = chargeSystemService.faultCountAndHourLast(userId);
        if (hourDOLast.getCount() != 0 && hourDOLast.getHour() != 0) {
            Integer intHour = hourDOLast.getHour();
            hourLast = new BigDecimal((float) intHour / (hourDOLast.getCount() * 60)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        twoScoreLast = 1 - new BigDecimal(hourLast / 12).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        if (twoScoreLast < 0) {
            twoScoreLast = 0.00;
        }
        //根据用户id、查询当天的未处理故障数
        Integer countLast = chargeSystemService.faultCountLast(userId);

        if (systemIdList != null && systemIdList.size() > 0) {
            oneScoreLast = 1 - new BigDecimal((float) allCountLast / systemIdList.size()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            shreeScoreLast = 1 - new BigDecimal((float) countLast / systemIdList.size()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (oneScoreLast < 0) {
                oneScoreLast = 0.00;
            }
            if (shreeScoreLast < 0) {
                shreeScoreLast = 0.00;
            }
        }
        applicationScoreLast = ((oneScoreLast + twoScoreLast + shreeScoreLast) / 3) * 100;
        if (applicationScoreLast <= 0) {
            applicationScoreLast = 100.00;
        }
        //根据用户id、查询当天的服务评分
        ScoreCountDO serviceScoreLast = chargeSystemService.serviceScoreLast(userId);
        Double serviceScoreALast = null;
        if (serviceScoreLast != null && serviceScoreLast.getCount() != 0) {
            serviceScoreALast = (double) serviceScoreLast.getScore() / serviceScoreLast.getCount();
        } else {
            serviceScoreALast = 100.00;
        }
        //根据用户id、查询当天的培训评分
        ScoreCountDO trainScoreLast = chargeSystemService.trainScoreLast(userId);
        Double trainScoreBLast = null;
        if (trainScoreLast != null && trainScoreLast.getCount() != 0) {
            trainScoreBLast = (double) trainScoreLast.getScore() / trainScoreLast.getCount();
        } else {
            trainScoreBLast = 100.00;
        }
        //根据用户id、查询当天的咨询评分
        ScoreCountDO consultLast = chargeSystemService.consulttationScoreLast(userId);
        Double trainScoreCLast = null;
        if (consultLast != null && consultLast.getCount() != 0) {
            trainScoreCLast = (double) consultLast.getScore() / consultLast.getCount();
        } else {
            trainScoreCLast = 100.00;
        }
        Double operationScoreLast = applicationScoreLast + serviceScoreALast + trainScoreBLast + trainScoreCLast;
        if (operationScore != null && operationScore != 0.00) {
            appScoreLast = new BigDecimal(operationScoreLast / 4).setScale(0, BigDecimal.ROUND_HALF_UP);
            dto.setOperationScoreLast(appScoreLast.doubleValue());
        } else {
            dto.setOperationScoreLast(100.00);
        }
        //目的数据
        List<Double> data = new ArrayList<Double>();
        data.add(dto.getOperationScoreLast());
        data.add(dto.getOperationScore());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", data);
        map.put("dayList", dayList);
        dto.setMap(map);
    }

    @ApiOperation(value = "根据部门id查询部门人员信息", notes = "根据部门id查询部门人员信息")
    @RequestMapping(value = "/getDeptPerson", method = RequestMethod.POST)
    public Result<PageInfo<PersonManageDTO>> getDeptPerson(@RequestBody OpenApiReq<GxqptEmpDTO> openApiReq) {
        String dept = openApiReq.getData().getMaindeptid();
        if (dept == null) {
            return Result.fail("部门id不能为空！");
        }
        //查询
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        Result<PageInfo<GxqptEmpRetDTO>> pageInfoResult = gxqptEmpApi.pageEmpListFroOperation(openApiReq);
        PageInfo map = dozerUtils.map(pageInfoResult.getData(), PageInfo.class);
        List<PersonManageDTO> dtoList = new ArrayList<>();
        if (pageInfoResult.getData() != null && pageInfoResult.getData().getList().size() > 0) {
            for (GxqptEmpRetDTO dto : pageInfoResult.getData().getList()) {
                PersonManageDTO manageDTO = dozerUtils.map(dto, PersonManageDTO.class);
                List<ChargeSystemDTO> systemNameDto = new ArrayList<>();
                Long userId = dto.getGxqptEmpId();
                PersonManage personManage = personService.getById(userId);
                if (personManage != null) {
                    //主要工作内容
                    manageDTO.setContent(personManage.getContent());
                    manageDTO.setPersonId(personManage.getId());
                    manageDTO.setMainmobile(personManage.getMainmobile());
                }
                ChargeSystemExample example = new ChargeSystemExample();
                example.createCriteria().andPIdEqualTo(userId);
                List<ChargeSystemDTO> system = dozerUtils.mapList(chargeSystemService.find(example), ChargeSystemDTO.class);
                if (system != null && system.size() > 0) {
                    for (ChargeSystemDTO sys : system) {
                        systemNameDto.add(sys);
                    }
                }
                //主要负责系统
                manageDTO.setSystemName(systemNameDto);
                dtoList.add(manageDTO);
            }
        }
        map.setList(dtoList);
        return Result.success(map);
    }

    @ApiOperation(value = "保存运维人员主要工作信息和负责系统信息", notes = "保存运维人员主要工作信息和负责系统信息")
    @ApiResponses({
            @ApiResponse(code = 105000, message = "用户id不能为空"),
            @ApiResponse(code = 105001, message = "负责内容不能为空"),
            @ApiResponse(code = 105002, message = "运维人员id不能为空")
    })
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<PersonManageSaveDTO> save(@RequestBody PersonManageSaveDTO saveDTO) {
        //1.校验
        BizAssert.assertNotNull(OperationExceptionCode.USER_ID_NULL, saveDTO.getId());
        BizAssert.assertNotNull(OperationExceptionCode.CONTENT_NULL, saveDTO.getContent());
        BizAssert.assertNotNull(OperationExceptionCode.SYETEM_NAME_NULL, saveDTO.getSystemName());

        //转换，保存与运维人员表数据
        Long userId = BaseContextHandler.getAdminId();
        PersonManage personManage = dozerUtils.map(saveDTO, PersonManage.class);
        personManage.setCreateUser(userId);
        personManage.setUpdateUser(userId);
        personService.insertSelective(personManage);

        //保存负责系统表数据
        List<ChargeSystemDTO> systemList = saveDTO.getSystemName();
        List<ChargeSystem> arrList = new ArrayList<>();
        if (systemList != null && systemList.size() > 0) {
            for (ChargeSystemDTO syetemDTO : systemList) {
                ChargeSystem system = new ChargeSystem();
                system.setpId(personManage.getId());
                system.setSystemId(syetemDTO.getSystemId());
                system.setSystemName(syetemDTO.getSystemName());
                system.setCreateUser(userId);
                system.setUpdateUser(userId);
                arrList.add(system);
            }
        }
        chargeSystemService.save(arrList);
        return Result.success(dozerUtils.map(personManage, PersonManageSaveDTO.class));
    }

    @ApiOperation(value = "修改运维人员主要工作信息和负责系统信息", notes = "修改运维人员主要工作信息和负责系统信息")
    @ApiResponses({
            @ApiResponse(code = 105000, message = "用户id不能为空"),
            @ApiResponse(code = 105001, message = "负责内容不能为空"),
            @ApiResponse(code = 105002, message = "运维人员id不能为空")
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<PersonManageSaveDTO> update(@RequestBody PersonManageSaveDTO saveDTO) {
        //1.校验
        BizAssert.assertNotNull(OperationExceptionCode.USER_ID_NULL, saveDTO.getId());
        BizAssert.assertNotNull(OperationExceptionCode.CONTENT_NULL, saveDTO.getContent());
        BizAssert.assertNotNull(OperationExceptionCode.SYETEM_NAME_NULL, saveDTO.getSystemName());

        //转换，保存与运维人员表数据
        Long userId = BaseContextHandler.getAdminId();
        PersonManage personManage = dozerUtils.map(saveDTO, PersonManage.class);
        personManage.setCreateUser(userId);
        personManage.setUpdateUser(userId);
        personService.updateByIdSelective(personManage);

        //删除负责系统表数据
        ChargeSystemExample systemExample = new ChargeSystemExample();
        systemExample.createCriteria().andPIdEqualTo(saveDTO.getId());
        List<ChargeSystem> chargeSystems = chargeSystemService.find(systemExample);
        List<Long> userIds = new ArrayList<>();
        if (chargeSystems != null && chargeSystems.size() > 0) {
            for (ChargeSystem chargeSystem : chargeSystems) {
                Long useId = chargeSystem.getId();
                userIds.add(useId);
            }
            chargeSystemService.deleteByIds(userIds);
        }
        //保存负责系统表数据
        List<ChargeSystemDTO> systemList = saveDTO.getSystemName();
        List<ChargeSystem> arrList = new ArrayList<>();
        if (systemList != null && systemList.size() > 0) {
            for (ChargeSystemDTO syetemDTO : systemList) {
                ChargeSystem system = new ChargeSystem();
                system.setpId(personManage.getId());
                system.setSystemId(syetemDTO.getSystemId());
                system.setSystemName(syetemDTO.getSystemName());
                system.setUpdateUser(userId);
                system.setCreateUser(userId);
                arrList.add(system);
            }
        }
        chargeSystemService.save(arrList);
        return Result.success(dozerUtils.map(personManage, PersonManageSaveDTO.class));
    }

    @ApiOperation(value = "查询系统应用列表", notes = "查询系统应用列表")
    @RequestMapping(value = "/findAppIdList", method = RequestMethod.GET)
    public Result<List<ApplicationAllDTO>> findAppIdList() {
        Result<List<ApplicationAllDTO>> findAppIdList = applicationApi.findAllList();
        return Result.success(findAppIdList.getData());
    }


    @ApiOperation(value = "根据用户id查询用户负责的系统应用列表", notes = "根据用户id查询用户负责的系统应用列表")
    @RequestMapping(value = "/getSystemList", method = RequestMethod.GET)
    public Result<List<ChargeSystemDTO>> getSystemList() {
        Long userId = BaseContextHandler.getAdminId();
        if (userId == null) {
            return Result.fail("用户id不能为空！");
        }
        ChargeSystemExample systemExample = new ChargeSystemExample();
        systemExample.createCriteria().andPIdEqualTo(userId);
        List<ChargeSystemDTO> list = dozerUtils.mapList(chargeSystemService.find(systemExample), ChargeSystemDTO.class);
        return Result.success(list);
    }
}
