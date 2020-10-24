package com.hengyunsoft.platform.msgs.repository.channelgroup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.msgs.entity.channelgroup.po.MobileSendStatus;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisSendErrorDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisSendExceptionDO;

@Repository
public interface MobileSendStatusMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.msgs.entity.channelgroup.po.MobileSendStatus, com.hengyunsoft.platform.msgs.repository.channelgroup.example.MobileSendStatusExample> {

	public List<MobileSendStatus> getByMsgId(@Param(value="msgId")String msgId);
    /**
     * 各类型渠道发送问题TOP10
     * @return
     */
	List<MsgAnalysisSendErrorDO> getMsgSendErrorTop10(@Param(value="list")List<String> list);
    /**
     * 各渠道类型异常情况分析(近六个月数据)
     * @return
     */
	List<MsgAnalysisSendExceptionDO> getMsgSendExceptionCount(@Param(value="userId")Long userId);
}