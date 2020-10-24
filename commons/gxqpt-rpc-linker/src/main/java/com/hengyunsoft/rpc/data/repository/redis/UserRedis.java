package com.hengyunsoft.rpc.data.repository.redis;

import org.springframework.stereotype.Repository;

import com.hengyunsoft.rpc.data.po.UserPO;
import com.hengyunsoft.rpc.data.repository.UserRepository;

@Repository
public class UserRedis extends BaseRepositoryImpl<UserPO> implements UserRepository{

	@Override
	protected Class<UserPO> getTClass() {
		return UserPO.class;
	}
	
}
