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
///**
// * com.hengyunsoft.platform.exchange.api.system.api
// * 版权：中科恒运软件科技股份有限公司贵阳分公司
// * 描述：数据源管理
// * 修改人：wt
// * 修改时间：2018/4/24
// * 修改内容：新增基础接口
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-exchange-server}",
//         path = "/api/exchange",
//        fallback = ShareDictApiHystrix.class)
//public interface ShareDbSourceApi {
//    /**
//     * @todo 查询数据源列表
//     * @param ShareRequestDbSourceDTO
//     * @return PageInfo<ShareResponseDbSourceDTO>
//     * @Author wt
//     * @createtime 2018-4-24
//     */
//    @RequestMapping(value = "/dbSource/find", method = RequestMethod.POST)
//    Result<PageInfo<ShareResponseDbSourceDTO>> find(@RequestBody OpenApiReq<ShareRequestDbSourceDTO> openApiReq);
//
//    /**
//     * @todo 查询数据源对象
//     * @param id
//     * @return ShareResponseDbSourceDTO
//     * @Author wt
//     * @createtime 2018-4-24
//     */
//    @RequestMapping(value = "/dbSource/getById", method = RequestMethod.POST)
//    Result<ShareResponseDbSourceDTO> getById(@RequestParam("id") Long id);
//
//
//    /**
//     * @todo 保存数据源
//     * @param ShareRequestDbSourceSaveDTO
//     * @return Boolean
//     * @Author wt
//     * @createtime 2018-4-24
//     */
//    @RequestMapping(value = "/dbSource/save", method = RequestMethod.POST)
//    Result<Boolean> save(@RequestBody ShareRequestDbSourceSaveDTO dto);
//
//    /**
//     * @todo 删除数据源
//     * @param id
//     * @return Boolean
//     * @Author wt
//     * @createtime 2018-4-24
//     */
//    @RequestMapping(value = "/dbSource/delete", method = RequestMethod.GET)
//    Result<Boolean> delete(@RequestParam("id") Long id);
//
//    /**
//     * @todo 更新数据源
//     * @param ShareSystemDTO 系统表
//     * @return Boolean
//     * @Author wt
//     * @createtime 2018-4-24
//     */
//    @RequestMapping(value = "/dbSource/update", method = RequestMethod.POST)
//    Result<Boolean> update(@RequestBody ShareRequestDbSourceUpdateDTO dto);
//}
