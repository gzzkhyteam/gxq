package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.Office;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.dao.OfficeMapper;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.OfficeExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.OfficeService;
@Service
public class OfficeServiceImpl extends BaseAllServiceImpl<Long, Office, OfficeExample> implements OfficeService{
	@Autowired
	private OfficeMapper officeMapper;
	@Override
	protected BaseNormalDao<Long, Office, OfficeExample> getDao() {		
		return officeMapper;
	}
	@Override
	public Integer getAllCount(Long reciverId) {		
		return officeMapper.getAllCount(reciverId);
	}
}
