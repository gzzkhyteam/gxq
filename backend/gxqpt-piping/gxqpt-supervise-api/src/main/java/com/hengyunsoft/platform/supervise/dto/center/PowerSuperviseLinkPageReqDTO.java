package com.hengyunsoft.platform.supervise.dto.center;

import com.hengyunsoft.validator.annotation.FieldDesc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

/**
 * 权责环节监管分页查询请求DTO
 * @author sxy
 * @date 2018-09-12
 */
@Data
@ApiModel(value = "PowerSuperviseLinkPageReqDTO",description = "权责环节监管分页查询请求DTO")
public class PowerSuperviseLinkPageReqDTO implements Serializable{

    private static final long serialVersionUID = 1L;

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
     * 主配置ID
     *
     * @mbggenerated
     */
    @FieldDesc("主配置ID")
    @ApiModelProperty(value = "主配置ID")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long powerSuperviseId;

}
