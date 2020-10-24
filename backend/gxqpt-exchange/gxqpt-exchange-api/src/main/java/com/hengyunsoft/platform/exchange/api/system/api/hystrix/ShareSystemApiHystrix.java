//package com.hengyunsoft.platform.exchange.api.system.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.exchange.api.system.api.ShareSystemApi;
//import com.hengyunsoft.platform.exchange.api.system.dto.ShareRequestSaveSystemDTO;
//import com.hengyunsoft.platform.exchange.api.system.dto.ShareRequestSystemDTO;
//import com.hengyunsoft.platform.exchange.api.system.dto.ShareResponseSelectSystemDTO;
//import com.hengyunsoft.platform.exchange.api.system.dto.ShareResponseSystemDTO;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// *com.hengyunsoft.platform.exchange.api.system.api.hystrix
// * 版权：中科恒运软件科技股份有限公司贵阳分公司
// * 描述：熔断机制的实现， 默认返回超时响应
// * 修改人：wt
// * 修改时间：2018/4/23
// * 修改内容：新增熔断机制
// */
//@Component
//public class ShareSystemApiHystrix implements ShareSystemApi {
//
//    /**
//     * 描述：查询系统列表
//     * 参数：ShareResponseSystemDTO
//     * 返回值：List<ShareResponseSystemDTO>
//     * 修改人：wt
//     * 修改时间：2018/4/23
//     * 修改内容：
//     */
//    @Override
//    public Result<PageInfo<ShareResponseSystemDTO>> findSys(OpenApiReq<ShareRequestSystemDTO> openApiReq) { return Result.timeout(); }
//
//    /**
//     * @todo 查询系统列表对象
//     * @param id
//     * @return ShareResponseDbSourceDTO
//     * @Author wt
//     * @createtime 2018-4-24
//     */
//    @Override
//    public Result<ShareResponseSystemDTO> getById(Long id) {
//        return Result.timeout();
//    }
//
//    /**
//     * @todo 保存系统列表
//     * @param ShareSystemDTO 系统表
//     * @return Boolean
//     * @Author wt
//     * @createtime 2018-4-23
//     */
//    @Override
//    public Result<Boolean> saveSys(ShareRequestSaveSystemDTO dto) {
//        return Result.timeout();
//    }
//
//    /**
//     * @todo 删除系统列表
//     * @param id 系统表ID
//     * @return Boolean
//     * @Author wt
//     * @createtime 2018-4-23
//     */
//    @Override
//    public Result<Boolean> deleteById(Long id) {
//        return Result.timeout();
//    }
//
//    /**
//     * @todo 更新系统列表
//     * @param ShareSystemDTO 系统表
//     * @return Boolean
//     * @Author wt
//     * @createtime 2018-4-23
//     */
//    @Override
//    public Result<Boolean> updateSys(ShareResponseSystemDTO dto) {
//        return Result.timeout();
//    }
//
//    /**
//     * @todo 查询系统列表下拉框信息
//     * @param
//     * @return List<ShareResponseSelectSystemDTO>
//     * @Author wt
//     * @createtime 2018-4-25
//     */
//    @Override
//    public Result<List<ShareResponseSelectSystemDTO>> findSelectInfo() {
//        return Result.timeout();
//    }
//}
