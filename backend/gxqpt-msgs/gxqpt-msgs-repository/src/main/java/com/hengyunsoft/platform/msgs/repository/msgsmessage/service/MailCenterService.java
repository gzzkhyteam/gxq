package com.hengyunsoft.platform.msgs.repository.msgsmessage.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MailCenter;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MailCenterExample;

public interface MailCenterService extends BaseAllService<Long, MailCenter, MailCenterExample>{
	/**
	 * 获取全部数量消息
	 * @return
	 */
	Integer getAllCount(Long reciverId);
}
