package com.hengyunsoft.platform.developer.api.fast.dto.docment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author sunxiaoya
 * @create 2018-05-03
 * @desc 快速应用公文拟办保存返回
 **/
@Data
@ApiModel(value = "FastAppDocTaskPageDTO",description = "快速应用公文拟办保存返回")
public class FastAppDocTaskPageDTO implements Serializable{

    /**
     * 应用id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用id")
    private String appId;

    /**
     * 处理状态
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理状态")
    private String handleStatus;

    /**
     * 文件名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件名称")
    private String fileName;

    /**
     * 公文编号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "公文编号")
    private String docNum;

    /**
     * 公文类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "公文类型")
    private String docType;

    /**
     * 开始时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开始时间")
    private String startTime;

    /**
     * 结束时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "结束时间")
    private String endTime;

    /**
     * 内容关键字
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "内容关键字")
    private String content;

    /**
     * 拟稿人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "拟稿人")
    private String draftedPersonName;

    /**
     * 当前登录用户
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "当前登录用户")
    private String loginPerson;

    private static final long serialVersionUID = 1L;

}