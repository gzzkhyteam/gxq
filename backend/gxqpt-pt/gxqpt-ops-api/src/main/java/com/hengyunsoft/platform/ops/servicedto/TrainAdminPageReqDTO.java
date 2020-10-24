package com.hengyunsoft.platform.ops.servicedto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "TrainAdminPageReqDTO", description = "培训审核分页列表请求参数")
public class TrainAdminPageReqDTO extends TrainPageReqDTO{
    @ApiModelProperty(value = "提交单位")
    private String company;
    @ApiModelProperty(value = "提交人")
    private String person;
    @ApiModelProperty(value = "处理页面标示，0=审核，1=处理")
    private Integer handle;
}
