package com.hengyunsoft.platform.supervise.dto.center;

import com.hengyunsoft.validator.ValidatorGroups;
import com.hengyunsoft.validator.annotation.FieldDesc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 权责监管环节更新DTO
 * @author sxy
 * @date 2018-09-12
 */
@Data
@ApiModel(value = "PowerSuperviseLinkUpdateDTO",description = "权责监管更新环节DTO")
public class PowerSuperviseLinkUpdateDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=ValidatorGroups.MustNoneNull.class)
    private Long id;

    /**
     * 主配置ID
     *
     * @mbggenerated
     */
    @FieldDesc("主配置ID")
    @ApiModelProperty(value = "主配置ID")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long powerSuperviseId;

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
     * 时长限制
     *
     * @mbggenerated
     */
    @FieldDesc("时长限制")
    @ApiModelProperty(value = "时长限制")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Double timeLimit;

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
     * 提醒方式 1-消息 2-短信 3-短信和消息
     *
     * @mbggenerated
     */
    @FieldDesc("提醒方式 1-消息 2-短信 3-短信和消息")
    @ApiModelProperty(value = "提醒方式 1-消息 2-短信 3-短信和消息")
    @Range(min=Short.MIN_VALUE,max=Short.MAX_VALUE)
    private Short remindType;

    /**
     * 排序编号
     *
     * @mbggenerated
     */
    @FieldDesc("排序编号")
    @ApiModelProperty(value = "排序编号")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer sortNum;

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
