package com.hengyunsoft.platform.msgs.repository.bbsmsg.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.msgdo.BbsAllMsgResDO;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.msgdo.BbsMsgDetailResDO;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.po.BbsAllMainMsg;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.dao.BbsAllMainMsgMapper;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.example.BbsAllMainMsgExample;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.service.BbsAllMainMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BbsAllMainMsgServiceImpl extends BaseAllServiceImpl<Long, BbsAllMainMsg, BbsAllMainMsgExample>
        implements BbsAllMainMsgService {
    @Autowired
    private BbsAllMainMsgMapper bbsAllMainMsgMapper;

    @Override
    protected BaseNormalDao<Long, BbsAllMainMsg, BbsAllMainMsgExample> getDao() {

    	return bbsAllMainMsgMapper;
    }

    @Override
    public List<BbsAllMsgResDO> getAllMsg(Long userId) {
        return bbsAllMainMsgMapper.getAllMsg(userId);
    }

    @Override
    public List<BbsAllMsgResDO> getReadMsg(Long userId) {
        return bbsAllMainMsgMapper.getReadMsg(userId);
    }

    @Override
    public List<BbsAllMsgResDO> getAllNotHandleMsg(Long userId) {
        return bbsAllMainMsgMapper.getAllNotHandleMsg(userId);
    }

    @Override
    public BbsMsgDetailResDO getDetailById(Long msgId) {
        return bbsAllMainMsgMapper.getDetailById(msgId);
    }

    @Override
    public BbsMsgDetailResDO getRecentMsgAndNotReadNum(Long userId)  {
        return bbsAllMainMsgMapper.getRecentMsgAndNotReadNum(userId);
    }
}
