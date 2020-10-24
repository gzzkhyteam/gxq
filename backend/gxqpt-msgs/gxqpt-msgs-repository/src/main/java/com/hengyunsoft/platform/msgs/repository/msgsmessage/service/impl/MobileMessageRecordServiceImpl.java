package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.channelgroup.po.MobileMessageRecord;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAllChannelUsedDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisChannelUsedDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisSendErrorDO;
import com.hengyunsoft.platform.msgs.repository.channelgroup.dao.MobileMessageRecordMapper;
import com.hengyunsoft.platform.msgs.repository.channelgroup.example.MobileMessageRecordExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MobileMessageRecordService;
@Service
public class MobileMessageRecordServiceImpl extends BaseAllServiceImpl<Long, MobileMessageRecord, MobileMessageRecordExample> implements MobileMessageRecordService{

	@Autowired
	private MobileMessageRecordMapper mobileMessageRecordMapper;
	@Override
	protected BaseNormalDao<Long, MobileMessageRecord, MobileMessageRecordExample> getDao() {		
		return mobileMessageRecordMapper;
	}
	
	@Override
	public List<MobileMessageRecord> getAll() {
		return mobileMessageRecordMapper.getAll();
	}

	@Override
	public MobileMessageRecord getNewest() {
		return mobileMessageRecordMapper.getNewest();
	}

	@Override
	public int getTotalNum() {
		return mobileMessageRecordMapper.getTotalNum();
	}
    /**
     * 个人渠道使用情况
     * @return
     */
	@Override
	public List<MsgAnalysisChannelUsedDO> getMsgChannelUsedCount(String userId,List<String> ids) {
		return mobileMessageRecordMapper.getMsgChannelUsedCount(userId,ids);
	}
    /**
     * 近一年高新区各类型渠道使用发展情况(近12个月)
     * @return
     */
	@Override
	public List<MsgAllChannelUsedDO> getMsgAllChannelUsedCount() {
		return mobileMessageRecordMapper.getMsgAllChannelUsedCount();
	}
    /**
     * 个人渠道发布商次数TOP10
     * @return
     */
	@Override
	public List<MsgAnalysisSendErrorDO> getPublisherSendTop10(List<String> list) {
		return mobileMessageRecordMapper.getPublisherSendTop10(list);
	}
}
