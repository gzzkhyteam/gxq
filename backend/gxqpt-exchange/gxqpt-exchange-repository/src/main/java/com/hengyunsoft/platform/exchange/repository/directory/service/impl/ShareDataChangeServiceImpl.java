package com.hengyunsoft.platform.exchange.repository.directory.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataChange;
import com.hengyunsoft.platform.exchange.repository.directory.dao.ShareDataChangeMapper;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataChangeExample;
import com.hengyunsoft.platform.exchange.repository.directory.service.ShareDataChangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tianai
 * @createTime 2018-04-25
 */
@Service
@Slf4j
public class ShareDataChangeServiceImpl extends BaseAllServiceImpl<Long,ShareDataChange,ShareDataChangeExample> implements ShareDataChangeService {

    @Autowired
    private ShareDataChangeMapper shareDataChangeMapper;

    @Override
    protected BaseNormalDao<Long, ShareDataChange, ShareDataChangeExample> getDao() {
        return shareDataChangeMapper;
    }

    /**
     * 更新变动表
     * @param applyCode
     * @param status
     */
    @Override
    public void updateStatusByApplyCode(String applyCode, int status) {

        shareDataChangeMapper.updateStatusByApplyCode(applyCode,status);
    }

    @Override
    public List<ShareDataChange> getDirOrElement(Long id) {
        return shareDataChangeMapper.getDirOrElement(id);
    }
}
