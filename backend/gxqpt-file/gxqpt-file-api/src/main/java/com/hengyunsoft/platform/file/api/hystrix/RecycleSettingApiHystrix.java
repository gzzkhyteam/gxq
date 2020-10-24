//package com.hengyunsoft.platform.file.api.hystrix;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.file.api.RecycleSettingApi;
//import com.hengyunsoft.platform.file.dto.RecycleSettingDTO;
//import com.hengyunsoft.platform.file.dto.RecycleSettingSaveDTO;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.List;
//
///**
// * @author madengbo
// * @create 2018-09-03 11:43
// * @desc
// * @Version 1.0
// **/
//public class RecycleSettingApiHystrix implements RecycleSettingApi {
//
//    @Override
//    public Result<Boolean> saveOrUpdate(@RequestBody RecycleSettingSaveDTO recycleSettingSaveDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<RecycleSettingDTO>> find() {
//        return Result.timeout();
//    }
//}
