package com.hengyunsoft.rpc.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hengyunsoft.rpc.data.po.DepartmentPO;
import com.hengyunsoft.rpc.target.repository.DepartmentRepository;
import com.hengyunsoft.sync.consumer.BaseDataToRedis;
import com.hengyunsoft.sync.consumer.IConsumer;
import com.hengyunsoft.sync.target.repository.BaseRepository;


@Component
public class DepartmentdbToRedis extends BaseDataToRedis<DepartmentPO> implements IConsumer<DepartmentPO>{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public BaseRepository<DepartmentPO> getBaseRepository() {
		
		return departmentRepository;
	}

	@Override
	public String getId(DepartmentPO t) {
		return t.getId();
	}

}
