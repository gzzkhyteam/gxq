package com.hengyunsoft.platform.msgs.repository.msgscontactoften.service.impl;


import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.msgscontactoften.po.MsgsContactOften;
import com.hengyunsoft.platform.msgs.repository.msgscontactoften.dao.MsgsContactOftenMapper;
import com.hengyunsoft.platform.msgs.repository.msgscontactoften.example.MsgsContactOftenExample;
import com.hengyunsoft.platform.msgs.repository.msgscontactoften.service.MsgsContactOftenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgsContactOftenServiceImpl extends BaseAllServiceImpl<Long, MsgsContactOften, MsgsContactOftenExample>
        implements MsgsContactOftenService{
    @Autowired
    MsgsContactOftenMapper msgsContactOftenMapper;

    @Override
    protected BaseNormalDao<Long,MsgsContactOften,MsgsContactOftenExample> getDao() {return msgsContactOftenMapper;}


}

