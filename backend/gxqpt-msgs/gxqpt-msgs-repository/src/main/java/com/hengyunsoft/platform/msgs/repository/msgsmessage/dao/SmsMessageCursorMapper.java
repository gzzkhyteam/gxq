package com.hengyunsoft.platform.msgs.repository.msgsmessage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.SmsMessageCursor;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.SmsMessageCursorExample;

@Repository
public interface SmsMessageCursorMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, SmsMessageCursor,SmsMessageCursorExample> {
	List<SmsMessageCursor> getAll();
}