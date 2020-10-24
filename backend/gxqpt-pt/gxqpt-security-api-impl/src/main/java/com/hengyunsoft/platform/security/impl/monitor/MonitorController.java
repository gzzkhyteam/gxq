package com.hengyunsoft.platform.security.impl.monitor;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.RoleCode;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.context.CommonConstants;
import com.hengyunsoft.commons.exception.core.SecurityExceptionCode;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.db.example.BaseExample;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.msgs.queue.BbbMsgQueueProducer;
import com.hengyunsoft.platform.security.dto.monitor.*;
import com.hengyunsoft.platform.security.entity.monitor.po.MonitorAccess;
import com.hengyunsoft.platform.security.entity.monitor.po.MonitorProcess;
import com.hengyunsoft.platform.security.entity.monitor.po.MonitorProcessWhitelist;
import com.hengyunsoft.platform.security.entity.monitor.po.MonitorServer;
import com.hengyunsoft.platform.security.repository.constant.HandleStatus;
import com.hengyunsoft.platform.security.repository.monitor.example.MonitorProcessExample;
import com.hengyunsoft.platform.security.repository.monitor.example.MonitorServerExample;
import com.hengyunsoft.platform.security.repository.monitor.service.MonitorAccessService;
import com.hengyunsoft.platform.security.repository.monitor.service.MonitorProcessService;
import com.hengyunsoft.platform.security.repository.monitor.service.MonitorProcessWhitelistService;
import com.hengyunsoft.platform.security.repository.monitor.service.MonitorServerService;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
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
@Api(value = "API - MonitorController.java",description = "服务监控")
@RestController
@RequestMapping("monitor")
@Slf4j
public class MonitorController {
    @Autowired
    private MonitorAccessService monitorAccessService;
    @Autowired
    private MonitorProcessService monitorProcessService;
    @Autowired
    private MonitorProcessWhitelistService monitorProcessWhitelistService;
    @Autowired
    private MonitorServerService monitorServerService;
    @Autowired
    private BbbMsgQueueProducer msgQueueProducer;
    @Autowired
    private DozerUtils dozerUtils;

    @Value("${gxqpt.security-webapp.app-id}")
    private String APPID;
    private final String APPNAME = "安全保障平台";

