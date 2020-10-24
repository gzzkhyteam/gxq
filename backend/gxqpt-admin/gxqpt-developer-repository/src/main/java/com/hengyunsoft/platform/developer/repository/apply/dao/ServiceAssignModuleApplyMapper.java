package com.hengyunsoft.platform.developer.repository.apply.dao;

import com.hengyunsoft.platform.developer.entity.apply.po.ServiceAssignModuleApply;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceAssignModuleApplyMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.developer.entity.apply.po.ServiceAssignModuleApply, com.hengyunsoft.platform.developer.repository.apply.example.ServiceAssignModuleApplyExample> {
    /**
     * 获取模块个人申请分页数据
     * @param apply
     * @return
     */
    List<ServiceAssignModuleApply> findMyApply(ServiceAssignModuleApply apply);

    List<ServiceAssignModuleApply> getByModuleId(Long modId);
}