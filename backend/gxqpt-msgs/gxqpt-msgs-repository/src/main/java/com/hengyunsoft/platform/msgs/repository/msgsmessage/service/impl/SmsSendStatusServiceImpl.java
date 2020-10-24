package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.SmsSendStatus;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.dao.SmsSendStatusMapper;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.SmsSendStatusExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.SmsSendStatusService;
@Service
public class SmsSendStatusServiceImpl extends BaseAllServiceImpl<Long, SmsSendStatus, SmsSendStatusExample> implements SmsSendStatusService{
	@Autowired
	private SmsSendStatusMapper smsSendStatusMapper;

	@Override
	protected BaseNormalDao<Long, SmsSendStatus, SmsSendStatusExample> getDao() {
		return smsSendStatusMapper;
	}

	@Override
	public List<SmsSendStatus> getByMsgId(String msgId) {
		return smsSendStatusMapper.getByMsgId(msgId);
	}
}
