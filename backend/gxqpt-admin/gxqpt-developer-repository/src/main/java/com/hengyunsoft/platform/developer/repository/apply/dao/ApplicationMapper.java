package com.hengyunsoft.platform.developer.repository.apply.dao;

import com.hengyunsoft.platform.developer.entity.apply.po.Application;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.ApplicationCostAndTimeDO;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.ApplicationDO;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.ApplicationInComeAppDO;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.ApplicationRelationDO;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.ApplicationScreenDO;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.ApplicationVisitCountDO;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.CountOrgApplicationDO;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ApplicationMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.developer.entity.apply.po.Application, com.hengyunsoft.platform.developer.repository.apply.example.ApplicationExample> {
    /**
     * 描述：根据用户Id查找所拥有应用
     * 参数：userId 用户Id
     * 返回值：List<Application> 应用list
     * 修改人：zhaopengfei
     * 修改时间：2018/3/8
     * 修改内容：
     */
    List<Application> selectAppByUserId(@Param("userId") Long userId, @Param("type")Long type);


    /**
     * 根据name查询应用
     * @param name
     * @param userId
     * @return
     */
    List<Application> findAppListByNameAndUserId(@Param("name") String name, @Param("userId") Long userId);

    /**
     * 查询当前管理的所有的应用
     * @param id
     * @param type
     * @return
     */
    List<ApplicationDO> findAppByAdmin(@Param("id") Long id, @Param("type")Long type);

    /**
     * 详情查询
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
     * 查询应用之间的依赖关系
     * @param application
     * @return
     */
    List<ApplicationRelationDO> getApplicationRelation(@Param("appId")Long appId,@Param("name")String name);

    /**
     * 根据appId获取应用信息
     * @param appId
     * @return
     */
    Application getMsgByAppId(String appId);


	List<Application> findAppVisible(@Param("type")Integer type, @Param("userId") Long userId);

    List<Application> findAppVisibleName(@Param("name")String name,@Param("type")Integer type, @Param("userId") Long userId);

    List<Long> findAppIdByUserId(@Param("applicationIdList") List<Long> applicationIdList,@Param("userId") Long userId);

    /**
     *大屏运维监控应用系统访问次数top10
     * @return
     */
    List<ApplicationVisitCountDO> findApplicationVisitCount();

    /**
     * 大屏运维监控调用方应用系统访问次数top10
     * @return
     */
    List<ApplicationVisitCountDO> findConsumerAppApplicationVisitCount();

    /**
     * 2018-5-11
     * 因大屏需求修改应用集成所有接口重写
     * 根据定窑新需求：接入应用查询
     * @return
     */
    List<ApplicationInComeAppDO> findAllIncomeApplication(@Param("top") Integer top);


	List<CountOrgApplicationDO> countOrgApplication(@Param("status") Boolean status);

    List<Application> findAppByCondition();

    /**
     * 运维系统根据appid集合查询应用列表
     * @param param
     * @return
     */
    List<ApplicationDO> findByAppIdList(Map<String,Object> param);

    /**
     * 查询我所管理的所有启用的应用或服务(1：应用；2：服务)
     * @param id
     * @param type
     * @return
     */
    List findAppByAdminWithEnable(@Param("id")Long id, @Param("type")Long type);

    /**
     * 我所管理的编辑应用
     * @param id
     * @param type
     * @return
     */
    List<Application> findAppByAdminEdit(@Param("id")Long id, @Param("type")Long type);
}