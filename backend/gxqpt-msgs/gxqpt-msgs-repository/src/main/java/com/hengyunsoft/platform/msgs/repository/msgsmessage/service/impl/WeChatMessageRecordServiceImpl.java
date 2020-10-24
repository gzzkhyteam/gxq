package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgActiveSendDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAllChannelUsedDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisChannelUsedDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisSendErrorDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgsListBackDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgsMessagePublisherDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.WeChatMessageRecord;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.dao.WeChatMessageRecordMapper;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.WeChatMessageRecordExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.WeChatMessageRecordService;
@Service
public class WeChatMessageRecordServiceImpl extends BaseAllServiceImpl<Long, WeChatMessageRecord, WeChatMessageRecordExample> implements WeChatMessageRecordService{
	@Autowired
	private WeChatMessageRecordMapper weChatMessageRecordMapper;
	@Override
	protected BaseNormalDao<Long, WeChatMessageRecord, WeChatMessageRecordExample> getDao() {
		return weChatMessageRecordMapper;
	}
	/**
	 * 根据信息id获取主键id
	 * @param msgId
	 * @return
	 */
	@Override
	public Long getIdByMsgId(String msgId) {
		return weChatMessageRecordMapper.getIdByMsgId(msgId);
	}
	/**
	 * 根据信息id更新数据
	 * @param weChatMessageRecord
	 */
	@Override
	public void updateByMsgId(WeChatMessageRecord weChatMessageRecord) {
		weChatMessageRecordMapper.updateByMsgId(weChatMessageRecord);
	}
    /**
     * 个人渠道使用情况
     * @return
     */
	@Override
	public List<MsgAnalysisChannelUsedDO> getMsgChannelUsedCount(String userId,List<String> ids) {
		return weChatMessageRecordMapper.getMsgChannelUsedCount(userId,ids);
	}
    /**
     * 近一年高新区各类型渠道使用发展情况(近12个月)
     * @return
     */
	@Override
	public List<MsgAllChannelUsedDO> getMsgAllChannelUsedCount() {
		return weChatMessageRecordMapper.getMsgAllChannelUsedCount();
	}
    /**
     * 个人渠道发布商次数TOP10
     * @return
     */
	@Override
	public List<MsgAnalysisSendErrorDO> getPublisherSendTop10(List<String> list) {
		return weChatMessageRecordMapper.getPublisherSendTop10(list);
	}
    /**
     * 近期发布商活跃情况分析
     * @return
     */
	@Override
	public List<MsgActiveSendDO> getActivePublisherSendCount(List<String> appIds, List<Long> channelIds,
			String appId) {
		return weChatMessageRecordMapper.getActivePublisherSendCount(appIds,channelIds,appId);
	}
    /**
     * 发布商消息记录分页列表
     */
	@Override
	public List<MsgsListBackDO> getMsgsList(MsgsMessagePublisherDO msgsMessagePublisherDTO) {
		return weChatMessageRecordMapper.getMsgsList(msgsMessagePublisherDTO);
	}
}
