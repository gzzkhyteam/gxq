package com.hengyunsoft.platform.msgs.repository.msgsmessage.dao;

import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.SmsProviderExample;

@Repository
public interface SmsProviderMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.msgs.entity.msgsmessage.po.SmsProvider, SmsProviderExample> {

}
