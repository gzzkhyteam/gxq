//package com.hengyunsoft.platform.logs.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.logs.api.LogSetApi;
//import com.hengyunsoft.platform.logs.dto.LogPatternSetDTO;
//import com.hengyunsoft.platform.logs.dto.LogPatternSetQueryDTO;
//import com.hengyunsoft.platform.logs.dto.LogPatternSetSaveDTO;
//import com.hengyunsoft.platform.logs.dto.LogPatternSetUpdateDTO;
//import org.springframework.stereotype.Component;
//
//@Component
//public class LogSetApiHystrix implements LogSetApi {
//
//    @Override
//    public Result<PageInfo<LogPatternSetDTO>> pageQueryPattern(OpenApiReq<LogPatternSetQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<LogPatternSetDTO> save(LogPatternSetSaveDTO logPatternSetSaveDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> updateSetDay(LogPatternSetUpdateDTO logPatternSetUpdateDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> delete(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> deleteBatch(String ids) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<LogPatternSetDTO> get(Long id) {
//        return Result.timeout();
//    }
//
//    /**
//     * 根据appId和logType查询日志格式是否存在
//     *
//     * @param logPatternSetSaveDTO
//     * @return
//     */
//    @Override
//    public Result<Integer> isExist(LogPatternSetSaveDTO logPatternSetSaveDTO) {
//        return Result.timeout();
//    }
//}
