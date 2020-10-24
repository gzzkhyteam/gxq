package com.hengyunsoft.platform.developer.impl.screen;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.developer.api.screen.api.ApplicationScreenApi;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationAndServiceNumDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationInComeAppDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationReduceAnalysisDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationReduceCostAndTimeDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationStatisticsDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationTypeNumDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationVisitCountDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.app.UseNumDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.reducedCost.RelationStatisticsCostDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.reducedCost.RelationStatisticsTimeDTO;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.ApplicationCostAndTimeDO;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.ApplicationVisitCountDO;
import com.hengyunsoft.platform.developer.entity.core.po.ModuleUseInfo;
import com.hengyunsoft.platform.developer.repository.apply.example.ApplicationExample;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationService;
import com.hengyunsoft.platform.developer.repository.apply.service.ServiceModuleService;
import com.hengyunsoft.platform.developer.repository.core.example.ModuleUseInfoExample;
import com.hengyunsoft.platform.developer.repository.core.service.DependRelationService;
import com.hengyunsoft.platform.developer.repository.service.example.ServiceModuleExample;
import com.hengyunsoft.platform.developer.repository.service.service.ModuleUseJnlService;
import com.hengyunsoft.platform.developer.utils.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wz
 * @create 2018-04-30 21:37
 * @desc 应用大屏Api
 **/
@Api(value = "API - OrgScreenApiImpl", description = "大屏应用查询")
@RestController
@RequestMapping("app")
@Slf4j
public class ApplicationScreenApiImpl implements ApplicationScreenApi {
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private ServiceModuleService serviceModuleService;
    @Autowired
    private DependRelationService dependRelationService;
    @Autowired
    private ModuleUseJnlService moduleUseJnlService;
    @Autowired
    private DozerUtils dozerUtils;

    private static final Boolean DEFAULT_STATUS = true;
    private static final Short DEFAULT_STATUS_SHORT = 1;

    /**
     * 可用应用分类查询
     *
     * @return
     */
    @Override
    @ApiOperation(value = "可用应用分类查询", notes = "可用应用分类查询")
    @RequestMapping(value = "/findAppStatistics", method = RequestMethod.GET)
    public Result<Map> findAppStatistics() {
        //1.初始查询条件
        ApplicationExample example = new ApplicationExample();
        example.createCriteria().andStatusEqualTo(DEFAULT_STATUS);
        List<ApplicationStatisticsDTO> list = dozerUtils
                .mapList(applicationService.find(example), ApplicationStatisticsDTO.class);
        List<String> typeList = list.stream().map(ApplicationStatisticsDTO::getType).collect(Collectors.toList());
        Map map = new HashMap();
        for (String type : typeList) {
            if (!map.containsKey(type)) {
                map.put(type, 1);
                continue;
            }
            map.put(type, (int) map.get(type) + 1);
        }
        //2.查询转换并返回
        return Result.success(map);
    }

    /**
     * 统计应用可降低成本与时间
     *
     * @return
     */
    @Override
    @ApiOperation(value = "统计应用可降低成本与时间", notes = "统计应用可降低成本与时间")
    @RequestMapping(value = "/findReduceCostAndTime", method = RequestMethod.GET)
    public Result<List<ApplicationReduceCostAndTimeDTO>> findReduceCostAndTime() {
        List<ApplicationCostAndTimeDO> reduceCostAndTime = applicationService.findReduceCostAndTime();
        List<ApplicationReduceCostAndTimeDTO> map = dozerUtils.mapList(reduceCostAndTime, ApplicationReduceCostAndTimeDTO.class);
        Result<List<ApplicationReduceCostAndTimeDTO>> result = Result.success(map, "查询统计数据成功");
        return result;
    }

    /**
     * 统计应用预计降本率
     *
     * @return
     */
    @Override
    @ApiOperation(value = "统计应用预计降本率", notes = "统计应用预计降本率")
    @RequestMapping(value = "/getReduced", method = RequestMethod.GET)
    public Result<Integer> getReduced() {
        String reduced = dependRelationService.getReduced();
        if (reduced != null) {
            Float f = Float.valueOf(reduced) * 100;
            return Result.success(f.intValue());
        }
        return Result.success(0);
    }

