package com.hengyunsoft.rpc.target.repository.redis;

import org.springframework.stereotype.Repository;

import com.hengyunsoft.rpc.data.po.DepartmentPO;
import com.hengyunsoft.rpc.target.repository.DepartmentRepository;
import com.hengyunsoft.sync.target.repository.redis.BaseRepositoryImpl;

@Repository
public class DepartmentRedis extends BaseRepositoryImpl<DepartmentPO> implements DepartmentRepository{

	@Override
	protected Class<DepartmentPO> getTClass() {
		return DepartmentPO.class;
	}
}
