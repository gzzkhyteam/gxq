package com.hengyunsoft.platform.admin.open.sync;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hengyunsoft.data.sync.server.IIncrementDataSync;
import com.hengyunsoft.data.sync.server.controller.SyncController;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;

@RestController
@RequestMapping("sync")
@IgnoreToken
public class AdminServerSyncController extends SyncController implements ApplicationContextAware {
	

	@Override
	@IgnoreToken
	public Long getCurrentSysTime(@PathVariable("service") String service) {
		return super.getCurrentSysTime(service);
	}
	
	@IgnoreToken
	@Override
	public List syncData(@PathVariable("service") String service, Integer limit, Integer syncFlag, Long minUpdateTime) {
		// TODO Auto-generated method stub
		return super.syncData(service, limit, syncFlag, minUpdateTime);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		Map<String, IIncrementDataSync> serviceSync = applicationContext.getBeansOfType(IIncrementDataSync.class);
		setServices(serviceSync);
	}
	
	@IgnoreToken
	public Boolean cleanSyncFlag(@PathVariable("service") String service,Integer syncFlag,Long minUpdateTime) {
		
		return super.cleanSyncFlag(service, syncFlag, minUpdateTime);
	}
	
	private ApplicationContext applicationContext = null;
}
