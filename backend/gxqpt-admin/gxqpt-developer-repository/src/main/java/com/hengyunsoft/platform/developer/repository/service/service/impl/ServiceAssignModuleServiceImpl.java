package com.hengyunsoft.platform.developer.repository.service.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hengyunsoft.platform.developer.entity.apply.po.Application;
import com.hengyunsoft.platform.developer.entity.service.po.domain.QueryConsumAssignModuleInfo;
import com.hengyunsoft.platform.developer.entity.service.po.domain.ServiceAssignModuleDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.ApplicationDO;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceAssignModule;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceModule;
import com.hengyunsoft.platform.developer.entity.service.po.domain.QueryConsummerAssignModule;
import com.hengyunsoft.platform.developer.repository.service.dao.ServiceAssignModuleMapper;
import com.hengyunsoft.platform.developer.repository.service.example.ServiceAssignModuleExample;
import com.hengyunsoft.platform.developer.repository.service.service.ServiceAssignModuleService;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述:消费模块实现类
 * @author chb
 * @date 2018/4/3 11:02 
 */
@Service
@Slf4j
public class ServiceAssignModuleServiceImpl extends BaseAllServiceImpl<Long, ServiceAssignModule, ServiceAssignModuleExample> implements ServiceAssignModuleService {
    @Autowired
    private ServiceAssignModuleMapper serviceAssignModuleMapper;

    @Override
    protected BaseNormalDao<Long, ServiceAssignModule, ServiceAssignModuleExample> getDao() {
        return serviceAssignModuleMapper;
    }

    /**
     *查看我某个应用所消费的所有功能
     * @param assignModule
     * @return
     */
    @Override
    public List<QueryConsummerAssignModule> pageMy(QueryConsummerAssignModule assignModule) {
        return serviceAssignModuleMapper.pageMy(assignModule);
    }

    /**
     * 查看我消费的所有功能
     * @param assignModule
     * @param applist
     * @return
     */
    @Override
    public List<QueryConsummerAssignModule> page(QueryConsummerAssignModule assignModule, List<ApplicationDO> applist) {
        return serviceAssignModuleMapper.page(assignModule,applist);
    }

    /**
     * 查看消费的所有功能，2018-4-11修改，减少返回字段
     * @param assignModule
     * @param applist
     * @return
     */
    @Override
    public List<QueryConsummerAssignModule> findNoPage(QueryConsummerAssignModule assignModule, List<ApplicationDO> applist) {
        return serviceAssignModuleMapper.findNoPage(assignModule,applist);
    }

    /**
     * 根据id查询功能详情
     * @param id
     * @return
     */
    @Override
    public QueryConsummerAssignModule findMoudleById(Long id) {
        return serviceAssignModuleMapper.findMoudleById(id);
    }

    /**
     * 2018-5-25根据ID查询功能详情,申请功能时填写的页面字段及值,禅道BUG号2930
     * @param id
     * @return
     */
    @Override
    public QueryConsumAssignModuleInfo findApplyMoudleInfoById(Long id) {
        return serviceAssignModuleMapper.findApplyMoudleInfoById(id);
    }

	@Override
	public List<Long> getConsumerModuleIdsUsable(String consumerAppId) {
		
		
		ServiceAssignModuleExample example = new ServiceAssignModuleExample();
		example.createCriteria().andAppIdEqualTo(consumerAppId).andStatusEqualTo(true);
		List<ServiceAssignModule> assignModule = super.find(example );
		if(CollectionUtils.isEmpty(assignModule)) {
			return Collections.EMPTY_LIST ;
		}
		List<Long> moduleIds = new ArrayList<>(assignModule.size());
		for (ServiceAssignModule serviceAssignModule : assignModule) {
			moduleIds.add(serviceAssignModule.getModuleId());
		}
		return moduleIds;
	}

    @Override
    public List<ServiceAssignModuleDO> moduleConsumePage(Long moduleId) {
        return serviceAssignModuleMapper.moduleConsumePage(moduleId);
    }
}
