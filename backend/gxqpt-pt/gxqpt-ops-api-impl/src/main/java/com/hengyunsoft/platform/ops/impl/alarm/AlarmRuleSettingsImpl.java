package com.hengyunsoft.platform.ops.impl.alarm;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.OperationExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.ops.alarmdto.AlarmRuleSettingsDTO;
import com.hengyunsoft.platform.ops.alarmdto.AlarmRuleSettingsSaveDTO;
import com.hengyunsoft.platform.ops.alarmdto.AlarmRuleSetPageReqDTO;
import com.hengyunsoft.platform.ops.entity.alarm.po.AlarmRuleSettings;
import com.hengyunsoft.platform.ops.repository.alarm.service.AlarmRuleSettingsService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("Alarm")
@Api(value = "API - AlarmRuleSettingsImpl", description = "告警规则设置管理")
public class AlarmRuleSettingsImpl {
    @Autowired
    private AlarmRuleSettingsService alarmRuleSettingsService;

    @Autowired
    private DozerUtils dozerUtils;

    @ApiOperation(value = "查询告警规则设置分页信息", notes = "查询告警规则设置分页信息")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result<PageInfo<AlarmRuleSettingsDTO>> page(@RequestBody OpenApiReq<AlarmRuleSetPageReqDTO> openApiReq) {

        String alarmName = openApiReq.getData().getAlarmName();
        Integer alarmLevel = openApiReq.getData().getAlarmLevel();
        Integer alarmType = openApiReq.getData().getAlarmType();

        Map map = new HashMap<>();
        map.put("alarmName", alarmName);
        map.put("alarmLevel", alarmLevel);
        map.put("alarmType", alarmType);
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        return Result.success(new PageInfo<>(dozerUtils.mapPage(alarmRuleSettingsService.getAlarmPageList(map), AlarmRuleSettingsDTO.class)));
    }
    @ApiOperation(value = "保存告警规则设置信息", notes = "保存告警规则设置信息")
    @ApiResponses({
            @ApiResponse(code = 105070, message = "告警名称不能为空"),
            @ApiResponse(code = 105071, message = "告警级别不能为空"),
            @ApiResponse(code = 105072, message = "告警类型不能为空"),
            @ApiResponse(code = 105073, message = "任务类型不能为空"),
            @ApiResponse(code = 105074, message = "告警天数不能为空")
    })
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<AlarmRuleSettingsSaveDTO> save(@RequestBody AlarmRuleSettingsSaveDTO saveDTO) {
        //验证
        BizAssert.assertNotNull(OperationExceptionCode.ALARM_NAME_NULL, saveDTO.getAlarmName());
        BizAssert.assertNotNull(OperationExceptionCode.ALARM_LEVEL_NULL, saveDTO.getAlarmLevel());
        BizAssert.assertNotNull(OperationExceptionCode.ALARM_TYPE_NULL, saveDTO.getAlarmType());
        BizAssert.assertNotNull(OperationExceptionCode.ALARM_TASK_TYPE_NULL, saveDTO.getTaskType());
        BizAssert.assertNotNull(OperationExceptionCode.ALARM_DAY_NULL, saveDTO.getDay());

        //转换，保存应用升级表数据
        Long userId = BaseContextHandler.getAdminId();
        AlarmRuleSettings alarmRuleSettings=dozerUtils.map(saveDTO,AlarmRuleSettings.class);
        alarmRuleSettings.setCreateUser(userId);
        alarmRuleSettings.setUpdateUser(userId);
        alarmRuleSettingsService.saveSelective(alarmRuleSettings);
        return Result.success(dozerUtils.map(alarmRuleSettings, AlarmRuleSettingsSaveDTO.class));
    }

    @ApiOperation(value = "修改告警规则设置信息", notes = "修改告警规则设置信息")
    @ApiResponses({
            @ApiResponse(code = 105070, message = "告警名称不能为空"),
            @ApiResponse(code = 105071, message = "告警级别不能为空"),
            @ApiResponse(code = 105072, message = "告警类型不能为空"),
            @ApiResponse(code = 105073, message = "任务类型不能为空"),
            @ApiResponse(code = 105074, message = "告警天数不能为空")
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<AlarmRuleSettingsSaveDTO> update(@RequestBody AlarmRuleSettingsSaveDTO saveDTO) {
        //验证
        BizAssert.assertNotNull(OperationExceptionCode.ALARM_NAME_NULL, saveDTO.getAlarmName());
        BizAssert.assertNotNull(OperationExceptionCode.ALARM_LEVEL_NULL, saveDTO.getAlarmLevel());
        BizAssert.assertNotNull(OperationExceptionCode.ALARM_TYPE_NULL, saveDTO.getAlarmType());
        BizAssert.assertNotNull(OperationExceptionCode.ALARM_DAY_NULL, saveDTO.getDay());
        BizAssert.assertNotNull(OperationExceptionCode.ALARM_TASK_TYPE_NULL, saveDTO.getTaskType());

        //转换，保存应用升级表数据
        Long userId = BaseContextHandler.getAdminId();
        AlarmRuleSettings alarmRuleSettings=dozerUtils.map(saveDTO,AlarmRuleSettings.class);
        alarmRuleSettings.setUpdateUser(userId);
        alarmRuleSettingsService.updateByIdSelective(alarmRuleSettings);
        return Result.success(dozerUtils.map(alarmRuleSettings, AlarmRuleSettingsSaveDTO.class));
    }

    @ApiOperation(value = "根据id删除告警规则信息",notes="根据id删除告警规则信息")
    @RequestMapping(value = "/delete" ,method =RequestMethod.POST)
    public Result<Boolean> delete(@RequestParam(value = "ids") List<Long> ids) {
        if (ids.size()==0) {
            return Result.success(null);
        }
        alarmRuleSettingsService.deleteByIds(ids);
        return Result.success(true);
    }

    @ApiOperation(value = "根据id查询告警规则信息",notes="根据id查询告警规则信息")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result<AlarmRuleSettingsDTO> get(@RequestParam(value = "id") Long id) {
        //验证
        if (id == null) {
            return Result.success(null);
        }
        AlarmRuleSettings alarmRuleSettings= alarmRuleSettingsService.getById(id);
        return Result.success(dozerUtils.map(alarmRuleSettings, AlarmRuleSettingsDTO.class));
    }
}
