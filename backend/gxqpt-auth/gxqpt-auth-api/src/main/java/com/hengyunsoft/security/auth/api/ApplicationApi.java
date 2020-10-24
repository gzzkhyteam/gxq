package com.hengyunsoft.security.auth.api;

import com.hengyunsoft.base.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 应用服务管理
 *
 * @author wz
 * @createTime 2018-04-03
 */
@FeignClient(name = "${gxqpt.feign.auth-server:gxqpt-auth-server}")
public interface ApplicationApi {
    /**
     * 获取被批准接入单点登录的应用的首页列表
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/application/findRatifySsoAppList", method = RequestMethod.GET)
    Result<List<String>> findRatifySsoAppList();
}
