package com.hengyunsoft.security.gete.feign;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceDTO;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationAllDTO;
import com.hengyunsoft.platform.developer.api.service.dto.module.serviceresource.ServiceResourceDTO;
import com.hengyunsoft.security.gete.feign.hystrix.AuthInfoApiHystrix;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "GXQPT-ADMIN-SERVER", fallback = AuthInfoApiHystrix.class)
public interface AuthInfoApi {

	
    /**
     * 描述：通过账号Id和应用Id获取可访问资源列表和菜单
     * 参数：openApiReq
     * 返回值：List<ResourseDto>  资源集合
     * 修改人：zhangbiao
     * 修改时间：2018/3/26
     * 修改内容：新增基础接口
     */
    @RequestMapping(value = "/p/resource/findresource" , method = RequestMethod.GET)
    Result<List<ResourceDTO>> findResByAppIdAndUserId(@RequestParam(value = "appId") String appId,@RequestParam(value = "userId")  Long userId,@RequestParam(value = "group")  String group,@RequestParam("token") String token);
    
    /**
     * 获取指定应用的非公有的所有存在authUrls的资源列表。
     * 仅仅只获取需要后端验证的那些资源列表
     * 网关需要使用
     * @param appId
     * @return
     */
    @RequestMapping(value = "/resource/getAppAllNotpublicResourceOfExistAuthUrls", method = RequestMethod.GET)
	Result<List<ResourceDTO>> getAppAllNotpublicResourceOfExistAuthUrls(@RequestParam("appId") String appId,@RequestParam("token") String token);

    /**
     * 加载指定应用的服务资源中的所有公有（对所有应用开放）可用的资源链接地址
     * @param token 
     * @return
     */
    @RequestMapping(value = "/serviceResource/getServiceAllPublicUrlsUsable", method = RequestMethod.GET)
	Result<List<ServiceResourceDTO>> getServiceAllPublicUrlsUsable(@RequestParam("appId") String appId,@RequestParam("token") String token);

    /**
     * 获取应用非公开的所有可用使用的服务资源
     * @param producerAppId
     * @param token
     * @return
     */
    @RequestMapping(value = "/serviceResource/getServiceResourceOfAppPrivateUsable", method = RequestMethod.GET)
	Result<List<ServiceResourceDTO>> getServiceResourceOfAppPrivateUsable(@RequestParam("appId") String appId,@RequestParam("token") String token);

	/**
	 * 获取指定消费者可用消费的所有模块id
	 * @param consumerAppId
	 * @param token
	 * @return
	 */
    @RequestMapping(value = "/serviceModule/getConsumerModuleIdsUsable", method = RequestMethod.GET)
	Result<List<Long>> getConsumerModuleIdsUsable(@RequestParam("consumerAppId") String consumerAppId, @RequestParam("token") String token);

    /**
     * 获取所有的接入appid
     * @param token
     * @return
     */
    @RequestMapping(value = "/application/getAllUseableJryy", method = RequestMethod.GET)
	Result<List<String>> getAllUseableJryy(@RequestParam("token") String token);

    @RequestMapping(value = "/application/findAllList", method = RequestMethod.GET)
    Result<List<ApplicationAllDTO>> findAllList(@RequestParam("token") String token);
}
