package com.hengyunsoft.platform.msgs.repository.msgsmessage.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.BlackListDeleteDO;

@Repository
public interface MsgsBlacklistMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsBlacklist, com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MsgsBlacklistExample> {

	void deleteByAppId(@Param(value="blackListDeleteDTO")BlackListDeleteDO blackListDeleteDTO);

}