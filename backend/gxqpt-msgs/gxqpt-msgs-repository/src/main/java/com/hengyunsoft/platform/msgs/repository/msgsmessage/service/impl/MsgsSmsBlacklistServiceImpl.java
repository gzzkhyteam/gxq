package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsSmsBlacklist;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.dao.MsgsSmsBlacklistMapper;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MsgsSmsBlacklistExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MsgsSmsBlacklistService;

@Service
public class MsgsSmsBlacklistServiceImpl extends BaseAllServiceImpl<Long, MsgsSmsBlacklist, MsgsSmsBlacklistExample>
implements MsgsSmsBlacklistService{
    @Autowired
    private MsgsSmsBlacklistMapper msgsSmsBlacklistMapper;
    
	@Override
	protected BaseNormalDao<Long, MsgsSmsBlacklist, MsgsSmsBlacklistExample> getDao() {
		return msgsSmsBlacklistMapper;
	}

}
