//package com.hengyunsoft.security.gete.feign;
//
//import com.hengyunsoft.base.Result;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * TODO 日志接口 待实现
// * @author tyh
// * @createTime 2017-12-13 15:09
// */
//@FeignClient("gxqpt-admin-server")
//public interface LogService {
//    @RequestMapping(value = "/api/log/save", method = RequestMethod.POST)
//    void saveLog(LogDto log);
//
//    @RequestMapping(value = "/admin/check", method = RequestMethod.GET)
//    Result<Boolean> check(@RequestParam("userName") String userName);
//}
