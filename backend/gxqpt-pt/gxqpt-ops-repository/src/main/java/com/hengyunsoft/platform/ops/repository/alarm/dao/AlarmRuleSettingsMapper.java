package com.hengyunsoft.platform.ops.repository.alarm.dao;

import com.hengyunsoft.platform.ops.entity.alarm.po.AlarmRuleSettings;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AlarmRuleSettingsMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.ops.entity.alarm.po.AlarmRuleSettings, com.hengyunsoft.platform.ops.repository.alarm.example.AlarmRuleSettingsExample> {
    /**
     * 查询告警规则设置分页信息
     * @param
     */
    List<AlarmRuleSettings> getAlarmPageList(Map map);
}