    /**
     * 降本提质-成本统计
     *
     * @return
     */
    @Override
    @ApiOperation(value = "降本提质-成本统计", notes = "降本提质-成本统计")
    @RequestMapping(value = "/findApplicationReduceCost", method = RequestMethod.GET)
    public Result<RelationStatisticsCostDTO> findApplicationReduceCost() {
        //1.查询出成本统计集合
//        List<DependRelationStatisticsDO> castList = dependRelationService.findApplicationReduceCost();

        //2.注入对应list
//        RelationStatisticsCostDTO reducedCost = new RelationStatisticsCostDTO();
//        reducedCost.setAppNameList(castList.stream().map(DependRelationStatisticsDO::getAppName).collect(Collectors.toList()));
//        reducedCost.setOriginalCostList(castList.stream().map(DependRelationStatisticsDO::getOriginalCost).collect(Collectors.toList()));
//        reducedCost.setReduceCostList(castList.stream().map(DependRelationStatisticsDO::getReduceCost).collect(Collectors.toList()));
//        reducedCost.setProducerNameList(castList.stream().map(DependRelationStatisticsDO::getProducerName).collect(Collectors.toList()));
//        reducedCost.setActualReduceCostList(castList.stream().map(DependRelationStatisticsDO::getActualReduceCost).collect(Collectors.toList()));
//        reducedCost.setReduceProtectCost(castList.stream().map(DependRelationStatisticsDO::getReduceProtectCost).collect(Collectors.toList()));
        //临时数据
        try {
            return Result.success(ExcelUtil.findApplicationReduceCost());
        } catch (Exception e) {
            log.error("读取Excel失败！", e);
        }
        return Result.fail("fail");
    }

    /**
     * 降本提质-成本统计
     *
     * @return
     */
    @Override
    @ApiOperation(value = "降本提质-工期统计", notes = "降本提质-工期统计")
    @RequestMapping(value = "/findApplicationReduceTime", method = RequestMethod.GET)
    public Result<RelationStatisticsTimeDTO> findApplicationReduceTime() {
//        //1.查询出成本统计集合
//        List<DependRelationStatisticsDO> castList = dependRelationService.findApplicationReduceTime();
//
//        //2.注入对应list
//        RelationStatisticsTimeDTO reducedTime = new RelationStatisticsTimeDTO();
//        reducedTime.setAppNameList(castList.stream().map(DependRelationStatisticsDO::getAppName).collect(Collectors.toList()));
//        reducedTime.setOriginalTimeList(castList.stream().map(DependRelationStatisticsDO::getOriginalTime).collect(Collectors.toList()));
//        reducedTime.setReduceTimeList(castList.stream().map(DependRelationStatisticsDO::getReduceTime).collect(Collectors.toList()));
//        reducedTime.setProducerNameList(castList.stream().map(DependRelationStatisticsDO::getProducerName).collect(Collectors.toList()));
//        reducedTime.setActualReduceTimeList(castList.stream().map(DependRelationStatisticsDO::getActualReduceTime).collect(Collectors.toList()));
        try {
            return Result.success(ExcelUtil.findApplicationReduceTime());
        } catch (Exception e) {
            log.error("读取Excel失败！", e);
        }
        return Result.fail("fail");
    }

    /**
     * 大屏应用与服务统计
     *
     * @return
     */
    @Override
    @ApiOperation(value = "大屏应用与服务统计", notes = "大屏应用与服务统计")
    @RequestMapping(value = "/findApplicationAndServiceNum", method = RequestMethod.GET)
    public Result<ApplicationAndServiceNumDTO> findApplicationAndServiceNum() {
        //1.新建返回实体
        ApplicationAndServiceNumDTO res = new ApplicationAndServiceNumDTO();

        //2.查找应用个数
        ApplicationExample applicationExample = new ApplicationExample();
        applicationExample.createCriteria().andStatusEqualTo(DEFAULT_STATUS);
        res.setAppNum(applicationService.count(applicationExample));

        //3.查找服务个数
        ServiceModuleExample serviceModuleExample = new ServiceModuleExample();
        serviceModuleExample.createCriteria().andStatusEqualTo(DEFAULT_STATUS_SHORT);
        res.setServiceNum(serviceModuleService.count(serviceModuleExample));

        return Result.success(res);
    }

