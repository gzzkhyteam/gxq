package com.hengyunsoft.rpc.target.repository.redis;

import org.springframework.stereotype.Repository;

import com.hengyunsoft.rpc.data.po.OrgPO;
import com.hengyunsoft.rpc.target.repository.OrgRepository;
import com.hengyunsoft.sync.target.repository.redis.BaseRepositoryImpl;

@Repository
public class OrgRedis extends BaseRepositoryImpl<OrgPO> implements OrgRepository{

	@Override
	protected Class<OrgPO> getTClass() {
		return OrgPO.class;
	}
}
