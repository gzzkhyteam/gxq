package com.hengyunsoft.security.gete.auth.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.ExceptionCode;
import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationAllDTO;
import com.hengyunsoft.platform.developer.api.service.dto.module.serviceresource.ServiceResourceDTO;
import com.hengyunsoft.security.gete.auth.ApplicationAuth;
import com.hengyunsoft.security.gete.feign.AuthInfoApi;
import com.hengyunsoft.security.gete.utils.IShareCache;
import com.hengyunsoft.security.gete.utils.WEBUtils;

public class DefaultApplicationAuthImpl implements ApplicationAuth {

	@Autowired
	private IShareCache shareCache;
	@Autowired
	private AuthInfoApi authInfoApi;
	private final static long timeout_min = 20;
	
	@Override
	public Long moduleIdOfConsumerUseable(String consumerAppId,String producerAppId,String url, String token) {
		
		String formatterUrl = WEBUtils.formatterUrl(url);
		Long moduleId = getPublicModuleId(producerAppId,formatterUrl,token);
		if(moduleId != null) {
			return moduleId;
		}
		
		return getPrivateModuleId( consumerAppId, producerAppId,  formatterUrl,  token);
	}

	/**
	 *  判断消费者是否可用消息指定生产者的资源
	 * @param consumerAppId   消息者appid
	 * @param producerAppId   生产者appid
	 * @param url             要消费的资源
	 * @param token
	 * @return
	 */
	private Long getPrivateModuleId(String consumerAppId, String producerAppId, String url, String token) {
		
		Map<Long, List<String>> moduleId2Resourceurls = getModuleId2ResourceUrl(producerAppId, url, token);
		if(moduleId2Resourceurls.size() < 1) {
			return null;
		}
		
		List<Long> moduleIds = getConsumableModuleId(consumerAppId,token);
		if(moduleIds.size() < 1) {
			return null;
		}
		for (Long moduleId : moduleIds) {
			
			List<String> resourceUrl =  moduleId2Resourceurls.get(moduleId);
			if(CollectionUtils.isEmpty(resourceUrl) ||  !resourceUrl.contains(url)) {
				continue;
			} else {
				return moduleId;
			}
		}
		
		return null;
	}

	/**
	 * 获取指定消费者可用指定生产者的所有可用资源id集合
	 * @param consumerAppId
	 * @param producerAppId
	 * @return
	 */
	private List<Long> getConsumableModuleId(String consumerAppId, String token) {
		
		List<Long> privateModuleIds = (List<Long>) shareCache.get(privateConsumerKey(consumerAppId));
		if(privateModuleIds == null) {
			
			Result<List<Long>> moduleIds= authInfoApi.getConsumerModuleIdsUsable(consumerAppId,token);
			if(moduleIds.isSuccess()) {
				//这里随机数20以内   怕的是同时缓存失效
				long timeoutCur = timeout_min + Math.round(Math.random()*30) ;
				if(moduleIds.getData() != null && moduleIds.getData().size() > 0) {
					privateModuleIds = moduleIds.getData();
				} else {
					privateModuleIds = Collections.EMPTY_LIST;
				}
				shareCache.putFixedTimeout(privateConsumerKey(consumerAppId), privateModuleIds, timeoutCur , TimeUnit.MINUTES);
			} else {
				throw new BizException(ExceptionCode.LOAD_RESOURCES_ERROR.getCode(),ExceptionCode.LOAD_RESOURCES_ERROR.getMsg());
			}
		}
		return privateModuleIds;
	}

	private String privateConsumerKey(String consumerAppId) {
		
		return new StringBuilder("gate:private:urls:").append(consumerAppId).toString();
	}

