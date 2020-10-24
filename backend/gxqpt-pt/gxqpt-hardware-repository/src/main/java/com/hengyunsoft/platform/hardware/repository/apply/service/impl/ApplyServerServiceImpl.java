package com.hengyunsoft.platform.hardware.repository.apply.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.hardware.entity.apply.domain.ApplyServerDO;
import com.hengyunsoft.platform.hardware.entity.apply.po.ApplyServer;
import com.hengyunsoft.platform.hardware.repository.apply.dao.ApplyServerMapper;
import com.hengyunsoft.platform.hardware.repository.apply.example.ApplyServerExample;
import com.hengyunsoft.platform.hardware.repository.apply.service.ApplyServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyServerServiceImpl extends BaseServiceImpl<Long, ApplyServer, ApplyServerExample> implements ApplyServerService {

    @Autowired
    ApplyServerMapper applyServerMapper;

    @Override
    protected BaseNormalDao<Long, ApplyServer, ApplyServerExample> getDao() {
        return applyServerMapper;
    }

    @Override
    public int deleteByApplyKeyId(Long id) {
        return applyServerMapper.deleteByApplyKeyId(id);
    }

    /**
     * 联查操作系统和网络
     * @param id
     * @return
     */
    @Override
    public ApplyServerDO getApplyServerById(Long id) {
        return applyServerMapper.getApplyServerById(id);
    }

    @Override
    public List<ApplyServerDO> getApplyServerByApplyKeyId(Long id) {
        return applyServerMapper.getApplyServerByApplyKeyId(id);
    }
}