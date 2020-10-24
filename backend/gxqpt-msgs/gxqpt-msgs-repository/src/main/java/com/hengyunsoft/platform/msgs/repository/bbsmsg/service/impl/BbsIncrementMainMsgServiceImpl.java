package com.hengyunsoft.platform.msgs.repository.bbsmsg.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.msgdo.BbsNotReadMsgResDO;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.po.BbsIncrementMainMsg;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.dao.BbsIncrementMainMsgMapper;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.example.BbsIncrementMainMsgExample;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.service.BbsIncrementMainMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BbsIncrementMainMsgServiceImpl extends BaseAllServiceImpl<Long, BbsIncrementMainMsg, BbsIncrementMainMsgExample>
        implements BbsIncrementMainMsgService {
    @Autowired
    private BbsIncrementMainMsgMapper bbsIncrementMainMsgMapper;

    @Override
    protected BaseNormalDao<Long, BbsIncrementMainMsg, BbsIncrementMainMsgExample> getDao() {
        return bbsIncrementMainMsgMapper;
    }


    @Override
    public List<BbsNotReadMsgResDO> getAllNotReadMsg(Long userId) {
        return bbsIncrementMainMsgMapper.getAllNotReadMsg(userId);
    }

    @Override
    public List<BbsNotReadMsgResDO> getNeedHandleNotReadMsg(Long userId) {
        return bbsIncrementMainMsgMapper.getNeedHandleNotReadMsg(userId);
    }

    @Override
    public List<BbsNotReadMsgResDO> getCommonNotReadMsg(Long userId) {
        return bbsIncrementMainMsgMapper.getCommonNotReadMsg(userId);
    }

    @Override
    public void saveBimm(BbsIncrementMainMsg bimm) {
        bbsIncrementMainMsgMapper.insert(bimm);
    }

}
