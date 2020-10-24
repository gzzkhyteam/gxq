package com.hengyunsoft.platform.developer.api.service.dto.module.apply;

import com.hengyunsoft.validator.ValidatorGroups;
import com.hengyunsoft.validator.annotation.FieldDesc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 模块功能申请
 * @author sxy
 * @date 2019-02-15
 */
@Data
@ApiModel(value = "ServiceAssignModuleDTO", description = "模块功能申请")
public class ServiceAssignModuleDTO {

    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=ValidatorGroups.MustNoneNull.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 是否公有资源
     *
     * @mbggenerated
     */
    @FieldDesc("是否公有资源")
    @ApiModelProperty(value = "是否公有资源")
    private Boolean publicIs;

    /**
     * 功能id
     *
     * @mbggenerated
     */
    @FieldDesc("功能id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @ApiModelProperty(value = "功能id")
    private Long moduleId;

    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
    @FieldDesc("所属应用appid")
    @Length(max=64)
    @ApiModelProperty(value = "所属应用appid")
    private String appId;

    /**
     * 所属应用名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属应用名称")
    private String appName;

    /**
     * 状态： 1启用   0禁用
     *
     * @mbggenerated
     */
    @FieldDesc("状态： 1启用   0禁用")
    @ApiModelProperty(value = "状态： 1启用   0禁用")
    private Boolean status;

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    @FieldDesc("创建人id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @ApiModelProperty(value = "创建人id")
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @FieldDesc("创建时间")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新人id
     *
     * @mbggenerated
     */
    @FieldDesc("更新人id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @ApiModelProperty(value = "更新人id")
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @FieldDesc("更新时间")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 禁用备注
     *
     * @mbggenerated
     */
    @FieldDesc("禁用备注")
    @Length(max=500)
    @ApiModelProperty(value = "禁用备注")
    private String disableDesc;

    private static final long serialVersionUID = 1L;
}
