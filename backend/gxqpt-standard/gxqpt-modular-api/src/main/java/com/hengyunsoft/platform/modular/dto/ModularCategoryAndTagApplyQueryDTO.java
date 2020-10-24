package com.hengyunsoft.platform.modular.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "ModularApplyQuery", description = "申请查询参数对象")
public class ModularCategoryAndTagApplyQueryDTO {

    /**
     * 申请类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请类型，CATEGORYAPPLY：分类申请；TAGAPPLY：标签申请")
    private String applyType;

    /**
     * 申请名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请名称")
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

}
