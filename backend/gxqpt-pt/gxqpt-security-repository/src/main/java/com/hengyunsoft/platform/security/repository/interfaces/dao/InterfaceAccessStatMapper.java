package com.hengyunsoft.platform.security.repository.interfaces.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceAccessStat;

@Repository
public interface InterfaceAccessStatMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceAccessStat, com.hengyunsoft.platform.security.repository.interfaces.example.InterfaceAccessStatExample> {
    /**
     * 获取访问量统计结果
     * @param apiId 接口ID
     * @param statDate 统计日期
     * @return List<Map<stat_hour,stat_sum>>
     */
    List getApiAccessStatisticList(@Param("interfaceConfigId")Long interfaceConfigId, @Param("statDate") String statDate);

    int saveOrUpdate(InterfaceAccessStat accessStat);
}