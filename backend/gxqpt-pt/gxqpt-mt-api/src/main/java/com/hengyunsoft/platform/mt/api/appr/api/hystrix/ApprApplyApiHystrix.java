//package com.hengyunsoft.platform.mt.api.appr.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.mt.api.appr.api.ApprApplyApi;
//import com.hengyunsoft.platform.mt.api.appr.dto.*;
//
//public class ApprApplyApiHystrix implements ApprApplyApi {
//
//    @Override
//    public Result<PageInfo<ApprApplyDTO>> findApprApplyPage(OpenApiReq<QueryApprApplyParamDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<ApprApplyDTO>> findPageCurSendMeApplyList(OpenApiReq<QueryApprApplyParamDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> dealApprApply(Long applyId, Integer agree, String apprOpinion) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> cancellApprApply(CancellApprAppDTO dto) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> createApprApply(CreateApprApplyDTO dto) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<ApprApplyInfoDTO> getApprApplyInfo(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<DefaultPersonDTO> getDefaultPerson(String aprType) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Integer> geCurSendMeCount() {
//        return Result.timeout();
//    }
//}
