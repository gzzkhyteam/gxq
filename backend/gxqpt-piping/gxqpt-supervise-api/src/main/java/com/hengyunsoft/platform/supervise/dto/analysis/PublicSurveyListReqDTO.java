package com.hengyunsoft.platform.supervise.dto.analysis;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "PublicSurveyListReq", description = "单位预警概况接收参数")
public class PublicSurveyListReqDTO {
    @ApiModelProperty(value = "单位id")
    private List<String> orgIds;
    @ApiModelProperty(value = "部门id")
    private List<String> dpmIds;
    @ApiModelProperty(value = "人员id")
    private List<String> empIds;
    @ApiModelProperty(value = "应用id")
    private List<String> appIds;
    @ApiModelProperty(value = "部门id,专用于人员分部门集合查询")
    private String empDpmId;

    @ApiModelProperty(value = "选取时间")
    @DateTimeFormat(pattern = "yyyy")
    @JsonFormat(pattern = "yyyy",timezone = "GMT+8")
    private Date date;
}

