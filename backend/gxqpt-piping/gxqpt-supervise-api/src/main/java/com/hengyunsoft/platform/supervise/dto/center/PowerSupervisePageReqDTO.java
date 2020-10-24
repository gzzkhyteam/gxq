package com.hengyunsoft.platform.supervise.dto.center;

import com.hengyunsoft.validator.annotation.FieldDesc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;
import java.util.List;

/**
 * 权责监管分页查询请求DTO
 * @author sxy
 * @date 2018-09-12
 */
@Data
@ApiModel(value = "PowerSupervisePageReqDTO",description = "权责监管分页查询请求DTO")
public class PowerSupervisePageReqDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    /**
     * 权责编码
     *
     * @mbggenerated
     */
    @FieldDesc("权责编码")
    @ApiModelProperty(value = "权责编码")
    @Length(max=64)
    private String code;

    /**
     * 权责类型
     *
     * @mbggenerated
     */
    @FieldDesc("权责类型")
    @ApiModelProperty(value = "权责类型")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long typeId;

    /**
     * 权责名称
     *
     * @mbggenerated
     */
    @FieldDesc("权责名称")
    @ApiModelProperty(value = "权责名称")
    @Length(max=20)
    private String name;

    /**
     * 执行单位
     *
     * @mbggenerated
     */
    @FieldDesc("执行单位")
    @ApiModelProperty(value = "执行单位")
    @Length(max=64)
    private List<String> unit;

    /**
     * 运行状态 启用:true 禁用:false
     *
     * @mbggenerated
     */
    @FieldDesc("运行状态 启用:true 禁用:false")
    @ApiModelProperty(value = "运行状态 启用:true 禁用:false 全部:null")
    private Boolean runStatus;
    
    /**
     * 系统ID
     *
     * @mbggenerated
     */
    @FieldDesc("系统ID")
    @ApiModelProperty(value = "系统ID")
    private String systemId;
    
    /**
     * 系统名称
     *
     * @mbggenerated
     */
    @FieldDesc("系统名称")
    @ApiModelProperty(value = "系统名称")
    private String systemName;
}
