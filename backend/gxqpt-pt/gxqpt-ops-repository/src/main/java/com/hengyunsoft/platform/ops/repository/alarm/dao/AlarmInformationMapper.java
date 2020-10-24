package com.hengyunsoft.platform.ops.repository.alarm.dao;

import com.hengyunsoft.platform.ops.entity.alarm.po.AlarmInformation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AlarmInformationMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, AlarmInformation, com.hengyunsoft.platform.ops.repository.alarm.example.AlarmInformationExample> {
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
}