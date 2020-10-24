package com.hengyunsoft.platform.modular.entity.modular.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * 表名：modular_provider_information
 *
 * @mbggenerated do_not_delete_during_merge
 * addModelClassComment 242 
 */
@Data
@ApiModel(value = "ProviderInformation", description = "")
public class ProviderInformation extends BaseEntity<Long> implements Serializable {
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 提供商名称
     *
     * @mbggenerated
     */
    @FieldDesc("提供商名称")
    @ApiModelProperty(value = "提供商名称")
    @Length(max=100)
    private String name;

    /**
     * 联系电话
     *
     * @mbggenerated
     */
    @FieldDesc("联系电话")
    @ApiModelProperty(value = "联系电话")
    @Length(max=20)
    private String phone;

    /**
     * 提供商简介
     *
     * @mbggenerated
     */
    @FieldDesc("提供商简介")
    @ApiModelProperty(value = "提供商简介")
    @Length(max=500)
    private String describle;

    /**
     * 提供商地址
     *
     * @mbggenerated
     */
    @FieldDesc("提供商地址")
    @ApiModelProperty(value = "提供商地址")
    @Length(max=500)
    private String address;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @FieldDesc("创建时间")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @FieldDesc("创建人")
    @ApiModelProperty(value = "创建人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long createUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @FieldDesc("更新时间")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @FieldDesc("更新时间")
    @ApiModelProperty(value = "更新时间")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long updateUser;

    //------------- 手动新增字段，请写在此后面 -------------
    private static final long serialVersionUID = 1L;
}