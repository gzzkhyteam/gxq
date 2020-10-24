//package com.hengyunsoft.platform.modular.api;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.commons.config.FeignConfiguration;
//import com.hengyunsoft.platform.modular.api.hystrix.ModularApiHystrix;
//import com.hengyunsoft.platform.modular.dto.*;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.List;
//
///**
// * @author zhoukx
// * @createTime 2018-3-28
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gaxq-gate-server}",
//        configuration = FeignConfiguration.class,
//        path = "/api/modular", fallback = ModularApiHystrix.class)
//public interface ModularRepositoryApi {
//
//    /**
//     * 仓库列表查询
//     *
//     * @createTime 2018-4-5
//     * @author wangs
//     */
//    @RequestMapping(value = "/repository/find", method = RequestMethod.POST)
//    Result<List<ModularRepositoryDTO>> findAll();
//}
