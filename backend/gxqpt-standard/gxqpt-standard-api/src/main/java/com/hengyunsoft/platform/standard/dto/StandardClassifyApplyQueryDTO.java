package com.hengyunsoft.platform.standard.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "StandardClassifyApplySave", description = "标准分类申请信息参数对象")
public class StandardClassifyApplyQueryDTO{

    /**
     * 分类名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "分类名称")
    private String name;

    /**
     *申请开始时间
     */
    @ApiModelProperty(value = "申请开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTimeStart;

    /**
     *申请截止时间
     */
    @ApiModelProperty(value = "申请截止时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTimeEnd;

    /**
     * 处理结果，PASS：通过；REJECT：驳回
     *
     */
    @ApiModelProperty(value = "处理结果，PASS：通过；REJECT：驳回")
    private String dealResult;

    /**
     * 处理结果，PASS：通过；REJECT：驳回
     *
     */
    @ApiModelProperty(value = "是否处理，false：未处理； true：已处理")
    private Boolean isDeal;

}
