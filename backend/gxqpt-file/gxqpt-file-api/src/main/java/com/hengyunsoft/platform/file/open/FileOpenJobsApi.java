package com.hengyunsoft.platform.file.open;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.file.dto.FileDownWaterDTO;
import com.hengyunsoft.platform.file.dto.FileStatisDTO;
import com.hengyunsoft.platform.file.open.hystrix.FileOpenJobsApiHystrix;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 为定时任务
 */
@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-file-server}"
        , fallback = FileOpenJobsApiHystrix.class)
public interface FileOpenJobsApi {


    @RequestMapping(value = "/p/file/findDownStatis", method = RequestMethod.GET)
    Result<List<FileStatisDTO>> findDownStatis(
            @RequestHeader(value = "token") String toekn,
            @RequestParam(value = "ids[]") Long[] ids);

    @RequestMapping(value = "/p/file/findDownWater", method = RequestMethod.GET)
    Result<List<FileDownWaterDTO>> findDownWater(
            @RequestHeader(value = "token") String token,
            @RequestParam(value = "fileId[]") Long[] fileId,
            @RequestParam(value = "startTime", required = false) String startTime,
            @RequestParam(value = "endTime", required = false) String endTime);
}
