//package com.hengyunsoft.platform.file.api.hystrix;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.file.api.SwfApi;
//import com.hengyunsoft.platform.file.dto.FileSwfDTO;
//import com.hengyunsoft.platform.file.dto.VideoListDTO;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * feign 熔断机制的实现， 默认返回超时响应
// * @author tianai
// * @createTime 2018-02-27
// */
//@Component
//public class SwfApiHystrix implements SwfApi {
//
//    /**
//     * 转swf
//     * feign 熔断机制的实现， 默认返回超时响应
//     * @param id 文件夹id
//     * @param
//     * @return
//     * @throws Exception
//     */
//    @Override
//    public Result<FileSwfDTO> toSwf(Long id){
//        return Result.timeout();
//    }
//
//
//}
