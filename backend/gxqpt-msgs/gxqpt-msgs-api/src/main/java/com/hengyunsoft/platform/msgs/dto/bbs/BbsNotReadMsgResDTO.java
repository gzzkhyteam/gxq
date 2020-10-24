package com.hengyunsoft.platform.msgs.dto.bbs;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BbsNotReadMsgResDTO implements Serializable {
	private static final long serialVersionUID = 1L;

    /**
     * 主键id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键ID")
    private Long id;

    /**
     * 业务id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "业务id")
    private String bizId;

    /**
     * 业务类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "业务类型")
    private String bizType;

    /**
     * 客户端对此消息的唯一标示,   若客户端对此消息进行了存储，这里推荐是那里的存储id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "客户端标识")
    private String clientFlag;

    /**
     * 简要类型，粗粒度的类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "简要类型，粗粒度的类型")
    private String briefTpye;

    /**
     * 详细类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "详细类型")
    private String detailedType;

    /**
     * 详细类型描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "详细类型描述")
    private String detailedTypeDesc;

    /**
     * 标题
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 作者名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "作者名称")
    private String senderName;

    /**
     * 处理地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理地址")
    private String handlerUrl;

    /**
     * 处理参数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理参数")
    private String handlerParams;

    /**
     * 是否单人处理
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否单人处理")
    private Boolean singleHandleIs;

    /**
     * 是否需要操作
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否需要操作")
    private Boolean handlerNeedIs;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用id")
    private String appId;

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用名称")
    private String appName;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 未读消息接收DTO
     *
     * @mbggenerated
     */
    /*@ApiModelProperty(value = "未读消息接收DTO")
    private BbsNotReadReceiveMsgDTO dto;*/

    /**
     * 接收主键id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "接收主键ID")
    private Long recId;

    /**
     * 消息id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "消息id")
    private Long msgId;

    /**
     * 接收人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "接收人id")
    private Long receiveId;

    /**
     * 是否已读
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否已读")
    private Boolean readIs;

    /**
     * 接收是否需要处理
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "接收是否需要处理")
    private Boolean recHanderNeedIs;

    /**
     * 接收创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "接收创建时间")
    private Date recCreateTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新人")
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}