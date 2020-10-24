package com.hengyunsoft.platform.developer.api.fast.dto.docment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sunxiaoya
 * @create 2018-05-03
 * @desc 快速应用公文拟办保存返回
 **/
@Data
@ApiModel(value = "FastAppDocTaskPageRetDTO",description = "快速应用公文拟办保存返回")
public class FastAppDocTaskPageRetDTO implements Serializable{
    /**
     * ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private Long id;

    /**
     * 开发者ID，提供给各个应用的设别码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开发者ID，提供给各个应用的设别码")
    private String appId;


    /**
     * 当前用户类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "当前用户类型")
    private String currentUserType;

    /**
     * 下一步用户类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "下一步用户类型")
    private String nextUserType;

    /**
     * 下一个处理人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "下一个处理人")
    private Long nextUserId;

    /**
     * 环节状态
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "环节状态")
    private String linkStatus;

    /**
     * 名字
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "名字")
    private String name;

    /**
     * 收发文目标
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "收发文目标")
    private String target;

    /**
     * 密级
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "密级")
    private String rank;

    /**
     * 标题
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "描述")
    private String desc;

    /**
     * 公文内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "公文内容")
    private String content;

    /**
     * 收文单位
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "收文单位")
    private String docUnit;

    /**
     * 收文文号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "收文文号")
    private String docNum;

    /**
     * 收文时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "收文时间")
    private Date docTime;

    /**
     * 收文编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "收文编码")
    private String docCode;

    /**
     * 公文类型：send(发文) receive(收文)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "公文类型：send(发文) receive(收文)")
    private String docType;

    /**
     * 紧急度
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "紧急度")
    private String urgencyDegree;

    /**
     * 附件地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "附件地址")
    private String attachmentUrl;

    /**
     * 附件名字
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "附件名字")
    private String attachmentName;

    /**
     * 处理状态：待办（processing） 已办（finished）
     *
     * @mbggenerated
     */
    private String handleStatus;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人")
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新人id")
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 创建人名字
     *
     * @mbggenerated
     */
    private String createUserName;


    private static final long serialVersionUID = 1L;

}