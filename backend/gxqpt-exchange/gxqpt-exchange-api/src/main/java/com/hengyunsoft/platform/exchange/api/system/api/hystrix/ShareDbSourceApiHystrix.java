//package com.hengyunsoft.platform.exchange.api.system.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.exchange.api.system.api.ShareDbSourceApi;
//import com.hengyunsoft.platform.exchange.api.system.api.ShareDictApi;
//import com.hengyunsoft.platform.exchange.api.system.dto.*;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// *com.hengyunsoft.platform.exchange.api.system.api.hystrix
// * 版权：中科恒运软件科技股份有限公司贵阳分公司
// * 描述：熔断机制的实现， 默认返回超时响应
// * 修改人：wt
// * 修改时间：2018/4/24
// * 修改内容：新增熔断机制
// */
//@Component
//public class ShareDbSourceApiHystrix implements ShareDbSourceApi {
//
//    /**
//     * 描述：查询数据源列表
//     * 参数：ShareRequestDbSourceDTO
//     * 返回值：PageInfo<ShareResponseDbSourceDTO>
//     * 修改人：wt
//     * 修改时间：2018/4/24
//     * 修改内容：
//     */
//    @Override
//    public Result<PageInfo<ShareResponseDbSourceDTO>> find(OpenApiReq<ShareRequestDbSourceDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：查询数据源对象
//     * 参数：id
//     * 返回值：ShareResponseDbSourceDTO
//     * 修改人：wt
//     * 修改时间：2018/4/24
//     * 修改内容：
//     */
//    @Override
//    public Result<ShareResponseDbSourceDTO> getById(Long id) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：保存数据源
//     * 参数：ShareRequestDbSourceSaveDTO
//     * 返回值：Boolean
//     * 修改人：wt
//     * 修改时间：2018/4/24
//     * 修改内容：
//     */
//    @Override
//    public Result<Boolean> save(ShareRequestDbSourceSaveDTO dto) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：删除数据源
//     * 参数：id
//     * 返回值：Boolean
//     * 修改人：wt
//     * 修改时间：2018/4/24
//     * 修改内容：
//     */
//    @Override
//    public Result<Boolean> delete(Long id) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：更新数据源
//     * 参数：ShareRequestDbSourceUpdateDTO
//     * 返回值：Boolean
//     * 修改人：wt
//     * 修改时间：2018/4/24
//     * 修改内容：
//     */
//    @Override
//    public Result<Boolean> update(ShareRequestDbSourceUpdateDTO dto) {
//        return Result.timeout();
//    }
//}
