package com.hengyunsoft.platform.file.open.hystrix;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.file.dto.FileDownWaterDTO;
import com.hengyunsoft.platform.file.dto.FileStatisDTO;
import com.hengyunsoft.platform.file.open.FileOpenApi;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FileOpenApiHystrix implements FileOpenApi {

    //@Override
    //public Result<UploadListDTO> upload(MultipartFile file) throws Exception {
    //    return Result.timeout();
    //}
    //
    //@Override
    //public Result<UploadListDTO> multiUpload(HttpServletRequest request) throws Exception {
    //    return Result.timeout();
    //}

    @Override
    public Result<List<FileStatisDTO>> findDownStatis(Long[] ids) {
        return Result.timeout();
    }

    @Override
    public Result<List<FileDownWaterDTO>> findDownWater(Long[] fileId, String startTime, String endTime) {
        return Result.timeout();
    }
}
