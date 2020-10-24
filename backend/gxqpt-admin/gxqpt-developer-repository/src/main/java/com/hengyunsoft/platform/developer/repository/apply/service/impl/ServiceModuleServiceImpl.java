package com.hengyunsoft.platform.developer.repository.apply.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceModule;
import com.hengyunsoft.platform.developer.entity.service.po.domain.ModuleCountDO;
import com.hengyunsoft.platform.developer.entity.service.po.domain.ModuleRelationDO;
import com.hengyunsoft.platform.developer.entity.service.po.domain.ModuleRelationLinksDO;
import com.hengyunsoft.platform.developer.repository.apply.service.ServiceModuleService;
import com.hengyunsoft.platform.developer.repository.service.dao.ServiceModuleMapper;
import com.hengyunsoft.platform.developer.repository.service.example.ServiceModuleExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ServiceModuleServiceImpl
        extends BaseServiceImpl<Long, ServiceModule, ServiceModuleExample>
        implements ServiceModuleService {

        @Autowired
        private ServiceModuleMapper serviceModuleMapper;

        @Override
        protected BaseNormalDao<Long, ServiceModule, ServiceModuleExample> getDao() {
            return serviceModuleMapper;
        }

        @Override
        public List<ServiceModule> selectListByUserId(Long userId) {
            return serviceModuleMapper.selectListByUserId(userId);
        }

        @Override
        public void update(ServiceModule serviceModule) {
            serviceModuleMapper.update(serviceModule);
        }

        @Override
        public List<ServiceModule> getByAppId(String appId) {
            return serviceModuleMapper.selectByAppId(appId);
        }

    /**
     * 查询功能按类型分类统计数量
     * @param top
     * @return
     */
    @Override
        public List<ModuleCountDO> getModuleCount(Integer top) {
            return serviceModuleMapper.getModuleCount(top);
        }

    @Override
    public List<ServiceModule> findModuleName(Integer pageSize) {
        return  serviceModuleMapper.findModuleName(pageSize);
    }

    /**
     * 查询功能应用关系-力引导布局数据
     * @return
     */
    @Override
    public List<ModuleRelationDO> getNodesDate() {
        return serviceModuleMapper.getNodesDate();
    }

    /**
     * 查询功能应用关系-力引导布局数据 links
     * @return
     */
    @Override
    public List<ModuleRelationLinksDO> getLinksDate() {
        return serviceModuleMapper.getLinksDate();
    }
    /**
     * farglory
     * 降本提质-获取功能模块数
     * @return
     */
	@Override
	public List<Map<String, Object>> findComponentEstimatedValue() {

		return serviceModuleMapper.findComponentEstimatedValue();
	}
	/**
	 * farglory
     * 降本提质-总数统计
     * @return
     */
	@Override
	public List<Map<String, Object>> findTotalStatistics() {

		return serviceModuleMapper.findTotalStatistics();
	}


    /**
     * 查询热门功能
     * @param top
     * @return
     */
    @Override
    public List<ServiceModule> hotModule(Integer top, boolean isLogin) {
        return serviceModuleMapper.hotModule(top,isLogin);
    }

    /**
     * 2018-5-30增加返回模块类型名称
     * @param serviceModule
     * @return
     */
    @Override
    public List<ServiceModule> findAllServiceModule(ServiceModule serviceModule, boolean isLogin) {
        return serviceModuleMapper.findAllServiceModule(serviceModule, isLogin);
    }

    @Override
    public List<Map<String, Object>> getServerUseTop() {
        return serviceModuleMapper.getServerUseTop();
    }

    @Override
    public List<Map<String, Object>> getMonthInvokingTop() {
        return serviceModuleMapper.getMonthInvokingTop();
    }

    @Override
    public List<Map<String, Object>> getMonthAppTop() {
        return serviceModuleMapper.getMonthAppTop();
    }
}
