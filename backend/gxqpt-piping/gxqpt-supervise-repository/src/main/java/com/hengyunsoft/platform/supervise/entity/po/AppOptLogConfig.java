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
@ApiModel(value = "AppOptLogConfig", description = "")
public class AppOptLogConfig extends com.hengyunsoft.base.entity.BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @FieldDesc("主键")
    @ApiModelProperty(value = "主键")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 应用app id
     *
     * @mbggenerated
     */
    @FieldDesc("应用app id")
    @ApiModelProperty(value = "应用app id")
    @Length(max=64)
    @NotNull(groups=MustNoneNull.class)
    private String appId;

    /**
     * 在erueka中的id
     *
     * @mbggenerated
     */
    @FieldDesc("在erueka中的id")
    @ApiModelProperty(value = "在erueka中的id")
    @Length(max=255)
    private String serviceId;

    /**
     * 服务 service  应用 application
     *
     * @mbggenerated
     */
    @FieldDesc("服务 service  应用 application")
    @ApiModelProperty(value = "服务 service  应用 application")
    @Length(max=20)
    private String type;

    /**
     * 采集方式
     *
     * @mbggenerated
     */
    @FieldDesc("采集方式")
    @ApiModelProperty(value = "采集方式")
    @NotNull(groups=MustNoneNull.class)
    @Length(max=20)
    private String storeDay;

    /**
     * 存储率   采集率
     *
     * @mbggenerated
     */
    @FieldDesc("存储率   采集率")
    @ApiModelProperty(value = "存储率   采集率")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer storeRates;

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
     * 更新人
     *
     * @mbggenerated
     */
    @FieldDesc("更新人")
    @ApiModelProperty(value = "更新人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long updateUser;

    /**
     * 采集占用率(%)
     *
     * @mbggenerated
     */
    @FieldDesc("采集占用率(%)")
    @ApiModelProperty(value = "采集占用率(%)")
    @NotNull(groups=MustNoneNull.class)
    private float storeIs;

    //------------- 手动新增字段，请写在此后面 -------------
    private static final long serialVersionUID = 1L;
}