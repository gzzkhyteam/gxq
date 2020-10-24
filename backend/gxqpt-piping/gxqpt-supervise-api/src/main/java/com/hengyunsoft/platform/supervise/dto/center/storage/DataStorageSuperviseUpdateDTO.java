package com.hengyunsoft.platform.supervise.dto.center.storage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "DataStorageSuperviseUpdate", description = "数据存储配置修改实体")
public class DataStorageSuperviseUpdateDTO {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 应用ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用ID")
    private String appId;

    /**
     * 数据库空间阀值
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库空间阀值")
    private Double dbSpaceLimit;

    /**
     * 日志空间阀值
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日志空间阀值")
    private Double logSpaceLimit;

    /**
     * 文件空间阀值
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件空间阀值")
    private Double fileSpaceLimit;

    /**
     * 文件空间地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件空间地址")
    private String fileSpaceUrl;

    /**
     * 日志空间地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日志空间地址")
    private String logSpaceUrl;

    /**
     * 数据库空间地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库空间地址")
    private String dbSpaceUrl;

    /**
     * 责任人:单个
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "责任人:单个")
    private String dutyUser;

    /**
     * 确认人:多个,逗号隔开
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "确认人:多个,逗号隔开")
    private String confirmUser;

    /**
     * 抄送人:多个,逗号隔开
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "抄送人:多个,逗号隔开")
    private String copyUser;

    /**
     * 监管类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "监管类型")
    private Short superviseType;

    /**
     * 提醒方式 消息:1,短信:2
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "提醒方式 消息:1,短信:2")
    private Short remindType;

    /**
     * 运行状态 启用:true 禁用:false
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "运行状态 启用:true 禁用:false")
    private Boolean runStatus;

    /**
     * 备注
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备注")
    private String desc;

    @ApiModelProperty(value = "级别")
    private Integer level;
}
