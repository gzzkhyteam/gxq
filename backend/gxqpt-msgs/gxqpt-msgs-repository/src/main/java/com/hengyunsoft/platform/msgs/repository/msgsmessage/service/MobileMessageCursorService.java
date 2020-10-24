package com.hengyunsoft.platform.msgs.repository.msgsmessage.service;

import java.util.List;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.channelgroup.po.MobileMessageCursor;
import com.hengyunsoft.platform.msgs.repository.channelgroup.example.MobileMessageCursorExample;

public interface MobileMessageCursorService extends BaseAllService<Long, MobileMessageCursor, MobileMessageCursorExample>{

	List<MobileMessageCursor> getAll();
}
