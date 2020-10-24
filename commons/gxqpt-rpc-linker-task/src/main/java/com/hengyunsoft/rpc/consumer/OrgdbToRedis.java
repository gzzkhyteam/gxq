package com.hengyunsoft.rpc.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hengyunsoft.rpc.data.po.OrgPO;
import com.hengyunsoft.rpc.target.repository.OrgRepository;
import com.hengyunsoft.sync.consumer.BaseDataToRedis;
import com.hengyunsoft.sync.target.repository.BaseRepository;

@Component
public class OrgdbToRedis extends BaseDataToRedis<OrgPO> {

	@Autowired
	private OrgRepository orgRepository;
	@Override
	public BaseRepository<OrgPO> getBaseRepository() {
		return orgRepository;
	}

	@Override
	public String getId(OrgPO t) {
		return t.getId();
	}

}
