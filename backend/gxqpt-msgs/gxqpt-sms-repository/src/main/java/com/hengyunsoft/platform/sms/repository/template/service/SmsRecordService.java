package com.hengyunsoft.platform.sms.repository.template.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.sms.entity.template.dos.*;
import com.hengyunsoft.platform.sms.entity.template.po.SmsRecord;
import com.hengyunsoft.platform.sms.repository.template.example.SmsRecordExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SmsRecordService extends BaseService<Long, SmsRecord, SmsRecordExample>{

	List<Map<String, Object>> getCountByApp(Date startTime,Date endTime);
	
	List<Map<String, Object>> getCountByPersonal(Date startTime,Date endTime);
	
	List<Map<String, Object>> getCountByTemplate(Date startTime,Date endTime);
	
	SmsRecord selectByMsgId(String msgId);
	
	void batchDeleteDraft(List<Long> ids);
	/**
     * 短信发送量
     * @return
     */
	Integer getSendNum(String userId);
	/**
     * 近一月短信使用情况
     * @return
     */
	List<SmsMonthAcountDO> getSmsMonthAcount(SmsRequestDO smsRequestDTO);
	/**
     * 近一年短信使用情况
     * @return
     */
	List<SmsYearAcountDO> getSmsYearAcount(SmsRequestDO smsRequestDTO);
	/**
     * 模板使用TOP10
     * @return
     */
	List<SmsTemplateTop10DO> getTemplateTop10(SmsRequestDO smsRequestDTO);
    /**
     * 各应用使用情况分析
     * @return
     */
	List<AnalysisRespondsDO> getApplicationsCount(List<Long> ids);
    /**
     * 各服务使用情况分析
     * @return
     */
	List<AnalysisRespondsDO> getServicesCount(List<Long> ids);
	/**
	 * 一年内我发送短信量
	 * @param
	 * @return
	 */
	List<SmsTimeStampCountDO> getYearCount(ScaleRequestDO scaleDTO);
	/**
	 * 近半年我发送短信量
	 * @param
	 * @return
	 */
	List<SmsTimeStampCountDO> getHarfYearCount(ScaleRequestDO scaleDTO);
	/**
	 * 三个月内我发送短信量
	 * @param
	 * @return
	 */
	List<SmsTimeStampCountDO> getWeekCount(ScaleRequestDO scaleDTO);
	/**
	 * 一个月内我发送短信量
	 * @param
	 * @return
	 */
	List<SmsTimeStampCountDO> getDayCount(ScaleRequestDO scaleDTO);

	/**
	 * 分页查询发送记录
	 * @param querySmsRecordDO
	 * @return
	 */
    List<SmsRecordDO> pageSmsRecordList(QuerySmsRecordDO querySmsRecordDO);
}
