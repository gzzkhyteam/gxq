package com.hengyunsoft.security.auth.controller;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.RoleCode;
import com.hengyunsoft.platform.admin.entity.core.po.Role;
import com.hengyunsoft.platform.admin.repository.authority.service.RoleService;
import com.hengyunsoft.platform.admin.repository.core.example.RoleExample;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/client")
@Api(value = "API - AuthController", description = "用户登录的token管理")
public class RoleApi {

	@Autowired
	private RoleService roleService;
    /**
     * 描述：根据账号Id查询其管理的所有应用appId
     * 参数：openApiReq
     * 返回值：List<String>  管理的应用appId集合
     * 作者：潘定遥
     */
    @RequestMapping(value = "/role/findAppAdminRoleByUid" , method = RequestMethod.GET)
    Result<List<String>> findAppAdminRoleByUid(@RequestParam("userId") Long userId){
    	
    	RoleExample roleExample = new RoleExample();
    	roleExample.createCriteria().andCodeEqualTo(RoleCode.APPLICATION_ADMIN_CODE).andStatusEqualTo((short)1);
    	List<Role> roles = roleService.findUserRole(roleExample, userId);
    	if(CollectionUtils.isEmpty(roles)) {
    		return Result.success(Collections.EMPTY_LIST);
    	}
    	List<String> appIds = roles.stream().map(role->role.getAppId()).collect(Collectors.toList());
    	return Result.success(appIds);
    }
    
    @RequestMapping(value = "/role/isPtAdmin" , method = RequestMethod.GET)
	Result<Boolean> isPtAdmin(@RequestParam("userId") Long userId){
    	
    	RoleExample roleExample = new RoleExample();
    	roleExample.createCriteria().andCodeEqualTo(RoleCode.GXQ_PT_ADMIN_CODE).andStatusEqualTo((short)1);
    	List<Role> roles = roleService.findUserRole(roleExample, userId);
    	if(CollectionUtils.isEmpty(roles)) {
    		return Result.success(false);
    	} else {
    		return Result.success(true);
    	}
    }
}
