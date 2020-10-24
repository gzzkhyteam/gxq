package com.hengyunsoft.platform.developer.repository.apply.service;

import java.util.List;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceResource;
import com.hengyunsoft.platform.developer.repository.service.example.ServiceResourceExample;

public interface ServiceResourceService extends BaseService<Long, ServiceResource, ServiceResourceExample>{

    /**
     * 描述：根据模块id查询服务资源Api
     * 参数：模块id
     * 返回值：List<ServiceResource>
     * 修改人：sunxiaoya
     * 修改时间：2018/4/4
     * 修改内容：
     */
	List<ServiceResource> getByModuleId(Long moduleId);

    /** 
     * 加载指定应用的服务资源中的所有公有（对所有应用开放）可用的资源链接地址
     */
	List<ServiceResource> getServiceAllPublicUrlsUsableByAppId(String appId);

	/**
	 * 获取应用非公开的所有可用使用的服务资源
	 * @param appId
	 * @return
	 */
	List<ServiceResource> getServiceResourceOfAppPrivateUsable(String appId);

	/**
	 * 获取指定应用集合消费的资源列表
	 * @param appIds   消费的appIds集合
	 * @param likeResourceName  
	 * @return
	 */
	List<ServiceResource> getServiceResourceOfAppConsumer(List<String> appIds, String likeResourceName);
}
