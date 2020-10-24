package com.hengyunsoft.platform.msgs.repository.msgsmessage.service;

import java.util.List;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgActiveSendDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAllChannelUsedDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisChannelUsedDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisSendErrorDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgsListBackDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgsMessagePublisherDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.WeChatMessageRecord;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.WeChatMessageRecordExample;

public interface WeChatMessageRecordService extends BaseAllService<Long, WeChatMessageRecord, WeChatMessageRecordExample>{

	/**
	 * 根据信息id获取主键id
	 * @param msgId
	 * @return
	 */
	Long getIdByMsgId(String msgId);
	/**
	 * 根据信息id更新数据
	 * @param weChatMessageRecord
	 */
	void updateByMsgId(WeChatMessageRecord weChatMessageRecord);
    /**
     * 个人渠道使用情况
     * @return
     */
	List<MsgAnalysisChannelUsedDO> getMsgChannelUsedCount(String userId,List<String> ids);
    /**
     * 近一年高新区各类型渠道使用发展情况(近12个月)
     * @return
     */
	List<MsgAllChannelUsedDO> getMsgAllChannelUsedCount();
    /**
     * 个人渠道发布商次数TOP10
     * @return
     */
	List<MsgAnalysisSendErrorDO> getPublisherSendTop10(List<String> list);
    /**
     * 近期发布商活跃情况分析
     * @return
     */
	List<MsgActiveSendDO> getActivePublisherSendCount(List<String> appIds,List<Long> channelIds,String appId);
    /**
     * 发布商消息记录分页列表
     */
	List<MsgsListBackDO> getMsgsList(MsgsMessagePublisherDO msgsMessagePublisherDO);
}
