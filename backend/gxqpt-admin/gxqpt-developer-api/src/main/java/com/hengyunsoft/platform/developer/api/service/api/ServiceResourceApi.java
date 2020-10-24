package com.hengyunsoft.platform.developer.api.service.api;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.commons.config.FeignConfiguration;
import com.hengyunsoft.platform.developer.api.service.api.hystrix.ServiceResourceApiHystrix;
import com.hengyunsoft.platform.developer.api.service.dto.module.serviceresource.ServiceResourceDTO;
import com.hengyunsoft.platform.developer.api.service.dto.module.serviceresource.ServiceResourceDocDTO;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * com.hengyunsoft.platform.admin.api.authority.api
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：服务资源管理Api
 * 修改人：sunxiaoya
 * 修改时间：2018/4/4
 * 修改内容：新增基础接口
 */
@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-admin-server}",
        configuration = FeignConfiguration.class,
        path = "/serviceResource", fallback = ServiceResourceApiHystrix.class)
public interface ServiceResourceApi {

    /**
     * 描述：根据模块id查询服务资源列表Api
     * 参数：模块id
     * 返回值：List<ServiceResourceDTO>
     * 修改人：sunxiaoya
     * 修改时间：2018/4/4
     * 修改内容：
     */
    @RequestMapping(value = "/getServiceResourceList", method = RequestMethod.GET)
    Result<List<ServiceResourceDTO>> getByModuleId(@RequestParam(value = "moduleId") Long moduleId);

    /**
     * 描述：根据moduleId查询服务资源文档Api
     * 参数：moduleId
     * 返回值：ServiceResourceDocDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/4/4
     * 修改内容：
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    Result<ServiceResourceDocDTO> getById(@RequestParam(value = "moduleId") Long moduleId);

    /**
     * 加载指定应用的服务资源中的所有公有（对所有应用开放）可用的资源链接地址
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getServiceAllPublicUrlsUsable", method = RequestMethod.GET)
    Result<List<ServiceResourceDTO>> getServiceAllPublicUrlsUsableByAppId(@RequestParam(value = "appId") String appId);

    /**
     * 获取应用非公开的所有可用使用的服务资源
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "/getServiceResourceOfAppPrivateUsable", method = RequestMethod.GET)
    Result<List<ServiceResourceDTO>> getServiceResourceOfAppPrivateUsable(@RequestParam(value = "appId") String appId);

    /**
     * 获取指定用户管理下的应用消费服务资源集合
     *
     * @return
     */
    @RequestMapping(value = "/getServiceResourceOfUserAppConsumer", method = RequestMethod.GET)
    Result<List<ServiceResourceDTO>> getServiceResourceOfUserAppConsumer(@RequestParam(value = "likeResourceName", required = false) String likeResourceName);
}
