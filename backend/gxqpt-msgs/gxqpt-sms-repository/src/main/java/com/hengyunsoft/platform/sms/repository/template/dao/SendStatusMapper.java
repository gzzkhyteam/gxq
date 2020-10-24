package com.hengyunsoft.platform.sms.repository.template.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.sms.entity.template.po.SendStatus;
import com.hengyunsoft.platform.sms.repository.template.example.SendStatusExample;

@Repository
public interface SendStatusMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, SendStatus,SendStatusExample> {
	List<SendStatus> getByMsgId(String msgId);
}