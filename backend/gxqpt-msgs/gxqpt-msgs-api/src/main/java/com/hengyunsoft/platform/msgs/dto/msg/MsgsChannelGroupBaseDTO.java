package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MsgsChannelGroupBaseDTO {

    /**
     * 渠道群组
     */
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     *描述
     */
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 渠道类型1
     */
    @ApiModelProperty(value = "渠道类型1")
    private Integer channelType1;

    /**
     *渠道1
     */
    @ApiModelProperty(value = "渠道1")
    private String channel1;

    /**
     * 渠道类型2
     */
    @ApiModelProperty(value = "渠道类型2")
    private Integer channelType2;

    /**
     *渠道2
     */
    @ApiModelProperty(value = "渠道2")
    private String channel2;

    /**
     * 渠道类型2
     */
    @ApiModelProperty(value = "渠道类型3")
    private Integer channelType3;

    /**
     *渠道2
     */
    @ApiModelProperty(value = "渠道4")
    private String channel3;

    /**
     * 渠道类型4
     */
    @ApiModelProperty(value = "渠道类型4")
    private Integer channelType4;

    /**
     *渠道4
     */
    @ApiModelProperty(value = "渠道4")
    private String channel4;

    /**
     * 渠道类型5
     */
    @ApiModelProperty(value = "渠道类型5")
    private Integer channelType5;

    /**
     *渠道5
     */
    @ApiModelProperty(value = "渠道5")
    private String channel5;

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    private String channel1Id;

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    private String channel2Id;

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    private String channel3Id;

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    private String channel4Id;

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    private String channel5Id;

}
