package com.hengyunsoft.platform.supervise.dto.analysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "PublicContrastRes", description = "公用对比分析统计返回参数")
public class PublicContrastResDTO {
    @ApiModelProperty(value = "使用个数")
    private List<Float> num;
    @ApiModelProperty(value = "平均预警数")
    private List<Float> avg;
    @ApiModelProperty(value = "类型id")
    private List<String> typeId;
    @ApiModelProperty(value = "类型名称")
    private List<String> typeName;

    public PublicContrastResDTO(){
        num = new ArrayList<>();
        avg = new ArrayList<>();
        typeId = new ArrayList<>();
        typeName = new ArrayList<>();
    }
}
