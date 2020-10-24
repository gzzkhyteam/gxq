package com.hengyunsoft.platform.msgs.repository.msgsmessage.service;

import java.util.List;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisSendErrorDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisSendExceptionDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.WechatSendStatus;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.WechatSendStatusExample;

public interface WechatSendStatusService extends BaseAllService<Long, WechatSendStatus, WechatSendStatusExample>{
	
	public List<WechatSendStatus> getByMsgId(String msgId);	
    /**
     * 各类型渠道发送问题TOP10
     * @return
     */
	List<MsgAnalysisSendErrorDO> getMsgSendErrorTop10(List<String> list);
    /**
     * 各渠道类型异常情况分析(近六个月数据)
     * @return
     */
	List<MsgAnalysisSendExceptionDO> getMsgSendExceptionCount(Long userId);
}
