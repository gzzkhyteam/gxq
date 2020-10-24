package com.hengyunsoft.platform.msgs.repository.bbsmsg.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.po.BbsIncrementReceiveMsg;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.dao.BbsIncrementReceiveMsgMapper;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.example.BbsIncrementReceiveMsgExample;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.service.BbsIncrementReceiveMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbsIncrementReceiveMsgServiceImpl extends BaseAllServiceImpl<Long, BbsIncrementReceiveMsg, BbsIncrementReceiveMsgExample>
        implements BbsIncrementReceiveMsgService {
    @Autowired
    private BbsIncrementReceiveMsgMapper bbsIncrementReceiveMsgMapper;

    @Override
    protected BaseNormalDao<Long, BbsIncrementReceiveMsg, BbsIncrementReceiveMsgExample> getDao() {
        return bbsIncrementReceiveMsgMapper;
    }


    @Override
    public void saveBrim(BbsIncrementReceiveMsg birm) {
        bbsIncrementReceiveMsgMapper.insert(birm);
    }
}
