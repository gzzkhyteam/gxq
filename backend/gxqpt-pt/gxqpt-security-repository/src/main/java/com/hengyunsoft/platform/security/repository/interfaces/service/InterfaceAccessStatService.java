package com.hengyunsoft.platform.security.repository.interfaces.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceAccessStat;
import com.hengyunsoft.platform.security.repository.interfaces.example.InterfaceAccessStatExample;
import java.util.List;

/**
 * 服务访问量统计接口
 * @author yxl
 * @createTime 2018-06-29
 */
public interface InterfaceAccessStatService extends BaseService<Long,InterfaceAccessStat, InterfaceAccessStatExample> {
    /**
     * 获取访问量统计结果
     * @param interfaceConfigId 接口ID
     * @param statDate 统计日期
     * @return List<Map<stat_hour,stat_sum>>
     */
    List getApiAccessStatisticList(Long interfaceConfigId,String statDate);
}
