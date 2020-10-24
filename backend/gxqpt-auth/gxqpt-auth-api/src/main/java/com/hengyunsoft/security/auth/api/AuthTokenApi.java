package com.hengyunsoft.security.auth.api;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.security.auth.dto.TokenVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${gxqpt.feign.auth-server:gxqpt-auth-server}")
public interface AuthTokenApi {

    @RequestMapping(value = "/client/token", method = RequestMethod.POST)
    Result<TokenVo> token(@RequestParam(value = "appId") String appId,
                          @RequestParam(value = "appSecret") String appSecret);

    /**
     * 刷新用户所有 应用的token
     *
     * @param userName
     * @return
     */
    //@RequestMapping(value = "/client/login", method = RequestMethod.POST)
    //Result<TokenVo> login(@RequestParam(value = "appId") String appId, @RequestParam(value = "userName") String userName);
}
