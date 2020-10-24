package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAllChannelUsedDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisChannelUsedDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisSendErrorDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.BlogMessageRecord;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.dao.BlogMessageRecordMapper;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.BlogMessageRecordExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.BlogMessageRecordService;

@Service
public class BlogMessageRecordServiceImpl extends BaseAllServiceImpl<Long, BlogMessageRecord, BlogMessageRecordExample> implements BlogMessageRecordService{
	@Autowired
	private BlogMessageRecordMapper blogMessageRecordMapper;
	@Override
	protected BaseNormalDao<Long, BlogMessageRecord, BlogMessageRecordExample> getDao() {
		return blogMessageRecordMapper;
	}
	/**
	 * 根据信息id获取主键id
	 * @param msgId
	 * @return
	 */
	@Override
	public Long getIdByMsgId(String msgId) {
		return blogMessageRecordMapper.getIdByMsgId(msgId);
	}
	/**
	 * 根据信息id更新
	 * @param blogMessageRecord
	 */
	@Override
	public void updateByMsgId(BlogMessageRecord blogMessageRecord) {
		blogMessageRecordMapper.updateByMsgId(blogMessageRecord);
	}
    /**
     * 个人渠道使用情况
     * @return
     */
	@Override
	public List<MsgAnalysisChannelUsedDO> getMsgChannelUsedCount(String userId,List<String> ids) {
		return blogMessageRecordMapper.getMsgChannelUsedCount(userId,ids);
	}
    /**
     * 近一年高新区各类型渠道使用发展情况(近12个月)
     * @return
     */
	@Override
	public List<MsgAllChannelUsedDO> getMsgAllChannelUsedCount() {
		return blogMessageRecordMapper.getMsgAllChannelUsedCount();
	}
    /**
     * 个人渠道发布商次数TOP10
     * @return
     */
	@Override
	public List<MsgAnalysisSendErrorDO> getPublisherSendTop10(List<String> list) {
		return blogMessageRecordMapper.getPublisherSendTop10(list);
	}
}
