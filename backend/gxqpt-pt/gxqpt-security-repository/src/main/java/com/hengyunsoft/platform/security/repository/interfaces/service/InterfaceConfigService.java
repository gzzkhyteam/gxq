package com.hengyunsoft.platform.security.repository.interfaces.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.security.entity.interfaces.domain.ServiceResource;
import com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceConfig;
import com.hengyunsoft.platform.security.repository.interfaces.example.InterfaceConfigExample;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface InterfaceConfigService extends BaseService<Long,InterfaceConfig,InterfaceConfigExample> {
    /**
     * 查询接口列表
     * @author yxl
     * @param param contain appid 模块id（必传）、status 设置状态、apiName 接口名称（模糊查询）
     * @return List
     */
    List pageApiList(Map param);

    /**
     * 批量更新接口阀值限制信息
     * @author yxl
     * @param apiIdList 待更新的 接口ID 列表
     * @param interfaceConfig 接口阀值及操作人信息
     * @return List
     */
    int updateApiAccessLimitList(List apiIdList,InterfaceConfig interfaceConfig);

    List<Long> findNeedFilter();

    void batchSaveOrUpdate(List<InterfaceConfig> configList);

    List<ServiceResource> findAllServiceResource();

    /**
     * 获取接口列表
     * @param apiIdSet 接口id 集合
     * @return List
     * @author yxl
     */
    List getInterfaceConfigList(Set<Long> apiIdSet);

    /**
     * 获取接口列表
     * @param apiIdSet 接口id 集合
     * @return List
     * @author yxl
     */
    List pageInterfaceConfigList(List<Set<Long>> apiIdList);
}
