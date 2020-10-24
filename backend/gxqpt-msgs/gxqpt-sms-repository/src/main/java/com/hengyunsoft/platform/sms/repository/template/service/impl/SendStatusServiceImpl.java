package com.hengyunsoft.platform.sms.repository.template.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.sms.entity.template.po.SendStatus;
import com.hengyunsoft.platform.sms.repository.template.dao.SendStatusMapper;
import com.hengyunsoft.platform.sms.repository.template.example.SendStatusExample;
import com.hengyunsoft.platform.sms.repository.template.service.SendStatusService;
@Service
public class SendStatusServiceImpl extends BaseAllServiceImpl<Long, SendStatus, SendStatusExample> implements SendStatusService{
	@Autowired
	private SendStatusMapper sendStatusMapper;
	
	@Override
	protected BaseNormalDao<Long, SendStatus, SendStatusExample> getDao() {		
		return sendStatusMapper;
	}

	@Override
	public List<SendStatus> getByMsgId(String msgId) {
		return sendStatusMapper.getByMsgId(msgId);
	}

}
