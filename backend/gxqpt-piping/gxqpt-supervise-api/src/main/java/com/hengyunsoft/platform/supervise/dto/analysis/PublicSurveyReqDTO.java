package com.hengyunsoft.platform.supervise.dto.analysis;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "PublicSurveyReq", description = "单位预警概况接收参数(非集合)")
public class PublicSurveyReqDTO {
    @ApiModelProperty(value = "单位id")
    private String orgId;
    @ApiModelProperty(value = "部门id")
    private String dpmId;
    @ApiModelProperty(value = "人员id")
    private String empId;
    @ApiModelProperty(value = "应用id")
    private String appId;
    @ApiModelProperty(value = "部门id,专用于人员分部门集合查询")
    private String empDpmId;

    @ApiModelProperty(value = "选取时间")
    @DateTimeFormat(pattern = "yyyy")
    @JsonFormat(pattern = "yyyy",timezone = "GMT+8")
    private Date date;
}

