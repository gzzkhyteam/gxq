package com.hengyunsoft.platform.developer.repository.service.dao;

import com.hengyunsoft.platform.developer.entity.service.po.ServiceResource;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceResourceMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.developer.entity.service.po.ServiceResource, com.hengyunsoft.platform.developer.repository.service.example.ServiceResourceExample> {
	List<ServiceResource> getByModuleId(Long moduleId);

	List<ServiceResource> getServiceResourceOfAppUsable(@Param("publicIs") Boolean publicIs,@Param("appId") String appId);

	List<ServiceResource> getServiceResourceOfAppConsumer(@Param("appIds") List<String> appIds,@Param("likeResourceName") String likeResourceName);
}