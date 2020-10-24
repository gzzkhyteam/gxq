package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.WarnCenter;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.dao.WarnCenterMapper;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.WarnCenterExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.WarnCenterService;
@Service
public class WarnCenterServiceImpl extends BaseAllServiceImpl<Long, WarnCenter, WarnCenterExample> implements WarnCenterService{

	@Autowired
	private WarnCenterMapper warnCenterMapper;
	@Override
	protected BaseNormalDao<Long, WarnCenter, WarnCenterExample> getDao() {
		return warnCenterMapper;
	}
	@Override
	public Integer getAllCount(Long reciverId) {		
		return warnCenterMapper.getAllCount(reciverId);
	}
}
