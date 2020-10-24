//package com.hengyunsoft.platform.mt.api.component.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.mt.api.component.api.hystrix.AppComponentApiHystrix;
//import com.hengyunsoft.platform.mt.api.component.dto.AppComponentDTO;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * com.hengyunsoft.platform.mt.api.component.api
// * 版权：中科恒运软件科技股份有限公司贵阳分公司
// * 描述：角色管理Api
// * 修改人：zhaopengfei
// * 修改时间：2018/8/27
// * 修改内容：新增基础接口
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/component", fallback = AppComponentApiHystrix.class)
//public interface AppComponentApi {
//    /**
//     * 描述：创建APP主件
//     * 参数： AppComponentDTO
//     * 返回值： Result<Long>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/8/27
//     * 修改内容：
//     */
//    @RequestMapping(value = "save", method = RequestMethod.POST)
//    Result<Boolean> save(@RequestBody AppComponentDTO dto);
//
//    /**
//     * 描述：用于保存主键
//     * 参数：AppComponentDTO
//     * 返回值：Result<Boolean>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/8/27
//     * 修改内容：
//     */
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    Result<Boolean> delete(@RequestParam("id") Long id);
//
//    /**
//     * 描述：修改主件信息
//     * 参数：AppComponentDTO
//     * 返回值：Result<Boolean>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/8/27
//     * 修改内容：
//     */
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    Result<Boolean> update(@RequestBody AppComponentDTO dto);
//
//    /**
//     * 描述：根据id获取主件详细信息
//     * 参数：id：主键id
//     * 返回值：
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @RequestMapping(value = "/detail", method = RequestMethod.POST)
//    Result<AppComponentDTO> getById(@RequestParam("id") Long id);
//
//    /**
//     * 描述：查询组件分页信息
//     * 参数：openApiReq 分页信息；
//     * 返回值：PageInfo<AppComponentDTO>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/8/28
//     * 修改内容：
//     */
//    @RequestMapping(value = "/page", method = RequestMethod.POST)
//    Result<PageInfo<AppComponentDTO>> page(@RequestBody OpenApiReq<String> openApiReq);
//
//}
