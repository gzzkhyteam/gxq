package com.hengyunsoft.platform.developer.repository.service.dao;

import com.hengyunsoft.platform.developer.entity.service.po.ServiceModule;
import com.hengyunsoft.platform.developer.entity.service.po.domain.ModuleCountDO;
import com.hengyunsoft.platform.developer.entity.service.po.domain.ModuleRelationDO;
import com.hengyunsoft.platform.developer.entity.service.po.domain.ModuleRelationLinksDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ServiceModuleMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.developer.entity.service.po.ServiceModule, com.hengyunsoft.platform.developer.repository.service.example.ServiceModuleExample> {

    List<ServiceModule> selectListByUserId(Long userId);

    void update(ServiceModule serviceModule);

    List<ServiceModule> selectByAppId(String appId);

    /**
     * 功能按类型分类统计数量
     * @param top
     * @return
     */
    List<ModuleCountDO> getModuleCount(@Param("top") Integer top);

    /**
     * 查询模块名称
     * @param pageSize
     * @return
     */
    List<ServiceModule> findModuleName(@Param("pageSize")Integer pageSize);

    /**
     * 查询功能应用关系-力引导布局数据
     * @return
     */
    List<ModuleRelationDO> getNodesDate();

    /**
     * 查询功能应用关系-力引导布局数据 links
     * @return
     */
    List<ModuleRelationLinksDO> getLinksDate();

    /**
     * farglory
     * 降本提质-获取功能模块数
     * @return
     */
	List<Map<String, Object>> findComponentEstimatedValue();

	/**
	 * farglory
     * 降本提质-总数统计
     * @return
     */
	List<Map<String, Object>> findTotalStatistics();

    /**
     * 查询热门功能
     * @param top
     * @param isLogin 
     * @return
     */
    List<ServiceModule> hotModule(@Param("top")Integer top,@Param("isLogin") boolean isLogin);

    /**
     * 2018-5-30增加返回模块类型名称
     * @param serviceModule
     * @param isLogin 
     * @return
     */
    List<ServiceModule> findAllServiceModule(@Param("serviceModule") ServiceModule serviceModule,@Param("isLogin") boolean isLogin);

    /**
     * 根据服务查询对外接口使用top10
     * @return
     */
    List<Map<String,Object>> getServerUseTop();

    /**
     * 查询对外接口使用top5
     * @return
     */
    List<Map<String,Object>> getMonthInvokingTop();

    /**
     * 根据应用查询对外接口使用top5
     * @return
     */
    List<Map<String,Object>> getMonthAppTop();
}