package com.hengyunsoft.rpc.linker;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hengyunsoft.rpc.data.po.DepartmentPO;
import com.hengyunsoft.rpc.data.repository.BaseRepository;
import com.hengyunsoft.rpc.data.repository.redis.DepartmentRedis;

@Component
public class DepartmentLinker extends BaseLinker<DepartmentPO>{

	@Autowired
	private DepartmentRedis DepartmentRedis;
	@Override
	protected BaseRepository<DepartmentPO> getBaseRepository() {
		return DepartmentRedis;
	}
	@Override
	protected Serializable getId(DepartmentPO value) {
		return value.getId();
	}
}