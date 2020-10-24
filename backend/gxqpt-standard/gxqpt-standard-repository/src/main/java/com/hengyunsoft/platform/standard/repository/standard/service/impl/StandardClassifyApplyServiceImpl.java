package com.hengyunsoft.platform.standard.repository.standard.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.standard.entity.standard.po.StandardClassifyApply;
import com.hengyunsoft.platform.standard.repository.standard.dao.StandardClassifyApplyMapper;
import com.hengyunsoft.platform.standard.repository.standard.example.StandardClassifyApplyExample;
import com.hengyunsoft.platform.standard.repository.standard.service.StandardClassifyApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandardClassifyApplyServiceImpl extends BaseAllServiceImpl<Long, StandardClassifyApply, StandardClassifyApplyExample> implements StandardClassifyApplyService {
    @Autowired
    private StandardClassifyApplyMapper standardClassifyApplyMapper;

    @Override
    protected BaseNormalDao<Long, StandardClassifyApply, StandardClassifyApplyExample> getDao() {
        return standardClassifyApplyMapper;
    }

}