    /**
     * 大屏运维监控应用系统访问次数top10
     *
     * @return
     */
    @Override
    @ApiOperation(value = "大屏运维监控应用系统访问次数top10", notes = "大屏运维监控应用系统访问次数top10")
    @RequestMapping(value = "/findApplicationVisitCount", method = RequestMethod.GET)
    public Result<List<ApplicationVisitCountDTO>> findApplicationVisitCount() {
        List<ApplicationVisitCountDO> applicationVisitList = applicationService.findApplicationVisitCount();
        List<ApplicationVisitCountDTO> list = dozerUtils.mapList(applicationVisitList, ApplicationVisitCountDTO.class);
        return Result.success(list);
    }

    /**
     * 大屏运维监控调用方应用系统访问次数top10
     *
     * @return
     */
    @Override
    @ApiOperation(value = "大屏运维监控调用方应用系统访问次数top10", notes = "大屏运维监控调用方应用系统访问次数top10")
    @RequestMapping(value = "/findConsumerAppApplicationVisitCount", method = RequestMethod.GET)
    public Result<List<ApplicationVisitCountDTO>> findConsumerAppApplicationVisitCount() {
        List<ApplicationVisitCountDO> applicationVisitList = applicationService.findConsumerAppApplicationVisitCount();
        List<ApplicationVisitCountDTO> list = dozerUtils.mapList(applicationVisitList, ApplicationVisitCountDTO.class);
        return Result.success(list);
    }


    /**
     * 2018-5-11
     * 因大屏需求修改应用集成所有接口重写
     * 根据定窑新需求：接入应用查询
     *
     * @return
     */
    @Override
    @ApiOperation(value = "大屏应用集成接入应用查询", notes = "大屏应用集成接入应用查询")
    @RequestMapping(value = "/findAllIncomeApplication", method = RequestMethod.GET)
    public Result<List<ApplicationInComeAppDTO>> findAllIncomeApplication(@RequestParam(value = "top") Integer top) {
       /* List<ApplicationInComeAppDO> application = applicationService.findAllIncomeApplication(top);
        List<ApplicationInComeAppDTO> list = dozerUtils.mapList(application,ApplicationInComeAppDTO.class);*/
        //大屏造数据
        String[] appNames = {
                "监管数据无线采集系统", "呼叫受理子系统", "协同工作子系统", "监管指挥子系统",
                "综合评价子系统", "地理编码子系统", "应用维护子系统", "基础数据资源管理子系统", "数据交换子系统",
                "综合行政执法办案系统", "智慧城管信息系统", "智能指挥调度系统", "大数据融合分析系统"};
//        String[] appNames = {
//                "大数据精准招商安商", "大数据精准政务服务", "大数据精准权力监督", "大数据精准综合治税",
//                "大数据精准经济监测", "大数据精准市场监管", "大数据精准信用评估", "大数据精准生态监测", "大数据精准国土监测",
//                "大数据精准安全监管", "大数据精准结对帮扶", "大数据精准移动办公", "智慧质监"};
        String[] appIds = {
                "1016187584545", "1016191778881", "1016191778913", "1016191778945", "1016191778977", "1016191779009",
                "1016191779041", "1016191779073", "1016191779105", "1016191779137", "1016191779169", "1016191779201",
                "1016191779233"};
        List<ApplicationInComeAppDTO> list = new ArrayList<>();
        for (int i = 0; i < appNames.length; i++) {
            ApplicationInComeAppDTO app = new ApplicationInComeAppDTO();
            app.setAppId(appIds[i]);
            app.setAppName(appNames[i]);
            list.add(app);
        }
        return Result.success(list);
    }

    /**
     * 降本分析
     *
     * @return
     */
    @Override
    @ApiOperation(value = "降本分析", notes = "降本分析")
    @RequestMapping(value = "/getReduceAnalysis", method = RequestMethod.GET)
    public Result<ApplicationReduceAnalysisDTO> getReduceAnalysis() {
//        //1.设置查询条件
//        ApplicationExample example = new ApplicationExample();
//        example.createCriteria().andStatusEqualTo(DEFAULT_STATUS);
//
//
//        //2.查询结果并筛选
//        List<Application> list = applicationService.find(example);
//        ApplicationReduceAnalysisDTO res = new ApplicationReduceAnalysisDTO();
//
//        res.setBuild(list.stream()
//                .mapToInt(Application::getReduceBuildCost)
//                .sum());
//        res.setProtect(list.stream()
//                .mapToInt(Application::getReduceProtectCost)
//                .sum());
//        res.setUse(list.stream()
//                .mapToInt(Application::getReduceUseCost)
//                .sum());

        //3.返回
        try {
            return Result.success(ExcelUtil.getReduceAnalysis());
        } catch (Exception e) {
            log.error("读取Excel失败！", e);
        }
        return Result.fail("fail");
    }

