//package com.hengyunsoft.platform.mt.api.index.api;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.mt.api.appr.api.hystrix.ApprApplyApiHystrix;
//import com.hengyunsoft.platform.mt.api.index.dto.HalfYearAttenceDTO;
//import com.hengyunsoft.platform.mt.api.index.dto.IndexTotalDTO;
//import com.hengyunsoft.platform.mt.api.version.dto.ClientVersionDTO;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.List;
//
///**
// * com.hengyunsoft.platform.mt.api.index.api
// * 版权：中科恒运软件科技股份有限公司贵阳分公司
// * 描述：首页Api
// * 修改人：zhaopengfei
// * 修改时间：2018/8/28
// * 修改内容：新增基础接口
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/index/", fallback = ApprApplyApiHystrix.class)
//public interface IndexApi {
//    /**
//     * 描述：查找总信息
//     * 参数：
//     * 返回值：
//     * 修改人：zhaopengfei
//     * 修改时间：2018/8/28
//     * 修改内容：
//     */
//    @RequestMapping(value = "getTotalInfo", method = RequestMethod.GET)
//    Result<IndexTotalDTO> getTotalInfo();
//
//    /**
//     * 描述：查找APP版本更新信息
//     * 参数：
//     * 返回值：
//     * 修改人：zhaopengfei
//     * 修改时间：2018/8/28
//     * 修改内容：
//     */
//    @RequestMapping(value = "getAppUpdateInfo", method = RequestMethod.GET)
//    Result<List<ClientVersionDTO>> getAppUpdateInfo();
//
//    /**
//     * 描述：查找登录用户近半年考勤
//     * 参数：
//     * 返回值：
//     * 修改人：zhaopengfei
//     * 修改时间：2018/8/28
//     * 修改内容：
//     */
//    @RequestMapping(value = "queryHalfYearAttence", method = RequestMethod.GET)
//    Result<HalfYearAttenceDTO> queryHalfYearAttence();
//}
