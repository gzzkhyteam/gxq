package com.hengyunsoft.platform.sms.repository.template.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.sms.entity.template.dos.QuerySmsTemplateDO;
import com.hengyunsoft.platform.sms.entity.template.dos.SmsTemplateListDO;
import com.hengyunsoft.platform.sms.entity.template.po.SmsTemplate;
import com.hengyunsoft.platform.sms.repository.template.example.TemplateExample;

public interface SmsTemplateService extends BaseService<Long, SmsTemplate, TemplateExample>{
	List<Map<String, Object>> getTemplateByChannelId(Long id);
	
	List<Map<String, Object>> getAppTemplateCreate(Date startTime,Date endTime);
	
	List<Map<String, Object>> getPersonalTemplateCreate(Date startTime,Date endTime);
	
	List<SmsTemplateListDO> getSmsTemplateList(QuerySmsTemplateDO querySmsTemplateDTO);
}
