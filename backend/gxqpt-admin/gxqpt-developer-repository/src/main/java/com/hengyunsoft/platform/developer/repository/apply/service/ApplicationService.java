package com.hengyunsoft.platform.developer.repository.apply.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.developer.entity.apply.po.Application;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.*;
import com.hengyunsoft.platform.developer.repository.apply.example.ApplicationExample;

import java.util.List;
import java.util.Map;

public interface ApplicationService extends BaseService<Long, Application, ApplicationExample> {
	
	/**
	 * 应用类型字典编码 ---- 接入应用
	 */
	static final String JRYY_TYPE_CODE = "jryy";
	/**
	 * 应用类型字典编码 ---- 支撑平台
	 */
	static final String ZCPT_TYPE_CODE = "zcpt";
	/**
	 * 应用类型字典编码 ---- 支撑服务
	 */
	static final String ZCFW_TYPE_CODE = "zcfw";
	/**
	 * 应用类型字典编码 ---- 支撑服务模块
	 */
	static final String ZCFWMK_TYPE_CODE = "zcfwmk";
	/**
	 * 应用类型字典编码 ---- 支撑应用
	 */
	static final String ZCYY_TYPE_CODE = "zcyy";
    /**
     * 描述：根据用户Id查找所拥有应用
     * 参数：userId 用户Id
     * 返回值：List<Application> 应用list
     * 修改人：zhaopengfei
     * 修改时间：2018/3/8
     * 修改内容：
     */
    List<Application> queryAppByUserId(Long userId, Long type);

    /**
     * 查询可用的应用
     * @param appId
     * @param appSecret
     * @return
     */
    Application getAppIdAndAppSecret(String appId, String appSecret);

    /**
     * 根据name查询应用
     * @param name
     * @param userId
     * @return
     */
    List<Application> findAppListByNameAndUserId(String name, Long userId);

    /**
     * 查询当前管理的所有的应用
     * @param id
     * @param type
     * @return
     */
    List<ApplicationDO> findAppByAdmin(Long id, Long type);

    /**
     * 获取应用的详情
     * @param id
     * @return
     */
    ApplicationDO getDetails(Long id);



    /**
     * 查询指定月份前各应用总数
     * @return
     */
    List<ApplicationScreenDO> getPlatformDev(String strDate);


    /**
     * 统计可降低成本与时间
     * @return
     */
    List<ApplicationCostAndTimeDO> findReduceCostAndTime();
    /**
     * farglory
     * 降本提质-组件预估价值统计
     * @return
     */
	List<Map<String,Object>>  findComponentEstimatedValue();
	
	/**
	 * farglory
     * 降本提质-总数统计
     * @return
     */
	List<Map<String, Object>> findTotalStatistics();

    /**
     * 查询应用之间依赖关系
     * @param appId
     * @return
     */
    List<ApplicationRelationDO> getApplicationRelation(Long appId,String name);

    /**
     * 根据appId获取应用信息
     * @param appId
     * @return
     */
    Application getMsgByAppId(String appId);

	List<Application> findAppVisible(Integer type, Long userId);

    List<Application> findAppVisibleName(String name,Integer type, Long userId);

    /**
     * 查询用户拥有的指定应用集合中的应用id
     * @param applicationIdList 应用集合
     * @param userId 用户id
     */
    List<Long> findAppIdByUserId(List<Long> applicationIdList, Long userId);

    /**
     *大屏运维监控应用系统访问次数top10
     * @return
     */
    List<ApplicationVisitCountDO> findApplicationVisitCount();

    /**
     *大屏运维监控调用方应用系统访问次数top10
     * @return
     */
    List<ApplicationVisitCountDO> findConsumerAppApplicationVisitCount();

    /**
     * 2018-5-11
     * 因大屏需求修改应用集成所有接口重写
     * 根据定窑新需求：接入应用查询
     * @return
     */
    List<ApplicationInComeAppDO> findAllIncomeApplication(Integer top);

    /**
     * 统计查单位应用数量
     * @param status 查询是否启用的应用    null表示查询所有
     * @author 潘定遥
     * @return  
     */
	List<CountOrgApplicationDO> countOrgApplication(Boolean status);

    /**
     * 查询非 支撑服务(zcfw)，支撑服务模块(zcfwmk) 之外应用
     * @return
     */
    List<Application> findAppByCondition();

    /**
     * 运维系统根据appid集合查询应用列表
     * @param param
     * @return
     */
    List<ApplicationDO> findByAppIdList(Map<String,Object> param);

    /**
     * 查询我所管理的所有启用的应用或服务(1：应用；2：服务)
     * @param userId
     * @param type
     * @return
     */
    List findAppByAdminWithEnable(Long userId, Long type);

    /**
     * 我所管理的编辑应用
     * @param userId
     * @param type
     * @return
     */
    List<Application> findAppByAdminEdit(Long userId, Long type);
}
