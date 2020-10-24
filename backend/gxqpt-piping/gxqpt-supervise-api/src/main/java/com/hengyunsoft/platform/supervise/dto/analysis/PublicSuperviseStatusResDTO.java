package com.hengyunsoft.platform.supervise.dto.analysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "PublicSuperviseStatusRes", description = "单位预警状态统计返回参数")
public class PublicSuperviseStatusResDTO {
    @ApiModelProperty(value = "单位id")
    private List<String> ids;
    @ApiModelProperty(value = "单位名称")
    private List<String> names;
    @ApiModelProperty(value = "已处理预警")
    private List<Integer> processeds;
    @ApiModelProperty(value = "未处理预警")
    private List<Integer> untreateds;
    @ApiModelProperty(value = "新增预警")
    private List<Integer> newThisYears;

    public PublicSuperviseStatusResDTO(){
        ids = new ArrayList<>();
        names = new ArrayList<>();
        processeds = new ArrayList<>();
        untreateds = new ArrayList<>();
        newThisYears = new ArrayList<>();
    }
}
