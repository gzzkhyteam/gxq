package com.hengyunsoft.platform.mt.repository.appr.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.appr.po.ApprApply;
import com.hengyunsoft.platform.mt.repository.appr.dao.ApprApplyMapper;
import com.hengyunsoft.platform.mt.repository.appr.example.ApprApplyExample;
import com.hengyunsoft.platform.mt.repository.appr.service.ApprApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ApprApplyServiceImpl extends BaseServiceImpl<Long, ApprApply, ApprApplyExample> implements ApprApplyService {
    @Autowired
    private ApprApplyMapper apprApplyMapper;

    @Override
    protected BaseNormalDao<Long, ApprApply, ApprApplyExample> getDao() {
        return apprApplyMapper;
    }

    @Override
    public List<ApprApply> findPageMyApplyList(Map<String, Object> param) {
        return apprApplyMapper.findPageMyApplyList(param);
    }

    @Override
    public List<ApprApply> findPageSendMeApplyList(Map<String, Object> param) {
        return  apprApplyMapper.findPageSendMeApplyList(param);
    }

    @Override
    public List<ApprApply> findPageCurSendMeApplyList(Map<String, Object> param) {
        return apprApplyMapper.findPageCurSendMeApplyList(param);
    }

    @Override
    public List<ApprApply> findPagePassSendMeApplyList(Map<String, Object> param) {
        return apprApplyMapper.findPagePassSendMeApplyList(param);
    }

    @Override
    public ApprApply findLastApplyByAprType(Long userId,String unitId, String aprType) {
        return apprApplyMapper.findLastApplyByAprType(userId,unitId,aprType);
    }

    @Override
    public int getCurSendMeApplyCount(Long userId, String unitId) {
        return apprApplyMapper.getCurSendMeApplyCount(userId,unitId);
    }
}
