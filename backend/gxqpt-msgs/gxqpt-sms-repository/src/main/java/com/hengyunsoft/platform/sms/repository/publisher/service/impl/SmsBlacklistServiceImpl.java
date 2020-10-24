package com.hengyunsoft.platform.sms.repository.publisher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.sms.entity.publisher.po.SmsBlacklist;
import com.hengyunsoft.platform.sms.entity.template.dos.PublisherPullblackDO;
import com.hengyunsoft.platform.sms.repository.publisher.dao.SmsBlacklistMapper;
import com.hengyunsoft.platform.sms.repository.publisher.example.SmsBlacklistExample;
import com.hengyunsoft.platform.sms.repository.publisher.service.SmsBlacklistService;

@Service
public class SmsBlacklistServiceImpl extends BaseAllServiceImpl<Long, SmsBlacklist, SmsBlacklistExample> implements SmsBlacklistService{
	@Autowired
	private SmsBlacklistMapper smsBlacklistMapper;
	
	@Override
	protected BaseNormalDao<Long, SmsBlacklist, SmsBlacklistExample> getDao() {
		return smsBlacklistMapper;
	}

	@Override
	public void deleteByAppidAndUserId(PublisherPullblackDO publisherPullblackDTO) {		
		smsBlacklistMapper.deleteByAppidAndUserId(publisherPullblackDTO);
	}

}
