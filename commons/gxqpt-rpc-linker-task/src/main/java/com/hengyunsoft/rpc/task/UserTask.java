package com.hengyunsoft.rpc.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hengyunsoft.rpc.consumer.UserdbToRedis;
import com.hengyunsoft.rpc.data.po.UserPO;
import com.hengyunsoft.rpc.source.service.UserService;

@Component
public class UserTask implements Runnable{

	@Autowired
	private UserService userService ;
	@Autowired
	private UserdbToRedis userdbToRedis;
	private int pageSize = 100 ;
	
	@Override
	@Scheduled(fixedDelay=60*1000)
	public void run() {
		
		long startId = Long.MIN_VALUE;
		List<UserPO> users;
		while(true) {
			
			users = userService.listIdOrderByMinId(startId, pageSize);
			System.out.println(users);
			if(users == null || users.isEmpty()) {
				break ;
			}
			startId = users.get(users.size()-1).getId();
			userdbToRedis.persistent(users);
			if(users.size() < pageSize) {
				break ;
			}
		}
	}
}
