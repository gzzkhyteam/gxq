package com.hengyunsoft.platform.logs.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.LogsExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.developer.api.core.dto.application.AppShowDto;
import com.hengyunsoft.platform.logs.dto.LogStructApacheDTO;
import com.hengyunsoft.platform.logs.dto.LogStructApacheQueryDTO;
import com.hengyunsoft.platform.logs.dto.LogStructAppDTO;
import com.hengyunsoft.platform.logs.dto.LogStructAppQueryDTO;
import com.hengyunsoft.platform.logs.dto.LogStructNginxDTO;
import com.hengyunsoft.platform.logs.dto.LogStructNginxQueryDTO;
import com.hengyunsoft.platform.logs.dto.LogStructTogetherDTO;
import com.hengyunsoft.platform.logs.dto.LogStructTogetherQueryDTO;
import com.hengyunsoft.platform.logs.dto.LogStructTomcatDTO;
import com.hengyunsoft.platform.logs.dto.LogStructTomcatQueryDTO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogStructTogetherDO;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructApache;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructApp;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructNginx;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructTomcat;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructApacheExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructAppExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructNginxExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructTogetherExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructTomcatExample;
import com.hengyunsoft.platform.logs.repository.logs.service.LogStructApacheService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogStructAppService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogStructNginxService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogStructTogetherService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogStructTomcatService;
import com.hengyunsoft.utils.BizAssert;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(value = "结构化日志管理", description = "结构化日志管理")
public class LogStructApiImpl /*implements LogStructApi*/ {

    @Autowired
    private LogStructAppService logStructAppService;
    @Autowired
    private LogStructApacheService logStructApacheService;
    @Autowired
    private LogStructTomcatService logStructTomcatService;
    @Autowired
    private LogStructNginxService logStructNginxService;
    @Autowired
    private LogStructTogetherService logStructService;
    @Autowired
    private ApplicationApi applicationApi;
    @Autowired
    private DozerUtils dozerUtils;

