//package com.hengyunsoft.platform.file.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.file.api.FileRecycleApi;
//import com.hengyunsoft.platform.file.dto.FileRecycleDTO;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.List;
//
///**
// * feign 熔断机制的实现， 默认返回超时响应
// */
//public class FileRecycleApiHystrix implements FileRecycleApi {
//    @Override
//    public Result<PageInfo<FileRecycleDTO>> page(@RequestBody OpenApiReq<FileRecycleDTO> openApiReq) {
//       return  Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> remove(Long[] ids) {
//         return  Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> recycleFile(Long[] ids) {
//        return  Result.timeout();
//    }
//
//    @Override
//    public List<FileRecycleDTO> getForeverRecycle() {
//        return null;
//    }
//
//    @Override
//    public void foreverRecycle(Long id) { return; }
//
//}
