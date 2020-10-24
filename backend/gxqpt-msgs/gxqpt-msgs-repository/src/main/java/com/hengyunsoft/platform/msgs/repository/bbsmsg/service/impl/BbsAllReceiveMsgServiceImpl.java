package com.hengyunsoft.platform.msgs.repository.bbsmsg.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.msgdo.UpdateBacklogDO;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.po.BbsAllReceiveMsg;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.dao.BbsAllReceiveMsgMapper;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.example.BbsAllReceiveMsgExample;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.service.BbsAllReceiveMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbsAllReceiveMsgServiceImpl extends BaseAllServiceImpl<Long,  BbsAllReceiveMsg, BbsAllReceiveMsgExample>
        implements BbsAllReceiveMsgService {
    @Autowired
    private BbsAllReceiveMsgMapper bbsAllReceiveMsgMapper;

    @Override
    protected BaseNormalDao<Long, BbsAllReceiveMsg, BbsAllReceiveMsgExample> getDao() {

    	return bbsAllReceiveMsgMapper;
    }

    @Override
    public void updateBacklog(UpdateBacklogDO updateBacklogDO) {
        bbsAllReceiveMsgMapper.updateBacklog(updateBacklogDO);
    }
}
