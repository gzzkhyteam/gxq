package com.hengyunsoft.platform.supervise.dto.analysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "PublicHandle", description = "公用预警处理时长统计返回参数")
public class PublicHandleResDTO {
    @ApiModelProperty(value = "id")
    private List<String> ids;
    @ApiModelProperty(value = "名称")
    private List<String> names;
    @ApiModelProperty(value = "平均确认时长")
    private List<Float> confirmedHours;
    @ApiModelProperty(value = "平均处理时长")
    private List<Float> processedHours;

    public PublicHandleResDTO(){
        ids = new ArrayList<>();
        names = new ArrayList<>();
        confirmedHours = new ArrayList<>();
        processedHours = new ArrayList<>();
    }
}
