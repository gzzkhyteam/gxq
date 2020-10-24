package com.hengyunsoft.platform.hardware.repository.apply.dao;

import com.hengyunsoft.platform.hardware.entity.apply.domain.ApplyManageDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyManageMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.hardware.entity.apply.po.ApplyManage, com.hengyunsoft.platform.hardware.repository.apply.example.ApplyManageExample> {

    /**
     * 查询审批记录
     * @param applyManage
     * @return
     */
    List<ApplyManageDO> getApprApplyList(ApplyManageDO applyManageDO);
}