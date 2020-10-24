package com.hengyunsoft.platform.developer.repository.apply.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.commons.constant.EnableStatus;
import com.hengyunsoft.platform.developer.entity.apply.po.Application;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.*;
import com.hengyunsoft.platform.developer.repository.apply.dao.ApplicationMapper;
import com.hengyunsoft.platform.developer.repository.apply.example.ApplicationExample;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ApplicationServiceImpl extends BaseServiceImpl<Long, Application, ApplicationExample> implements ApplicationService{
    @Autowired
    private ApplicationMapper mapper;

    @Override
    protected BaseNormalDao<Long, Application, ApplicationExample> getDao() {
        return this.mapper;
    }

    /**
     * 描述：根据用户Id查找所拥有应用
     * 参数：userId 用户Id
     * 返回值：List<Application> 应用list
     * 修改人：zhaopengfei
     * 修改时间：2018/3/8
     * 修改内容：
     */
    public List<Application> queryAppByUserId(Long userId, Long type) {
        return mapper.selectAppByUserId(userId,type);
    }

    ;

    @Override
    public Application getAppIdAndAppSecret(String appId, String appSecret) {
        ApplicationExample example = new ApplicationExample();
        example.createCriteria().andAppIdEqualTo(appId)
                .andAppSecretEqualTo(appSecret)
                .andStatusEqualTo(EnableStatus.ENABLE.getVal());
        return mapper.selectEntity(example);
    }

    /**
     * 根据name查询应用
     * @param name
     * @param userId
     * @return
     */
    @Override
    public List<Application> findAppListByNameAndUserId(String name, Long userId) {
        return mapper.findAppListByNameAndUserId(name,userId);
    }

    /**
     * 查询当前管理的所有的应用
     * @param id
     * @param type
     * @return
     */
    @Override
    public List<ApplicationDO> findAppByAdmin(Long id, Long type) {
        return mapper.findAppByAdmin(id,type);
    }

    /**
     * 详情查询
     * @param id
     * @return
     */
    @Override
    public ApplicationDO getDetails(Long id) {
        return mapper.getDetails(id);
    }

    /**
     * 查询指定月份前各应用总数
     * @return
     */
    @Override
    public List<ApplicationScreenDO> getPlatformDev(String strDate) {
        return mapper.getPlatformDev(strDate);
    }

    @Override
    public List<ApplicationCostAndTimeDO> findReduceCostAndTime() {
        return  mapper.findReduceCostAndTime();
    }
    /**
     * farglory
     * 降本提质-组件预估价值统计
     * @return
     */
	@Override
	public List<Map<String,Object>>  findComponentEstimatedValue() {
		return mapper.findComponentEstimatedValue();
	}
	/**
	 * farglory
     * 降本提质-总数统计
     * @return
     */
	@Override
	public List<Map<String, Object>> findTotalStatistics() {
		
		return mapper.findTotalStatistics();
	}


    /**
     * 查询应用之间的依赖关系
     * @param application
     * @return
     */
    @Override
    public List<ApplicationRelationDO> getApplicationRelation(Long appId,String name) {
        return mapper.getApplicationRelation(appId,name);
    }

    /**
     * 根据appId获取应用信息
     * @param appId
     * @return
     */
    @Override
    public Application getMsgByAppId(String appId) {
        return mapper.getMsgByAppId(appId);
    }

	@Override
	public List<Application> findAppVisible(Integer type, Long userId) {
		
		return mapper.findAppVisible(type, userId);
	}

    @Override
    public List<Application> findAppVisibleName(String name, Integer type, Long userId) {
        return mapper.findAppVisibleName(name,type,userId);
    }

    /**
     * 大屏运维监控应用系统访问次数top10
     * @return
     */
    @Override
    public List<ApplicationVisitCountDO> findApplicationVisitCount() {
        return mapper.findApplicationVisitCount();
    }

    /**
     * 大屏运维监控调用方应用系统访问次数top10
     * @return
     */
    @Override
    public List<ApplicationVisitCountDO> findConsumerAppApplicationVisitCount() {
        return mapper.findConsumerAppApplicationVisitCount();
    }

    /**
     * 2018-5-11
     * 因大屏需求修改应用集成所有接口重写
     * 根据定窑新需求：接入应用查询
     * @return
     */
    @Override
    public List<ApplicationInComeAppDO> findAllIncomeApplication(Integer top) {
        return mapper.findAllIncomeApplication(top);
    }

    @Override
    public List<Long> findAppIdByUserId(List<Long> applicationIdList, Long userId) {
        return mapper.findAppIdByUserId(applicationIdList, userId);
    }

	@Override
	public List<CountOrgApplicationDO> countOrgApplication(Boolean status) {
		return mapper.countOrgApplication(status);
    }

    @Override
    public List<Application> findAppByCondition() {
        return mapper.findAppByCondition();
    }

    @Override
    public List<ApplicationDO> findByAppIdList(Map<String, Object> param) {
        return mapper.findByAppIdList(param);
    }

    /**
     * 查询我所管理的所有启用的应用或服务(1：应用；2：服务)
     * @param userId
     * @param type
     * @return
     */
    @Override
    public List findAppByAdminWithEnable(Long userId, Long type) {
        return mapper.findAppByAdminWithEnable(userId,type);
    }

    /**
     * 我所管理的编辑应用
     * @param userId
     * @param type
     * @return
     */
    @Override
    public List<Application> findAppByAdminEdit(Long userId, Long type) {
        return mapper.findAppByAdminEdit(userId, type);
    }
}
