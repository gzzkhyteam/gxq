package com.hengyunsoft.rpc.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hengyunsoft.rpc.consumer.OrgdbToRedis;
import com.hengyunsoft.rpc.data.po.OrgPO;
import com.hengyunsoft.rpc.source.service.OrgService;

@Component
public class OrgTask implements Runnable{

	@Autowired
	private OrgService orgService ;
	@Autowired
	private OrgdbToRedis orgdbToRedis;
	private int pageSize = 100 ;
	
	@Override
	@Scheduled(fixedDelay=60*1000)
	public void run() {
		
		String startId = null;
		List<OrgPO> orgs;
		while(true) {
			
			orgs = orgService.listIdOrderByMinId(startId, pageSize);
			System.out.println(orgs);
			if(orgs == null || orgs.isEmpty()) {
				break ;
			}
			startId = orgs.get(orgs.size()-1).getId();
			orgdbToRedis.persistent(orgs);
			if(orgs.size() < pageSize) {
				break ;
			}
		}
	}
}
