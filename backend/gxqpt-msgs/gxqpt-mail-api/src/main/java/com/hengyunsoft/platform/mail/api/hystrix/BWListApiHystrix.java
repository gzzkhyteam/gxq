//package com.hengyunsoft.platform.mail.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.mail.api.BWListApi;
//import com.hengyunsoft.platform.mail.dto.bwlist.BWListDTO;
//import com.hengyunsoft.platform.mail.dto.bwlist.BWPagingDTO;
//import com.hengyunsoft.platform.mail.dto.bwlist.QueryBWDTO;
//import org.springframework.stereotype.Component;
//
///**
// * 描述:熔断实现默认响应超时
// * @author zjr
// * @date 2018/08/08
// * @return
// */
//@Component
//public class BWListApiHystrix implements BWListApi {
//
//    /**
//     * 新增黑名单
//     * @param bwListDto
//     * @return
//     */
//    @Override
//    public Result<Boolean> save(BWListDTO bwListDto){return Result.timeout();}
//
//    /**
//     * 查询黑名单分页列表
//     * @param openApiReq
//     * @return
//     */
//    @Override
//    public Result<PageInfo<BWPagingDTO>> findBWList(OpenApiReq<QueryBWDTO> openApiReq){return Result.timeout();}
//
//    /**
//     * 根据id删除黑名单
//     * @param id
//     * @return
//     */
//    @Override
//    public Result<String> deleteById(Long id){return Result.timeout();}
//
//    /**
//     * 新增白名单
//     * @param bwListDto
//     * @return
//     */
//    @Override
//    public Result<Boolean> saveWhite(BWListDTO bwListDto){return Result.timeout();}
//
//    /**
//     * 根据id删除白名单
//     * @param id
//     * @return
//     */
//    @Override
//    public Result<String> deleteWhiteById(Long id){return Result.timeout();}
//}
