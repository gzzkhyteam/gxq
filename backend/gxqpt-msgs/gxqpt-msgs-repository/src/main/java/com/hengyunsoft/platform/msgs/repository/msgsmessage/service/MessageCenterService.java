package com.hengyunsoft.platform.msgs.repository.msgsmessage.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MessageCenter;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MessageCenterExample;

public interface MessageCenterService extends BaseAllService<Long, MessageCenter, MessageCenterExample>{
	/**
	 * 获取全部数量消息
	 * @return
	 */
	Integer getAllCount(Long reciverId);
}
