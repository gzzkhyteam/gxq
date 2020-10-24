package com.hengyunsoft.platform.ops.servicedto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "TrainAdminPageResDTO", description = "培训审核分页列表返回参数")
public class TrainAdminPageResDTO extends TrainPageResDTO{
    @ApiModelProperty(value = "提交单位")
    private String company;
    @ApiModelProperty(value = "提交人")
    private String person;
    @ApiModelProperty(value = "培训人Id")
    private String personId;
}
