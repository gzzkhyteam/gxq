package com.hengyunsoft.platform.hardware.dto.apply;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "ApplyApprQueryDTO", description = "申请查询")
public class ApplyApprQueryDTO {

    /**
     * 申请单号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请单号")
    private String applyNo;


    /**
     *申请开始时间
     */
    @ApiModelProperty(value = "申请开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date applyStartTime;


    /**
     *申请结束时间
     */
    @ApiModelProperty(value = "申请结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date applyEneTime;

    /**
     * 申请单位名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请单位名称")
    private String applyOrgname;


    /**
     * 申请类型(1新增2变更)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请类型(1新增2变更)")
    private String applyType;

    /**
     * 审请人姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审请人姓名")
    private String applyUname;

    /**
     * 大环节code（SQ，GL，UY，YY）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "大环节code（SQ，GL，UY，YY）")
    private String scode;
}
