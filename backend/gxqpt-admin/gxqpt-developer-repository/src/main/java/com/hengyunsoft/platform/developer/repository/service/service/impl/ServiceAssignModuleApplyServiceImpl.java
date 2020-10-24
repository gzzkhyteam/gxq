package com.hengyunsoft.platform.developer.repository.service.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.apply.po.ServiceAssignModuleApply;
import com.hengyunsoft.platform.developer.repository.apply.dao.ServiceAssignModuleApplyMapper;
import com.hengyunsoft.platform.developer.repository.apply.example.ServiceAssignModuleApplyExample;
import com.hengyunsoft.platform.developer.repository.service.service.ServiceAssignModuleApplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:模块申实现类
 * @author chb
 * @date 2018/4/3 11:02 
 */
@Service
@Slf4j
public class ServiceAssignModuleApplyServiceImpl extends BaseAllServiceImpl<Long, ServiceAssignModuleApply, ServiceAssignModuleApplyExample> implements ServiceAssignModuleApplyService {
    @Autowired
    private ServiceAssignModuleApplyMapper serviceAssignModuleApplyMapper;

    @Override
    protected BaseNormalDao<Long, ServiceAssignModuleApply, ServiceAssignModuleApplyExample> getDao() {
        return serviceAssignModuleApplyMapper;
    }

    /**
     * 获取模块个人申请分页数据
     * @param apply
     * @return
     */
    @Override
    public List<ServiceAssignModuleApply> findMyApply(ServiceAssignModuleApply apply) {
        return serviceAssignModuleApplyMapper.findMyApply(apply);
    }

    @Override
    public List<ServiceAssignModuleApply> getByModuleId(Long modId) {
        return serviceAssignModuleApplyMapper.getByModuleId(modId);
    }
}
