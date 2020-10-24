package com.hengyunsoft.platform.sms.repository.template.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.sms.entity.template.dos.QuerySmsTemplateDO;
import com.hengyunsoft.platform.sms.entity.template.dos.SmsTemplateListDO;
import com.hengyunsoft.platform.sms.entity.template.po.SmsTemplate;
import com.hengyunsoft.platform.sms.repository.template.example.TemplateExample;

@Repository
public interface TemplateMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, SmsTemplate, TemplateExample> {
	/**
	 * 个人创建模板情况统计
	 * @param startTime
	 * @param endTime
	 * @return
	 */	
	List<Map<String, Object>> getPersonalTemplateCreate(@Param("startTime")Date startTime,@Param("endTime")Date endTime);
	/**
	 * 应用程序创建模板情况统计
	 * @param startTime
	 * @param endTime
	 * @return
	 */	
	List<Map<String, Object>> getAppTemplateCreate(@Param("startTime")Date startTime,@Param("endTime")Date endTime);
	/**
	 * 根据取代id获取模板列表
	 * @return
	 */
	List<Map<String, Object>> getTemplateSByChannelId(@Param("channelId") Long channelId);
	/**
	 * 根据条件查询模板列表
	 * @param querySmsTemplateDTO
	 * @return
	 */
	List<SmsTemplateListDO> getSmsTemplateList(@Param("querySmsTemplateDTO") QuerySmsTemplateDO querySmsTemplateDTO);
}
