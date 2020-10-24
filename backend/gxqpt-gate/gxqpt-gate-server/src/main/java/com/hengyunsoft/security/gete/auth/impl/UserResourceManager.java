package com.hengyunsoft.security.gete.auth.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.ExceptionCode;
import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceDTO;
import com.hengyunsoft.security.gete.feign.AuthInfoApi;
import com.hengyunsoft.security.gete.utils.IShareCache;
/**
 * 管理用户的菜单资源      
 * 在验证用户的资源权限环境中，充当验证的功能，判断用户是否有指定应用下的指定资源权限。
 * 
 * 
 * @author 潘定遥
 *
 */
public class UserResourceManager {
	@Autowired
	private IShareCache shareCache;
	@Autowired
	private AuthInfoApi authInfoApi;
	private final static long timeout_min = 20;
	
	/**
	 * 判断指定用户在指定应用下是否有指定的资源权限
	 * @param userId          需要判断的用户id
	 * @param resourceIds      需要判断的资源id
	 * @param appId           需要判断的应用id
	 * @param token           仅仅因为后端访问需要token进行传输而已。
	 * @return
	 */
	public boolean exitsResource(Long userId,List<Long> resourceIds,String appId, String token) {
		
		List<Long> selfResourceIds = getUserAllResourceId(userId, appId, token);
		return selfResourceIds.stream().anyMatch(id -> resourceIds.contains(id));
	}

	/**
	 * 获取用户在指定应用下所拥有的所有资源id集合
	 * @param userId
	 * @param appId
	 * @param token
	 * @return
	 */
	private List<Long> getUserAllResourceId(Long userId, String appId, String token) {
		List<Long> obj = (List<Long>) shareCache.get(key(userId,appId));
		if(obj == null) {
			List<Long> resourceIds = loadResource( userId, appId,token);
			//这里随机数20以内   怕的是同时缓存失效
			long timeoutCur = timeout_min + Math.round(Math.random()*30) ;
			shareCache.putFixedTimeout(key(userId,appId), resourceIds, timeout_min, TimeUnit.MINUTES);
			obj = resourceIds;
		}
		return obj;
	}

	private boolean doExitsResource(Long resourceId, List<Long> resourceIds) {
		
		for (Long selfResourceId : resourceIds) {
			if(resourceId.equals(selfResourceId)) {
				return true;
			}
		}
		return false;
	}

	private List<Long> loadResource(Long userId, String appId, String token) {
		
		Result<List<ResourceDTO>> resources = authInfoApi.findResByAppIdAndUserId(appId,userId,null ,token);
		if(resources.isSuccess()) {
			
			if(resources.getData() != null) {
			     List<Long> resourceIds = new ArrayList<>();
			     for (ResourceDTO treeDto : resources.getData()) {
			    	 resourceIds.add(Long.valueOf(treeDto.getId().toString()));
				}
			     return resourceIds;
			} else {
				return Collections.EMPTY_LIST;
			}
			
		} else {
			throw new BizException(ExceptionCode.LOAD_RESOURCES_ERROR.getCode(),ExceptionCode.LOAD_RESOURCES_ERROR.getMsg());
		}
		
	}

	private String key(Long userId, String appId) {
		
		
		return new StringBuilder("gate:uRsc:").append(appId).append('-').append(userId).toString();
	}
}
