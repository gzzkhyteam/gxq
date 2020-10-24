package com.hengyunsoft.platform.msgs.entity.msgsmessage.po;

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
@ApiModel(value = "SmsMessageRecord", description = "")
public class SmsMessageRecord extends com.hengyunsoft.base.entity.BaseEntity<Long> implements Serializable {
    /**
     * 短信记录id
     *
     * @mbggenerated
     */
    @FieldDesc("短信记录id")
    @ApiModelProperty(value = "短信记录id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 发布信息的id
     *
     * @mbggenerated
     */
    @FieldDesc("发布信息的id")
    @ApiModelProperty(value = "发布信息的id")
    @Length(max=64)
    private String msgId;

    /**
     * 应用程序id
     *
     * @mbggenerated
     */
    @FieldDesc("应用程序id")
    @ApiModelProperty(value = "应用程序id")
    @Length(max=32)
    @NotNull(groups=MustNoneNull.class)
    private String appId;

    /**
     * 模块id
     *
     * @mbggenerated
     */
    @FieldDesc("模块id")
    @ApiModelProperty(value = "模块id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long moduleId;

    /**
     * 模块名称
     *
     * @mbggenerated
     */
    @FieldDesc("模块名称")
    @ApiModelProperty(value = "模块名称")
    @Length(max=100)
    private String moduleName;
    /**
     * 应用程序名称
     *
     * @mbggenerated
     */
    @FieldDesc("应用程序名称")
    @ApiModelProperty(value = "应用程序名称")
    @Length(max=100)
    private String appName;

    /**
     * 发送者id
     *
     * @mbggenerated
     */
    @FieldDesc("发送者id")
    @ApiModelProperty(value = "发送者id")
    @Length(max=100)
    @NotNull(groups=MustNoneNull.class)
    private String sender;

    /**
     * 发送者名称
     *
     * @mbggenerated
     */
    @FieldDesc("发送者名称")
    @ApiModelProperty(value = "发送者名称")
    @Length(max=100)
    private String senderName;

    /**
     * 接收者手机号
     *
     * @mbggenerated
     */
    @FieldDesc("接收者手机号")
    @ApiModelProperty(value = "接收者手机号")
    @Length(max=65535)
    private String receiver;

    /**
     * 短信主题
     *
     * @mbggenerated
     */
    @FieldDesc("短信主题")
    @ApiModelProperty(value = "短信主题")
    @Length(max=255)
    private String topic;

    /**
     * 发送渠道id
     *
     * @mbggenerated
     */
    @FieldDesc("发送渠道id")
    @ApiModelProperty(value = "发送渠道id")
    @Length(max=300)
    @NotNull(groups=MustNoneNull.class)
    private String channelId;

    /**
     * 是否为草稿,1表示是草稿，0表示不是
     *
     * @mbggenerated
     */
    @FieldDesc("是否为草稿,1表示是草稿，0表示不是")
    @ApiModelProperty(value = "是否为草稿,1表示是草稿，0表示不是")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer draft;

    /**
     * 是否删除
     *
     * @mbggenerated
     */
    @FieldDesc("是否删除")
    @ApiModelProperty(value = "是否删除")
    private Boolean deleteIs;

    /**
     * 来源类型APP应用，MODULAR模块，SERVICE服务
     *
     * @mbggenerated
     */
    @FieldDesc("来源类型APP应用，MODULAR模块，SERVICE服务")
    @ApiModelProperty(value = "来源类型APP应用，MODULAR模块，SERVICE服务")
    @Length(max=20)
    private String sourceType;

    /**
     * 短信模板id
     *
     * @mbggenerated
     */
    @FieldDesc("短信模板id")
    @ApiModelProperty(value = "短信模板id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long templateId;

    /**
     * 短信模板参数
     *
     * @mbggenerated
     */
    @FieldDesc("短信模板参数")
    @ApiModelProperty(value = "短信模板参数")
    @Length(max=500)
    private String templateParams;

    /**
     * 短信发送时间
     *
     * @mbggenerated
     */
    @FieldDesc("短信发送时间")
    @ApiModelProperty(value = "短信发送时间")
    private Date sendTime;

    /**
     * 发送开始时间
     *
     * @mbggenerated
     */
    @FieldDesc("发送开始时间")
    @ApiModelProperty(value = "发送开始时间")
    @Length(max=50)
    private String startTime;

    /**
     * 发送结束时间
     *
     * @mbggenerated
     */
    @FieldDesc("发送结束时间")
    @ApiModelProperty(value = "发送结束时间")
    @Length(max=50)
    private String endTime;

    /**
     * 发送内容
     *
     * @mbggenerated
     */
    @FieldDesc("发送内容")
    @ApiModelProperty(value = "发送内容")
    @Length(max=500)
    private String context;

    /**
     * 短信记录创建时间
     *
     * @mbggenerated
     */
    @FieldDesc("短信记录创建时间")
    @ApiModelProperty(value = "短信记录创建时间")
    private Date createTime;

    /**
     * 短信记录更新时间
     *
     * @mbggenerated
     */
    @FieldDesc("短信记录更新时间")
    @ApiModelProperty(value = "短信记录更新时间")
    private Date updateTime;

    //------------- 手动新增字段，请写在此后面 -------------
    private static final long serialVersionUID = 1L;
}