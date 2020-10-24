package com.hengyunsoft.platform.developer.repository.service.service;

import java.util.List;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.ApplicationDO;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceAssignModule;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceModule;
import com.hengyunsoft.platform.developer.entity.service.po.domain.QueryConsumAssignModuleInfo;
import com.hengyunsoft.platform.developer.entity.service.po.domain.QueryConsummerAssignModule;
import com.hengyunsoft.platform.developer.entity.service.po.domain.ServiceAssignModuleDO;
import com.hengyunsoft.platform.developer.repository.service.example.ServiceAssignModuleExample;

/**
 * 描述:消费模块Service
 * @author chb
 * @date 2018/4/3 10:59 
 */
public interface ServiceAssignModuleService extends BaseService<Long, ServiceAssignModule, ServiceAssignModuleExample> {
    /**
     *查看我某个应用所消费的所有功能
     * @param assignModule
     * @return
     */
    List<QueryConsummerAssignModule> pageMy(QueryConsummerAssignModule assignModule);

    /**
     * 查看我消费的所有功能
     * @param assignModule
     * @param applist
     * @return
     */
    List<QueryConsummerAssignModule> page(QueryConsummerAssignModule assignModule, List<ApplicationDO> applist);

    /**
     * 查看消费的所有功能，2018-4-11修改，减少返回字段
     * @param assignModule
     * @param applist
     * @return
     */
    List<QueryConsummerAssignModule> findNoPage(QueryConsummerAssignModule assignModule, List<ApplicationDO> applist);

    /**
     * 根据id查询功能详情
     * @param id
     * @return
     */
    QueryConsummerAssignModule findMoudleById(Long id);

    /**
     * 2018-5-25根据ID查询功能详情,申请功能时填写的页面字段及值,禅道BUG号2930
     * @param id
     * @return
     */
    QueryConsumAssignModuleInfo findApplyMoudleInfoById(Long id);

    /**
     * 获取指定消费者可用消费的所有模块id
     * 
     * @param consumerAppId
     * @return
     */
	List<Long> getConsumerModuleIdsUsable(String consumerAppId);

    /**
     * 分页查询我的模块消费列表
     * @param moduleId
     * @return
     */
    List<ServiceAssignModuleDO> moduleConsumePage(Long moduleId);
}
