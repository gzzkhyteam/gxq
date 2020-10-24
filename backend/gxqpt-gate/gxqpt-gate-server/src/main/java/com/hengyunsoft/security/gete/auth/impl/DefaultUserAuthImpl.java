package com.hengyunsoft.security.gete.auth.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.hengyunsoft.security.gete.auth.UserAuth;
public class DefaultUserAuthImpl implements UserAuth {

	@Autowired
	private AppResourceManager appResourceManager;
	@Autowired
	private UserResourceManager userResourceManager;
	
	@Override
	public boolean isPass(String appId, Long userId,String url,String token) {
		
		List<Long> resourceIds = appResourceManager.getResourceId(appId, url, token);
		if(CollectionUtils.isEmpty(resourceIds)) {
			return true;
		}
		return userResourceManager.exitsResource(userId, resourceIds, appId, token);
	}

}
