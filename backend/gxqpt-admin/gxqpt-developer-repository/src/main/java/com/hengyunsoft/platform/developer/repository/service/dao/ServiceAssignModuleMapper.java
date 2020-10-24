package com.hengyunsoft.platform.developer.repository.service.dao;

import com.hengyunsoft.platform.developer.entity.apply.po.domain.ApplicationDO;
import com.hengyunsoft.platform.developer.entity.service.po.domain.QueryConsumAssignModuleInfo;
import com.hengyunsoft.platform.developer.entity.service.po.domain.QueryConsummerAssignModule;
import com.hengyunsoft.platform.developer.entity.service.po.domain.ServiceAssignModuleDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceAssignModuleMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.developer.entity.service.po.ServiceAssignModule, com.hengyunsoft.platform.developer.repository.service.example.ServiceAssignModuleExample> {
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
    List<QueryConsummerAssignModule> page(@Param("assignModule") QueryConsummerAssignModule assignModule,@Param("applist")  List<ApplicationDO> applist);

    /**
     * 查看消费的所有功能，2018-4-11修改，减少返回字段
     * @param assignModule
     * @param applist
     * @return
     */
    List<QueryConsummerAssignModule> findNoPage(@Param("assignModule")QueryConsummerAssignModule assignModule,@Param("applist")  List<ApplicationDO> applist);

    /**
     * 根据id查询功能详情
     * @param id
     * @return
     */
    QueryConsummerAssignModule findMoudleById(@Param("id")Long id);

    /**
     * 2018-5-25根据ID查询功能详情,申请功能时填写的页面字段及值,禅道BUG号2930
     * @param id
     * @return
     */
    QueryConsumAssignModuleInfo findApplyMoudleInfoById(@Param("id")Long id);

    /**
     * 分页查询我的模块消费列表
     * @param moduleId
     * @return
     */
    List<ServiceAssignModuleDO> moduleConsumePage(@Param(value = "moduleId") Long moduleId);
}