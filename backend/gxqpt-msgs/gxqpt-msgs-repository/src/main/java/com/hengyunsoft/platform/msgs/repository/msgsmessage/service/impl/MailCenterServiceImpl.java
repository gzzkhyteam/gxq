package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MailCenter;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.dao.MailCenterMapper;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MailCenterExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MailCenterService;
@Service
public class MailCenterServiceImpl extends BaseAllServiceImpl<Long, MailCenter, MailCenterExample> implements MailCenterService{

	@Autowired
	private MailCenterMapper mailCenterMapper;
	@Override
	protected BaseNormalDao<Long, MailCenter, MailCenterExample> getDao() {
		return mailCenterMapper;
	}
	@Override
	public Integer getAllCount(Long reciverId) {		
		return mailCenterMapper.getAllCount(reciverId);
	}
}
