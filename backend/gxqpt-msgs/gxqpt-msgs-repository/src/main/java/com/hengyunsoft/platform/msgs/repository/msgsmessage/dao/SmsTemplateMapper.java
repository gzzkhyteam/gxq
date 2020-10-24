package com.hengyunsoft.platform.msgs.repository.msgsmessage.dao;

import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.SmsTemplate;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.SmsTemplateExample;

@Repository
public interface SmsTemplateMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, SmsTemplate, SmsTemplateExample> {

}
