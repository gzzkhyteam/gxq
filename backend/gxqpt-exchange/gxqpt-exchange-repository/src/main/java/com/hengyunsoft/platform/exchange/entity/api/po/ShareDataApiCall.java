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
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Data
@ApiModel(value = "ShareDataApiCall", description = "")
public class ShareDataApiCall extends BaseEntity<Long> implements Serializable {
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
     * api管理id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "api管理id")
    @FieldDesc("api管理id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long apiId;

    /**
     * 调用单位Id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "调用单位Id")
    @FieldDesc("调用单位Id")
    @Length(max=64)
    private String unitId;

    /**
     * 返回数据量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "返回数据量")
    @FieldDesc("返回数据量")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer dataCount;

    /**
     * 访问IP
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "访问IP")
    @FieldDesc("访问IP")
    @Length(max=128)
    private String ipAddress;

    /**
     * 是否成功：1，成功；2，失败
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否成功：1，成功；2，失败")
    @FieldDesc("是否成功：1，成功；2，失败")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Integer isSuccess;

    /**
     * 响应时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "响应时间")
    @FieldDesc("响应时间")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Float rsponseTime;

    /**
     * 返回结果
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "返回结果")
    @FieldDesc("返回结果")
    @Length(max=2147483647)
    private String result;

    /**
     * 操作人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "操作人")
    @FieldDesc("操作人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long userId;

    /**
     * 访问时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "访问时间")
    @FieldDesc("访问时间")
    private Date visitTime;

    /**
     * 失败类型：1，系统错误；2，访问参数错误
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "失败类型：1，系统错误；2，访问参数错误")
    @FieldDesc("失败类型：1，系统错误；2，访问参数错误")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer failType;

    /**
     * 失败日志
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "失败日志")
    @FieldDesc("失败日志")
    @Length(max=2147483647)
    private String failLog;

    /**
     * 处理状态:1,已处理；2，未处理，3、已忽略
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理状态:1,已处理；2，未处理，3、已忽略")
    @FieldDesc("处理状态:1,已处理；2，未处理，3、已忽略")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer hdleState;

    /**
     * 处理人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理人id")
    @FieldDesc("处理人id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long hdleUser;

    /**
     * 处理时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理时间")
    @FieldDesc("处理时间")
    private Date hdleTime;

    /**
     * 处理方式
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理方式")
    @FieldDesc("处理方式")
    @Length(max=1000)
    private String hdleContent;

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