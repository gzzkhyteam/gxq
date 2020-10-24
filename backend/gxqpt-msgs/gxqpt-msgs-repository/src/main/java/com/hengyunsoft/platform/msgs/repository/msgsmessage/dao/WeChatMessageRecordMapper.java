package com.hengyunsoft.platform.msgs.repository.msgsmessage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgActiveSendDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAllChannelUsedDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisChannelUsedDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisSendErrorDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgsListBackDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgsMessagePublisherDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.WeChatMessageRecord;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.WeChatMessageRecordExample;

@Repository
public interface WeChatMessageRecordMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, WeChatMessageRecord, WeChatMessageRecordExample> {
	List<WeChatMessageRecord> getBySendstatus(Integer status);
	/**
	 * 根据信息id更新记录
	 * @param msgId
	 * @return
	 */
	void updateByMsgId(WeChatMessageRecord weChatMessageRecord);
	/**
	 * 根据信息id获取id
	 * @param msgId
	 * @return
	 */
	Long getIdByMsgId(String msgId);
    /**
     * 个人渠道使用情况
     * @return
     */
	List<MsgAnalysisChannelUsedDO> getMsgChannelUsedCount(@Param(value="userId")String userId,@Param(value="ids") List<String> ids);
    /**
     * 近一年高新区各类型渠道使用发展情况(近12个月)
     * @return
     */
	List<MsgAllChannelUsedDO> getMsgAllChannelUsedCount();
    /**
     * 个人渠道发布商次数TOP10
     * @return
     */
	List<MsgAnalysisSendErrorDO> getPublisherSendTop10(@Param(value="ids") List<String> ids);
    /**
     * 近期发布商活跃情况分析
     * @return
     */
	List<MsgActiveSendDO> getActivePublisherSendCount(@Param(value="appIds")List<String> appIds,@Param(value="channelIds")List<Long> channelIds,@Param(value="appId")String appId);
    /**
     * 发布商消息记录分页列表
     */
	List<MsgsListBackDO> getMsgsList(@Param(value="msgsMessagePublisherDTO")MsgsMessagePublisherDO msgsMessagePublisherDTO);
}