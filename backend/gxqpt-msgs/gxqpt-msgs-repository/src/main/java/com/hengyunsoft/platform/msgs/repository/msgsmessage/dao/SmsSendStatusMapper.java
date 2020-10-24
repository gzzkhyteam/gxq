package com.hengyunsoft.platform.msgs.repository.msgsmessage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.SmsSendStatus;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.SmsSendStatusExample;

@Repository
public interface SmsSendStatusMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, SmsSendStatus,SmsSendStatusExample> {
	List<SmsSendStatus> getByMsgId(String msgId);
}