	/**
	 * 获取指定生产者的指定资源的id号
	 * @param producerAppId
	 * @param url
	 * @param token
	 * @return
	 */
	private Map<Long, List<String>> getModuleId2ResourceUrl(String producerAppId, String url, String token) {
	

		Map<Long,List<String>> privateUrls = (Map<Long,List<String>>) shareCache.get(privateUrlKey(producerAppId));
		if(privateUrls == null) {
			
			Result<List<ServiceResourceDTO>> resources= authInfoApi.getServiceResourceOfAppPrivateUsable(producerAppId,token);
			if(resources.isSuccess()) {
				//这里随机数20以内   怕的是同时缓存失效
				long timeoutCur = timeout_min + Math.round(Math.random()*20) ;
				if(resources.getData() != null && resources.getData().size() > 0) {
					privateUrls = simplify(resources.getData());
				} else {
					privateUrls = Collections.EMPTY_MAP;
				}
				shareCache.putFixedTimeout(privateUrlKey(producerAppId), privateUrls, timeoutCur , TimeUnit.MINUTES);
			} else {
				throw new BizException(ExceptionCode.LOAD_RESOURCES_ERROR.getCode(),ExceptionCode.LOAD_RESOURCES_ERROR.getMsg());
			}
		}
		return privateUrls;
	}

	

	private Map<Long, List<String>> simplify(List<ServiceResourceDTO> data) {
		
		Map<Long, List<String>> moduleId2ResourceUrl = new HashMap<>();
		
		for (ServiceResourceDTO serviceResource : data) {
		
			List<String> resources = moduleId2ResourceUrl.get(serviceResource.getModuleId());
			if(resources == null) {
				resources = new ArrayList<>();
				moduleId2ResourceUrl.put(serviceResource.getModuleId(), resources);
			}
			resources.add(WEBUtils.formatterUrl(serviceResource.getUrl()));
		}
		
		return moduleId2ResourceUrl;
	}

	/**
	 * 获取指定url所对应的服务功能（模块id）
	 * 若没有返回null   表示没有公有模块包含此url
	 * @param url
	 * @param token 
	 */
	private Long getPublicModuleId(String producerAppId, String url, String token) {
		
		Map<Long,List<String>> urls = getPublicUrl(producerAppId,token);
		if(urls != null) {
			for (Entry<Long, List<String>> moduleId2Urls : urls.entrySet()) {
				if(!CollectionUtils.isEmpty(moduleId2Urls.getValue()) && moduleId2Urls.getValue().contains(url)) {
					return moduleId2Urls.getKey();
				}
			}
		}
		return null;
	}

	private Map<Long,List<String>> getPublicUrl(String producerAppId, String token) {
		

		Map<Long,List<String>> publicUrls = (Map<Long,List<String>>) shareCache.get(publicUrlKey(producerAppId));
		if(publicUrls == null) {
			
			Result<List<ServiceResourceDTO>> publicUrlsR= authInfoApi.getServiceAllPublicUrlsUsable(producerAppId,token);
			if(publicUrlsR.isSuccess()) {
				if(publicUrlsR.getData() != null && publicUrlsR.getData().size() > 0) {
					publicUrls = simplify(publicUrlsR.getData());
				} else {
					publicUrls = Collections.EMPTY_MAP;
				}
				long timeoutCur = timeout_min + Math.round(Math.random()*20) ;
				shareCache.putFixedTimeout(publicUrlKey(producerAppId), publicUrls, timeoutCur , TimeUnit.MINUTES);
			} else {
				throw new BizException(ExceptionCode.LOAD_RESOURCES_ERROR.getCode(),ExceptionCode.LOAD_RESOURCES_ERROR.getMsg());
			}
		}
		return publicUrls;
	}

	private String publicUrlKey(String producerAppId) {
		return "gate:public:urls:" + producerAppId;
	}

	private String privateUrlKey(String producerAppId) {
		return "gate:private:urls:" + producerAppId;
	}
	private String allJryyKey() {
		
		return "gate:jryy:appid";
	}
	private String allServiceId2AppIdKey() {
		
		return "gate:serviceId:appid:map";
	}
	
