package com.hengyunsoft.platform.sms.repository.template.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.sms.entity.template.dos.AppointDeleteAppDO;
import com.hengyunsoft.platform.sms.entity.template.dos.AppsDO;
import com.hengyunsoft.platform.sms.entity.template.po.SmsChannelOwner;
import com.hengyunsoft.platform.sms.repository.template.dao.SmsChannelOwnerMapper;
import com.hengyunsoft.platform.sms.repository.template.example.SmsChannelOwnerExample;
import com.hengyunsoft.platform.sms.repository.template.service.SmsChannelOwnerService;
@Service
public class SmsChannelOwnerServiceImpl extends BaseAllServiceImpl<Long, SmsChannelOwner, SmsChannelOwnerExample> implements SmsChannelOwnerService{
	@Autowired
	private SmsChannelOwnerMapper smsChannelOwnerMapper;
	@Override
	protected BaseNormalDao<Long, SmsChannelOwner, SmsChannelOwnerExample> getDao() {		
		return smsChannelOwnerMapper;
	}
	@Override
	public List<AppsDO> getAppList(Set<Long> channelNames) {
		return smsChannelOwnerMapper.getAppList(channelNames);
	}
	
	@Override
	public void deleteByAccountAndAppids(AppointDeleteAppDO appointDeleteAppDTO) {		
		smsChannelOwnerMapper.deleteByAccountAndAppids(appointDeleteAppDTO);
	}

    @Override
    public List<SmsChannelOwner> getOwnerChannerl(SmsChannelOwner owner) {
        return smsChannelOwnerMapper.getOwnerChannerl(owner);
    }
}
