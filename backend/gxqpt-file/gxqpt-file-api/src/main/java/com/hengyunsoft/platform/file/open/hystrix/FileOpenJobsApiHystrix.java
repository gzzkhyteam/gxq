package com.hengyunsoft.platform.file.open.hystrix;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.file.dto.FileDownWaterDTO;
import com.hengyunsoft.platform.file.dto.FileStatisDTO;
import com.hengyunsoft.platform.file.open.FileOpenJobsApi;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FileOpenJobsApiHystrix implements FileOpenJobsApi {
    @Override
    public Result<List<FileStatisDTO>> findDownStatis(String toekn, Long[] ids) {
        return Result.timeout();
    }

    @Override
    public Result<List<FileDownWaterDTO>> findDownWater(String token, Long[] fileId, String startTime, String endTime) {
        return Result.timeout();
    }
}
