package com.hengyunsoft.platform.developer.repository.service.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.developer.entity.apply.po.ServiceAssignModuleApply;
import com.hengyunsoft.platform.developer.repository.apply.example.ServiceAssignModuleApplyExample;

import java.util.List;

/**
 * 描述:模块申请Service
 * @author chb
 * @date 2018/4/3 10:59 
 */
public interface ServiceAssignModuleApplyService extends BaseService<Long, ServiceAssignModuleApply, ServiceAssignModuleApplyExample> {
    /**
     * 获取模块个人申请分页数据
     * @param apply
     * @return
     */
    List<ServiceAssignModuleApply> findMyApply(ServiceAssignModuleApply apply);

    /**
     * 根据模块Id查询功能申请信息
     * @param modId
     * @return
     */
    List<ServiceAssignModuleApply> getByModuleId(Long modId);
}
