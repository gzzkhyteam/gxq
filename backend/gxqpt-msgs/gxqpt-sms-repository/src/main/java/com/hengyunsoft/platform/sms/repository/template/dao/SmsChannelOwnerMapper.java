package com.hengyunsoft.platform.sms.repository.template.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.sms.entity.template.dos.AppointDeleteAppDO;
import com.hengyunsoft.platform.sms.entity.template.dos.AppsDO;
import com.hengyunsoft.platform.sms.entity.template.po.SmsChannelOwner;
import com.hengyunsoft.platform.sms.repository.template.example.SmsChannelOwnerExample;

@Repository
public interface SmsChannelOwnerMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, SmsChannelOwner, SmsChannelOwnerExample> {
	List<AppsDO> getAppList(@Param(value = "channelNames") Set<Long> channelNames);
	
	void deleteByAccountAndAppids(@Param(value = "appointDeleteAppDTO")AppointDeleteAppDO appointDeleteAppDTO);

    List<SmsChannelOwner> getOwnerChannerl(SmsChannelOwner owner);
}