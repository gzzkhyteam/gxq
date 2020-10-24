package com.hengyunsoft.rpc.data.repository.redis;

import org.springframework.stereotype.Repository;

import com.hengyunsoft.rpc.data.po.DepartmentPO;
import com.hengyunsoft.rpc.data.repository.DepartmentRepository;

@Repository
public class DepartmentRedis extends BaseRepositoryImpl<DepartmentPO> implements DepartmentRepository{

	@Override
	protected Class<DepartmentPO> getTClass() {
		return DepartmentPO.class;
	}
}
