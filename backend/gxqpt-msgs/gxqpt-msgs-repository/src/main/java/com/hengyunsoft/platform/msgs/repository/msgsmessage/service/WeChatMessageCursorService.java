package com.hengyunsoft.platform.msgs.repository.msgsmessage.service;

import java.util.List;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.WeChatMessageCursor;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.WeChatMessageCursorExample;

public interface WeChatMessageCursorService extends BaseAllService<Long, WeChatMessageCursor, WeChatMessageCursorExample>{
	/**
	 * 根据msgid删除数据
	 * @param msgId
	 */
	void deleteByMsgId(String msgId);
	/**
	 * 获取所有临时信息
	 * @return
	 */
	List<WeChatMessageCursor> getAll();
}
