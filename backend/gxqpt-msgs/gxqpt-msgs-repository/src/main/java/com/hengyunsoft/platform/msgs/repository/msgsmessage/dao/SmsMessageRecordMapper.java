package com.hengyunsoft.platform.msgs.repository.msgsmessage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.SmsMessageRecord;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.SmsMessageRecordExample;

@Repository
public interface SmsMessageRecordMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, SmsMessageRecord, SmsMessageRecordExample> {
	/**
	 * 根据短信发送状态查询记录
	 */
	List<SmsMessageRecord> getBySendstatus(Integer status);
	/**
	 * 根据信息id更新记录
	 * @param
	 * @return
	 */
	void updateByMsgId(SmsMessageRecord smsMessageRecord);
	/**
	 * 根据信息id获取id
	 * @param msgId
	 * @return
	 */
	Long getIdByMsgId(String msgId);
	/**
	 * 根据信息id获取记录
	 * @param msgId
	 * @return
	 */
	SmsMessageRecord getByMsgId(String msgId);
}