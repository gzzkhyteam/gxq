package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MessageCenter;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.dao.MessageCenterMapper;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MessageCenterExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MessageCenterService;
@Service
public class MessageCenterServiceImpl extends BaseAllServiceImpl<Long, MessageCenter, MessageCenterExample> implements MessageCenterService{

	@Autowired
	private MessageCenterMapper messageCenterMapper;
	@Override
	protected BaseNormalDao<Long, MessageCenter, MessageCenterExample> getDao() {
		return messageCenterMapper;
	}
	@Override
	public Integer getAllCount(Long reciverId) {		
		return messageCenterMapper.getAllCount(reciverId);
	}
}
