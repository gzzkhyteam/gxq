package com.hengyunsoft.platform.msgs.repository.msgsmessage.service;

import java.util.List;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.SmsMessageCursor;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.SmsMessageCursorExample;

public interface SmsMessageCursorService extends BaseAllService<Long, SmsMessageCursor, SmsMessageCursorExample>{

	/**
	 * 获取所有临时信息
	 * @return
	 */
	List<SmsMessageCursor> getAll();

    int saveHavedId(SmsMessageCursor smsMessageCursor);
}
