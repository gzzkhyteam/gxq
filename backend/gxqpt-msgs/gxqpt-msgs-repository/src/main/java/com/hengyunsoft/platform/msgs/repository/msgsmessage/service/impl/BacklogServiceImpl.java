package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.Backlog;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.dao.BacklogMapper;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.BacklogExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.BacklogService;

@Service
public class BacklogServiceImpl extends BaseAllServiceImpl<Long, Backlog, BacklogExample> implements BacklogService{

	@Autowired
	private BacklogMapper backlogMapper;
	
	@Override
	protected BaseNormalDao<Long, Backlog, BacklogExample> getDao() {		
		return backlogMapper;
	}

	@Override
	public Integer getAllCount(Long reciverId) {		
		return backlogMapper.getAllCount(reciverId);
	}

}
