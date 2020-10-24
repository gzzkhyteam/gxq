package com.hengyunsoft.platform.supervise.dto.center;

import com.hengyunsoft.validator.annotation.FieldDesc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;

/**
 * 权责监管临时数据保存DTO
 * @author sxy
 * @date 2018-09-12
 */
@Data
@ApiModel(value = "PowerSuperviseTempSaveDTO",description = "权责监管临时数据保存DTO")
public class PowerSuperviseTempSaveDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用id")
    private String appId;

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用名称")
    private String appName;

    /**
     * 业务ID
     */
    @ApiModelProperty(value = "业务ID")
    private Long bizId;

    /**
     * 环节编码
     *
     * @mbggenerated
     */
    @FieldDesc("环节编码")
    @ApiModelProperty(value = "环节编码")
    @Length(max=64)
    private String code;

    /**
     * 环节名称
     *
     * @mbggenerated
     */
    @FieldDesc("环节名称")
    @ApiModelProperty(value = "环节名称")
    @Length(max=64)
    private String name;

    /**
     * 环节描述
     *
     * @mbggenerated
     */
    @FieldDesc("环节描述")
    @ApiModelProperty(value = "环节描述")
    @Length(max=500)
    private String desc;

    /**
     * 开始时间
     *
     * @mbggenerated
     */
    @FieldDesc("开始时间")
    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    /**
     * 结束时间
     *
     * @mbggenerated
     */
    @FieldDesc("结束时间")
    @ApiModelProperty(value = "结束时间")
    private Date endTime;

}
