package com.hengyunsoft.rpc.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hengyunsoft.rpc.data.po.UserPO;
import com.hengyunsoft.rpc.target.repository.UserRepository;
import com.hengyunsoft.sync.consumer.BaseDataToRedis;
import com.hengyunsoft.sync.consumer.IConsumer;
import com.hengyunsoft.sync.target.repository.BaseRepository;


@Component
public class UserdbToRedis extends BaseDataToRedis<UserPO> implements IConsumer<UserPO>{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public BaseRepository<UserPO> getBaseRepository() {
		
		return userRepository;
	}

	@Override
	public String getId(UserPO t) {
		return t.getId().toString();
	}

}
