package com.hengyunsoft.platform.sms.repository.template.service;

import java.util.List;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.sms.entity.template.po.SendStatus;
import com.hengyunsoft.platform.sms.repository.template.example.SendStatusExample;

public interface SendStatusService extends BaseService<Long, SendStatus, SendStatusExample>{

	List<SendStatus> getByMsgId(String msgId);
}
