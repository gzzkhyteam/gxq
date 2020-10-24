package com.hengyunsoft.platform.security.repository.interfaces.dao;


import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceConfig;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceConfigMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceConfig, com.hengyunsoft.platform.security.repository.interfaces.example.InterfaceConfigExample> {

    /**
     * 查询接口列表
     *
     * @param appid   模块id（必传）
     * @param status  设置状态
     * @param apiName 接口名称（模糊查询）
     * @return List
     * @author yxl
     */
    List pageApiList(@Param("param") Map param);

    /**
     * 批量更新接口阀值限制信息
     *
     * @param apiIdList       待更新的 接口ID 列表
     * @param interfaceConfig 接口阀值及操作人信息
     * @return List
     * @author yxl
     */
    int updateApiAccessLimitList(@Param("apiIdList") List<Long> apiIdList, @Param("interfaceConfig") InterfaceConfig interfaceConfig);


    List<Long> findNeedFilter();

    int saveOrUpdate(InterfaceConfig interfaceConfig);

    /**
     * 获取接口列表
     * @param apiIdSet 接口id 集合
     * @return List
     * @author yxl
     */
    List getInterfaceConfigList(@Param("apiIdSet") Set<Long> apiIdSet);
    /**
     * 获取接口列表
     * @param apiIdSet 接口id 集合
     * @return List
     * @author yxl
     */
    List pageInterfaceConfigList(@Param("apiIdList")List<Set<Long>> apiIdList);
}