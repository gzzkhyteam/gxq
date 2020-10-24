package com.hengyunsoft.security.gete.auth.impl;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.ExceptionCode;
import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceDTO;
import com.hengyunsoft.security.gete.feign.AuthInfoApi;
import com.hengyunsoft.security.gete.utils.IShareCache;
import com.hengyunsoft.security.gete.utils.WEBUtils;

/**
 * 管理应用的菜单资源      
 * 在验证用户的资源权限环境中，充当资源与资源id的转换。
 * 通过提供应用id + 资源url 获取到资源对应的id。
 * @author 潘定遥
 *
 */
public class AppResourceManager {

	@Autowired
	private IShareCache shareCache;
	@Autowired
	private AuthInfoApi authInfoApi;
	private final static long timeout_min = 20;

	
	/**
	 * 获取指定应用指定的资源id号。
	 * @param appId 
	 * @param url
	 * @param token
	 * @return null 表示该资源不再应用所管理的资源之下。
	 */
	public List<Long> getResourceId(String appId,String url, String token) {
		
		if(StringUtils.isEmpty(appId) || StringUtils.isEmpty(url)) {
			return null;
		}
		Map<String, List<Long>> uri2Ids = getResource(appId,token);
		return findUrlId(uri2Ids,WEBUtils.formatterUrl(url));
	}


	private Map<String, List<Long>> getResource(String appId, String token) {

		Map<String, List<Long>> uri2Ids = (Map<String, List<Long>>) shareCache.get(key(appId));
		if(uri2Ids == null) {
			Result<List<ResourceDTO>> resources = authInfoApi.getAppAllNotpublicResourceOfExistAuthUrls(appId,token);
			if(resources.isSuccess()) {
				//这里随机数20以内   怕的是同时缓存失效
				long timeoutCur = timeout_min + Math.round(Math.random()*30) ;
				if(resources.getData() != null) {
					uri2Ids = simplify(resources.getData());
				} else {
					uri2Ids = Collections.EMPTY_MAP;
				}
				shareCache.putFixedTimeout(key(appId), uri2Ids, timeoutCur , TimeUnit.MINUTES);
			} else {
				throw new BizException(ExceptionCode.LOAD_RESOURCES_ERROR.getCode(),ExceptionCode.LOAD_RESOURCES_ERROR.getMsg()+ resources.getErrmsg());
			}
		}
		return uri2Ids;
	}


	private List<Long> findUrlId(Map<String, List<Long>> uri2Ids, String url) {
		
		
		for (Entry<String, List<Long>> uri2Id : uri2Ids.entrySet()) {
			if(url.equals(uri2Id.getKey())) {
				return uri2Id.getValue();
			}
		}
		return Collections.EMPTY_LIST;
	}


	private Map<String,List<Long>> simplify(List<ResourceDTO> resources) {
		
		Map<String,List<Long>> uri2Ids = new HashMap<>();
		for (ResourceDTO resource : resources) {
			if(StringUtils.isEmpty(resource.getAuthUrls())) {
				continue ;
			}
			 String[] authUrls = resource.getAuthUrls().split(";");
			 
			 for (String authUrl : authUrls) {
				 String formatter = WEBUtils.formatterUrl(authUrl);
				 if(StringUtils.isEmpty(formatter)) {
					 continue ;
				 }
				 List<Long> ids = uri2Ids.get(formatter);
				 if(ids == null) {
					 ids = new ArrayList<>(5);
					 uri2Ids.put(formatter, ids);
				 } 
				 ids.add(resource.getId());
			 }
		}
		
		return uri2Ids;
//		return resources.stream().filter(resource -> StringUtils.isNotEmpty(resource.getAuthUrls())).flatMap(resource -> {
//					 String[] authUrls = resource.getAuthUrls().split(";");
//					 List<ResourceSimplify> resim = new ArrayList<>(authUrls.length);
//					 for (String authUrl : authUrls) {
//						 String formatter = WEBUtils.formatterUrl(authUrl);
//						 if(StringUtils.isEmpty(formatter)) {
//							 continue ;
//						 }
//						 ResourceSimplify resourceSimplify = new ResourceSimplify();
//				         resourceSimplify.setId( resource.getId());
//						 resourceSimplify.setUrl(formatter);
//						 resim.add(resourceSimplify);
//					 }
//					 return resim.stream();
//		       }).collect(Collectors.toList());
//		return simplifies;
	}
	

	private String key(String appId) {

		return "gate:app:"+appId;
	}
	

}
