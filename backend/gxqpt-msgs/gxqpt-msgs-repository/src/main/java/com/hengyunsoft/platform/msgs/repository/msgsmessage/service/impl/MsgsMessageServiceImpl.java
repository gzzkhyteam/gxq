package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgsListDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgsMessageQueryDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.ChannelByAnalysis;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsMessage;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsMessageMerge;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.dao.MsgsMessageMapper;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MsgsMessageExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MsgsMessageQueryParam;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MsgsMessageService;

@Service
public class MsgsMessageServiceImpl extends BaseAllServiceImpl<Long, MsgsMessage, MsgsMessageExample>
implements MsgsMessageService {

    @Autowired
    private MsgsMessageMapper msgsMessageMapper;

    @Override
    protected BaseNormalDao<Long, MsgsMessage, MsgsMessageExample> getDao(){
        return msgsMessageMapper;
    }


    @Override
    public List<MsgsMessageMerge> queryMsgsMergeChannel(MsgsMessageQueryParam msgsMessageQueryParam) {
        return msgsMessageMapper.queryMessageMergeChannelByPage(msgsMessageQueryParam);
    }

    @Override
    public int updateMessageById(MsgsMessage msgsMessage) {
        return msgsMessageMapper.updateMessageById(msgsMessage);
    }
    //渠道平台消息量分析
    @Override
    public List<ChannelByAnalysis> getCountToChannelType(Date startDate, Date endDate) {
        MsgsMessageQueryParam msgsMessageQueryParam = new MsgsMessageQueryParam();
        msgsMessageQueryParam.setCreateTimeStart(startDate);
        msgsMessageQueryParam.setCreateTimeEnd(endDate);
        return msgsMessageMapper.queryChannelByAnalysis(msgsMessageQueryParam);
    }

	@Override
	public void updateStatusById(Long id) {
		msgsMessageMapper.updateStatusById(id);		
	}
    /**
     * 获取信息列表
     * @param msgsMessageQueryDTO
     * @return
     */
	@Override
	public List<MsgsListDO> getMsgsList(MsgsMessageQueryDO msgsMessageQueryDTO) {
		return msgsMessageMapper.getMsgsList(msgsMessageQueryDTO);	
	}

}