	@Override
	public boolean isJryy(String appId, String token) {
		
		List<String> jryyAll = getAllJryy(token);
		return !CollectionUtils.isEmpty(jryyAll) && jryyAll.contains(appId);
	}

	private List<String> getAllJryy(String token) {
		
		List<String> jryyAppids = (List<String>) shareCache.get(allJryyKey());
		if(jryyAppids == null) {
			
			Result<List<String>> jryyAppidsR= authInfoApi.getAllUseableJryy(token);
			if(jryyAppidsR.isSuccess()) {
				jryyAppids = jryyAppidsR.getData();
				long timeoutCur = timeout_min + Math.round(Math.random()*20) ;
				shareCache.putFixedTimeout(allJryyKey(), jryyAppids, timeoutCur , TimeUnit.MINUTES);
			} else {
				throw new BizException(ExceptionCode.LOAD_RESOURCES_ERROR.getCode(),ExceptionCode.LOAD_RESOURCES_ERROR.getMsg());
			}
		}
		return jryyAppids;
	}

	@Override
	public List<String> getAppIdsByServiceId(final String serviceId,final String token) {
		
		if(StringUtils.isEmpty(serviceId)) {
			return Collections.EMPTY_LIST;
		}
		
		Map<String, List<String>> serviceId2AppIds = getServiceId2AppIds(token);
		
		String standardFindServiceId = formatterServiceId(serviceId);
		
		return serviceId2AppIds.get(standardFindServiceId);
	}

	private Map<String, List<String>> getServiceId2AppIds(final String token) {
		Map<String,List<String>> serviceId2AppIds = (Map<String, List<String>>) shareCache.get(allServiceId2AppIdKey());
		if(serviceId2AppIds == null) {
			
			Result<List<ApplicationAllDTO>> allApp= authInfoApi.findAllList(token);
			if(allApp.isSuccess()) {
				if(CollectionUtils.isEmpty(allApp.getData())) {
					serviceId2AppIds = Collections.EMPTY_MAP ;
				} else {
					serviceId2AppIds = new HashMap<>();
					for (ApplicationAllDTO app : allApp.getData()) {
						String curAppServiceId = app.getServiceId();
						if(!StringUtils.isEmpty(curAppServiceId)) {
							String standardServiceId = formatterServiceId(curAppServiceId);
							List<String> appIds = serviceId2AppIds.get(standardServiceId);
							if(appIds == null) {
								appIds = new ArrayList<>(3);
								serviceId2AppIds.put(standardServiceId, appIds);
							}
							appIds.add(app.getAppId());
						}
					}
				}
				long timeoutCur = timeout_min + Math.round(Math.random()*20) ;
				shareCache.putFixedTimeout(allServiceId2AppIdKey(), serviceId2AppIds, timeoutCur , TimeUnit.MINUTES);
			} else {
				throw new BizException(ExceptionCode.LOAD_RESOURCES_ERROR.getCode(),ExceptionCode.LOAD_RESOURCES_ERROR.getMsg());
			}
		}
		return serviceId2AppIds;
	}

	private String formatterServiceId(String serviceId) {
		return serviceId.toLowerCase();
	}

	@Override
	public Long getModuleId(String producerAppId, String url, String token) {
		final String formatterUrl = WEBUtils.formatterUrl(url);
		Long moduleId = getPublicModuleId(producerAppId,formatterUrl,token);
		if(moduleId != null) {
			return moduleId;
		}
		
		Map<Long, List<String>> moduleId2Resourceurls = getModuleId2ResourceUrl(producerAppId, formatterUrl, token);
		if(moduleId2Resourceurls == null || moduleId2Resourceurls.isEmpty()) {
			return null;
		}
		for (Entry<Long, List<String>> kv : moduleId2Resourceurls.entrySet()) {
			if(kv.getValue()!=null && kv.getValue().contains(formatterUrl)) {
				return kv.getKey();
			}
		}
		return null;
	}

	

	
}
