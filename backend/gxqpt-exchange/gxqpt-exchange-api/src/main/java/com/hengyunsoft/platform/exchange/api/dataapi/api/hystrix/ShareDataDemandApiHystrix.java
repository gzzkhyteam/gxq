//package com.hengyunsoft.platform.exchange.api.dataapi.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.exchange.api.dataapi.api.ShareDataDemandApi;
//import com.hengyunsoft.platform.exchange.api.dataapi.dto.demand.*;
//import org.springframework.stereotype.Component;
//
///**
// * com.hengyunsoft.platform.exchange.api.dataapi.api.hystrix
// * 版权：中科恒运软件科技股份有限公司贵阳分公司
// * 描述：熔断机制的实现， 默认返回超时响应
// * 修改人：zhaopengfei
// * 修改时间：2018/4/21
// * 修改内容：新增熔断机制
// */
//@Component
//public class ShareDataDemandApiHystrix implements ShareDataDemandApi {
//
//    /**
//     * 描述：新增需求
//     * 参数：DemandSaveDTO 需求新增dto
//     * 返回值：Boolean
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @Override
//    public Result<Boolean> save(DemandSaveDTO dto) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：查询api分页数据
//     * 参数：openApiReq 分页信息；appId：应用Id
//     * 返回值：PageInfo<RoleDto>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @Override
//    public Result<PageInfo<DemandListDTO>> page(OpenApiReq<DemandQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：根据需求Id查询需求处理详细信息
//     * 参数：id：需求Id
//     * 返回值：DemandHandleDetailDTO
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @Override
//    public Result<DemandHandleDetailDTO> getHandleDetail(Long id) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：获取需求新增时公共信息
//     * 参数：unitId：单位Id
//     * 返回值：DemandHandleDetailDTO
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @Override
//    public Result<DemandAddRequestDTO> getUnitName() {
//        return Result.timeout();
//    }
//}
