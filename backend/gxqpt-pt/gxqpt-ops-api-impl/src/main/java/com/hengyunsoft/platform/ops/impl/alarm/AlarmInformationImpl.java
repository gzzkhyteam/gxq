package com.hengyunsoft.platform.ops.impl.alarm;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.ops.alarmdto.AlarmInformationDTO;
import com.hengyunsoft.platform.ops.alarmdto.AlarmInformationPageReqDTO;
import com.hengyunsoft.platform.ops.impl.utils.YwPtRoleUnits;
import com.hengyunsoft.platform.ops.repository.alarm.example.AlarmInformationExample;
import com.hengyunsoft.platform.ops.repository.alarm.service.AlarmInformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("AlarmInformation")
@Api(value = "API - AlarmInformationImpl", description = "告警列表信息管理")
public class AlarmInformationImpl {
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private AlarmInformationService alarmInformationService;
    @Autowired
    YwPtRoleUnits ywPtRoleUnits;

    @ApiOperation(value = "查询告警列表信息管理", notes = "查询告警列表信息管理")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result<PageInfo<AlarmInformationDTO>> page(@RequestBody OpenApiReq<AlarmInformationPageReqDTO> openApiReq) {

        Date startTime = openApiReq.getData().getStartTime();
        Date endTime = openApiReq.getData().getEndTime();
        String alarmName = openApiReq.getData().getAlarmName();
        Integer alarmLevel=openApiReq.getData().getAlarmLevel();
        Integer status=openApiReq.getData().getStatus();
        Map map = new HashMap<>();
        map.put("alarmName", alarmName);
        map.put("alarmLevel", alarmLevel);
        map.put("status", status);
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        return Result.success(new PageInfo<>(dozerUtils.mapPage(alarmInformationService.getAlarmInfoPageList(map), AlarmInformationDTO.class)));
    }

    @ApiOperation(value = "运维首页查询告警列表信息管理", notes = "运维首页查询告警列表信息管理")
    @RequestMapping(value = "/pageInfo", method = RequestMethod.POST)
    public Result<PageInfo<AlarmInformationDTO>> pageInfo(@RequestBody OpenApiReq<AlarmInformationPageReqDTO> openApiReq) {
        Boolean ywPtAuditAdmin;//是否是运维平台审核角色
        Long userId= BaseContextHandler.getAdminId();
        ywPtAuditAdmin = ywPtRoleUnits.getYwUnitOrPtRole(userId, YwPtRoleUnits.YW_APPROVAL_CODE);
        if(ywPtAuditAdmin){
            Map map = new HashMap<>();
            map.put("applyType", "audit");
            map.put("createUser", userId);
            PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
            //查询待审核数据(服务、咨询、培训)和待当前用户处理的数据
            return Result.success(new PageInfo<>(dozerUtils.mapPage(alarmInformationService.getAlarmInfo(map), AlarmInformationDTO.class)));
        }else{
            PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
            AlarmInformationExample example=new AlarmInformationExample();
            example.createCriteria().andCreateUserEqualTo(userId);
            return Result.success(new PageInfo<>(dozerUtils.mapPage(alarmInformationService.find(example), AlarmInformationDTO.class)));
        }
    }
}
