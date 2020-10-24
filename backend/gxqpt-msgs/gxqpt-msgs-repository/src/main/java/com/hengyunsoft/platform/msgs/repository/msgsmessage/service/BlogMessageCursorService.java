package com.hengyunsoft.platform.msgs.repository.msgsmessage.service;

import java.util.List;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.BlogMessageCursor;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.BlogMessageCursorExample;

public interface BlogMessageCursorService extends BaseAllService<Long, BlogMessageCursor, BlogMessageCursorExample>{

	/**
	 * 根据msgid删除数据
	 * @param msgId
	 */
	void deleteByMsgId(String msgId);
	/**
	 * 获取全部临时信息
	 * @return
	 */
	List<BlogMessageCursor> getAll();
}
