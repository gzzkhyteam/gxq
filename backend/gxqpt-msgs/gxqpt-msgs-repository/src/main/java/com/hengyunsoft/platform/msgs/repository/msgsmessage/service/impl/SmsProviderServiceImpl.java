package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.SmsProvider;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.dao.SmsProviderMapper;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.SmsProviderExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.SmsProviderService;
@Service
public class SmsProviderServiceImpl extends BaseAllServiceImpl<Long, SmsProvider, SmsProviderExample> implements SmsProviderService {
	@Autowired
	private SmsProviderMapper smsProviderMapper;
	
	@Override
	protected BaseNormalDao<Long, SmsProvider, SmsProviderExample> getDao() {		
		return smsProviderMapper;
	}	
}
