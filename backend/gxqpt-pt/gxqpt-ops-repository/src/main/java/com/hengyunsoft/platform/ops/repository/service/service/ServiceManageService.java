package com.hengyunsoft.platform.ops.repository.service.service;

import java.util.List;
import java.util.Map;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.ops.entity.alarm.po.domain.ServiceManageAlarmDO;
import com.hengyunsoft.platform.ops.entity.service.po.ServiceManage;
import com.hengyunsoft.platform.ops.repository.service.example.ServiceManageExample;

public interface ServiceManageService extends BaseService<Long,ServiceManage,ServiceManageExample>{

    /**
     * 查询服务管理分页信息
     * @param map
     * @return
     */
    List<ServiceManage> getPageList(Map map);

    /**
     * 查询服务审核分页信息
     * @param map
     * @return
     */
    List<ServiceManage> getAuditList(Map map);
    /**
     * 查询服务处理分页信息
     * @param map
     * @return
     */
    List<ServiceManage> getDealList(Map map);

    /**
     * 查询当前用户负责的服务处理分页信息
     * @param map
     * @return
     */
    List<ServiceManage> getByDealUserList(Map map);


    /**
     * 查询当前时间下待审核运维服务申请信息
     * @param
     * @return
     */
    List<ServiceManageAlarmDO> findServiceAudit();


    /**
     * 查询当前时间下未处理运维服务申请信息
     * @param
     * @return
     */
    List<ServiceManageAlarmDO> findServiceDeal();


    /**
     * 查询当前时间下待审核运维培训申请信息
     * @param
     * @return
     */
    List<ServiceManageAlarmDO> findTrainAudit();


    /**
     * 查询当前时间下未处理运维培训申请信息
     * @param
     * @return
     */
    List<ServiceManageAlarmDO> findTrainDeal();


    /**
     * 查询当前时间下待审核运维咨询申请信息
     * @param
     * @return
     */
    List<ServiceManageAlarmDO> findConsultAudit();


    /**
     * 查询当前时间下未处理运维咨询申请信息
     * @param
     * @return
     */
    List<ServiceManageAlarmDO> findConsultDeal();



}
