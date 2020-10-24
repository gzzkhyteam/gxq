package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.WeChatMessageCursor;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.dao.WeChatMessageCursorMapper;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.WeChatMessageCursorExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.WeChatMessageCursorService;
@Service
public class WeChatMessageCursorServiceImpl extends BaseAllServiceImpl<Long, WeChatMessageCursor, WeChatMessageCursorExample> implements WeChatMessageCursorService{
	@Autowired
	private WeChatMessageCursorMapper weChatMessageCursorMapper;
	@Override
	protected BaseNormalDao<Long, WeChatMessageCursor, WeChatMessageCursorExample> getDao() {
		return weChatMessageCursorMapper;
	}
	/**
	 * 根据msgid删除数据
	 * @param msgId
	 */
	@Override
	public void deleteByMsgId(String msgId) {
		weChatMessageCursorMapper.deleteByMsgId(msgId);
	}
	/**
	 * 获取所有临时信息
	 * @return
	 */
	@Override
	public List<WeChatMessageCursor> getAll() {
		return weChatMessageCursorMapper.getAll();
	}

}
