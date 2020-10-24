//package com.hengyunsoft.platform.warn.api.warn.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.warn.api.warn.dto.*;
//import com.hengyunsoft.platform.warn.api.warn.api.GxqptWarnApi;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * 描述:熔断实现默认响应超时
// * @author zjr
// * @date 2018/03/27
// * @return
// */
//@Component
//public class GxqptWarnApiHystrix implements GxqptWarnApi {
//
//    /**
//     * 根据id获取预警信息
//     * @param id
//     * @return
//     */
//    @Override
//    public Result<Map<String,Object>> getById(Long id){ return Result.timeout(); }
//
//    /**
//     * 根据id获取确认人信息
//     * @param id
//     * @return
//     */
//    @Override
//    public Result<List<GxqptSendeeDTO>> getConById(Long id){ return Result.timeout(); }
//
//    /**
//     * 根据id获取责任人信息
//     * @param id
//     * @return
//     */
//    @Override
//    public Result<List<GxqptSendeeDTO>> getHanById(Long id){ return Result.timeout(); }
//    /**
//     * 获取分页列表
//     * @param openApiReq
//     * @return
//     */
//    @Override
//    public Result<PageInfo<GxqptWarnPagingDTO>> findWarnList(OpenApiReq<QueryWarnDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    /**
//     * 根据ID确认预警信息
//     * @param updateModeGxqptWarnDTO
//     * @return
//     */
//    @Override
//    public Result<Boolean> updateModeById(ConfirmGxqptWarnDTO updateModeGxqptWarnDto) {
//        return Result.timeout();
//    }
//
//    /**
//     * 根据预警id查询预警责任人人
//     * @param dutyerDTO
//     * @return
//     */
//    @Override
//    public Result<DutyerDTO> getDutyer(Long warnId){return Result.timeout();}
//
//    /**
//     * 根据id处理预警信息
//     * @param handleGxqptWarnDto
//     * @return
//     */
//    @Override
//    public Result<Boolean> updateHandleById(HandleGxqptWarnDTO handleGxqptWarnDto){return Result.timeout();}
//
//}