    /**
     * 分页查询应用系统结构化日志列表
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "分页查询应用系统结构化日志", notes = "分页查询应用系统结构化日志")
    @RequestMapping(value = "/log/pageQueryApp", method = RequestMethod.POST)
    public Result<PageInfo<LogStructAppDTO>> pageQueryApp(@RequestBody OpenApiReq<LogStructAppQueryDTO> openApiReq) {
        //取当前登录用户拥用的应用系统
        Result<List<AppShowDto>> resultListApp = applicationApi.findAppIdList((long) 1);
        List<AppShowDto> listApp = resultListApp.getData();
        List<String> appIdListAll = new ArrayList();
        if(listApp.size()>0){
            for(int i=0;i<listApp.size();i++){
                AppShowDto appShowDto = listApp.get(i);
                appIdListAll.add(appShowDto.getAppId());
            }
        }

        LogStructAppQueryDTO data = openApiReq.getData();
        LogStructAppExample example = new LogStructAppExample();
        if (data != null) {
            String appIds=data.getAppId();
            List<String> appIdList = new ArrayList();
            if(null!=appIds && !"".equals(appIds)){
                String[] appIdArray = appIds.split(",");
                for(int m=0; m<appIdArray.length; m++) {
                    String appId = appIdArray[m];
                    if(null!=appId && !appId.equals("")) {
                        appIdList.add(appId);
                    }
                }
            }
            String levels=data.getLevel();
            List<String> levelList = new ArrayList();
            if(null!=levels && !"".equals(levels)){
                String[] levelArray = levels.split(",");
                for(int m=0; m<levelArray.length; m++) {
                    String level = levelArray[m];
                    if(level != null && !level.equals("")) {
                        levelList.add(level);
                    }
                }
            }
            example.createCriteria().andLogTimeGreaterThanOrEqualTo(openApiReq.getData().getLogTimeStart())
                    .andIdEqualTo(openApiReq.getData().getId())
                    .andLogTimeLessThanOrEqualTo(openApiReq.getData().getLogTimeEnd())
                    .andClassNameLike(LogStructAppExample.fullLike(openApiReq.getData().getClassName()))
                    .andContentLike(LogStructAppExample.fullLike(openApiReq.getData().getContent()))
                    .andFLevelIn(levelList.size()==0? Arrays.asList(""):levelList)
                    .andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll)
                    .andFAppIdIn(appIdList.size()==0? Arrays.asList(""):appIdList);

        }else{
            example.createCriteria().andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll);
        }
        example.setOrderByClause(" log_time desc ");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogStructApp> lists = logStructAppService.pageQueryApp(example);
        List<LogStructAppDTO> pageList = dozerUtils.mapPage(lists, LogStructAppDTO.class);
        return Result.success(new PageInfo(pageList));
    }
    @ApiResponses({
            @ApiResponse(code = 65000, message = "id不能为空")
    })
    @ApiOperation(value = "预览APP结构化数据详情", notes = "预览APP结构化数据详情")
    @RequestMapping(value = "/log/getApp", method = RequestMethod.GET)
    public Result<LogStructAppDTO> getApp(@RequestParam(value = "id") Long id) {
        //1，验证
        BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, id);

        LogStructApp logStructApp = logStructAppService.getById(id);
        return Result.success(dozerUtils.map(logStructApp, LogStructAppDTO.class));
    }
    @ApiResponses({
            @ApiResponse(code = 65000, message = "id不能为空")
    })
    @ApiOperation(value = "删除APP结构化数据详情", notes = "删除APP结构化数据详情")
    @RequestMapping(value = "/log/deleteApp", method = RequestMethod.GET)
    public Result<Boolean> deleteApp(@RequestParam(value = "id") Long id) {
        //1，验证
        BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, id);
        int i = logStructAppService.deleteById(id);
        if (i == 0) {
            return Result.fail("未找到要删除的数据，id：" + id);
        } else {
            return Result.success(true);
        }
    }
    @ApiOperation(value = "分页查询apache结构化数据信息", notes = "分页查询apache结构化数据信息")
    @RequestMapping(value = "/log/pageQueryApache", method = RequestMethod.POST)
    public Result<PageInfo<LogStructApacheDTO>> pageQueryApache(@RequestBody OpenApiReq<LogStructApacheQueryDTO> openApiReq) {
        //取当前登录用户拥用的应用系统
        Result<List<AppShowDto>> resultListApp = applicationApi.findAppIdList((long) 1);
        List<AppShowDto> listApp = resultListApp.getData();
        List<String> appIdListAll = new ArrayList();
        if(listApp.size()>0){
            for(int i=0;i<listApp.size();i++){
                AppShowDto appShowDto = listApp.get(i);
                appIdListAll.add(appShowDto.getAppId());
            }
        }

        LogStructApacheQueryDTO data = openApiReq.getData();
        LogStructApacheExample example = new LogStructApacheExample();
        if (data != null) {
            String appIds=data.getAppId();
            List<String> appIdList = new ArrayList();
            if(null!=appIds && !"".equals(appIds)){
                String[] appIdArray = appIds.split(",");
                for(int m=0; m<appIdArray.length; m++) {
                    String appId = appIdArray[m];
                    if(null!=appId && !appId.equals("")) {
                        appIdList.add(appId);
                    }
                }
            }
            String status=data.getStatus();
            List<String> statusList = new ArrayList();
            if(null!=status && !"".equals(status)){
                String[] statusArray = status.split(",");
                for(int m=0; m<statusArray.length; m++) {
                    String sts = statusArray[m];
                    if(sts != null && !sts.equals("")) {
                        statusList.add(sts);
                    }
                }
            }
            example.createCriteria().andIdEqualTo(openApiReq.getData().getId())
                    .andLogTimeGreaterThanOrEqualTo(openApiReq.getData().getLogTimeStart())
                    .andLogTimeLessThanOrEqualTo(openApiReq.getData().getLogTimeEnd())
                    .andRequestUrlLike(LogStructApacheExample.fullLike(openApiReq.getData().getRequestUrl()))
                    .andFTimeConsumGreaterThanOrEqualTo(openApiReq.getData().getTimeConsumStart())
                    .andFTimeConsumLessThanOrEqualTo(openApiReq.getData().getTimeConsumEnd())
                    .andRemoteIpEqualTo(openApiReq.getData().getRemoteIp())
                    .andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll)
                    .andFAppIdIn(appIdList.size()==0? Arrays.asList(""):appIdList)
                    .andFStatusIn(statusList.size()==0? Arrays.asList(""):statusList);

        }else{
            example.createCriteria().andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll);
        }
        example.setOrderByClause(" log_time desc ");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogStructApache> lists = logStructApacheService.pageQueryApache(example);
        List<LogStructApacheDTO> pageList = dozerUtils.mapPage(lists, LogStructApacheDTO.class);
        return Result.success(new PageInfo(pageList));
    }

    @ApiResponses({
            @ApiResponse(code = 65000, message = "id不能为空")
    })
    @ApiOperation(value = "预览APACHE结构化数据详情", notes = "预览APACHE结构化数据详情")
    @RequestMapping(value = "/log/getApache", method = RequestMethod.GET)
    public Result<LogStructApacheDTO> getApache(@RequestParam(value = "id") Long id) {
        //1，验证
        BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, id);

        LogStructApache logStructApache = logStructApacheService.getById(id);
        return Result.success(dozerUtils.map(logStructApache, LogStructApacheDTO.class));
    }
    @ApiResponses({
            @ApiResponse(code = 65000, message = "id不能为空")
    })
    @ApiOperation(value = "删除APACHE结构化数据详情", notes = "删除APACHE结构化数据详情")
    @RequestMapping(value = "/log/deleteApache", method = RequestMethod.GET)
    public Result<Boolean> deleteApache(@RequestParam(value = "id") Long id) {
        //1，验证
        BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, id);
        int i = logStructApacheService.deleteById(id);
        if (i == 0) {
            return Result.fail("未找到要删除的数据，id：" + id);
        } else {
            return Result.success(true);
        }
    }
    @ApiOperation(value = "分页查询NGINX结构化数据信息", notes = "分页查询NGINX结构化数据信息")
    @RequestMapping(value = "/log/pageQueryNginx", method = RequestMethod.POST)
    public Result<PageInfo<LogStructNginxDTO>> pageQueryNginx(@RequestBody OpenApiReq<LogStructNginxQueryDTO> openApiReq) {
        //取当前登录用户拥用的应用系统
        Result<List<AppShowDto>> resultListApp = applicationApi.findAppIdList((long) 1);
        List<AppShowDto> listApp = resultListApp.getData();
        List<String> appIdListAll = new ArrayList();
        if(listApp.size()>0){
            for(int i=0;i<listApp.size();i++){
                AppShowDto appShowDto = listApp.get(i);
                appIdListAll.add(appShowDto.getAppId());
            }
        }

        LogStructNginxQueryDTO data = openApiReq.getData();
        LogStructNginxExample example = new LogStructNginxExample();
        if (data != null) {
            String appIds=data.getAppId();
            List<String> appIdList = new ArrayList();
            if(null!=appIds && !"".equals(appIds)){
                String[] appIdArray = appIds.split(",");
                for(int m=0; m<appIdArray.length; m++) {
                    String appId = appIdArray[m];
                    if(null!=appId && !appId.equals("")) {
                        appIdList.add(appId);
                    }
                }
            }
            String status=data.getStatus();
            List<String> statusList = new ArrayList();
            if(null!=status && !"".equals(status)){
                String[] statusArray = status.split(",");
                for(int m=0; m<statusArray.length; m++) {
                    String sts = statusArray[m];
                    if(sts != null && !sts.equals("")) {
                        statusList.add(sts);
                    }
                }
            }
            example.createCriteria().andIdEqualTo(openApiReq.getData().getId())
                    .andLocalTimeGreaterThanOrEqualTo(openApiReq.getData().getLocalTimeStart())
                    .andLocalTimeLessThanOrEqualTo(openApiReq.getData().getLocalTimeEnd())
                    .andRequestUrlLike(LogStructNginxExample.fullLike(openApiReq.getData().getRequestUrl()))
                    .andFTimeConsumGreaterThanOrEqualTo(openApiReq.getData().getTimeConsumStart())
                    .andFTimeConsumLessThanOrEqualTo(openApiReq.getData().getTimeConsumEnd())
                    .andRemoteAddrEqualTo(openApiReq.getData().getRemoteAddr())
                    .andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll)
                    .andFAppIdIn(appIdList.size()==0? Arrays.asList(""):appIdList)
                    .andFStatusIn(statusList.size()==0? Arrays.asList(""):statusList);
        }else{
            example.createCriteria().andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll);
        }
        example.setOrderByClause(" local_time desc ");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogStructNginx> lists = logStructNginxService.pageQueryNginx(example);
        List<LogStructNginxDTO> pageList = dozerUtils.mapPage(lists, LogStructNginxDTO.class);
        return Result.success(new PageInfo(pageList));
    }
    @ApiResponses({
            @ApiResponse(code = 65000, message = "id不能为空")
    })
    @ApiOperation(value = "预览NGINX结构化数据详情", notes = "预览NGINX结构化数据详情")
    @RequestMapping(value = "/log/getNginx", method = RequestMethod.GET)
    public Result<LogStructNginxDTO> getNginx(@RequestParam(value = "id") Long id) {
        //1，验证
        BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, id);

        LogStructNginx logStructNginx = logStructNginxService.getById(id);
        return Result.success(dozerUtils.map(logStructNginx, LogStructNginxDTO.class));
    }
    @ApiResponses({
            @ApiResponse(code = 65000, message = "id不能为空")
    })
    @ApiOperation(value = "删除NGINX结构化数据详情", notes = "删除NGINX结构化数据详情")
    @RequestMapping(value = "/log/deleteNginx", method = RequestMethod.GET)
    public Result<Boolean> deleteNginx(@RequestParam(value = "id") Long id) {
        //1，验证
        BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, id);
        int i = logStructNginxService.deleteById(id);
        if (i == 0) {
            return Result.fail("未找到要删除的数据，id：" + id);
        } else {
            return Result.success(true);
        }
    }
    @ApiOperation(value = "分页查询TOMCAT结构化数据信息", notes = "分页查询TOMCAT结构化数据信息")
    @RequestMapping(value = "/log/pageQueryTomcat", method = RequestMethod.POST)
    public Result<PageInfo<LogStructTomcatDTO>> pageQueryTomcat(@RequestBody  OpenApiReq<LogStructTomcatQueryDTO> openApiReq) {
        //取当前登录用户拥用的应用系统
        Result<List<AppShowDto>> resultListApp = applicationApi.findAppIdList((long) 1);
        List<AppShowDto> listApp = resultListApp.getData();
        List<String> appIdListAll = new ArrayList();
        if(listApp.size()>0){
            for(int i=0;i<listApp.size();i++){
                AppShowDto appShowDto = listApp.get(i);
                appIdListAll.add(appShowDto.getAppId());
            }
        }

        LogStructTomcatQueryDTO data = openApiReq.getData();
        LogStructTomcatExample example = new LogStructTomcatExample();
        if (data != null) {
            String appIds=data.getAppId();
            List<String> appIdList = new ArrayList();
            if(null!=appIds && !"".equals(appIds)){
                String[] appIdArray = appIds.split(",");
                for(int m=0; m<appIdArray.length; m++) {
                    String appId = appIdArray[m];
                    if(null!=appId && !appId.equals("")) {
                        appIdList.add(appId);
                    }
                }
            }
            String status=data.getStatus();
            List<String> statusList = new ArrayList();
            if(null!=status && !"".equals(status)){
                String[] statusArray = status.split(",");
                for(int m=0; m<statusArray.length; m++) {
                    String sts = statusArray[m];
                    if(sts != null && !sts.equals("")) {
                        statusList.add(sts);
                    }
                }
            }
            example.createCriteria().andIdEqualTo(openApiReq.getData().getId())
                    .andLogTimeGreaterThanOrEqualTo(openApiReq.getData().getLogTimeStart())
                    .andLogTimeLessThanOrEqualTo(openApiReq.getData().getLogTimeEnd())
                    .andRequestUrlLike(LogStructTomcatExample.fullLike(openApiReq.getData().getRequestUrl()))
                    .andFTimeConsumGreaterThanOrEqualTo(openApiReq.getData().getTimeConsumStart())
                    .andFTimeConsumLessThanOrEqualTo(openApiReq.getData().getTimeConsumEnd())
                    .andRemoteIpEqualTo(openApiReq.getData().getRemoteIp())
                    .andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll)
                    .andFAppIdIn(appIdList.size()==0? Arrays.asList(""):appIdList)
                    .andFStatusIn(statusList.size()==0? Arrays.asList(""):statusList);
        }else{
            example.createCriteria().andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll);
        }
        example.setOrderByClause(" log_time desc ");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogStructTomcat> lists = logStructTomcatService.pageQueryTomcat(example);
        List<LogStructTomcatDTO> pageList = dozerUtils.mapPage(lists, LogStructTomcatDTO.class);
        return Result.success(new PageInfo(pageList));
    }
    @ApiResponses({
            @ApiResponse(code = 65000, message = "id不能为空")
    })
    @ApiOperation(value = "预览TOMCAT结构化数据详情", notes = "预览TOMCAT结构化数据详情")
    @RequestMapping(value = "/log/getTomcat", method = RequestMethod.GET)
    public Result<LogStructTomcatDTO> getTomcat(@RequestParam(value = "id") Long id) {
        //1，验证
        BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, id);

        LogStructTomcat logStructTomcat = logStructTomcatService.getById(id);
        return Result.success(dozerUtils.map(logStructTomcat, LogStructTomcatDTO.class));
    }
    @ApiResponses({
            @ApiResponse(code = 65000, message = "id不能为空")
    })
    @ApiOperation(value = "删除NGINX结构化数据详情", notes = "删除NGINX结构化数据详情")
    @RequestMapping(value = "/log/deleteTomcat", method = RequestMethod.GET)
    public Result<Boolean> deleteTomcat(@RequestParam(value = "id") Long id) {
        //1，验证
        BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, id);
        int i = logStructTomcatService.deleteById(id);
        if (i == 0) {
            return Result.fail("未找到要删除的数据，id：" + id);
        } else {
            return Result.success(true);
        }
    }

    @RequestMapping(value = "/log/pageQueryTogether", method = RequestMethod.POST)
    public Result<PageInfo<LogStructTogetherDTO>> pageQueryTogether(@RequestBody  OpenApiReq<LogStructTogetherQueryDTO> openApiReq) {
        //取当前登录用户拥用的应用系统
        Result<List<AppShowDto>> resultListApp = applicationApi.findAppIdList((long) 1);
        List<AppShowDto> listApp = resultListApp.getData();
        List<String> appIdListAll = new ArrayList();
        if(listApp.size()>0){
            for(int i=0;i<listApp.size();i++){
                AppShowDto appShowDto = listApp.get(i);
                appIdListAll.add(appShowDto.getAppId());
            }
        }

        LogStructTogetherQueryDTO data = openApiReq.getData();
        LogStructTogetherExample example = new LogStructTogetherExample();
        if (data != null) {
            String appIds=data.getAppId();
            List<String> appIdList = new ArrayList();
            if(null!=appIds && !"".equals(appIds)){
                String[] appIdArray = appIds.split(",");
                for(int m=0; m<appIdArray.length; m++) {
                    String appId = appIdArray[m];
                    if(null!=appId && !appId.equals("")) {
                        appIdList.add(appId);
                    }
                }
            }
            String logTypes=data.getLogType();
            List<String> logTypeList = new ArrayList();
            if(null!=logTypes && !"".equals(logTypes)){
                String[] logTypeArray = logTypes.split(",");
                for(int m=0; m<logTypeArray.length; m++) {
                    String logType = logTypeArray[m];
                    if(logType != null && !logType.equals("")) {
                        logTypeList.add(logType);
                    }
                }
            }
            example.createCriteria()
                    .andFLogTimeGt(data.getLocalTimeStart())
                    .andFLogTimeLt(data.getLocalTimeEnd())
                    .andFLogTypeIn(logTypeList.size()==0? Arrays.asList(""):logTypeList)
                    .andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll)
                    .andFAppIdIn(appIdList.size()==0? Arrays.asList(""):appIdList);
        }else{
            example.createCriteria().andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll);
        }
        example.setOrderByClause(" log_time desc ");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogStructTogetherDO> lists = logStructService.pageQueryStructTogether(example);
        List<LogStructTogetherDTO> pageList = dozerUtils.mapPage(lists, LogStructTogetherDTO.class);
        return Result.success(new PageInfo(pageList));
    }
}
