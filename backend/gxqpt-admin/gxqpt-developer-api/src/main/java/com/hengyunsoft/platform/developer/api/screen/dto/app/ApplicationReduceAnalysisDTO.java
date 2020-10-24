package com.hengyunsoft.platform.developer.api.screen.dto.app;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "ApplicationReduceAnalysis",description = "降本分析DTO")
public class ApplicationReduceAnalysisDTO {
    private Integer build;
    private Integer use;
    private Integer protect;

    public ApplicationReduceAnalysisDTO() {
        build = 0;
        use = 0;
        protect = 0;
    }
}
