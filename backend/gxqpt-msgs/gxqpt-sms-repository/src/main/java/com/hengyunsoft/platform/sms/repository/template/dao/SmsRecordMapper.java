package com.hengyunsoft.platform.sms.repository.template.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hengyunsoft.platform.sms.entity.template.dos.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.sms.entity.template.po.SmsRecord;
import com.hengyunsoft.platform.sms.repository.template.example.SmsRecordExample;

@Repository
public interface SmsRecordMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, SmsRecord, SmsRecordExample> {
	SmsRecord selectByMsgId(@Param("msgId") String msgId);
	void batchDeleteDraft(@Param("idItem")List<Long> idItem);
	/**
	 * 各应用使用短信量统计
	 * @param startTime
	 * @param endTime
	 * @return
	 */	
	List<Map<String, Object>> getCountByApp(@Param("startTime")Date startTime,@Param("endTime")Date endTime);
	/**
	 * 个人创建模板情况统计
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<Map<String, Object>> getCountByPersonal(@Param("startTime")Date startTime,@Param("endTime")Date endTime);
	/**
	 * 模板使用情况统计
	 * @param startTime
	 * @param endTime
	 * @return
	 */	
	List<Map<String, Object>> getCountByTemplate(@Param("startTime")Date startTime,@Param("endTime")Date endTime);
	/**
     * 近一月短信使用情况
     * @return
     */
	List<SmsMonthAcountDO> getSmsMonthAcount(@Param("smsRequestDTO")SmsRequestDO smsRequestDTO);
	/**
     * 近一年短信使用情况
     * @return
     */
	List<SmsYearAcountDO> getSmsYearAcount(@Param("smsRequestDTO")SmsRequestDO smsRequestDTO);
	/**
     * 模板使用TOP10
     * @return
     */
	List<SmsTemplateTop10DO> getTemplateTop10(@Param("smsRequestDTO")SmsRequestDO smsRequestDTO);
    /**
     * 各应用使用情况分析
     * @return
     */
	List<AnalysisRespondsDO> getApplicationsCount(@Param("ids")List<Long> ids);
    /**
     * 各服务使用情况分析
     * @return
     */
	List<AnalysisRespondsDO> getServicesCount(@Param("ids")List<Long> ids);
	/**
	 * 一年内我发送短信量
	 * @param
	 * @return
	 */
	List<SmsTimeStampCountDO> getYearCount(@Param("scaleDTO")ScaleRequestDO scaleDTO);
	/**
	 * 近半年我发送短信量
	 * @param
	 * @return
	 */
	List<SmsTimeStampCountDO> getHarfYearCount(@Param("scaleDTO")ScaleRequestDO scaleDTO);
	/**
	 * 三个月内我发送短信量
	 * @param
	 * @return
	 */
	List<SmsTimeStampCountDO> getWeekCount(@Param("scaleDTO")ScaleRequestDO scaleDTO);
	/**
	 * 一个月内我发送短信量
	 * @param
	 * @return
	 */
	List<SmsTimeStampCountDO> getDayCount(@Param("scaleDTO")ScaleRequestDO scaleDTO);
	/**
     * 短信发送量
     * @return
     */
	Integer getSendNum(@Param("userId")String userId);

    List<SmsRecordDO> pageSmsRecordList(@Param("querySmsRecordDO") QuerySmsRecordDO querySmsRecordDO);
}