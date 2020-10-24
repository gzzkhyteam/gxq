package com.hengyunsoft.platform.msgs.repository.msgsmessagetype.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.msgsmessagetype.po.MsgsMessageType;
import com.hengyunsoft.platform.msgs.repository.msgsmessagetype.dao.MsgsMessageTypeMapper;
import com.hengyunsoft.platform.msgs.repository.msgsmessagetype.example.MsgsMessageTypeExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessagetype.service.MsgsMessageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//消息关联渠道类型表
@Service
public class MsgsMessageTypeServiceImpl  extends BaseAllServiceImpl<Long, MsgsMessageType, MsgsMessageTypeExample>
        implements MsgsMessageTypeService {

    @Autowired
    private MsgsMessageTypeMapper msgsMessageTypeMapper;

    @Override
    protected BaseNormalDao<Long,  MsgsMessageType, MsgsMessageTypeExample> getDao(){
        return msgsMessageTypeMapper;
    }

    @Override
    public int deleteByMessageId(Long messagId) {
        return msgsMessageTypeMapper.deleteByMessageId(messagId);
    }
}
