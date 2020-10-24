package com.hengyunsoft.rpc.target.repository.redis;

import org.springframework.stereotype.Repository;

import com.hengyunsoft.rpc.data.po.UserPO;
import com.hengyunsoft.rpc.target.repository.UserRepository;
import com.hengyunsoft.sync.target.repository.redis.BaseRepositoryImpl;

@Repository
public class UserRedis extends BaseRepositoryImpl<UserPO> implements UserRepository{

	@Override
	protected Class<UserPO> getTClass() {
		return UserPO.class;
	}
	
}
