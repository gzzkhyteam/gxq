package com.hengyunsoft.platform.ops.repository.alarm.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.ops.entity.alarm.po.AlarmRuleSettings;
import com.hengyunsoft.platform.ops.repository.alarm.dao.AlarmRuleSettingsMapper;
import com.hengyunsoft.platform.ops.repository.alarm.example.AlarmRuleSettingsExample;
import com.hengyunsoft.platform.ops.repository.alarm.service.AlarmRuleSettingsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
@Slf4j
public class AlarmRuleSettingsServiceImpl extends BaseServiceImpl<Long,AlarmRuleSettings,AlarmRuleSettingsExample> implements AlarmRuleSettingsService{
    @Autowired
    private AlarmRuleSettingsMapper alarmRuleSettingsMapper;
    @Override
    protected BaseNormalDao<Long, AlarmRuleSettings, AlarmRuleSettingsExample> getDao() {
        return alarmRuleSettingsMapper;
    }

    @Override
    public List<AlarmRuleSettings> getAlarmPageList(Map map) {
        return alarmRuleSettingsMapper.getAlarmPageList(map);
    }
}
