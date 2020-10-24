package com.hengyunsoft.platform.exchange.entity.directory.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
@ApiModel(value = "ShareDataChangeElement", description = "")
public class ShareDataChangeElement extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    @FieldDesc("主键")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 变动主表id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "变动主表id")
    @FieldDesc("变动主表id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long chgId;

    /**
     * 变动类型:1,新增；2，编辑；3，删除;4,禁用;6启用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "变动类型:1,新增；2，编辑；3，删除;4,禁用;6启用")
    @FieldDesc("变动类型:1,新增；2，编辑；3，删除;4,禁用;6启用")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer changeType;

    /**
     * 业务类型:1，目录；2，字段;
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "业务类型:1，目录；2，字段;")
    @FieldDesc("业务类型:1，目录；2，字段;")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer busType;

    /**
     * 业务id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "业务id")
    @FieldDesc("业务id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long busId;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    @FieldDesc("创建时间")
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人")
    @FieldDesc("创建人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long createUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    @FieldDesc("更新时间")
    private Date updateTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新人")
    @FieldDesc("更新人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long updateUser;

    //------------- 手动新增字段，请写在此后面 -------------
    private static final long serialVersionUID = 1L;
}