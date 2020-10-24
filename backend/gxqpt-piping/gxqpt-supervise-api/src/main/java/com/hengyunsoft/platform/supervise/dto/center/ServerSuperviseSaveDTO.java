package com.hengyunsoft.platform.supervise.dto.center;

import com.hengyunsoft.validator.annotation.FieldDesc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;
import java.util.Date;

/**
 * 服务监管保存DTO
 * @author sxy
 * @date 2018-09-12
 */
@Data
@ApiModel(value = "ServerSuperviseSaveDTO",description = "服务监管保存DTO")
public class ServerSuperviseSaveDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    @FieldDesc("应用ID")
    @ApiModelProperty(value = "应用ID")
    @Length(max=64)
    private String appId;

    /**
     * 服务编码
     *
     * @mbggenerated
     */
    @FieldDesc("服务编码")
    @ApiModelProperty(value = "服务编码")
    @Length(max=20)
    private String appCode;

    /**
     * 上限阀值
     *
     * @mbggenerated
     */
    @FieldDesc("上限阀值")
    @ApiModelProperty(value = "上限阀值")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer limit;

    /**
     * 阀值周期
     *
     * @mbggenerated
     */
    @FieldDesc("阀值周期")
    @ApiModelProperty(value = "阀值周期")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer limitCycle;

    /**
     * 责任人:单个
     *
     * @mbggenerated
     */
    @FieldDesc("责任人:单个")
    @ApiModelProperty(value = "责任人:单个")
    @Length(max=32)
    private String dutyUser;

    /**
     * 确认人:多个,逗号隔开
     *
     * @mbggenerated
     */
    @FieldDesc("确认人:多个,逗号隔开")
    @ApiModelProperty(value = "确认人:多个,逗号隔开")
    @Length(max=2147483647)
    private String confirmUser;

    /**
     * 抄送人:多个,逗号隔开
     *
     * @mbggenerated
     */
    @FieldDesc("抄送人:多个,逗号隔开")
    @ApiModelProperty(value = "抄送人:多个,逗号隔开")
    @Length(max=2147483647)
    private String copyUser;

    /**
     * 定时时间
     *
     * @mbggenerated
     */
    @FieldDesc("定时时间")
    @ApiModelProperty(value = "定时时间")
    private Date scheduledTime;

    /**
     * 提醒方式 消息:1,短信:2
     *
     * @mbggenerated
     */
    @FieldDesc("提醒方式 消息:1,短信:2")
    @ApiModelProperty(value = "提醒方式 消息:1,短信:2")
    @Range(min=Short.MIN_VALUE,max=Short.MAX_VALUE)
    private Short remindType;

    /**
     * 运行状态 启用:true 禁用:false
     *
     * @mbggenerated
     */
    @FieldDesc("运行状态 启用:true 禁用:false")
    @ApiModelProperty(value = "运行状态 启用:true 禁用:false")
    private Boolean runStatus;

    /**
     * 备注
     *
     * @mbggenerated
     */
    @FieldDesc("备注")
    @ApiModelProperty(value = "备注")
    @Length(max=500)
    private String desc;

    @ApiModelProperty(value = "级别")
    private Integer level;
}
