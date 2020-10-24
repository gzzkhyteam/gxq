package com.hengyunsoft.platform.msgs.repository.channeltype.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.channeltype.po.MsgsChannelType;
import com.hengyunsoft.platform.msgs.repository.channeltype.dao.MsgsChannelTypeMapper;
import com.hengyunsoft.platform.msgs.repository.channeltype.example.MsgsChannelTypeExample;
import com.hengyunsoft.platform.msgs.repository.channeltype.service.MsgsChannelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgsChannelTypeServiceImpl extends BaseAllServiceImpl<Long, MsgsChannelType, MsgsChannelTypeExample>
        implements MsgsChannelTypeService {
    @Autowired
    private MsgsChannelTypeMapper msgsChannelTypeMapper;

    @Override
    protected BaseNormalDao<Long, MsgsChannelType, MsgsChannelTypeExample> getDao(){
        return msgsChannelTypeMapper;
    }

}
