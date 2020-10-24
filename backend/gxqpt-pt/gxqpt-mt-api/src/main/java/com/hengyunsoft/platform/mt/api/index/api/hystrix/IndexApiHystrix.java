//package com.hengyunsoft.platform.mt.api.index.api.hystrix;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.mt.api.index.api.IndexApi;
//import com.hengyunsoft.platform.mt.api.index.dto.HalfYearAttenceDTO;
//import com.hengyunsoft.platform.mt.api.index.dto.IndexTotalDTO;
//import com.hengyunsoft.platform.mt.api.version.dto.ClientVersionDTO;
//
//import java.util.List;
//
///**
// *com.hengyunsoft.platform.mt.api.index.api
// * 版权：中科恒运软件科技股份有限公司贵阳分公司
// * 描述：首页熔断机制的实现， 默认返回超时响应
// * 修改人：zhaopengfei
// * 修改时间：2018/8/28
// * 修改内容：新增熔断机制
// */
//public class IndexApiHystrix implements IndexApi {
//
//    @Override
//    public Result<IndexTotalDTO> getTotalInfo() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<ClientVersionDTO>> getAppUpdateInfo() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<HalfYearAttenceDTO> queryHalfYearAttence() {
//        return Result.timeout();
//    }
//}
