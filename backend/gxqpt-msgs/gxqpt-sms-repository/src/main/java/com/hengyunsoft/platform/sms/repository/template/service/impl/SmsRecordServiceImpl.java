package com.hengyunsoft.platform.sms.repository.template.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hengyunsoft.platform.sms.entity.template.dos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.sms.entity.template.po.SmsRecord;
import com.hengyunsoft.platform.sms.repository.template.dao.SmsRecordMapper;
import com.hengyunsoft.platform.sms.repository.template.example.SmsRecordExample;
import com.hengyunsoft.platform.sms.repository.template.service.SmsRecordService;
@Service
public class SmsRecordServiceImpl extends BaseAllServiceImpl<Long, SmsRecord, SmsRecordExample> implements SmsRecordService{
	@Autowired
	private SmsRecordMapper smsRecordMapper;
	@Override
	protected BaseNormalDao<Long, SmsRecord, SmsRecordExample> getDao() {		
		return smsRecordMapper;
	}
	@Override
	public List<Map<String, Object>> getCountByApp(Date startTime, Date endTime) {		
		return smsRecordMapper.getCountByApp(startTime, endTime);
	}
	@Override
	public List<Map<String, Object>> getCountByPersonal(Date startTime, Date endTime) {
		return smsRecordMapper.getCountByPersonal(startTime, endTime);
	}
	@Override
	public List<Map<String, Object>> getCountByTemplate(Date startTime, Date endTime) {
		return smsRecordMapper.getCountByTemplate(startTime, endTime);
	}
	@Override
	public SmsRecord selectByMsgId(String msgId) {
		return smsRecordMapper.selectByMsgId(msgId);
	}
	@Override
	public void batchDeleteDraft(List<Long> ids) {
		smsRecordMapper.batchDeleteDraft(ids);		
	}
	/**
     * 近一月短信使用情况
     * @return
     */
	@Override
	public List<SmsMonthAcountDO> getSmsMonthAcount(SmsRequestDO smsRequestDTO) {
		return smsRecordMapper.getSmsMonthAcount(smsRequestDTO);
	}
	/**
     * 近一年短信使用情况
     * @return
     */
	@Override
	public List<SmsYearAcountDO> getSmsYearAcount(SmsRequestDO smsRequestDTO) {
		return smsRecordMapper.getSmsYearAcount(smsRequestDTO);
	}
	/**
     * 模板使用TOP10
     * @return
     */
	@Override
	public List<SmsTemplateTop10DO> getTemplateTop10(SmsRequestDO smsRequestDTO) {
		return smsRecordMapper.getTemplateTop10(smsRequestDTO);
	}
    /**
     * 各应用使用情况分析
     * @return
     */
	@Override
	public List<AnalysisRespondsDO> getApplicationsCount(List<Long> ids) {
		return smsRecordMapper.getApplicationsCount(ids);
	}
    /**
     * 各服务使用情况分析
     * @return
     */
	@Override
	public List<AnalysisRespondsDO> getServicesCount(List<Long> ids) {
		return smsRecordMapper.getServicesCount(ids);
	}
	/**
	 * 一年内我发送短信量
	 * @param userId
	 * @return
	 */
	@Override
	public List<SmsTimeStampCountDO> getYearCount(ScaleRequestDO scaleDTO) {
		return smsRecordMapper.getYearCount(scaleDTO);
	}
	/**
	 * 近半年我发送短信量
	 * @param userId
	 * @return
	 */
	@Override
	public List<SmsTimeStampCountDO> getHarfYearCount(ScaleRequestDO scaleDTO) {
		return smsRecordMapper.getHarfYearCount(scaleDTO);
	}
	/**
	 * 三个月内我发送短信量
	 * @param userId
	 * @return
	 */
	@Override
	public List<SmsTimeStampCountDO> getWeekCount(ScaleRequestDO scaleDTO) {
		return smsRecordMapper.getWeekCount(scaleDTO);
	}
	/**
	 * 一个月内我发送短信量
	 * @param userId
	 * @return
	 */
	@Override
	public List<SmsTimeStampCountDO> getDayCount(ScaleRequestDO scaleDTO) {
		return smsRecordMapper.getDayCount(scaleDTO);
	}

	@Override
	public List<SmsRecordDO> pageSmsRecordList(QuerySmsRecordDO querySmsRecordDO) {
		return smsRecordMapper.pageSmsRecordList(querySmsRecordDO);
	}

	/**
     * 短信发送量
     * @return
     */
	@Override
	public Integer getSendNum(String userId) {
		return smsRecordMapper.getSendNum(userId);
	}
}
