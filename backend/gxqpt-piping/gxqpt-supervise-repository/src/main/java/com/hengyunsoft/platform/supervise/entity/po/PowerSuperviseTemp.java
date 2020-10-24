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
@ApiModel(value = "PowerSuperviseTemp", description = "")
public class PowerSuperviseTemp extends com.hengyunsoft.base.entity.BaseEntity<Long> implements Serializable {
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    @FieldDesc("应用id")
    @ApiModelProperty(value = "应用id")
    @Length(max=64)
    private String appId;

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    @FieldDesc("应用名称")
    @ApiModelProperty(value = "应用名称")
    @Length(max=30)
    private String appName;

    /**
     * 业务id
     *
     * @mbggenerated
     */
    @FieldDesc("业务id")
    @ApiModelProperty(value = "业务id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
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
     * 是否发送
     *
     * @mbggenerated
     */
    @FieldDesc("是否发送")
    @ApiModelProperty(value = "是否发送")
    private Boolean isSend;

    /**
     * 是否完成
     *
     * @mbggenerated
     */
    @FieldDesc("是否完成")
    @ApiModelProperty(value = "是否完成")
    private Boolean isFinish;

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