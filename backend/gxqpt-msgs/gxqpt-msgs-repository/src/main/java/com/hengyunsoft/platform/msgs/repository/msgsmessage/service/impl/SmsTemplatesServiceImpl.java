package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.SmsTemplate;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.dao.SmsTemplateMapper;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.SmsTemplateExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.SmsTemplatesService;

@Service
public class SmsTemplatesServiceImpl extends BaseAllServiceImpl<Long, SmsTemplate, SmsTemplateExample> implements SmsTemplatesService{
	@Autowired
	private SmsTemplateMapper smsTemplateMapper;
	@Override
	protected BaseNormalDao<Long, SmsTemplate, SmsTemplateExample> getDao() {
		return smsTemplateMapper;
	}

}
