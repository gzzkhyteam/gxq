package com.hengyunsoft.platform.file.open;


import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.file.dto.FileDownWaterDTO;
import com.hengyunsoft.platform.file.dto.FileStatisDTO;
import com.hengyunsoft.platform.file.open.hystrix.FileOpenApiHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-file-server}",
        fallback = FileOpenApiHystrix.class)
public interface FileOpenApi {
    //@RequestMapping(value = "/simple", method = RequestMethod.POST)
    //Result<UploadListDTO> upload(@RequestParam(value = "file") MultipartFile file) throws Exception;
    //
    //@RequestMapping(value = "/multi", method = RequestMethod.POST)
    //Result<UploadListDTO> multiUpload(HttpServletRequest request) throws Exception;

    @RequestMapping(value = "/findDownStatis", method = RequestMethod.GET)
    Result<List<FileStatisDTO>> findDownStatis(
            @RequestParam(value = "ids[]") Long[] ids);

    @RequestMapping(value = "/findDownWater", method = RequestMethod.GET)
    Result<List<FileDownWaterDTO>> findDownWater(
            @RequestParam(value = "fileId[]") Long[] fileId,
            @RequestParam(value = "startTime") String startTime,
            @RequestParam(value = "endTime") String endTime);
}
