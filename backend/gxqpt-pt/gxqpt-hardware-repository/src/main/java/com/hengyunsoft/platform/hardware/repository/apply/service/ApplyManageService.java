package com.hengyunsoft.platform.hardware.repository.apply.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.hardware.entity.apply.domain.ApplyManageDO;
import com.hengyunsoft.platform.hardware.entity.apply.po.ApplyManage;
import com.hengyunsoft.platform.hardware.repository.apply.example.ApplyManageExample;

import java.util.List;

public interface ApplyManageService extends BaseService<Long, ApplyManage, ApplyManageExample> {

    /**
     * 查询审批记录
     * @param applyManage
     * @return
     */
    List<ApplyManageDO> getApprApplyList(ApplyManageDO applyManageDO );
}
