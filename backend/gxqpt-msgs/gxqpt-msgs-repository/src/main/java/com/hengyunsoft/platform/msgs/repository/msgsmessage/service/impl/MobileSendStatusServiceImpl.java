package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.channelgroup.po.MobileSendStatus;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisSendErrorDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisSendExceptionDO;
import com.hengyunsoft.platform.msgs.repository.channelgroup.dao.MobileSendStatusMapper;
import com.hengyunsoft.platform.msgs.repository.channelgroup.example.MobileSendStatusExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MobileSendStatusService;

@Service
public class MobileSendStatusServiceImpl extends BaseAllServiceImpl<Long, MobileSendStatus, MobileSendStatusExample> implements MobileSendStatusService{

	@Autowired
	private MobileSendStatusMapper mobileSendStatusMapper;
	@Override
	protected BaseNormalDao<Long, MobileSendStatus, MobileSendStatusExample> getDao() {
		return mobileSendStatusMapper;
	}
	
	@Override
	public List<MobileSendStatus> getByMsgId(String msgId) {
		return mobileSendStatusMapper.getByMsgId(msgId);
	}
    /**
     * 各类型渠道发送问题TOP10
     * @return
     */
	@Override
	public List<MsgAnalysisSendErrorDO> getMsgSendErrorTop10(List<String> list) {
		return mobileSendStatusMapper.getMsgSendErrorTop10(list);
	}
    /**
     * 各渠道类型异常情况分析(近六个月数据)
     * @return
     */
	@Override
	public List<MsgAnalysisSendExceptionDO> getMsgSendExceptionCount(Long userId) {
		return mobileSendStatusMapper.getMsgSendExceptionCount(userId);
	}
}
