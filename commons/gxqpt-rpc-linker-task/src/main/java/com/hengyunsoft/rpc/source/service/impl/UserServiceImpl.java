package com.hengyunsoft.rpc.source.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.rpc.data.po.UserPO;
import com.hengyunsoft.rpc.source.service.UserService;
import com.hengyunsoft.sync.source.dao.BaseMapper;
import com.hengyunsoft.sync.source.service.impl.BaseServiceImpl;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserPO,Long> implements UserService {

	@Autowired
	private BaseMapper<UserPO> userMapper;

	@Override
	public BaseMapper<UserPO> getBaseMapper() {
		return userMapper;
	}
}
