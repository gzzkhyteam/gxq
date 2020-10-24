//package com.hengyunsoft.platform.file.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.file.api.ShareApi;
//import com.hengyunsoft.platform.file.dto.*;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@Component
//public class ShareApiHystrix implements ShareApi{
//    @Override
//    public Result<PageInfo<ShareFileDTO>> pageShareFileList(@RequestBody OpenApiReq<ShareFileLikeDTO> openApiReq) {
//        return  Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<ShareDTO>> pageShareList(@RequestBody OpenApiReq<Long> openApiReq) {
//        return  Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> deleteList(Long[] ids) {
//        return  Result.timeout();
//    }
//
//    @Override
//    public Result<SaveShareRetDTO> save(SaveShareDTO saveShareDTO) {
//        return  Result.timeout();
//    }
//
//    @Override
//    public Result<ShareUrlDTO> shareUrlPasswordIsNotNull(Long id) {
//        return  Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> shareUrlVerify(Long id, String sharePassword) {
//        return  Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<ShareFileDTO>> findTree(@RequestBody OpenApiReq<ShareFileLikeDTO> openApiReq) {
//        return  Result.timeout();
//    }
//}
