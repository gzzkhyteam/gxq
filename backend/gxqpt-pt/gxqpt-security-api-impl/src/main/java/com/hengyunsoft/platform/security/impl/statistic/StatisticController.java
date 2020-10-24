package com.hengyunsoft.platform.security.impl.statistic;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.security.entity.statistic.po.StatisticResultDTO;
import com.hengyunsoft.platform.security.repository.statistic.service.StatisticService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * com.hengyunsoft.platform.admin.controller.authority
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：服务监控Api
 * 修改人：yxl
 * 修改时间：2018/7/02
 * 修改内容：新增基础接口
 */
@Api(value = "API - StatisticController.java",description = "数据统计")
@RestController
@RequestMapping("statistic")
@Slf4j
public class  StatisticController {

    @Autowired
    private StatisticService statisticService;

    @RequestMapping(value = "/statInterfaceConfig",method = RequestMethod.GET)
    @ApiOperation(value = "统计接口总数量和配置接口数量",notes = "1.key:all_num,描述：接口总数量;2.key:set_num,描述：配置接口数量;")
    public Result<Map<String,String>> statisticInterfaceConfig(){
       return Result.success(statisticService.statisticInterfaceConfig());
    }

    @RequestMapping(value = "/statExceptionProcess",method = RequestMethod.GET)
    @ApiOperation(value = "统计总异常进程数量和本月异常进程数量",notes = "1.key:all_process,描述：总异常进程数量;2.key:month_process,描述：本月异常进程数量;")
    public Result<Map<String,String>> statisticExceptionProcess(){
        return Result.success(statisticService.statisticExceptionProcess());
    }

    @RequestMapping(value = "/statExceptionServer",method = RequestMethod.GET)
    @ApiOperation(value = "统计总异常服务数量和本月异常服务数量",notes = "1.key:all_server,描述：总异常服务数量;2.key:month_server,描述：本月异常服务数量;")
    public Result<Map<String,String>> statisticExceptionServer(){
        return Result.success(statisticService.statisticExceptionServer());
    }

    @RequestMapping(value = "/statInterfaceExecuteTop10",method = RequestMethod.GET)
    @ApiOperation(value = "统计接口调用数量排行前10位",notes = "1.key:id,描述：接口ID;2.key:api_name,描述：接口名称;3.key:num,描述：接口调用数量;")
    public Result<List<Map<String,String>>> statisticInterfaceExecuteTop10(){
        return Result.success(statisticService.statisticInterfaceExecuteTop10());
    }

    @RequestMapping(value = "/statExceptionServerIn7days",method = RequestMethod.GET)
    @ApiOperation(value = "统计最近7天内每天异常服务数量",notes = "1.key:num,描述：异常服务数量;2.key:statDate,描述：统计日期;")
    public Result<List<StatisticResultDTO>> statisticExceptionServerIn7days(){
        return Result.success(statisticService.statisticExceptionServerIn7days());
    }

    @RequestMapping(value = "/statExceptionProcessIn7days",method = RequestMethod.GET)
    @ApiOperation(value = "统计最近7天内每天异常进程数量",notes = "1.key:num,描述：异常进程数量;2.key:statDate,描述：统计日期;")
    public Result<List<StatisticResultDTO>> statisticExceptionProcessIn7days(){
        return Result.success(statisticService.statisticExceptionProcessIn7days());
    }

    @RequestMapping(value = "/statAllBackupsAndYesterday",method = RequestMethod.GET)
    @ApiOperation(value = "统计数据应备份数量和昨天数据备份数量",notes = "1.key:all_num,描述：数据应备份数量;2.key:yesterday_num,描述：昨天数据备份数量;")
    public Result<Map<String,String>> statisticAllBackupsAndYesterday(){
        return Result.success(statisticService.statisticAllBackupsAndYesterday());
    }
}