    @RequestMapping(value = "/pageServerAccessList",method = RequestMethod.POST)
    @ApiOperation(value = "查询服务器访问记录",notes = "分页查询服务器访问记录")
    @ApiResponse(code = 95001, message = "分页参数,不能为空")
    public Result<PageInfo<MonitorServerAccessDTO>> pageServerAccessList(@RequestBody OpenApiReq<MonitorServerAccessReqDTO> openApiReq){
        BizAssert.assertNotNull(SecurityExceptionCode.PAGE_OPENAPIREQ,openApiReq);
        PageHelper.startPage(openApiReq.getPageNo(),openApiReq.getPageSize());
        Map param = new HashMap();
        if(null != openApiReq.getData()){
            param.put("begDate",openApiReq.getData().getBegDate());
            param.put("endDate",openApiReq.getData().getEndDate());
            param.put("serverOrAccount",BaseExample.fullLike(openApiReq.getData().getServerIpOrAccount()));
        }
        List<MonitorServerAccessDTO> list = monitorAccessService.pageServerAccessList(param);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list,MonitorServerAccessDTO.class)));
    }

    @RequestMapping(value = "/pageProcessList",method = RequestMethod.POST)
    @ApiOperation(value = "查询进程列表",notes = "分页查询进程列表")
    @ApiResponse(code = 95001, message = "分页参数,不能为空")
    public Result<PageInfo<MonitorProcessSelectDTO>> pageProcessList(@RequestBody OpenApiReq<MonitorProcessReqDTO> openApiReq){
        BizAssert.assertNotNull(SecurityExceptionCode.PAGE_OPENAPIREQ,openApiReq);
        PageHelper.startPage(openApiReq.getPageNo(),openApiReq.getPageSize());
        Map param = new HashMap();
        if(null != openApiReq.getData()){
            param.put("processName",BaseExample.fullLike(openApiReq.getData().getProcessName()));
            if (null != openApiReq.getData().getStatus() && CommonConstants.SEARCH_ALL_INT != openApiReq.getData().getStatus()){
                param.put("status",openApiReq.getData().getStatus());
            }
            param.put("serverIp",BaseExample.fullLike(openApiReq.getData().getServerIp()));
        }
        List<MonitorProcess> list = monitorProcessService.pageProcessList(param);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list,MonitorProcessSelectDTO.class)));
    }

    @RequestMapping(value = "/pageServerMonitorList",method = RequestMethod.POST)
    @ApiOperation(value = "查询服务预警记录列表",notes = "分页查询服务预警记录列表")
    @ApiResponse(code = 95001, message = "分页参数,不能为空")
    public Result<PageInfo<MonitorServerSelectDTO>> pageServerMonitorList(@RequestBody OpenApiReq<MonitorServerReqDTO> openApiReq){
        BizAssert.assertNotNull(SecurityExceptionCode.PAGE_OPENAPIREQ,openApiReq);
        PageHelper.startPage(openApiReq.getPageNo(),openApiReq.getPageSize());
        Map param = new HashMap();
        if(CommonConstants.SEARCH_ALL_INT != openApiReq.getData().getStatus()){
            param.put("status",openApiReq.getData().getStatus());
        }
        if(null != openApiReq.getData()){
            param.put("name",BaseExample.fullLike(openApiReq.getData().getName()));
            param.put("serverIp",BaseExample.fullLike(openApiReq.getData().getServerIp()));
        }
        List<MonitorServer> list = monitorServerService.pageMonitorServer(param);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list,MonitorServerSelectDTO.class)));
    }

    @RequestMapping(value = "/pageProcessWhitelist",method = RequestMethod.POST)
    @ApiOperation(value = "查询进程白名单",notes = "分页查询进程白名单")
    @ApiResponse(code = 95001, message = "分页参数,不能为空")
    public Result<PageInfo<MonitorProcessWhitelistSaveDTO>> pageProcessWhitelist(@RequestBody OpenApiReq<MonitorProcessWhitelistReqDTO> openApiReq){
        BizAssert.assertNotNull(SecurityExceptionCode.PAGE_OPENAPIREQ,openApiReq);
        PageHelper.startPage(openApiReq.getPageNo(),openApiReq.getPageSize());
        Map param = new HashMap();
        if(null != openApiReq.getData()){
            param.put("serverIp",BaseExample.fullLike(openApiReq.getData().getServerIp()));
        }
        List<MonitorProcessWhitelist> list = monitorProcessWhitelistService.pageProcessWhitelist(param);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list,MonitorProcessWhitelistSaveDTO.class)));
    }

    @RequestMapping(value = "/updateMonitorProcess",method = RequestMethod.POST)
    @ApiOperation(value = "进程异常处理",notes = "处理异常进程信息")
    @ApiResponses({
            @ApiResponse(code = 95000, message = "主键不能为空"),
            @ApiResponse(code = 95003, message = "参数不能为空"),
            @ApiResponse(code = 95005, message = "主键不存在")
    })
    public Result<Boolean> updateMonitorProcess(@RequestBody MonitorProcessDTO monitorProcessDTO){
        BizAssert.assertNotNull(SecurityExceptionCode.PARAM_OBJECT_IS_NULL,monitorProcessDTO);
        BizAssert.assertNotNull(SecurityExceptionCode.ID_IS_NULL,monitorProcessDTO.getId());
        MonitorProcess monitorProcess = monitorProcessService.getById(monitorProcessDTO.getId());
        if(monitorProcess == null){
            return Result.fail(SecurityExceptionCode.ID_NOT_EXIST.getCode(),SecurityExceptionCode.ID_NOT_EXIST.getMsg());
        }
        monitorProcess =  dozerUtils.map(monitorProcessDTO,MonitorProcess.class);
        monitorProcess.setStatus(HandleStatus.HANDLED_STATUS.getValue());
        Long userID = BaseContextHandler.getAdminId();
        monitorProcess.setUpdateUser(userID);
        monitorProcess.setUpdateTime(DateUtils.getCurrentTime());
        monitorProcess.setHandleTime(DateUtils.getCurrentTime());
        monitorProcess.setHandleUser(BaseContextHandler.getName());
        monitorProcessService.updateByIdSelective(monitorProcess);
        return Result.success(true);
    }

    @RequestMapping(value = "/updateProcessWhitelist",method = RequestMethod.POST)
    @ApiOperation(value = "修改进程白名单",notes = "修改进程白名单")
    @ApiResponses({
            @ApiResponse(code = 95000, message = "主键不能为空"),
            @ApiResponse(code = 95003, message = "参数不能为空"),
            @ApiResponse(code = 95005, message = "主键不存在"),
            @ApiResponse(code = 95006, message = "进程ID不能为空"),
            @ApiResponse(code = 95007, message = "进程ID不存在"),
            @ApiResponse(code = 95008, message = "服务器IP不能为空"),
            @ApiResponse(code = 95009, message = "进程名称不能为空")
    })
    public Result<Boolean> updateProcessWhitelist(@RequestBody MonitorProcessWhitelistDTO monitorProcessWhitelistDTO){
        BizAssert.assertNotNull(SecurityExceptionCode.PARAM_OBJECT_IS_NULL,monitorProcessWhitelistDTO);
        BizAssert.assertNotNull(SecurityExceptionCode.ID_IS_NULL,monitorProcessWhitelistDTO.getId());
        BizAssert.assertNotNull(SecurityExceptionCode.PROCESS_ID_IS_NULL,monitorProcessWhitelistDTO.getProcessId());
        BizAssert.assertNotEmpty(SecurityExceptionCode.SERVER_IP_IS_NULL,monitorProcessWhitelistDTO.getServerIp());
        BizAssert.assertNotEmpty(SecurityExceptionCode.PROCESS_NAME_IS_NULL,monitorProcessWhitelistDTO.getProcessName());

        MonitorProcessWhitelist monitorProcessWhitelist =  monitorProcessWhitelistService.getById(monitorProcessWhitelistDTO.getId());
        if(monitorProcessWhitelist == null){
            return Result.fail(SecurityExceptionCode.ID_NOT_EXIST.getCode(),SecurityExceptionCode.ID_NOT_EXIST.getMsg());
        }
        MonitorProcess monitorProcess =  monitorProcessService.getById(monitorProcessWhitelistDTO.getProcessId());
        if(monitorProcess == null){
            return Result.fail(SecurityExceptionCode.PROCESS_ID_NOT_EXIST.getCode(),SecurityExceptionCode.PROCESS_ID_NOT_EXIST.getMsg());
        }
        monitorProcessWhitelist = dozerUtils.map(monitorProcessWhitelistDTO,MonitorProcessWhitelist.class);
        Long userID = BaseContextHandler.getAdminId();
        monitorProcessWhitelist.setUpdateUser(userID);
        monitorProcessWhitelist.setUpdateTime(new Date());
        monitorProcessWhitelistService.updateByIdSelective(monitorProcessWhitelist);
        return Result.success(true);
    }

    @RequestMapping(value = "/updateServiceWarn",method = RequestMethod.POST)
    @ApiOperation(value = "更新服务预警记录信息",notes = "更新服务预警记录信息")
    @ApiResponses({
            @ApiResponse(code = 95003, message = "参数不能为空"),
            @ApiResponse(code = 95000, message = "主键不能为空"),
            @ApiResponse(code = 95005, message = "主键不存在"),
            @ApiResponse(code = 95010, message = "处理人不能为空")
    })
    public Result<Boolean> updateServiceWarn(@RequestBody MonitorServerDTO monitorServerDTO){
        BizAssert.assertNotNull(SecurityExceptionCode.PARAM_OBJECT_IS_NULL,monitorServerDTO);
        BizAssert.assertNotNull(SecurityExceptionCode.ID_IS_NULL,monitorServerDTO.getId());
        MonitorServer monitorServer = monitorServerService.getById(monitorServerDTO.getId());
        if(monitorServer == null){
            return Result.fail(SecurityExceptionCode.ID_NOT_EXIST.getCode(),SecurityExceptionCode.ID_NOT_EXIST.getMsg());
        }
        monitorServer = dozerUtils.map(monitorServerDTO,MonitorServer.class);
        monitorServer.setStatus(HandleStatus.HANDLED_STATUS.getValue());
        monitorServer.setHandleTime(new Date());
        String userName = BaseContextHandler.getName();
        monitorServer.setHandleUser(userName);
        monitorServerService.updateByIdSelective(monitorServer);
        return Result.success(true);
    }

    @RequestMapping(value = "/deleteProcessWhitelist",method = RequestMethod.GET)
    @ApiOperation(value = "删除进程白名单",notes = "删除进程白名单")
    @ApiResponses({
            @ApiResponse(code = 95000, message = "主键不能为空"),
            @ApiResponse(code = 95005, message = "主键不存在")
    })
    public Result<Boolean> deleteProcessWhitelist(@RequestParam(value = "id",required = true) Long id){
        BizAssert.assertNotNull(SecurityExceptionCode.ID_IS_NULL,id);
        MonitorProcessWhitelist monitorProcessWhitelist =  monitorProcessWhitelistService.getById(id);
        if(monitorProcessWhitelist == null){
            return Result.fail(SecurityExceptionCode.ID_NOT_EXIST.getCode(),SecurityExceptionCode.ID_NOT_EXIST.getMsg());
        }
        monitorProcessWhitelistService.deleteById(id);
        return Result.success(true);
    }

    @RequestMapping(value = "/getProcess",method = RequestMethod.GET)
    @ApiOperation(value = "查询单个异常进程信息",notes = "根据主键获取单个异常进程信息")
    @ApiResponses({
            @ApiResponse(code = 95000, message = "主键不能为空"),
            @ApiResponse(code = 95005, message = "主键不存在")
    })
    public Result<MonitorProcessSelectDTO> get(@RequestParam(value = "id",required = true) Long id){
        BizAssert.assertNotNull(SecurityExceptionCode.ID_IS_NULL,id);
        MonitorProcess monitorProcess =  monitorProcessService.getById(id);
        if(monitorProcess == null){
            return Result.fail(SecurityExceptionCode.ID_NOT_EXIST.getCode(),SecurityExceptionCode.ID_NOT_EXIST.getMsg());
        }
        MonitorProcessSelectDTO monitorProcessSelectDTO = dozerUtils.map(monitorProcess,MonitorProcessSelectDTO.class);
        return Result.success(monitorProcessSelectDTO);
    }

    @RequestMapping(value = "/getMonitorServer",method = RequestMethod.GET)
    @ApiOperation(value = "查询单个异常服务信息",notes = "根据主键获取单个异常服务信息")
    @ApiResponses({
            @ApiResponse(code = 95000, message = "主键不能为空"),
            @ApiResponse(code = 95005, message = "主键不存在")
    })
    public Result<MonitorServerSelectDTO> getMonitorServer(@RequestParam(value = "id",required = true) Long id){
        BizAssert.assertNotNull(SecurityExceptionCode.ID_IS_NULL,id);
        MonitorServer monitorServer =  monitorServerService.getById(id);
        if(monitorServer == null){
            return Result.fail(SecurityExceptionCode.ID_NOT_EXIST.getCode(),SecurityExceptionCode.ID_NOT_EXIST.getMsg());
        }
        MonitorServerSelectDTO monitorServerSelectDTO = dozerUtils.map(monitorServer,MonitorServerSelectDTO.class);
        return Result.success(monitorServerSelectDTO);
    }

    @RequestMapping(value = "/saveMonitorServerAccess",method = RequestMethod.GET)
    @ApiOperation(value = "新增服务器访问记录",notes = "新增服务器访问记录")
    @ApiResponses({
            @ApiResponse(code = 95003, message = "参数不能为空"),
            @ApiResponse(code = 95008, message = "服务器IP不能为空"),
            @ApiResponse(code = 95012, message = "账户不能为空")

    })
    @IgnoreToken
    public Result<Boolean> saveMonitorServerAccess(MonitorServerAccessSaveDTO monitorServerAccessSaveDTO){
        BizAssert.assertNotNull(SecurityExceptionCode.IMPORTANT_COLUMN_LACK,monitorServerAccessSaveDTO.getAccount());
        BizAssert.assertNotNull(SecurityExceptionCode.SERVER_IP_IS_NULL,monitorServerAccessSaveDTO.getFromServerIp());
        BizAssert.assertNotNull(SecurityExceptionCode.SERVER_IP_IS_NULL,monitorServerAccessSaveDTO.getToServerIp());
        MonitorAccess monitorAccess = dozerUtils.map(monitorServerAccessSaveDTO,MonitorAccess.class);
        monitorAccess.setCreateTime(new Date());
        monitorAccessService.save(monitorAccess);
        /*//发送消息队列
        BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
        bbsAllMainMsgDTO.setAppId(APPID);
        bbsAllMainMsgDTO.setAppName(APPNAME);
        bbsAllMainMsgDTO.setBizId(monitorAccess.getId().toString());
        bbsAllMainMsgDTO.setBizType("add_monitor_server_access");
        bbsAllMainMsgDTO.setBriefTpye("monitor_server_access");
        bbsAllMainMsgDTO.setClientFlag("gxqpt");
        bbsAllMainMsgDTO.setDetailedTypeDesc("服务器访问监控");
        bbsAllMainMsgDTO.setDetailedType("gxqpt-security");
        bbsAllMainMsgDTO.setSingleHandleIs(false);
        bbsAllMainMsgDTO.setHandlerNeedIs(false);
        bbsAllMainMsgDTO.setHandlerUrl("index.html#/serverAccessMonitor?resourceId=1959075519905");
        bbsAllMainMsgDTO.setTitle("服务器" + monitorAccess.getToServerIp() + "访问通知");
        bbsAllMainMsgDTO.setContent("您的服务器" + monitorAccess.getToServerIp() + "于" + DateUtils.dateToString(monitorAccess.getLoginTime(),DateUtils.DATE_TIME_FORMAT) + "发生账户" + monitorAccess.getAccount() + "访问。");
        bbsAllMainMsgDTO.setSenderName("系统自动通知");
        msgQueueProducer.saveLookMsgToRole(bbsAllMainMsgDTO, RoleCode.APPLICATION_ADMIN_CODE,APPID);*/
        return Result.success(true);
    }

    @RequestMapping(value = "/saveProcessWhitelist",method = RequestMethod.GET)
    @ApiOperation(value = "新增进程白名单",notes = "新增进程白名单")
    @ApiResponses({
            @ApiResponse(code = 95003, message = "参数不能为空"),
            @ApiResponse(code = 95006, message = "进程ID不能为空"),
            @ApiResponse(code = 95007, message = "进程ID不存在"),
            @ApiResponse(code = 95008, message = "服务器IP不能为空"),
            @ApiResponse(code = 95009, message = "进程名称不能为空")

    })
    @IgnoreToken
    public Result<Boolean> saveProcessWhitelist(MonitorProcessWhitelistSaveDTO monitorProcessWhitelistSaveDTO){
        BizAssert.assertNotNull(SecurityExceptionCode.SERVER_IP_IS_NULL,monitorProcessWhitelistSaveDTO);
        BizAssert.assertNotEmpty(SecurityExceptionCode.SERVER_IP_IS_NULL,monitorProcessWhitelistSaveDTO.getServerIp());
        BizAssert.assertNotNull(SecurityExceptionCode.PROCESS_ID_IS_NULL,monitorProcessWhitelistSaveDTO.getProcessId());
        BizAssert.assertNotEmpty(SecurityExceptionCode.PROCESS_NAME_IS_NULL,monitorProcessWhitelistSaveDTO.getProcessName());
        MonitorProcessWhitelist monitorProcessWhitelist = dozerUtils.map(monitorProcessWhitelistSaveDTO,MonitorProcessWhitelist.class);
        monitorProcessWhitelist.setStatus(true);
        Long userID = BaseContextHandler.getAdminId();
        monitorProcessWhitelist.setCreateUser(userID);
        monitorProcessWhitelistService.save(monitorProcessWhitelist);
        return Result.success(true);
    }

    @RequestMapping(value = "/saveMonitorProcess",method = RequestMethod.GET)
    @IgnoreToken
    @ApiOperation(value = "新增预警进程信息",notes = "新增预警进程信息")
    @ApiResponses({
            @ApiResponse(code = 95003, message = "参数不能为空"),
            @ApiResponse(code = 95006, message = "进程ID不能为空"),
            @ApiResponse(code = 95007, message = "进程ID不存在"),
            @ApiResponse(code = 95008, message = "服务器IP不能为空"),
            @ApiResponse(code = 95009, message = "进程名称不能为空")
    })
    public Result<Boolean> saveMonitorProcess(MonitorProcessSaveDTO monitorProcessSaveDTO){
        BizAssert.assertNotNull(SecurityExceptionCode.PROCESS_ID_IS_NULL, monitorProcessSaveDTO);
        BizAssert.assertNotEmpty(SecurityExceptionCode.SERVER_IP_IS_NULL,monitorProcessSaveDTO.getServerIp());
        BizAssert.assertNotEmpty(SecurityExceptionCode.PROCESS_NAME_IS_NULL,monitorProcessSaveDTO.getProcessName());
        MonitorProcess monitorProcess = dozerUtils.map(monitorProcessSaveDTO,MonitorProcess.class);
        Long userID = BaseContextHandler.getAdminId();
        monitorProcess.setCreateUser(userID);
        monitorProcess.setStatus(HandleStatus.UNHANDLE_STATUS.getValue());//默认未处理
        //发送消息队列
        MonitorProcessExample  example = new MonitorProcessExample();
        example.createCriteria().andServerIpEqualTo(monitorProcess.getServerIp())
                .andCreateTimeGreaterThan(DateUtils.string2Date(DateUtils.getCurrentDate(),"yyyyMMdd"))
                .andProcessNameEqualTo(monitorProcess.getProcessName()).andStatusEqualTo(HandleStatus.UNHANDLE_STATUS.getValue());
        int count = monitorProcessService.count(example);
        if(count < 2){
            monitorProcess =  monitorProcessService.save(monitorProcess);
            //发送消息队列
            BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
            bbsAllMainMsgDTO.setAppId(APPID);
            bbsAllMainMsgDTO.setAppName(APPNAME);
            bbsAllMainMsgDTO.setBizId(monitorProcess.getId().toString());
            String add_monitor_server = "add_monitor_process";
            bbsAllMainMsgDTO.setBizType(add_monitor_server);
            bbsAllMainMsgDTO.setBriefTpye("monitor_process");
            bbsAllMainMsgDTO.setClientFlag("gxqpt");
            bbsAllMainMsgDTO.setDetailedType("gxqpt-security");
            bbsAllMainMsgDTO.setDetailedTypeDesc("进程监控");
            bbsAllMainMsgDTO.setSingleHandleIs(false);
            bbsAllMainMsgDTO.setHandlerNeedIs(false);
            bbsAllMainMsgDTO.setHandlerUrl("index.html#/processMonitor?resourceId=2174457224641");
            bbsAllMainMsgDTO.setTitle(monitorProcess.getServerIp()+"--"+monitorProcess.getProcessName()+"进程异常");
            bbsAllMainMsgDTO.setContent("您的" + monitorProcess.getServerIp() +"服务器--"+monitorProcess.getProcessName() + "进程有异常");
            bbsAllMainMsgDTO.setSenderName("系统自动通知");
            msgQueueProducer.saveLookMsgToRole(bbsAllMainMsgDTO, RoleCode.APPLICATION_ADMIN_CODE,APPID);
        }
        return Result.success(true);
    }

    @RequestMapping(value = "/saveMonitorServer",method = RequestMethod.GET)
    @IgnoreToken
    @ApiOperation(value = "新增异常服务预警信息",notes = "新增异常服务预警信息")
    @ApiResponses({
            @ApiResponse(code = 95003, message = "参数不能为空"),
            @ApiResponse(code = 95008, message = "服务器IP不能为空"),
            @ApiResponse(code = 95012, message = "缺少关键字段")

    })
    public Result<Boolean> saveMonitorServer(MonitorServerSaveDTO monitorServerSaveDTO){
        BizAssert.assertNotEmpty(SecurityExceptionCode.SERVER_IP_IS_NULL,monitorServerSaveDTO.getServerIp());
        BizAssert.assertNotEmpty(SecurityExceptionCode.IMPORTANT_COLUMN_LACK,monitorServerSaveDTO.getName());
        BizAssert.assertNotEmpty(SecurityExceptionCode.IMPORTANT_COLUMN_LACK,monitorServerSaveDTO.getAccount());
        MonitorServer monitorServer =  dozerUtils.map(monitorServerSaveDTO,MonitorServer.class);
        monitorServer.setStatus(HandleStatus.UNHANDLE_STATUS.getValue());//默认未处理
        monitorServer.setCreateTime(new Date());
        //判断当日是否已插入相同服务预警低于2次
        MonitorServerExample example = new MonitorServerExample();
        example.createCriteria().andServerIpEqualTo(monitorServerSaveDTO.getServerIp())
                .andCreateTimeGreaterThan(DateUtils.string2Date(DateUtils.getCurrentDate(),"yyyyMMdd"))
                .andNameEqualTo(monitorServerSaveDTO.getName()).andStatusEqualTo(HandleStatus.UNHANDLE_STATUS.getValue());
        int count = monitorServerService.count(example);
        if(count < 2){
            monitorServer = monitorServerService.save(monitorServer);
            //发送消息队列
            BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
            bbsAllMainMsgDTO.setAppId(APPID);
            bbsAllMainMsgDTO.setAppName(APPNAME);
            bbsAllMainMsgDTO.setBizId(monitorServer.getId().toString());
            String add_monitor_server = "add_monitor_server";
            bbsAllMainMsgDTO.setBizType(add_monitor_server);
            bbsAllMainMsgDTO.setBriefTpye("monitor_server");
            bbsAllMainMsgDTO.setClientFlag("gxqpt");
            bbsAllMainMsgDTO.setDetailedType("gxqpt-security");
            bbsAllMainMsgDTO.setDetailedTypeDesc("服务监控");
            bbsAllMainMsgDTO.setSingleHandleIs(false);
            bbsAllMainMsgDTO.setHandlerNeedIs(false);
            bbsAllMainMsgDTO.setHandlerUrl("index.html#/serverMonitor?resourceId=123983633953");
            bbsAllMainMsgDTO.setTitle(monitorServer.getServerIp()+"--"+monitorServer.getName()+"服务异常");
            bbsAllMainMsgDTO.setContent("您的" + monitorServer.getServerIp() +"服务器--"+monitorServer.getName() + "服务有异常");
            bbsAllMainMsgDTO.setSenderName("系统自动通知");
            msgQueueProducer.saveLookMsgToRole(bbsAllMainMsgDTO, RoleCode.APPLICATION_ADMIN_CODE,APPID);
        }
        return Result.success(true);
    }

}
