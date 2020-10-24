package com.hengyunsoft.platform.ops.repository.service.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.ops.entity.alarm.po.domain.ServiceManageAlarmDO;
import com.hengyunsoft.platform.ops.entity.service.po.ServiceManage;
import com.hengyunsoft.platform.ops.repository.service.dao.ServiceManageMapper;
import com.hengyunsoft.platform.ops.repository.service.example.ServiceManageExample;
import com.hengyunsoft.platform.ops.repository.service.service.ServiceManageService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ServiceManageServiceImpl extends BaseServiceImpl<Long,ServiceManage,ServiceManageExample> implements ServiceManageService{

    @Autowired
    private ServiceManageMapper serviceManageMapper;
    @Override
    protected BaseNormalDao<Long, ServiceManage, ServiceManageExample> getDao() {
        return serviceManageMapper;
    }

    @Override
    public List<ServiceManage> getPageList(Map map) {
        return serviceManageMapper.getPageList(map);
    }

    @Override
    public List<ServiceManage> getAuditList(Map map) {
        return serviceManageMapper.getAuditList(map);
    }

    @Override
    public List<ServiceManage> getDealList(Map map) {
        return serviceManageMapper.getDealList(map);
    }

    @Override
    public List<ServiceManage> getByDealUserList(Map map) {
        return serviceManageMapper.getByDealUserList(map);
    }

    @Override
    public List<ServiceManageAlarmDO> findServiceAudit() {
        return serviceManageMapper.findServiceAudit();
    }

    @Override
    public List<ServiceManageAlarmDO> findServiceDeal() {
        return serviceManageMapper.findServiceDeal();
    }

    @Override
    public List<ServiceManageAlarmDO> findTrainAudit() {
        return serviceManageMapper.findTrainAudit();
    }

    @Override
    public List<ServiceManageAlarmDO> findTrainDeal() {
        return serviceManageMapper.findTrainDeal();
    }

    @Override
    public List<ServiceManageAlarmDO> findConsultAudit() {
        return serviceManageMapper.findConsultAudit();
    }

    @Override
    public List<ServiceManageAlarmDO> findConsultDeal() {
        return serviceManageMapper.findConsultDeal();
    }


}
