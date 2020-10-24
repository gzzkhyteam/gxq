//package com.hengyunsoft.platform.modular.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.modular.api.ModularRepositoryApi;
//import com.hengyunsoft.platform.modular.api.ModularVersionApi;
//import com.hengyunsoft.platform.modular.dto.*;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
///**
// * @author zhoukx
// * @createTime 2018-3-28
// */
//@Component
//public class ModularRepositoryApiHystrix implements ModularRepositoryApi {
//
//
//    /**
//     * 仓库列表查询
//     *
//     * @createTime 2018-4-5
//     * @author wangs
//     */
//    @Override
//    public Result<List<ModularRepositoryDTO>> findAll() {
//        return Result.timeout();
//    }
//}
