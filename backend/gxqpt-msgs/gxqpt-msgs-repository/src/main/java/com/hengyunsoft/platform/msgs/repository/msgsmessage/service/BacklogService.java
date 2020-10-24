package com.hengyunsoft.platform.msgs.repository.msgsmessage.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.Backlog;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.BacklogExample;

public interface BacklogService extends BaseAllService<Long, Backlog, BacklogExample>{
	/**
	 * 获取全部数量消息
	 * @return
	 */
	Integer getAllCount(Long reciverId);
}
