package com.hengyunsoft.platform.msgs.repository.msgsmessage.service;

import java.util.List;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.SmsSendStatus;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.SmsSendStatusExample;

public interface SmsSendStatusService extends BaseAllService<Long, SmsSendStatus, SmsSendStatusExample> {

	public List<SmsSendStatus> getByMsgId(String msgId);
}
