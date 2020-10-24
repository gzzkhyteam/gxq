package com.hengyunsoft.platform.ops.repository.alarm.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.ops.entity.alarm.po.AlarmInformation;
import com.hengyunsoft.platform.ops.repository.alarm.example.AlarmInformationExample;

import java.util.List;
import java.util.Map;

public interface AlarmInformationService extends BaseService<Long,AlarmInformation,AlarmInformationExample> {
    /**
     * 查询告警列表分页信息
     * @param
     */
    List<AlarmInformation> getAlarmInfoPageList(Map map);

    /**
     * 首页查询告警列表分页信息
     * @param
     */
    List<AlarmInformation> getAlarmInfo(Map map);
    /**
     * 批量保存告警信息
     * @param
     */
    void  batchSave(List<AlarmInformation> alarmInformationList);
}
