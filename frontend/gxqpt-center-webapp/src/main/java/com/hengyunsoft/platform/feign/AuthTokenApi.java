//package com.hengyunsoft.platform.feign;
//
//import com.hengyunsoft.base.Result;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@FeignClient(name = "${gxqpt.feign.auth-server:gxqpt-auth-server}")
//public interface AuthTokenApi {
//
//    @RequestMapping(value = "/client/login", method = RequestMethod.POST)
//    Result<TokenVo> login(@RequestParam("userName") String userName);
//}
