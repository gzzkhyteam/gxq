package com.hengyunsoft.platform.supervise.entity.po;

import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Data
@ApiModel(value = "PowerSuperviseType", description = "")
public class PowerSuperviseType extends com.hengyunsoft.base.entity.BaseEntity<Long> implements Serializable {
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

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
     * 权责名称
     *
     * @mbggenerated
     */
    @FieldDesc("权责名称")
    @ApiModelProperty(value = "权责名称")
    @Length(max=64)
    private String name;

    /**
     * 层级
     *
     * @mbggenerated
     */
    @FieldDesc("层级")
    @ApiModelProperty(value = "层级")
    @Length(max=100)
    private String level;

    /**
     * 父节点ID
     *
     * @mbggenerated
     */
    @FieldDesc("父节点ID")
    @ApiModelProperty(value = "父节点ID")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long parentId;

    /**
     * 序号
     *
     * @mbggenerated
     */
    @FieldDesc("序号")
    @ApiModelProperty(value = "序号")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer orderNum;

    /**
     * 是否启用
     *
     * @mbggenerated
     */
    @FieldDesc("是否启用")
    @ApiModelProperty(value = "是否启用")
    private Boolean isEnable;

    /**
     * 类型描述
     *
     * @mbggenerated
     */
    @FieldDesc("类型描述")
    @ApiModelProperty(value = "类型描述")
    @Length(max=500)
    private String desc;

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
     * 创建时间
     *
     * @mbggenerated
     */
    @FieldDesc("创建时间")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    @FieldDesc("更新人")
    @ApiModelProperty(value = "更新人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @FieldDesc("更新时间")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    //------------- 手动新增字段，请写在此后面 -------------
    private static final long serialVersionUID = 1L;
}