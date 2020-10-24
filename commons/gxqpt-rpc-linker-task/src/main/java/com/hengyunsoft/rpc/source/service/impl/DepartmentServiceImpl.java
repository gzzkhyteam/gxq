package com.hengyunsoft.rpc.source.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.rpc.data.po.DepartmentPO;
import com.hengyunsoft.rpc.source.service.DepartmentService;
import com.hengyunsoft.sync.source.dao.BaseMapper;
import com.hengyunsoft.sync.source.service.impl.BaseServiceImpl;

@Service
public class DepartmentServiceImpl extends BaseServiceImpl<DepartmentPO,String> implements DepartmentService {

	@Autowired
	private BaseMapper<DepartmentPO> DepartmentMapper;

	@Override
	public BaseMapper<DepartmentPO> getBaseMapper() {
		return DepartmentMapper;
	}
}
