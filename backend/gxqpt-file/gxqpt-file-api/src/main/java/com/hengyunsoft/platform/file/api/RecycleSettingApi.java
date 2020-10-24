//package com.hengyunsoft.platform.file.api;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.file.api.hystrix.RecycleSettingApiHystrix;
//import com.hengyunsoft.platform.file.dto.RecycleSettingDTO;
//import com.hengyunsoft.platform.file.dto.RecycleSettingSaveDTO;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.List;
//
///**
// * 回收站
// */
//@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-file-server}", fallback = RecycleSettingApiHystrix.class)
//public interface RecycleSettingApi {
//
//    /**
//     * 添加或是更新云盘管理设置
//     * */
//    @RequestMapping(value = "/recyclesetting/saveOrUpdate", method = RequestMethod.POST)
//    Result<Boolean> saveOrUpdate(@RequestBody RecycleSettingSaveDTO recycleSettingSaveDTO);
//
//    /**
//     * 查询个人云盘设置
//     * */
//    @RequestMapping(value = "/recyclesetting/find", method = RequestMethod.GET)
//    Result<List<RecycleSettingDTO>> find();
//
//
//}
