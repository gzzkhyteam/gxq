//package com.hengyunsoft.platform.mail.api;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.mail.api.hystrix.MailboxRegisterApiHystrix;
//import com.hengyunsoft.platform.mail.dto.JamesUserDTO;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * This is a Description
// *
// * @auth tangyh
// * @date 2018/07/26
// */
//@FeignClient(value = "gxqpt-msgs-server", fallback = MailboxRegisterApiHystrix.class)
//public interface MailboxRegisterApi {
//    @RequestMapping(value = "/page", method = RequestMethod.POST)
//    Result<JamesUserDTO> register(@RequestParam(value = "account") String account);
//}
