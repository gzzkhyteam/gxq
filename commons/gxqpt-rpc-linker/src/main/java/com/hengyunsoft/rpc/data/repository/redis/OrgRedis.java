package com.hengyunsoft.rpc.data.repository.redis;

import org.springframework.stereotype.Repository;

import com.hengyunsoft.rpc.data.po.OrgPO;
import com.hengyunsoft.rpc.data.repository.OrgRepository;

@Repository
public class OrgRedis extends BaseRepositoryImpl<OrgPO> implements OrgRepository{

	@Override
	protected Class<OrgPO> getTClass() {
		return OrgPO.class;
	}
}
