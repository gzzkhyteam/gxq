package com.hengyunsoft.rpc.linker;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hengyunsoft.rpc.data.po.UserPO;
import com.hengyunsoft.rpc.data.repository.BaseRepository;
import com.hengyunsoft.rpc.data.repository.redis.UserRedis;

@Component
public class UserLinker extends BaseLinker<UserPO>{

	@Autowired
	private UserRedis userRedis;
	@Override
	protected BaseRepository<UserPO> getBaseRepository() {
		return userRedis;
	}
	@Override
	protected Serializable getId(UserPO value) {
		return value.getId();
	}
}
