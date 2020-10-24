package com.hengyunsoft.platform.supervise.dto.center;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.hengyunsoft.validator.annotation.FieldDesc;

/**
 * 权责监管详情DTO
 * @author sxy
 * @date 2018-09-12
 */
@Data
@ApiModel(value = "PowerSuperviseDetailDTO",description = "权责监管详情DTO")
public class PowerSuperviseDetailDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 权责编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "权责编码")
    private String code;

    /**
     * 权责类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "权责类型")
    private Long typeId;

    /**
     * 权责类型名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "权责类型名称")
    private String typeName;

    /**
     * 权责名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "权责名称")
    private String name;

    /**
     * 责任事项
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "责任事项")
    private String matter;

    /**
     * 执行单位
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "执行单位")
    private String unit;

    /**
     * 执行单位名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "执行单位名称")
    private String unitName;

    /**
     * 法律规定
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "法律规定")
    private String lawDesc;

    /**
     * 运行状态 启用:true 禁用:false
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "运行状态 启用:true 禁用:false")
    private Boolean runStatus;
    /**
     * 系统ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统ID")
    private String systemId;
    
    /**
     * 系统名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统名称")
    private String systemName;
    /**
     * 创建人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人")
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新人")
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "级别")
    private Integer level;
}
