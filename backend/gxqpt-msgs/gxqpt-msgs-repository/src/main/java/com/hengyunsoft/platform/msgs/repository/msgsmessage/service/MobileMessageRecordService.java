package com.hengyunsoft.platform.msgs.repository.msgsmessage.service;

import java.util.List;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.channelgroup.po.MobileMessageRecord;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAllChannelUsedDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisChannelUsedDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisSendErrorDO;
import com.hengyunsoft.platform.msgs.repository.channelgroup.example.MobileMessageRecordExample;

public interface MobileMessageRecordService extends BaseAllService<Long, MobileMessageRecord, MobileMessageRecordExample>{

	List<MobileMessageRecord> getAll();
	
	MobileMessageRecord getNewest();
	
	int getTotalNum();
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
}
