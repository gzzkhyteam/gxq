package com.hengyunsoft.platform.exchange.entity.api.po;

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
@ApiModel(value = "ShareDataApiSubscription", description = "")
public class ShareDataApiSubscription extends BaseEntity<Long> implements Serializable {
    /**
     * 主键ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键ID")
    @FieldDesc("主键ID")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 用户申请Id(b_share_data_api_user.id)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户申请Id(b_share_data_api_user.id)")
    @FieldDesc("用户申请Id(b_share_data_api_user.id)")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long applyId;

    /**
     * 数据仓库最后一次更新时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据仓库最后一次更新时间")
    @FieldDesc("数据仓库最后一次更新时间")
    @NotNull(groups=MustNoneNull.class)
    private Date lastUpdateTime;

    /**
     * 通知时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "通知时间")
    @FieldDesc("通知时间")
    private Date noticeTime;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    @FieldDesc("创建时间")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    @FieldDesc("创建时间")
    private Date createTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新人")
    @FieldDesc("更新人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    @FieldDesc("更新时间")
    private Date updateTime;

    //------------- 手动新增字段，请写在此后面 -------------
    private static final long serialVersionUID = 1L;
}