//package com.hengyunsoft.platform.exchange.api.dataapi.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.exchange.api.dataapi.api.ShareDataApplyApi;
//import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.ApiIRenewalDTO;
//import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.ApiRenewalInfoDTO;
//import com.hengyunsoft.platform.exchange.api.dataapi.dto.shareapply.ShareApplyDetailDTO;
//import com.hengyunsoft.platform.exchange.api.dataapi.dto.shareapply.ShareApplyListDTO;
//import com.hengyunsoft.platform.exchange.api.dataapi.dto.shareapply.ShareApplyQueryDTO;
//import com.hengyunsoft.platform.exchange.api.dataapi.dto.shareapply.ShareApplySaveDTO;
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
//public class ShareDataApplyApiHystrix implements ShareDataApplyApi {
//    /**
//     * 描述：保存共享申请
//     * 参数：ShareApplySaveDTO API元数据
//     * 返回值：Boolean 状态（成功、失败）
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @Override
//    public Result<Boolean> saveShareApply(ShareApplySaveDTO dto) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：根据共享申请Id查找共享申请详细信息
//     * 参数：id 申请Id
//     * 返回值：ShareApplyDetailDTO
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @Override
//    public Result<ShareApplyDetailDTO> getById(Long id) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：更新订阅状态
//     * 参数：id 申请Id
//     * 参数：isTake：是否订阅：1：订阅；2，取消订阅
//     * 返回值：Boolean 操作状态
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/22
//     * 修改内容：
//     */
//    @Override
//    public Result<Boolean> updatetake(Long id, Integer isTake) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：api延续申请
//     * 参数：ApiIRenewalDTO
//     * 返回值：Boolean 操作状态
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/22
//     * 修改内容：
//     */
//    @Override
//    public Result<Boolean> updateLimitTime(ApiIRenewalDTO dto) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：根据共享申请Id查询api续期基础信息
//     * 参数：id：共享申请id
//     * 返回值：ApiRenewalInfoDTO
//     * 修改人：zhaopengfei
//     * 修改时间：2018/5/1
//     * 修改内容：
//     */
//    @Override
//    public Result<ApiRenewalInfoDTO> queryBaseInfo(Long id) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：根据API id查询该单位是否已经申请过
//     * 参数：apiId
//     * 返回值：true:已经申请 false 未申请
//     * 修改人：zhaopengfei
//     * 修改时间：2018/5/11
//     * 修改内容：
//     */
//    @Override
//    public Result<Boolean> getApiApplyStatus(Long apiId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> deleteShareUnit(Long id){
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> delete(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<String> getApiApplyKey(Long apiId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> isValid(Long apiId) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：查询共享申请分页数据
//     * 参数：openApiReq 分页信息；
//     * 返回值：PageInfo<ShareApplyListDTO>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @Override
//    public Result<PageInfo<ShareApplyListDTO>> page(OpenApiReq<ShareApplyQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//}
