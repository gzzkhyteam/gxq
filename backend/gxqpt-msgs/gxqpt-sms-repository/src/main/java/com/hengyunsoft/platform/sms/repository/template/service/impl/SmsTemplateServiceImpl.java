package com.hengyunsoft.platform.sms.repository.template.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.sms.entity.template.dos.QuerySmsTemplateDO;
import com.hengyunsoft.platform.sms.entity.template.dos.SmsTemplateListDO;
import com.hengyunsoft.platform.sms.entity.template.po.SmsTemplate;
import com.hengyunsoft.platform.sms.repository.template.dao.TemplateMapper;
import com.hengyunsoft.platform.sms.repository.template.example.TemplateExample;
import com.hengyunsoft.platform.sms.repository.template.service.SmsTemplateService;

@Service
public class SmsTemplateServiceImpl extends BaseAllServiceImpl<Long, SmsTemplate, TemplateExample> implements SmsTemplateService{
	@Autowired
	private TemplateMapper templateMapper;
	@Override
	protected BaseNormalDao<Long, SmsTemplate, TemplateExample> getDao() {		
		return templateMapper;
	}
	@Override
	public List<Map<String, Object>> getTemplateByChannelId(Long id) {		
		return templateMapper.getTemplateSByChannelId(id);
	}
	@Override
	public List<Map<String, Object>> getAppTemplateCreate(Date startTime, Date endTime) {
		return templateMapper.getAppTemplateCreate(startTime, endTime);
	}
	@Override
	public List<Map<String, Object>> getPersonalTemplateCreate(Date startTime, Date endTime) {
		return templateMapper.getPersonalTemplateCreate(startTime, endTime);
	}
	@Override
	public List<SmsTemplateListDO> getSmsTemplateList(QuerySmsTemplateDO querySmsTemplateDTO) {
		return templateMapper.getSmsTemplateList(querySmsTemplateDTO);
	}
}