    /**
     * 组件降本情况
     *
     * @return
     */
    @Override
    @ApiOperation(value = "组件降本情况", notes = "组件降本情况")
    @RequestMapping(value = "/getAssemblyCost", method = RequestMethod.GET)
    public Result<ApplicationTypeNumDTO> getAssemblyCost() {
//        //1.设置查询条件
//        DependRelationExample example = new DependRelationExample();
//        example.createCriteria();
//
//
//        //2.查询结果
//        List<DependRelation> list = dependRelationService.find(example);
//        ApplicationTypeNumDTO res = new ApplicationTypeNumDTO();
//
//        //3.筛选数量
//        res.setApp((int) list.stream()
//                .filter(t -> t.getProducerType().equals("app"))
//                .mapToInt(DependRelation::getReduceCost)
//                .sum());
//        res.setService((int) list.stream()
//                .filter(t -> t.getProducerType().equals("service"))
//                .mapToInt(DependRelation::getReduceCost)
//                .sum());
//        res.setModule((int) list.stream()
//                .filter(t -> t.getProducerType().equals("module"))
//                .mapToInt(DependRelation::getReduceCost)
//                .sum());
        try {
            return Result.success(ExcelUtil.getAssemblyCost());
        } catch (Exception e) {
            log.error("读取Excel失败！", e);
        }
        return Result.fail("fail");
    }

    /**
     * 组件增效情况
     *
     * @return
     */
    @Override
    @ApiOperation(value = "组件增效情况", notes = "组件增效情况")
    @RequestMapping(value = "/getAssemblyTime", method = RequestMethod.GET)
    public Result<ApplicationTypeNumDTO> getAssemblyTime() {
//        //1.设置查询条件
//        DependRelationExample example = new DependRelationExample();
//        example.createCriteria();
//
//
//        //2.查询结果
//        List<DependRelation> list = dependRelationService.find(example);
//        ApplicationTypeNumDTO res = new ApplicationTypeNumDTO();
//
//        //3.筛选数量
//        res.setApp((int) list.stream()
//                .filter(t -> t.getProducerType().equals("app"))
//                .mapToDouble(DependRelation::getReduceTime)
//                .sum());
//        res.setService((int) list.stream()
//                .filter(t -> t.getProducerType().equals("service"))
//                .mapToDouble(DependRelation::getReduceTime)
//                .sum());
//        res.setModule((int) list.stream()
//                .filter(t -> t.getProducerType().equals("module"))
//                .mapToDouble(DependRelation::getReduceTime)
//                .sum());
        try {
            return Result.success(ExcelUtil.getAssemblyTime());
        } catch (Exception e) {
            log.error("读取Excel失败！", e);
        }
        return Result.fail("fail");
    }

    @Override
    @ApiOperation(value = "累计调用服务数", notes = "累计调用服务数")
    @RequestMapping(value = "/getSeviceUseNum", method = RequestMethod.GET)
    public Result<UseNumDTO> getSeviceUseNum() {
        //1.获取当前年月日
        Calendar rightNow = Calendar.getInstance();
        Integer year = rightNow.get(Calendar.YEAR);
        Integer month = rightNow.get(Calendar.MONTH) + 1;
        Integer day = rightNow.get(Calendar.DAY_OF_MONTH);
        String str = year + "-" + month + "-" + day;

        //2.设置查询条件
        ModuleUseInfoExample example = new ModuleUseInfoExample();
        example.createCriteria().andUseDayEqualTo(str);

        //3.查询结果并统计
        UseNumDTO dto = new UseNumDTO();
        List<ModuleUseInfo> list = moduleUseJnlService.find(example);
        dto.setServiceNum(list.stream().mapToInt(t -> t.getTotalNum().intValue()).sum());

        return Result.success(dto);
    }
}
