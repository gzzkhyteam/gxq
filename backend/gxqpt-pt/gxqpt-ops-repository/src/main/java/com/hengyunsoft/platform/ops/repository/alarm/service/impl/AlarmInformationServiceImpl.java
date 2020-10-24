package com.hengyunsoft.platform.ops.repository.alarm.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.ops.entity.alarm.po.AlarmInformation;
import com.hengyunsoft.platform.ops.repository.alarm.dao.AlarmInformationMapper;
import com.hengyunsoft.platform.ops.repository.alarm.example.AlarmInformationExample;
import com.hengyunsoft.platform.ops.repository.alarm.service.AlarmInformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
@Slf4j
public class AlarmInformationServiceImpl extends BaseServiceImpl<Long,AlarmInformation,AlarmInformationExample> implements AlarmInformationService{
    @Autowired
    private AlarmInformationMapper alarmInformationMapper;
    @Override
    protected BaseNormalDao<Long, AlarmInformation, AlarmInformationExample> getDao() {
        return alarmInformationMapper;
    }

    @Override
    public List<AlarmInformation> getAlarmInfoPageList(Map map) {
        return alarmInformationMapper.getAlarmInfoPageList(map);
    }

    @Override
    public List<AlarmInformation> getAlarmInfo(Map map) {
        return alarmInformationMapper.getAlarmInfo(map);
    }

    @Override
    public void batchSave(List<AlarmInformation> alarmInformationList) {
        alarmInformationMapper.batchInsert(alarmInformationList);
    }
}
