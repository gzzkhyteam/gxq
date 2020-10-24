package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.BlackListDeleteDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsBlacklist;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.dao.MsgsBlacklistMapper;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MsgsBlacklistExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MsgsBlacklistService;

@Service
public class MsgsBlacklistServiceImpl extends BaseAllServiceImpl<Long, MsgsBlacklist, MsgsBlacklistExample> implements MsgsBlacklistService{
	@Autowired
	private MsgsBlacklistMapper msgsBlacklistMapper;
	@Override
	protected BaseNormalDao<Long, MsgsBlacklist, MsgsBlacklistExample> getDao() {
		return msgsBlacklistMapper;
	}
	
	@Override
	public void deleteByAppId(BlackListDeleteDO blackListDeleteDTO) {		
		msgsBlacklistMapper.deleteByAppId(blackListDeleteDTO);
	}

}
