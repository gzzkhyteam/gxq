package com.hengyunsoft.security.auth.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.commons.config.Constants;
import com.hengyunsoft.platform.developer.entity.apply.po.Application;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceModule;
import com.hengyunsoft.platform.developer.entity.service.po.domain.ServiceAssignModuleDO;
import com.hengyunsoft.platform.developer.repository.apply.example.ApplicationExample;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationService;
import com.hengyunsoft.platform.developer.repository.apply.service.ServiceModuleService;
import com.hengyunsoft.platform.developer.repository.service.example.ServiceModuleExample;
import com.hengyunsoft.platform.developer.repository.service.service.ServiceAssignModuleService;
import com.hengyunsoft.security.auth.api.ApplicationApi;

@RestController
public class ApplicationApiImpl implements ApplicationApi {

    @Autowired
    private ServiceAssignModuleService serviceAssignModuleService;
    @Autowired
    private ServiceModuleService serviceModuleService;
    @Autowired
    private ApplicationService applicationService;
    
	@Override
	public Result<List<String>> findRatifySsoAppList() {
		
		ServiceModuleExample moduleExample = new ServiceModuleExample();
		moduleExample.createCriteria().andCodeEqualTo(Constants.SERVICE_MODULE_CODE_SSO);
		ServiceModule serviceModel = serviceModuleService.getUnique(moduleExample );
		if(serviceModel == null) {
			return Result.fail("没有发现编码为"+Constants.SERVICE_MODULE_CODE_SSO+"的单点登录模块");
		}
		
		List<ServiceAssignModuleDO> assignModuleDOs = serviceAssignModuleService.moduleConsumePage(serviceModel.getId());
		if(assignModuleDOs.isEmpty()) {
			return Result.success(Collections.EMPTY_LIST);
		}
		List<String> applicationIds = assignModuleDOs.stream().filter(r->r.getAppId()!=null).map(r->r.getAppId()).collect(Collectors.toList()); 
		if(applicationIds.isEmpty()) {
			return Result.success(Collections.EMPTY_LIST);
		}
		
		ApplicationExample applicationQuery = new ApplicationExample();
		applicationQuery.createCriteria().andAppIdIn(applicationIds).andStatusEqualTo(true);
		List<Application> applications = applicationService.find(applicationQuery );
		List<String> applicationIndexUrls = applications.stream().map(a->a.getIndexUrl()).collect(Collectors.toList());
		return Result.success(applicationIndexUrls);
	}

}
