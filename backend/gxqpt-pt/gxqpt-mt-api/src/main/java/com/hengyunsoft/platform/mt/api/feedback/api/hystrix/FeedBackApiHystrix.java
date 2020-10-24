//package com.hengyunsoft.platform.mt.api.feedback.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.mt.api.feedback.api.FeedBackApi;
//import com.hengyunsoft.platform.mt.api.feedback.dto.CreateFeedBackDTO;
//import com.hengyunsoft.platform.mt.api.feedback.dto.FeedBackBaseDTO;
//import com.hengyunsoft.platform.mt.api.feedback.dto.FeedBackInfoDTO;
//import com.hengyunsoft.platform.mt.api.feedback.dto.QueryFeedBackParamDTO;
//
//public class FeedBackApiHystrix implements FeedBackApi {
//    @Override
//    public Result<Boolean> createFeedBack(CreateFeedBackDTO dto) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<FeedBackBaseDTO>> findList(OpenApiReq<QueryFeedBackParamDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<FeedBackBaseDTO>> findMyList(OpenApiReq<QueryFeedBackParamDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<FeedBackInfoDTO> getFeedBackInfo(Long id, Boolean isWeb) {
//        return Result.timeout();
//    }
//
//
//    @Override
//    public Result<Boolean> replyFeedback(Long id, Boolean isWeb, String context) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> closeFeedBack(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Integer> getMyMsgNotReadCount() {
//        return Result.timeout();
//    }
//}
