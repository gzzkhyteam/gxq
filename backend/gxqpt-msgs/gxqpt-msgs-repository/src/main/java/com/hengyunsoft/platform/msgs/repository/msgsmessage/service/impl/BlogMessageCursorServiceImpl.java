package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.BlogMessageCursor;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.dao.BlogMessageCursorMapper;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.BlogMessageCursorExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.BlogMessageCursorService;
@Service
public class BlogMessageCursorServiceImpl extends BaseAllServiceImpl<Long, BlogMessageCursor, BlogMessageCursorExample> implements BlogMessageCursorService{
	@Autowired
	private BlogMessageCursorMapper blogMessageCursorMapper;
	@Override
	protected BaseNormalDao<Long, BlogMessageCursor, BlogMessageCursorExample> getDao() {
		return blogMessageCursorMapper;
	}
	/**
	 * 根据msgid删除数据
	 * @param msgId
	 */
	@Override
	public void deleteByMsgId(String msgId) {
		blogMessageCursorMapper.deleteByMsgId(msgId);		
	}
	/**
	 * 获取全部临时信息
	 * @return
	 */
	@Override
	public List<BlogMessageCursor> getAll() {
		return blogMessageCursorMapper.getAll();
	}

}
