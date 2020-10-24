package com.hengyunsoft.rpc.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hengyunsoft.rpc.consumer.DepartmentdbToRedis;
import com.hengyunsoft.rpc.data.po.DepartmentPO;
import com.hengyunsoft.rpc.source.service.DepartmentService;

@Component
public class DepartmentTask implements Runnable{

	@Autowired
	private DepartmentService departmentService ;
	@Autowired
	private DepartmentdbToRedis departmentdbToRedis;
	private int pageSize = 100 ;
	
	@Override
	@Scheduled(fixedDelay=60*1000)
	public void run() {
		
		String startId = null;
		List<DepartmentPO> departments;
		while(true) {
			
			departments = departmentService.listIdOrderByMinId(startId, pageSize);
			System.out.println(departments);
			if(departments == null || departments.isEmpty()) {
				break ;
			}
			startId = departments.get(departments.size()-1).getId();
			departmentdbToRedis.persistent(departments);
			if(departments.size() < pageSize) {
				break ;
			}
		}
	}
}
