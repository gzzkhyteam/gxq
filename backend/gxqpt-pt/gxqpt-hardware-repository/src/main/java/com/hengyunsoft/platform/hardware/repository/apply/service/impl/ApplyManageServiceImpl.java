package com.hengyunsoft.platform.hardware.repository.apply.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.hardware.entity.apply.domain.ApplyManageDO;
import com.hengyunsoft.platform.hardware.entity.apply.po.ApplyManage;
import com.hengyunsoft.platform.hardware.repository.apply.dao.ApplyManageMapper;
import com.hengyunsoft.platform.hardware.repository.apply.example.ApplyManageExample;
import com.hengyunsoft.platform.hardware.repository.apply.service.ApplyManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyManageServiceImpl extends BaseServiceImpl<Long, ApplyManage, ApplyManageExample> implements ApplyManageService {

    @Autowired
    ApplyManageMapper applyManageMapper;

    @Override
    protected BaseNormalDao<Long, ApplyManage, ApplyManageExample> getDao() {
        return applyManageMapper;
    }

    /**
     * 查询审批记录
     * @param applyManage
     * @return
     */
    @Override
    public List<ApplyManageDO> getApprApplyList(ApplyManageDO applyManageDO ) {
        return applyManageMapper.getApprApplyList(applyManageDO);
    }
}
