package com.hengyunsoft.platform.mt.repository.appr.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.appr.po.ApprPerson;
import com.hengyunsoft.platform.mt.repository.appr.dao.ApprPersonMapper;
import com.hengyunsoft.platform.mt.repository.appr.example.ApprPersonExample;
import com.hengyunsoft.platform.mt.repository.appr.service.ApprPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprPersonServiceImpl extends BaseServiceImpl<Long, ApprPerson, ApprPersonExample> implements ApprPersonService {
    @Autowired
    private ApprPersonMapper apprPersonMapper;

    @Override
    protected BaseNormalDao<Long, ApprPerson, ApprPersonExample> getDao() {
        return apprPersonMapper;
    }

    @Override
    public ApprPerson getApprApply(long applyId, int userType, int apprUserIndex) {
        List<ApprPerson> apprPersons = apprPersonMapper.getApprPersons(applyId, userType, apprUserIndex);
        if (apprPersons != null && apprPersons.size() > 0) {
            return apprPersons.get(0);
        }
        return null;
    }

    @Override
    public List<ApprPerson> getApprPersons(long applyId, int userType) {
        List<ApprPerson> apprPersons = apprPersonMapper.getApprPersons(applyId, userType, null);
        return apprPersons;
    }
}
