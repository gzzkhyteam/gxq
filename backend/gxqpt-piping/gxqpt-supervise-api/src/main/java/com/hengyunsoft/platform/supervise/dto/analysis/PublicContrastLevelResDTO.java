package com.hengyunsoft.platform.supervise.dto.analysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "PublicContrastLevelRes", description = "公用预警级别对比分析统计返回参数")
public class PublicContrastLevelResDTO {
    @ApiModelProperty(value = "使用个数")
    private List<Integer> num;
    @ApiModelProperty(value = "平均预警数")
    private List<Float> avg;
    @ApiModelProperty(value = "预警级别")
    private List<String> level;

    public PublicContrastLevelResDTO(){
        num = new ArrayList<>();
        avg = new ArrayList<>();
        level = new ArrayList<>();
    }
}
