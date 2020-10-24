package com.hengyunsoft.platform.developer.api.screen.dto.app;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "ApplicationReduceAnalysisList", description = "已有降本案例DTO")
public class ApplicationReduceAnalysisListDTO {
    private List<Double> builds;
    private List<Double> uses;
    private List<Double> protects;
    private List<String> names;

    public ApplicationReduceAnalysisListDTO() {
        builds = new ArrayList<>();
        uses = new ArrayList<>();
        protects = new ArrayList<>();
        names = new ArrayList<>();
    }
}
