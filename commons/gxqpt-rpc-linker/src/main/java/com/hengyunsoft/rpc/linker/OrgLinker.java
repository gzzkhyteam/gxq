package com.hengyunsoft.rpc.linker;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hengyunsoft.rpc.data.po.OrgPO;
import com.hengyunsoft.rpc.data.repository.BaseRepository;
import com.hengyunsoft.rpc.data.repository.redis.OrgRedis;

@Component
public class OrgLinker extends BaseLinker<OrgPO>{

	@Autowired
	private OrgRedis OrgRedis;
	@Override
	protected BaseRepository<OrgPO> getBaseRepository() {
		return OrgRedis;
	}
	@Override
	protected Serializable getId(OrgPO value) {
		return value.getId();
	}
}