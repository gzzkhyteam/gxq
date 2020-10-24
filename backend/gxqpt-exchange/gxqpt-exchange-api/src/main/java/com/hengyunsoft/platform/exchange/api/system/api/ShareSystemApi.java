//package com.hengyunsoft.platform.exchange.api.system.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.exchange.api.system.api.hystrix.ShareDictApiHystrix;
//import com.hengyunsoft.platform.exchange.api.system.dto.*;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
///**
// * com.hengyunsoft.platform.exchange.api.system.api
// * 版权：中科恒运软件科技股份有限公司贵阳分公司
// * 描述：系统列表
// * 修改人：wt
// * 修改时间：2018/4/23
// * 修改内容：新增基础接口
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-exchange-server}",
//         path = "/api/exchange",
//        fallback = ShareDictApiHystrix.class)
//public interface ShareSystemApi {
//    /**
//     * @todo 查询系统列表
//     * @param sysStatus 系统状态
//     * @param contractor 系统承建商
//     * @param sysArch 系统图架构
//     * @param sysData 系统主要数据 模糊查询
//     * @return List<ShareResponseSystemDTO>
//     * @Author wt
//     * @createtime 2018-4-23
//     */
//    @RequestMapping(value = "/system/findSys", method = RequestMethod.POST)
//    Result<PageInfo<ShareResponseSystemDTO>> findSys(@RequestBody OpenApiReq<ShareRequestSystemDTO> openApiReq);
//
//    /**
//     * @todo 查询系统列表对象
//     * @param id
//     * @return ShareResponseDbSourceDTO
//     * @Author wt
//     * @createtime 2018-4-24
//     */
//    @RequestMapping(value = "/system/getById", method = RequestMethod.POST)
//    Result<ShareResponseSystemDTO> getById(@RequestParam("id") Long id);
//
//    /**
//     * @todo 保存系统列表
//     * @param ShareSystemDTO 系统表
//     * @return Boolean
//     * @Author wt
//     * @createtime 2018-4-23
//     */
//    @RequestMapping(value = "/system/saveSys", method = RequestMethod.POST)
//    Result<Boolean> saveSys(@RequestBody ShareRequestSaveSystemDTO dto);
//
//    /**
//     * @todo 删除系统列表
//     * @param id 系统表ID
//     * @return Boolean
//     * @Author wt
//     * @createtime 2018-4-23
//     */
//    @RequestMapping(value = "/system/deleteById", method = RequestMethod.GET)
//    Result<Boolean> deleteById(@RequestParam("id") Long id);
//
//    /**
//     * @todo 更新系统列表
//     * @param ShareSystemDTO 系统表
//     * @return Boolean
//     * @Author wt
//     * @createtime 2018-4-23
//     */
//    @RequestMapping(value = "/system/updateSys", method = RequestMethod.POST)
//    Result<Boolean> updateSys(@RequestBody ShareResponseSystemDTO dto);
//
//    /**
//     * @todo 查询系统列表下拉框信息
//     * @param
//     * @return List<ShareResponseSelectSystemDTO>
//     * @Author wt
//     * @createtime 2018-4-25
//     */
//    @RequestMapping(value = "/system/findSelectInfo", method = RequestMethod.POST)
//    Result<List<ShareResponseSelectSystemDTO>> findSelectInfo();
//}
