package com.hengyunsoft.security.auth.api;

import com.hengyunsoft.base.Result;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient(name = "${gxqpt.feign.auth-server:gxqpt-auth-server}")
public interface RoleApi {

    /**
     * 描述：根据账号Id查询其管理的所有应用appId
     * 参数：openApiReq
     * 返回值：List<String>  管理的应用appId集合
     * 作者：潘定遥
     */
    @RequestMapping(value = "/client/role/findAppAdminRoleByUid" , method = RequestMethod.GET)
    Result<List<String>> findAppAdminRoleByUid(@RequestParam("userId") Long userId);
    
    @RequestMapping(value = "/client/role/isPtAdmin" , method = RequestMethod.GET)
	Result<Boolean> isPtAdmin(@RequestParam("userId") Long userId);
}
