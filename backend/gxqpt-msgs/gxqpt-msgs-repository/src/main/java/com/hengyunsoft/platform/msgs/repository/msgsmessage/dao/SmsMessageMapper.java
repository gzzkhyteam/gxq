package com.hengyunsoft.platform.msgs.repository.msgsmessage.dao;

import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.SmsMessageExample;

@Repository
public interface SmsMessageMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.msgs.entity.msgsmessage.po.SmsMessageRecord, SmsMessageExample> {

}
