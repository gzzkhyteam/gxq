package com.hengyunsoft.platform.msgs.repository.msgsmessage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.WeChatMessageCursor;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.WeChatMessageCursorExample;

@Repository
public interface WeChatMessageCursorMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, WeChatMessageCursor,WeChatMessageCursorExample> {
	List<WeChatMessageCursor> getAll();
	/**
	 * 根据msgid删除数据
	 * @param msgId
	 */
	void deleteByMsgId(@Param(value="msgId")String msgId);
}