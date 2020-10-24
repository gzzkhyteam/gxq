package com.hengyunsoft.platform.ops.repository.consult.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.ops.entity.consult.domain.ConsultManageDO;
import com.hengyunsoft.platform.ops.entity.consult.po.ConsultManage;
import com.hengyunsoft.platform.ops.repository.consult.dao.ConsultManageMapper;
import com.hengyunsoft.platform.ops.repository.consult.example.ConsultManageExample;
import com.hengyunsoft.platform.ops.repository.consult.service.ConsultManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by kevin on 2018/7/11.
 */
@Service
@Slf4j
public class ConsultManageServiceImpl extends BaseServiceImpl<Long,ConsultManage,ConsultManageExample> implements ConsultManageService {

    @Autowired
    private ConsultManageMapper consultManageMapper;


    @Override
    protected BaseNormalDao<Long, ConsultManage, ConsultManageExample> getDao() {
        return consultManageMapper;
    }

    @Override
    public List<ConsultManageDO> getApplyPageList(Map<String, Object> param) {
        return consultManageMapper.getApplyPageList(param);
    }

    @Override
    public List<ConsultManageDO> getDealPageList(Map<String, Object> param) {
        return consultManageMapper.getDealPageList(param);
    }

    @Override
    public List<ConsultManageDO> getHandlePageList(Map<String, Object> param) {
        return consultManageMapper.getHandlePageList(param);
    }

}
