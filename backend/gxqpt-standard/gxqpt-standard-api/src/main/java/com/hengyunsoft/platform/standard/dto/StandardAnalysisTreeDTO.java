package com.hengyunsoft.platform.standard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "StandardAnalysisTree", description = "各类文档下载数量统计")
public class StandardAnalysisTreeDTO implements Serializable {
    @ApiModelProperty(value = "分类名称")
    private String classifyName;

    @ApiModelProperty(value = "下载次数")
    private Integer downloadCount;
}
