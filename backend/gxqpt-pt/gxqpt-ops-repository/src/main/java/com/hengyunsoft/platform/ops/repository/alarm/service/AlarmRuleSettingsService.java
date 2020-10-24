package com.hengyunsoft.platform.ops.repository.alarm.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.ops.entity.alarm.po.AlarmRuleSettings;
import com.hengyunsoft.platform.ops.repository.alarm.example.AlarmRuleSettingsExample;

import java.util.List;
import java.util.Map;

public interface AlarmRuleSettingsService extends BaseService<Long,AlarmRuleSettings,AlarmRuleSettingsExample>{
    /**
     * 查询告警规则设置分页信息
     * @param
     */
    List<AlarmRuleSettings> getAlarmPageList(Map map);

}
